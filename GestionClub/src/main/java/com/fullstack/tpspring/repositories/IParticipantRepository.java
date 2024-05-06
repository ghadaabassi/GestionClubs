package com.fullstack.tpspring.repositories;

import com.fullstack.tpspring.entities.Participant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParticipantRepository extends CrudRepository<Participant,Integer> {

         
}
