App.controller('parametreController', ['$scope','$http', function ($scope, $http) {
    const appUrl = "api/parametres";
    const urlLoadParametres = appUrl;
    const urlCreateParametre = appUrl + "/create";
    const urlUpdateParametre = appUrl + "/update";
    const urlDeleteParametre = appUrl + "/delete";
    const urlFindParametre = appUrl + "/find";
  
    $scope.listeParametres = [];
    $scope.parametreDTO = { id: null, titre: null, type: null, valeur: null };
  
    // Fonction pour charger la liste des Parametres
    $scope.loadParametres = function () {
        $http.get(urlLoadParametres)
            .then(
                function (res) {
                    $scope.listeParametres = res.data;
                    console.log("LISTE DES Parametres : ", $scope.listeParametres);
                },
                function (error) {
                    console.log("ERREUR DE RECUPERATION DES Parametres : ", error);
                }
            );
    };
  
    // Fonction pour créer un Parametre
    $scope.createParametre = function () {
        var parametreJson = angular.toJson($scope.parametreDTO);
    
        console.log(urlCreateParametre, parametreJson);
        // Envoyer les données JSON dans la requête POST
        $http.post(urlCreateParametre, parametreJson)
            .then(
                function (res) {
                    console.log("Parametre CREE : ", res.data);
                    $scope.loadParametres();
                    // Réinitialisez l'objet ParametreDTO après la création
                    $scope.parametreDTO = { id: null, titre: null, type: null, valeur: null };
                    $scope.successSwal("Parametre créé avec succès");
                },
                function (error) {
                    console.log("ERREUR DE CREATION DU Parametre : ", error);
                    $scope.errorSwal("Erreur lors de la création du Parametre");
                }
            );
    };
  
    // Fonction pour mettre à jour un Parametre
    $scope.updateParametre = function () {
        $http.put(urlUpdateParametre+'/'+$scope.parametreDTO.id, $scope.parametreDTO)
            .then(
                function (res) {
                    console.log("Parametre MISE A JOUR : ", res.data);
                    $scope.loadParametres();
                    // Réinitialisez l'objet ParametreDTO après la mise à jour
                    $scope.parametreDTO = { id: null, titre: null, type: null, valeur: null };
                    $scope.successSwal("Parametre mis à jour avec succès");
                },
                function (error) {
                    console.log("ERREUR DE MISE A JOUR DU Parametre : ", error);
                    $scope.errorSwal("Erreur lors de la mise à jour du Parametre");
                }
            );
    };
  
    // Fonction pour supprimer un Parametre
    $scope.deleteParametre = function (id) {
        $http.delete(urlDeleteParametre + '/' + id)
            .then(
                function (res) {
                    console.log("Parametre SUPPRIME : ", res.data);
                    $scope.loadParametres();
                    $scope.successSwal("Parametre supprimé avec succès");
                },
                function (error) {
                    console.log("ERREUR DE SUPPRESSION DU Parametre : ", error);
                    $scope.errorSwal("Erreur lors de la suppression du Parametre");
                }
            );
    };
  
    // Chargez la liste des Parametres au chargement de la page
    $scope.loadParametres();
  
    $scope.valider = function () {
        // Vérifiez si les champs requis sont remplis
        if (!$scope.parametreDTO.titre || !$scope.parametreDTO.type || !$scope.parametreDTO.valeur) {
            console.log("Veuillez remplir tous les champs obligatoires.");
            $scope.errorSwal("Veuillez remplir tous les champs obligatoires");
            return;
        }
  
        if ($scope.parametreDTO.id) {
            // Appel de la fonction de mise à jour
            $scope.updateParametre();
        } else {
            // Appel de la fonction de création
            $scope.createParametre();
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
  