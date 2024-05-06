package com.fullstack.tpspring.repositories;

import com.fullstack.tpspring.entities.Logistique;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogistiqueRepository extends CrudRepository<Logistique,Integer> {
}
