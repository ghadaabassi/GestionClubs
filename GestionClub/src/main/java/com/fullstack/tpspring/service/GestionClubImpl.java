package com.fullstack.tpspring.service;

import com.fullstack.tpspring.entities.Club;
import com.fullstack.tpspring.entities.Evenement;
import com.fullstack.tpspring.entities.Participant;
import com.fullstack.tpspring.repositories.IClubRepository;
import com.fullstack.tpspring.repositories.IParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GestionClubImpl implements IGestionClub {

    
   IClubRepository iClubRepository;
   IParticipantRepository iParticipantRepository;

    @Override
    public Club addClub(Club club) {
        return  iClubRepository.save(club);
    }

    @Override
    public Club getClubById(int id) {

        return iClubRepository.findById(id).orElseThrow(() -> new RuntimeException("Club not found"));
    }

    @Override
    public Club updateClub(Club club) {
        if (!iClubRepository.existsById(club.getId())) {
            throw new RuntimeException("Club not found");
        }
        return iClubRepository.save(club);
    }
    @Override
    public void deleteClub(int id) {
        iClubRepository.deleteById(id);
    }

    /*
    @Override
    public void affecerParticipantClub(int idParticipant, int idClub) {
        Club club = iClubRepository.findById(idClub).orElse(null);
        Participant participant= iParticipantRepository.findById(idParticipant).orElse(null);
        club.getEvents().get(0).getParticipants().add(participant);


        iClubRepository.save(club);

    }
    */

    @Override
    public void affecerParticipantClub(int idParticipant, int idClub) {
        Club club = iClubRepository.findById(idClub).orElse(null);
        Participant participant= iParticipantRepository.findById(idParticipant).orElse(null);

        club.getParticipants().add(participant);

        iClubRepository.save(club);
    }

}
