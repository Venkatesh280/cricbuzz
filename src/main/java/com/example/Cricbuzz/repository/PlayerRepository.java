package com.example.Cricbuzz.repository;

import com.example.Cricbuzz.model.Player;
import com.example.Cricbuzz.model.enums.Gender;
import com.example.Cricbuzz.model.enums.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Integer> {

    List<Player> findByGenderAndAgeGreaterThan(Gender gender,int age);

    @Query(value = "select p from Player p where p.gender =:gender AND p.speciality=:speciality")
    List<Player> getByGenderAndSpeciality(Gender gender, Speciality speciality);

}
