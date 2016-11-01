angular.module('myApp.view9', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/view9', {
              templateUrl: 'app/view9/view9.html',
              controller: 'View9Ctrl'
            });
          }]).controller('View9Ctrl', ['$scope', '$http', function($scope, $http){
          $scope.add = function(username, password){
              var jsonObject = {username: username, password: password};
              var user = JSON.parse(jsonObject);
              $http.post('api/adduser', user).success(function(res){
                  $scope.data = res.data;
              }).error(function(data){
                  $scope.status = data;
              });
          };
          }]);