var App = angular.module('myApp', []);

var appUrl;
App.controller('clientController', ['$scope', '$http', function ($scope, $http) {
  const appUrl = 'api/client';
  const urlLoadClients = appUrl + "/list";
  const urlCreateOrUpdate = appUrl + "/create-update";
  const urlDeleteClient = appUrl + "/delete";

  $scope.listClients = [];
  $scope.clientDTO = { id: null, numeroOp: null, banque: null, zone: null, agence: null, caisse: null, dateCreation: null };
  $scope.clientMasterDTO = { id: null, numeroOp: null, banque: null, zone: null, agence: null, caisse: null, dateCreation: null };

  // Fonction pour charger la liste des clients
  $scope.loadClients = function () {
      $http.get(urlLoadClients)
          .then(
              function (res) {
                  $scope.listClients = res.data;
                  console.log("LISTE DES CLIENTS : ", $scope.listClients);
              },
              function (error) {
                  console.log("ERREUR DE RECUPERATION DES CLIENTS : ", error);
              }
          );
  };

  // Fonction pour créer ou mettre à jour un client
  $scope.createOrUpdateClient = function () {
      $http.post(urlCreateOrUpdate, $scope.clientDTO)
          .then(
              function (res) {
                  console.log("CLIENT CREE OU MIS A JOUR : ", res.data);
                  $scope.loadClients();
                  // Réinitialisez l'objet clientDTO après la création ou la mise à jour
                  $scope.clientDTO = { id: null, numeroOp: null, banque: null, zone: null, agence: null, caisse: null, dateCreation: null };
              },
              function (error) {
                  console.log("ERREUR DE CREATION OU DE MISE A JOUR DU CLIENT : ", error);
              }
          );
  };

  // Fonction pour supprimer un client
  $scope.deleteClient = function (id) {
      $http.delete(urlDeleteClient + '/' + id)
          .then(
              function (res) {
                  console.log("CLIENT SUPPRIME AVEC SUCCES");
                  $scope.loadClients();
              },
              function (error) {
                  console.log("ERREUR DE SUPPRESSION DU CLIENT : ", error);
              }
          );
  };

  // Chargez la liste des clients au chargement de la page
  $scope.loadClients();
}]);

