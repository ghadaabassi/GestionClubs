package com.fullstack.clubs.Controllers;

import com.fullstack.clubs.entities.Logistique;
import com.fullstack.clubs.service.IGestionLogistique;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logistiques")
@AllArgsConstructor

public class LogistiqueController {

    IGestionLogistique iGestionLogistique;
    
    @PostMapping("/add")
    public Logistique addLogistique(@RequestBody Logistique Logistique) {
        return iGestionLogistique.addLogistique(Logistique);
    }

    @GetMapping("get/{id}")
    public Logistique getById(@PathVariable int id) {
        return iGestionLogistique.getLogistiqueById(id);
    }

    @PutMapping("/update/{id}")
    public Logistique updateLogistique(@PathVariable int id, @RequestBody Logistique Logistique) {
        Logistique.setId(id);
        return iGestionLogistique.updateLogistique(Logistique);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLogistique(@PathVariable int id) {
        iGestionLogistique.deleteLogistique(id);
    }


}
