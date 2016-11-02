'use strict';

angular.module('myApp.view8', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view8', {
                    templateUrl: 'app/view8/view8.html',
                    controller: 'View8Ctrl'
                });
            }])

        .controller('View8Ctrl', function ($http, $scope) {
   $http.get('api/admin/users')
            .success(function (data, status, headers, config) {
              $scope.data = data;
            })
            .error(function (data, status, headers, config) {
              
             });
            $scope.data1 = "hej";
        });