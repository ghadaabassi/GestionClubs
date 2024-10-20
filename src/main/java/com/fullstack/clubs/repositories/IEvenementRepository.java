package com.fullstack.clubs.repositories;

import com.fullstack.clubs.entities.Evenement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvenementRepository extends CrudRepository<Evenement,Integer> {
}
