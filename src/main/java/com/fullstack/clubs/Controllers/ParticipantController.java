package com.fullstack.clubs.Controllers;

import com.fullstack.clubs.entities.Participant;
import com.fullstack.clubs.service.IGestionParticipant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/participants")
@AllArgsConstructor
public class ParticipantController {

    IGestionParticipant iGestionParticipant;

    @PostMapping("/add")
    public Participant addParticipant(@RequestBody Participant participant) {
        return iGestionParticipant.addParticipant(participant);
    }

    @GetMapping("get/{id}")
    public Participant getById(@PathVariable int id) {
        return iGestionParticipant.getPaticipantById(id);
    }

    @PutMapping("/update/{id}")
    public Participant updateParticipant(@PathVariable int id, @RequestBody Participant participant) {
        participant.setId(id);
        return iGestionParticipant.updateParticipant(participant);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteParticipant(@PathVariable int id) {
        iGestionParticipant.deleteParticipant(id);
    }


}

