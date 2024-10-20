package com.fullstack.clubs.Controllers;

import com.fullstack.clubs.entities.Evenement;
import com.fullstack.clubs.entities.Logistique;
import com.fullstack.clubs.service.IGestionClub;
import com.fullstack.clubs.service.IGestionEvenement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evenements")
@AllArgsConstructor
public class EvenementController {
    IGestionEvenement iGestionEvenement;
    IGestionClub iGestionClub;

    @PostMapping("/add")
    public Evenement addEvenement(@RequestBody Evenement Evenement) {
        return iGestionEvenement.addEvenement(Evenement);
    }

    @GetMapping("get/{id}")
    public Evenement getById(@PathVariable int id) {
        return iGestionEvenement.getEvenementById(id);
    }

    @PutMapping("/update/{id}")
    public Evenement updateEvenement(@PathVariable int id, @RequestBody Evenement Evenement) {
        Evenement.setId(id);
        return iGestionEvenement.updateEvenement(Evenement);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvenement(@PathVariable int id) {
        iGestionEvenement.deleteEvenement(id);
    }

    @PutMapping("/affecterClub/{idclub}/{idevent}")
    public Evenement affecterEvenemnt(@PathVariable("idclub") int idclub , @PathVariable("idevent") int idevent) {

        return iGestionEvenement.affecterClubEvenement(idclub,idevent);
    }

    @PutMapping("/ajouterLog/{idevent}")
    public void ajouterLogistique(@RequestBody Logistique l,  @PathVariable("idevent") int idEvent) {

        iGestionEvenement.ajouterAffecterLogistique(l,idEvent);
    }

}
