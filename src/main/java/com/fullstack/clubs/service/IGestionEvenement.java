package com.fullstack.clubs.service;

import com.fullstack.clubs.entities.Evenement;
import com.fullstack.clubs.entities.Logistique;

public interface IGestionEvenement {


    Evenement addEvenement(Evenement Evenement);
    Evenement getEvenementById(int id);
    Evenement updateEvenement(Evenement Evenement);
    void deleteEvenement(int id);

    public Evenement affecterClubEvenement(int idClub,int idEvenement);

    public void ajouterAffecterLogistique(Logistique l , int idEvent);

}
