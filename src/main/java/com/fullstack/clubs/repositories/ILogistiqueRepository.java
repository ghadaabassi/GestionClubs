package com.fullstack.clubs.repositories;

import com.fullstack.clubs.entities.Logistique;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogistiqueRepository extends CrudRepository<Logistique,Integer> {
}
