package com.fullstack.clubs.service;

import com.fullstack.clubs.entities.Participant;
import com.fullstack.clubs.repositories.IParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
