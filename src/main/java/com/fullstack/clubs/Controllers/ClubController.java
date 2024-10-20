package com.fullstack.clubs.Controllers;

import com.fullstack.clubs.entities.Club;
import com.fullstack.clubs.service.IGestionClub;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Clubs")
@AllArgsConstructor
public class ClubController {
    IGestionClub iGestionClub;

    @PostMapping("/add")
    public Club addClub(@RequestBody Club Club) {
        return iGestionClub.addClub(Club);
    }

    @GetMapping("get/{id}")
    public Club getById(@PathVariable int id) {
        return iGestionClub.getClubById(id);
    }

    @PutMapping("/update/{id}")
    public Club updateClub(@PathVariable int id, @RequestBody Club Club) {
        Club.setId(id);
        return iGestionClub.updateClub(Club);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClub(@PathVariable int id) {
        iGestionClub.deleteClub(id);
    }

    @PutMapping("/affecterParticipant/{idPart}/{idClub}")
    public void affecerParticipantClub(@PathVariable("idPart") int idPart , @PathVariable("idClub") int idClub) {
        iGestionClub.affecerParticipantClub(idPart,idClub);
    }
    @PutMapping("/ajouterAffecterParticipant/{idPart}")
    public void ajouterAffecerParticipantClub( @PathVariable("idPart") int idParticipant,@RequestBody Club club) {

         iGestionClub.ajouterAffecerParticipantClub(idParticipant,club);
    }
}
