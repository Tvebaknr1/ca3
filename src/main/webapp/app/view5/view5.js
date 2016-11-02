angular.module('myApp.view5', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view5', {
                    templateUrl: 'app/view5/view5.html',
                    controller: 'View5Ctrl'
                });
            }]).controller('View5Ctrl', function ($http, $scope) {
    $http.get('/REST12/api/admin/users').then(function (response) {
                    $scope.persons = [response.data];
                    $scope.statuscode = response.status;
                    $scope.statustext = response.statustext;
                });
});

               