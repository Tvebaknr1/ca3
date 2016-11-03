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
                $scope.companies = data.productionunits;

                $scope.nmypenis = "nothing";
                console.log($scope.company);
            });
            
            $scope.showDetails = function()
            {
                $scope.detailModel = this.data;
                $('#viewModal').modal('show');
            };
        })

        .factory('userService', function ($http) {
            return {
                getCompanies: function () {
                    var req = {
                        method: 'GET',
                        url: 'http://cvrapi.dk/api?vat=3167%208021&country=dk',
                        skipAuthorization: true,
                        
                        data: {}
                    };
                    console.log("breakpoint z");
                    return $http(req);
//                             .then(function mySucces (response) {
//                         response.data;
//                    }, function myError (response) {
//                        return response.statusText;
//                    });
//                    $http.defaults.headers.common.Authorization = "CVR API-CA3 SCHOOL Exercise-YOUR NAMEYOUREMAIL@cphbusiness.dk";
//                            return $http.get("http://cvrapi.dk/api?vat=3167%208021&country=dk");
                }
            };
        });