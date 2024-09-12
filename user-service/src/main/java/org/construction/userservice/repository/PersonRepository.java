package org.construction.userservice.repository;

import org.construction.userservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findByUsername(String username);
    @Query("SELECT p.id from Person p where p.username=:username")
    Integer findIdByUsername(@Param("username") String username);



}
