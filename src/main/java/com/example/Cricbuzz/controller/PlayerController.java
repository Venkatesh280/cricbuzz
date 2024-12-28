package com.example.Cricbuzz.controller;

import com.example.Cricbuzz.dto.request.PlayerRequest;
import com.example.Cricbuzz.dto.response.PlayerResponse;
import com.example.Cricbuzz.exception.PlayerNotFoundException;
import com.example.Cricbuzz.model.enums.Gender;
import com.example.Cricbuzz.model.enums.Speciality;
import com.example.Cricbuzz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping
    public ResponseEntity savePlayer(@RequestBody PlayerRequest playerRequest){
        return new ResponseEntity<>(playerService.addPlayer(playerRequest), HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public PlayerResponse getPlayerById(@PathVariable("id") int id){
        return playerService.getPlayerByid(id);
    }
    //gender and  age
    @GetMapping("/gender/{gender}/age/{age}")
   public List<PlayerResponse> getByGenderAgeGreaterThan(@PathVariable("gender") Gender gender,
                                                         @PathVariable("age") int age){
        return playerService.getByGenderAndGreaterThan(gender,age);
    }

    @GetMapping("/gender/{gender}/speciality/{speciality}")
    public List<PlayerResponse> getByGenderAndSpeciality(@PathVariable("gender") Gender gender,
                                                         @PathVariable("speciality") Speciality speciality){
        return playerService.getByGenderAndSpeciality(gender,speciality);

    }
}
