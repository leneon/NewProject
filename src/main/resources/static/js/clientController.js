var App = angular.module('myApp', []);

App.controller('clientController', ['$scope','$http', function ($scope, $http) {
  const appUrl = 'api/clients';
  const urlLoadClients = appUrl ;
  const urlLoadAgences = "api/agences";
  const urlCreateClient = appUrl + "/create";
  const urlUpdateClient = appUrl + "/update";
  const urlDeleteClient = appUrl + "/delete";
  const urlFindClient = appUrl + "/find";

  $scope.listeClients = [];
  $scope.clientDTO = { id: null, numeroOp: null, banque: null, zone: null, agence: null, caisse: null, dateCreation: null };
  $scope.clientMasterDTO = { id: null, numeroOp: null, banque: null, zone: null, agence: {id:null,nom:""}, caisse: null, dateCreation: null };
  $scope.listeAgences = [];

   // Fonction pour charger la liste des agences
   $scope.loadAgences = function () {
    $http.get(urlLoadAgences)
        .then(
            function (res) {
                $scope.listeAgences = res.data;
                console.log("LISTE DES AGENCES : ", $scope.listeAgences);
            },
            function (error) {
                console.log("ERREUR DE RECUPERATION DES AGENCES : ", error);
            }
        );
};
// Chargez la liste des agences au chargement de la page
$scope.loadAgences();
    // Fonction pour trouver une agence par son ID
    $scope.findClientById = function (id) {
        $http.get(urlFindClient + '/' + id)
            .then(
                function (res) {
                    console.log("CLIENT TROUVEE : ", res.data);
                    $scope.clientMasterDTO = res.data;
                    $scope.modalShow();
                },
                function (error) {
                    console.log("ERREUR DE RECHERCHE DU CLIENT : ", error);
                }
            );
    };


  // Fonction pour charger la liste des clients
  $scope.loadClients = function () {
      $http.get(urlLoadClients)
          .then(
              function (res) {
                  $scope.listeClients = res.data;
                  console.log("LISTE DES CLIENTS : ", $scope.listeClients);
              },
              function (error) {
                  console.log("ERREUR DE RECUPERATION DES CLIENTS : ", error);
              }
          );
  };

    // Fonction pour créer une Client
    $scope.createClient = function () {
        var clientJson = angular.toJson($scope.clientMasterDTO);
    
        console.log(urlCreateClient, clientJson);
        // Envoyer les données JSON dans la requête POST
        $http.post(urlCreateClient, clientJson)
            .then(
                function (res) {
                    $scope.modalHide();
                    console.log("Client CREE : ", res.data);
                    $scope.loadClients();
                    swal({
                        title: "Succès",
                        text: "Client crée avec succès!",
                        icon: "success",
                        button: "OK!",
                      });
                    // Réinitialisez l'objet ClientMasterDTO après la création
                    $scope.clientMasterDTO = $scope.clientDTO ;               },
                function (error) {
                    console.log("ERREUR DE CREATION DE L'Client : ", error);
                }
            );
    };
    

    // Fonction pour mettre à jour une 
    $scope.updateClient = function () {
        $http.put(urlUpdateClient+'/'+$scope.clientMasterDTO.id, $scope.clientMasterDTO)
            .then(
                function (res) {
                    console.log("Client MISE A JOUR : ", res.data);
                    $scope.loadClients();
                    // Réinitialisez l'objet ClientDTO après la mise à jour
                    $scope.clientMasterDTO = $scope.clientDTO ;     
                    $scope.modalHide();
                    $scope.successSwal("Mise a jour éffectué avec succès");

                },
                function (error) {
                    console.log("ERREUR DE MISE A JOUR DE L'Client : ", error);
                }
            );
    };
   // Fonction pour supprimer une agence
$scope.deleteClient = function (id) {
    // Afficher la boîte de dialogue de confirmation
    swal({
        title: "Êtes-vous sûr?",
        text: "Une fois supprimé, vous ne pourrez pas récupérer ce client!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
    .then((willDelete) => {
        // Si l'utilisateur clique sur le bouton "Supprimer"
        if (willDelete) {
            // Envoyer la requête de suppression au serveur
            $http.delete(urlDeleteClient + '/' + id)
                .then(
                    function (res) {
                        // Afficher un message de succès
                        swal("Le client a été supprimée avec succès!", {
                            icon: "success",
                        });
                        // Recharger la liste des agences
                        $scope.loadClients();
                    },
                    function (error) {
                        // Afficher un message d'erreur en cas d'échec de la suppression
                        swal("Erreur lors de la suppression du client : " + error.message, {
                            icon: "error",
                        });
                    }
                );
        } else {
            // Si l'utilisateur clique sur le bouton "Annuler", ne rien faire
            swal("Le client n'a pas été supprimée!");
        }
    });
};

  // Chargez la liste des clients au chargement de la page
  $scope.loadClients();

  $scope.valider = function () {
        
    // Vérifiez si les champs requis sont remplis
    if (!$scope.clientMasterDTO.agence || !$scope.clientMasterDTO.numeroOp || !$scope.clientMasterDTO.banque || !$scope.clientMasterDTO.caisse || !$scope.clientMasterDTO.zone || !$scope.clientMasterDTO.localite) {
        console.log("Veuillez remplir tous les champs obligatoires.");
        swal({
            title: "Erreur",
            text: "Veuillez remplir tous les champs obligatoires.!",
            icon: "error",
            button: "OK!",
          });
        return;
    }

    if ($scope.clientMasterDTO.id) {
        // Appel de la fonction de mise à jour
        $scope.updateClient();
    } else {
        // Appel de la fonction de création
        $scope.createClient();
    }
};

$scope.successSwal = function(string){
    swal({
        title: "Succès",
        text: string,
        icon: "success",
        button: "OK!",
      });
};
$scope.errorSwal = function(string){
    swal({
        title: "Erreur",
        text: string,
        icon: "error",
        button: "OK!",
      });
};

$scope.modalShow = function(){
    $('#myModal').modal('show');
};
$scope.modalHide = function(){
    $('#myModal').modal('hide');
};
$scope.importExcel = function() {
    var fileInput = document.getElementById('excelFile');
    var file = fileInput.files[0];

    var formData = new FormData();
    formData.append('file', file);

    $http.post('api/clients/import', formData, {
        transformRequest: angular.identity,
        headers: {'Content-Type': undefined}
    }).then(
        function(response) {
            // Traitement réussi
            console.log("Données importées avec succès :", response.data);
            // Actualiser la liste des clients après l'importation
            $scope.loadClients();
        },
        function(error) {
            // Erreur lors de l'importation
            console.error("Erreur lors de l'importation :", error);
        }
    );
};


}]);

