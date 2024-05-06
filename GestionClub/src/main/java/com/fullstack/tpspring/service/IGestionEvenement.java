package com.fullstack.tpspring.service;

import com.fullstack.tpspring.entities.Evenement;

public interface IGestionEvenement {


    Evenement addEvenement(Evenement Evenement);
    Evenement getEvenementById(int id);
    Evenement updateEvenement(Evenement Evenement);
    void deleteEvenement(int id);

    public Evenement affecterClubEvenement(int idClub,int idEvenement);

}
