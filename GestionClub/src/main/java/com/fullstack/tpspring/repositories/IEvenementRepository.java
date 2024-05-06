package com.fullstack.tpspring.repositories;

import com.fullstack.tpspring.entities.Evenement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvenementRepository extends CrudRepository<Evenement,Integer> {
}
