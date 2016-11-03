angular.module('myApp.view7', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view7', {
                    templateUrl: 'app/view7/view7.html',
                    controller: 'View7Ctrl'
                });
            }]).controller('View7Ctrl', function ($http,$scope) {
        $http.get('api/currency/dailyrates').success(function (data) {
              $scope.data = data;
            })
            .error(function (status) {
              $scope.status = status;
             });
    });