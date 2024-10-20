package com.fullstack.clubs.repositories;

import com.fullstack.clubs.entities.Club;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClubRepository extends CrudRepository<Club,Integer> {
}
