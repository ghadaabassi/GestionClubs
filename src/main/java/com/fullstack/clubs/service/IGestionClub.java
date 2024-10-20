package com.fullstack.clubs.service;

import com.fullstack.clubs.entities.Club;

public interface IGestionClub {

    Club addClub(Club club);
    Club getClubById(int id);
    Club updateClub(Club club);
    void deleteClub(int id);

    void affecerParticipantClub(int idParticipant,int idClub);

    void ajouterAffecerParticipantClub(int idParticipant,Club club);
}
