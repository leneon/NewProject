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
import com.example.project.entities.AbattementParametre;
import com.example.project.entities.Client;
import com.example.project.repositories.AbattementParametreRepository;
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
        System.out.println("\n\n"+abattementObjectDTO.toString()+"\n\n");
        List <String> parametres = new ArrayList<>();
        if(abattementObjectDTO.getMoins_verses() && abattementObjectDTO.getMoins_verses()!=null)
            parametres.add("moins_verses");
        if(abattementObjectDTO.getNon_verse() && abattementObjectDTO.getNon_verse()!=null)
            parametres.add("non_verse");
        if( abattementObjectDTO.getRetards() && abattementObjectDTO.getRetards()!=null)
            parametres.add("retards");
        if(!abattementObjectDTO.getMoins_verses_avec_retard() || abattementObjectDTO.getMoins_verses_avec_retard() != null)
            parametres.add("moins_verses_avec_retard");

        Abattement abattement = abattementService.createAbattement(this.setAbattement(abattementObjectDTO));
        if(abattement!=null){
            parametreService.getAllParametresDTO().stream().forEach(temp->{
                this.createAbattementParametres(abattement, temp, parametres, abattementObjectDTO);
            });
            abattementService.updateAbattement(abattement.getId(), abattement);
        } 
    return abattement;
    }
    public void createAbattementParametres(Abattement abattement,ParametreDTO parametreDTO,List<String> parametres, AbattementObjectDTO aObjectDTO){
        AbattementParametre abattementParametre = new AbattementParametre();
        abattementParametre.setAbattement(abattement);
        abattementParametre.setParametre(parametreService.getParametreById(parametreDTO.getId()));
        parametres.stream().forEach(str ->{
            if(parametreDTO.getSlug().contentEquals(str)){
                abattementParametre.setMontantAbattement((abattement.getVente()*parametreDTO.getValeur())/100);
                abattementParametre.setValeur("retards".equals(str) && parametreDTO.getSlug().equals(str)? aObjectDTO.getHeure().toString() : abattement.getSoldeAVerser().toString());
            }
        });     
        abattement.setTotal((abattement.getTotal()!=null? abattement.getTotal() : 0) + (abattementParametre.getMontantAbattement()!=null? abattementParametre.getMontantAbattement() : 0));
        
        AbattementParametreRepository.save(abattementParametre);
    }

    public Abattement setAbattement(AbattementObjectDTO abattementObjectDTO)
    {
        Abattement abattement = new Abattement();
        abattement.setClient(new Client(abattementObjectDTO.getClient().getId()));
        abattement.setDate(abattementObjectDTO.getDate());
        abattement.setNonReg(abattementObjectDTO.getSolde_a_verser());
        abattement.setSoldeAVerser(abattementObjectDTO.getSolde_a_verser());
        abattement.setPaiement(abattementObjectDTO.getPaiement());
        abattement.setReg(abattementObjectDTO.getPaiement());
        abattement.setVente(abattementObjectDTO.getVente());
        return abattement;
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
