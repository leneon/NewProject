'use strict';
var App;
var appUrl;
App.controller('compteController', ['$scope', 'GenericService', 'StatutService', function ($scope, GenericService) {

    const urlLoadUtilisateurs = appUrl + "api/utilisateur/list";
    const urlLoadUtilisateur = appUrl + "api/utilisateur/list";

    $scope.listUtilisateurs = [];


    
    $scope.loadUtilisateurs = function () {
        GenericService.get(urlLoadClients)
                .then(
                    function (data) {
                        $scope.listClients = data.listClients;
                    },
                    function (error) {
                        console.log("ERREUR DE RECUPERATION CLIENTS : ",error);
                    }
                );
    };
    $scope.loadUtilisateurs();

}]);