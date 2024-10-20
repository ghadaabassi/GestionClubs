package com.fullstack.clubs.service;

import com.fullstack.clubs.entities.Logistique;

public interface IGestionLogistique {

    Logistique addLogistique(Logistique Logistique);
    Logistique getLogistiqueById(int id);
    Logistique updateLogistique(Logistique Logistique);
    void deleteLogistique(int id);
}
