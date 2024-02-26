package com.example.project.resources;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.dto.AbattementDTO;
import com.example.project.dto.AbattementObjectDTO;
import com.example.project.dto.ParametreDTO;
import com.example.project.entities.Abattement;
import com.example.project.entities.Parametre;
import com.example.project.repositories.AbattementParametreRepository;
import com.example.project.repositories.ParametreRepository;
import com.example.project.services.AbattementService;
import com.example.project.services.ParametreService;

@RestController
@RequestMapping("api/abattements")
public class AbattementResource {

    private final AbattementService abattementService;
    @Autowired
    public AbattementResource(AbattementService abattementService) {
        this.abattementService = abattementService;
    }

    @Autowired
    private ParametreService parametreService;
    @Autowired
    private AbattementParametreRepository AbattementParametreRepository;


    @GetMapping
    public List<Abattement> getAllAbattements() {
        return abattementService.getAllAbattements();
    }

    @GetMapping("/find/{id}")
    public Abattement getAbattementById(@PathVariable Long id) {
        return abattementService.getAbattementById(id);
    }

    @PostMapping("/create")
    public Abattement createAbattement(@RequestBody AbattementObjectDTO abattementObjectDTO) {

        Abattement ab = abattementService.createAbattement(abattementObjectDTO.getAbatttement());
        if(ab==null)
            return null;
        for (ParametreDTO parametreDTO : this.parametreService.getAllParametresDTO() ) {
            String slug = parametreDTO.getSlug();
            // Vérifier si le slug correspond à l'une des clés de slugsRecherches
            for (String key : abattementObjectDTO.getParametres()) {
                if (key.equals(slug) && abattementObjectDTO.getParametres().getBoolean(key)) {
                    // Vous pouvez traiter ici le paramètre trouvé, par exemple le stocker ou effectuer d'autres actions nécessaires
                    // parametre représente le paramètre correspondant trouvé
                    // param est le paramètre passé en tant qu'argument à la méthode, si vous devez le comparer également
                    // parametresTrouves.add(parametre); // Cette ligne semble être en dehors du contexte actuel, vous pouvez le modifier en conséquence
                    break; // Sortir de la boucle interne dès qu'une correspondance est trouvée
                }
            }
        }
        return ab;
    }



    public void storeAbattementParametre(Parametre param, JSONObject slugsRecherches) {
        for (Parametre parametre : this.parametreRepository.findAll()) {
            String slug = parametre.getSlug();
            // Vérifier si le slug correspond à l'une des clés de slugsRecherches
            for (String key : slugsRecherches.keySet()) {
                if (key.equals(slug) && slugsRecherches.getBoolean(key)) {
                    // Vous pouvez traiter ici le paramètre trouvé, par exemple le stocker ou effectuer d'autres actions nécessaires
                    // parametre représente le paramètre correspondant trouvé
                    // param est le paramètre passé en tant qu'argument à la méthode, si vous devez le comparer également
                    // parametresTrouves.add(parametre); // Cette ligne semble être en dehors du contexte actuel, vous pouvez le modifier en conséquence
                    break; // Sortir de la boucle interne dès qu'une correspondance est trouvée
                }
            }
        }
    }
    

    @PutMapping("/update/{id}")
    public Abattement updateAbattement(@PathVariable Long id, @RequestBody Abattement abattement) {
        return abattementService.updateAbattement(id, abattement);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAbattement(@PathVariable Long id) {
        abattementService.deleteAbattement(id);
    }
}
