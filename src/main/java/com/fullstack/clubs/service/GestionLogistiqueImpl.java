package com.fullstack.clubs.service;

import com.fullstack.clubs.entities.Logistique;
import com.fullstack.clubs.repositories.ILogistiqueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GestionLogistiqueImpl implements IGestionLogistique{

    ILogistiqueRepository repository;

    @Override
    public Logistique addLogistique(Logistique logistique) {
        return repository.save(logistique);
    }

    @Override
    public Logistique getLogistiqueById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Logistique not found"));
    }

    @Override
    public Logistique updateLogistique(Logistique logistique) {
        if (!repository.existsById(logistique.getId())) {
            throw new RuntimeException("Evenement not found");
        }
        return repository.save(logistique);
    }

    @Override
    public void deleteLogistique(int id) {
        repository.deleteById(id);
    }
}
