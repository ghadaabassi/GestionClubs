package com.fullstack.tpspring.service;

import com.fullstack.tpspring.entities.Club;
import com.fullstack.tpspring.entities.Evenement;
import com.fullstack.tpspring.repositories.IClubRepository;
import com.fullstack.tpspring.repositories.IEvenementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GestionEvenementImpl implements IGestionEvenement {

    IEvenementRepository repository;
    IClubRepository clubRepository;
    @Override
    public Evenement addEvenement(Evenement evenement) {
        return repository.save(evenement);
    }

    @Override
    public Evenement getEvenementById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Participant not found"));
    }

    @Override
    public Evenement updateEvenement(Evenement evenement) {
        if (!repository.existsById(evenement.getId())) {
            throw new RuntimeException("Evenement not found");
        }
        return repository.save(evenement);
    }

    @Override
    public void deleteEvenement(int id) {
        repository.deleteById(id);
    }

    @Override
    public Evenement affecterClubEvenement(int idClub, int idEvenement) {

        Club club = clubRepository.findById(idClub).orElse(null);
        Evenement event= repository.findById(idEvenement).orElse(null);
        event.setClub(club);
       // club.getEvents().add(event);
        //clubRepository.save(club);
        repository.save(event);


     return event;
    }


}
