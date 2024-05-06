package com.fullstack.tpspring.Controllers;

import com.fullstack.tpspring.entities.Participant;
import com.fullstack.tpspring.service.IGestionParticipant;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participants")
@AllArgsConstructor
public class ParticipantController {

    IGestionParticipant IGestionParticipant;

    @PostMapping("/add")
    public Participant addParticipant(@RequestBody Participant participant) {
        return IGestionParticipant.addParticipant(participant);
    }

    @GetMapping("get/{id}")
    public Participant getById(@PathVariable int id) {
        return IGestionParticipant.getPaticipantById(id);
    }

    @PutMapping("/update/{id}")
    public Participant updateParticipant(@PathVariable int id, @RequestBody Participant participant) {
        participant.setId(id);
        return IGestionParticipant.updateParticipant(participant);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteParticipant(@PathVariable int id) {
        IGestionParticipant.deleteParticipant(id);
    }


}

