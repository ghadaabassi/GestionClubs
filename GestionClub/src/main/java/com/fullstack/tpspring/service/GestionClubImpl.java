package com.fullstack.tpspring.service;

import com.fullstack.tpspring.entities.Club;
import com.fullstack.tpspring.repositories.IClubRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GestionClubImpl implements IGestionClub {

    
   IClubRepository repository;

    @Override
    public Club addClub(Club club) {
        return  repository.save(club);
    }

    @Override
    public Club getClubById(int id) {

        return repository.findById(id).orElseThrow(() -> new RuntimeException("Club not found"));
    }

    @Override
    public Club updateClub(Club club) {
        if (!repository.existsById(club.getId())) {
            throw new RuntimeException("Club not found");
        }
        return repository.save(club);
    }
    @Override
    public void deleteClub(int id) {
        repository.deleteById(id);
    }
}
