package com.fullstack.clubs.repositories;

import com.fullstack.clubs.entities.Participant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParticipantRepository extends CrudRepository<Participant,Integer> {

         
}
