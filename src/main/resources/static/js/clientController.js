var App = angular.module('myApp', []);

var appUrl;
App.controller('clientController', ['$scope','$http', function ($scope,$http) {
    const appUrl = 'api/client'; // Make sure you define the appUrl variable
    const urlLoadClients = appUrl + "/list";
    const urlCreatOrUpdate = appUrl + "api/client/ceate-update";

    alert(5);
    $scope.listClients = [];
    $scope.clientDTO = { id: null, numeroOp: null, banque: null, zone: null, agence: null, caisse: null, dateCreation: null };
    $scope.clientMasterDTO = { id: null, numeroOp: null, banque: null, zone: null, agence: null, caisse: null, dateCreation: null };

    $scope.loadClients = function () {
      console.log("LANCEMENT DE RECUPERATION CLIENTS : ");
      
            $http.get(urlLoadClients)
              .then(
                function (data) {
                    $scope.listClients = data.listClients;
                },
                function (error) {
                    console.log("ERREUR DE RECUPERATION CLIENTS : ", error);
                }
              );
    };

    $scope.loadClients();
}]);
