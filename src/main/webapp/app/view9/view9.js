angular.module('myApp.view9', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/view9', {
              templateUrl: 'app/view9/view9.html',
              controller: 'View9Ctrl'
            });
          }]);