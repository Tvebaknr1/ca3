angular.module('myApp.view6', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view6', {
                    templateUrl: 'app/view6/view6.html',
                    controller: 'View6Ctrl'
                });
            }])

        .controller('View6Ctrl', function ($scope, userService) {
            userService.getCompanies().success(function (data) {
                $scope.company = data;
            });
        })

        .factory('userService', function ($http) {
            return {
                getCompanies: function () {
                    return $http.get("http://cvrapi.dk/api?vat=3167%208021&country=dk");
                }
            };
        });