var App = angular.module('myApp', []);

App.controller('abattementsController', ['$scope','$http', function ($scope, $http) {
  const appUrl = "api/abattements";
  const urlLoadabattements = appUrl ;
  const urlDeleteAbattements = appUrl + "/delete";
  const urlFindUtilisateur = appUrl + "/find";

  $scope.listeabattements = [];
  $scope.utilisateurDTO = { id: null, nom: null, prenoms: null, email: null, telephone: null, username: null, agence: { id: null, nom: "" } };
  $scope.utilisateurMasterDTO = { id: null, nom: null, prenoms: null, email: null, telephone: null, username: null, agence: { id: null, nom: "" } };
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
    $scope.findUtilisateurById = function (id) {
        $http.get(urlFindUtilisateur + '/' + id)
            .then(
                function (res) {
                    console.log("Utilisateur TROUVEE : ", res.data);
                    $scope.utilisateurMasterDTO = res.data;
                    $scope.modalShow();
                },
                function (error) {
                    console.log("ERREUR DE RECHERCHE DU Utilisateur : ", error);
                }
            );
    };


  // Fonction pour charger la liste des abattements
  $scope.loadAbattements = function () {
      $http.get(urlLoadAbattements)
          .then(
              function (res) {
                  $scope.listeabattements = res.data;
                  console.log("LISTE DES abattements : ", $scope.listeabattements);
              },
              function (error) {
                  console.log("ERREUR DE RECUPERATION DES abattements : ", error);
              }
          );
  };


    // Fonction pour mettre à jour une 
    $scope.updateAbattements = function () {
        $http.put(urlUpdateAbattements+'/'+$scope.utilisateurMasterDTO.id, $scope.utilisateurMasterDTO)
            .then(
                function (res) {
                    console.log("Utilisateur MISE A JOUR : ", res.data);
                    $scope.loadabattements();
                    // Réinitialisez l'objet UtilisateurDTO après la mise à jour
                    $scope.utilisateurMasterDTO = $scope.utilisateurDTO ;     
                    $scope.modalHide();
                    $scope.successSwal("Mise a jour éffectué avec succès");

                },
                function (error) {
                    console.log("ERREUR DE MISE A JOUR DE L'Utilisateur : ", error);
                }
            );
    };
   // Fonction pour supprimer une agence
    $scope.deleteAbattements = function (id) {
        // Afficher la boîte de dialogue de confirmation
        swal({
            title: "Êtes-vous sûr?",
            text: "Une fois supprimé, vous ne pourrez pas récupérer ce Utilisateur!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
        .then((willDelete) => {
            // Si l'utilisateur clique sur le bouton "Supprimer"
            if (willDelete) {
                // Envoyer la requête de suppression au serveur
                $http.delete(urlDeleteAbattements + '/' + id)
                    .then(
                        function (res) {
                            // Afficher un message de succès
                            swal("Le Utilisateur a été supprimée avec succès!", {
                                icon: "success",
                            });
                            // Recharger la liste des agences
                            $scope.loadabattements();
                        },
                        function (error) {
                            // Afficher un message d'erreur en cas d'échec de la suppression
                            swal("Erreur lors de la suppression du Utilisateur : " + error.message, {
                                icon: "error",
                            });
                        }
                    );
            } else {
                // Si l'utilisateur clique sur le bouton "Annuler", ne rien faire
                swal("Le Utilisateur n'a pas été supprimée!");
            }
        });
    };

  // Chargez la liste des abattements au chargement de la page
  $scope.loadabattements();

  $scope.valider = function () {
        
    // Vérifiez si les champs requis sont remplis
    if (!$scope.utilisateurMasterDTO.agence || !$scope.utilisateurMasterDTO.nom || !$scope.utilisateurMasterDTO.prenoms || !$scope.utilisateurMasterDTO.email || !$scope.utilisateurMasterDTO.telephone || !$scope.utilisateurMasterDTO.username) {
        console.log("Veuillez remplir tous les champs obligatoires.");
        swal({
            title: "Erreur",
            text: "Veuillez remplir tous les champs obligatoires.!",
            icon: "error",
            button: "OK!",
          });
        return;
    }

    if ($scope.utilisateurMasterDTO.id) {
        // Appel de la fonction de mise à jour
        $scope.updateAbattements();
    } else {
        // Appel de la fonction de création
        $scope.createAbattements();
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
}]);

