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
                    .success(function (data) {
                        $scope.data = data;
                    })
                    .error(function (status) {
                        $scope.status = status;
                    });

            $scope.deleteUser = function(id){
                
            
                $http.delete("api/admin/deleteUser/"+id)
                    .sucess(function (data) {
                        $scope.data = data;
                $scope.$apply();
                    })
                    .error(function (status) {
                        $scope.status = status;
                   $scope.$apply();
                    });
                }
        });