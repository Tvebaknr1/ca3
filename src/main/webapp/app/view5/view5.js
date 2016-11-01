angular.module('myApp.view5', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/view5', {
              templateUrl: 'app/view5/view5.html',
              controller: 'View8Ctrl'
            });
          }])

        .controller('View5Ctrl', function ($http, $scope) {
          $http({
            method: 'GET',
            url: 'api/demouser'
          }).then(function successCallback(res) {
            $scope.data = res.data.message;
          }, function errorCallback(res) {
            $scope.error = res.status + ": "+ res.data.statusText;
          });

        });