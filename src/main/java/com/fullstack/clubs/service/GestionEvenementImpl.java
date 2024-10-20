package com.fullstack.clubs.service;

import com.fullstack.clubs.entities.Club;
import com.fullstack.clubs.entities.Evenement;
import com.fullstack.clubs.entities.Logistique;
import com.fullstack.clubs.repositories.IClubRepository;
import com.fullstack.clubs.repositories.IEvenementRepository;
import com.fullstack.clubs.repositories.ILogistiqueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GestionEvenementImpl implements IGestionEvenement {

    IEvenementRepository iEvenementRepository;
    IClubRepository iClubRepository;
    ILogistiqueRepository iLogistiqueRepository;
    @Override
    public Evenement addEvenement(Evenement evenement) {
        return iEvenementRepository.save(evenement);
    }

    @Override
    public Evenement getEvenementById(int id) {
        return iEvenementRepository.findById(id).orElseThrow(() -> new RuntimeException("Participant not found"));
    }

    @Override
    public Evenement updateEvenement(Evenement evenement) {
        if (!iEvenementRepository.existsById(evenement.getId())) {
            throw new RuntimeException("Evenement not found");
        }
        return iEvenementRepository.save(evenement);
    }

    @Override
    public void deleteEvenement(int id) {
        iEvenementRepository.deleteById(id);
    }

    @Override
    public Evenement affecterClubEvenement(int idClub, int idEvenement ) {

        Club club = iClubRepository.findById(idClub).orElse(null);
        Evenement event= iEvenementRepository.findById(idEvenement).orElse(null);
        event.setClub(club);
        // club.getEvents().add(event);
        //clubRepository.save(club);
        iEvenementRepository.save(event);
     return event;
    }

    /*
    @Override
    public void ajouterLogistique(Logistique l, int idEvent) {
        Evenement event = iEvenementRepository.findById(idEvent).orElse(null);
        if (iLogistiqueRepository.findById(l.getId()).isPresent()){
            event.getLogs().add(l);
        }else {
            iLogistiqueRepository.save(l);
            event.getLogs().add(iLogistiqueRepository.findById(l.getId()).orElse(null));
        }

        iEvenementRepository.save(event);
    }
*/
    @Override
    public void ajouterAffecterLogistique(Logistique l, int idEvent) {
        Evenement event = iEvenementRepository.findById(idEvent).orElse(null);

        iLogistiqueRepository.save(l);
        event.getLogs().add(iLogistiqueRepository.findById(l.getId()).orElse(null));
        iEvenementRepository.save(event);
    }

}
