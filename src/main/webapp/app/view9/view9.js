angular.module('myApp.view9', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/view9', {
              templateUrl: 'app/view9/view9.html',
              controller: 'View9Ctrl'
            });
          }]).controller('View9Ctrl', ['$scope', function($scope){
          $scope.add = function(username, password){
              console.log("" + username + password);
              var user = {username: '', password: ''};
              
          };
          }]);