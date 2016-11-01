angular.module('myApp.view8', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/view8', {
              templateUrl: 'app/view8/view8.html',
              controller: 'View8Ctrl'
            });
          }])

        .controller('View8Ctrl', function ($http, $scope) {
          $http({
            method: 'GET',
            url: 'api/demouser'
          }).then(function successCallback(res) {
            $scope.data = res.data.message;
          }, function errorCallback(res) {
            $scope.error = res.status + ": "+ res.data.statusText;
          });

        });