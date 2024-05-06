package com.fullstack.tpspring.service;

import com.fullstack.tpspring.entities.Participant;
import com.fullstack.tpspring.repositories.IParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GestionParticipantImpl implements IGestionParticipant{

    IParticipantRepository repository;

    @Override
    public Participant addParticipant(Participant participant) {
        return repository.save(participant);
    }

    @Override
    public Participant getPaticipantById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Participant not found"));
    }

    @Override
    public Participant updateParticipant(Participant participant) {
        if (!repository.existsById(participant.getId())) {
            throw new RuntimeException("Participant not found");
        }
        return repository.save(participant);
    }

    @Override
    public void deleteParticipant(int id) {
        repository.deleteById(id);
    }



}
