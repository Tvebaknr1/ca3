angular.module('myApp.view9', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view9', {
                    templateUrl: 'app/view9/view9.html',
                    controller: 'View9Ctrl'
                });
            }]).controller('View9Ctrl', ['$scope', '$http', function ($scope, $http) {
        $scope.add = function (username, password) {
            var jsonObject = {"userName": username, "password": password};
            $http.post('api/demoall/adduser', jsonObject).success(function (res) {
                console.log("added");
                $scope.data = res.data;
            }).error(function (data) {
                $scope.status = data;
            });
        };
    }]);