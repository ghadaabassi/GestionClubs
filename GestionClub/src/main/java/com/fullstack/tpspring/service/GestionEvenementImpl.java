package com.fullstack.tpspring.service;

import com.fullstack.tpspring.entities.Club;
import com.fullstack.tpspring.entities.Evenement;
import com.fullstack.tpspring.entities.Logistique;
import com.fullstack.tpspring.repositories.IClubRepository;
import com.fullstack.tpspring.repositories.IEvenementRepository;
import com.fullstack.tpspring.repositories.ILogistiqueRepository;
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
