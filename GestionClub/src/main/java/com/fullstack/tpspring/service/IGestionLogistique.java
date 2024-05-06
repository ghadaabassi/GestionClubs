package com.fullstack.tpspring.service;

import com.fullstack.tpspring.entities.Logistique;

public interface IGestionLogistique {

    Logistique addLogistique(Logistique Logistique);
    Logistique getLogistiqueById(int id);
    Logistique updateLogistique(Logistique Logistique);
    void deleteLogistique(int id);
}
