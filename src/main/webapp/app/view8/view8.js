angular.module('myApp.view8', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view8', {
                    templateUrl: 'app/view8/view8.html',
                    controller: 'View8Ctrl'
                });
            }]);