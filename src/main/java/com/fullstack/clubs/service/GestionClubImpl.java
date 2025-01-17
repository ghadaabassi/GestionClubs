package com.fullstack.clubs.service;

import com.fullstack.clubs.entities.Club;
import com.fullstack.clubs.entities.Participant;
import com.fullstack.clubs.repositories.IClubRepository;
import com.fullstack.clubs.repositories.IParticipantRepository;
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


    @Override
    public void affecerParticipantClub(int idParticipant, int idClub) {
        Club club = iClubRepository.findById(idClub).orElse(null);
        Participant participant= iParticipantRepository.findById(idParticipant).orElse(null);

        club.getParticipants().add(participant);

        iClubRepository.save(club);
    }
    @Override
    public void ajouterAffecerParticipantClub(int idParticipant, Club club) {

        Participant participant= iParticipantRepository.findById(idParticipant).orElse(null);
        club.getParticipants().add(participant);
        iClubRepository.save(club);

    }

}
