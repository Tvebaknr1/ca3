angular.module('myApp.view9', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/view9', {
              templateUrl: 'app/view9/view9.html',
              controller: 'View9Ctrl'
            });
          }])

        .controller('View9Ctrl', function ($http, $scope) {
          $http({
            method: 'GET',
            url: 'api/demouser'
          }).then(function successCallback(res) {
            $scope.data = res.data.message;
          }, function errorCallback(res) {
            $scope.error = res.status + ": "+ res.data.statusText;
          });

        });