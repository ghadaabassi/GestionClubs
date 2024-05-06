package com.fullstack.tpspring.repositories;

import com.fullstack.tpspring.entities.Club;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClubRepository extends CrudRepository<Club,Integer> {
}
