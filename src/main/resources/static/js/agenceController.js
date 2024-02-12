
var App = angular.module('myApp', []);

var appUrl;
App.controller('agenceController', ['$scope','$http', function ($scope,$http) {
    const appUrl = 'api/agence'; // Make sure you define the appUrl variable
    const urlLoadAgences = appUrl + "/liste";
    const urlCreatOrUpdate = appUrl + "/ceate-update";


    $scope.listeAgences = [];
    $scope.agenceDTO = { id: null, nom: null, adresse: null, ville: null, localisation: null};
    $scope.agenceMasterDTO = { id: null, nom: null, adresse: null, ville: null, localisation: null};

    $scope.loadAgences = function () {
        $http.get(urlLoadAgences)
            .then(
                function (res) {
                    $scope.listeAgences = res.data.listeAgences;
                    console.log("LISTE DES AGENTS : ", res.data.listeAgences);

                },
                function (error) {
                    console.log("ERREUR DE RECUPERATION DES AGENTS : ", error);
                }
            );
    };

    $scope.loadAgences();
}]);
