package com.example.Cricbuzz.service;

import com.example.Cricbuzz.convertor.PlayerConvertor;
import com.example.Cricbuzz.dto.request.PlayerRequest;
import com.example.Cricbuzz.dto.response.PlayerResponse;
import com.example.Cricbuzz.exception.PlayerNotFoundException;
import com.example.Cricbuzz.model.Player;
import com.example.Cricbuzz.model.enums.Gender;
import com.example.Cricbuzz.model.enums.Speciality;
import com.example.Cricbuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public PlayerResponse addPlayer(PlayerRequest playerRequest){
      Player player= PlayerConvertor.playerRequesToPlayer(playerRequest);
      Player savedPlayer=playerRepository.save(player);
      return PlayerConvertor.playerToPlayerResponse(savedPlayer);
    }

    public PlayerResponse getPlayerByid(int id){
      Optional<Player> playerOptional= playerRepository.findById(id);
      if(playerOptional.isEmpty()){
          throw new PlayerNotFoundException("player with id: "+id+" doesn't exist");
      }
      return PlayerConvertor.playerToPlayerResponse(playerOptional.get());
    }

    public List<PlayerResponse> getByGenderAndGreaterThan(Gender gender, int age) {
        List<Player> players=playerRepository.findByGenderAndAgeGreaterThan(gender,age);

        List<PlayerResponse> playerResponses=new ArrayList<>();
        for(Player player:players){
            playerResponses.add(PlayerConvertor.playerToPlayerResponse(player));
        }
        return playerResponses;
    }
    public List<PlayerResponse> getByGenderAndSpeciality(Gender gender, Speciality speciality) {
        List<Player> players=playerRepository.getByGenderAndSpeciality(gender,speciality);

        List<PlayerResponse> playerResponses=new ArrayList<>();
        for(Player player:players){
            playerResponses.add(PlayerConvertor.playerToPlayerResponse(player));
        }
        return playerResponses;
    }


}
