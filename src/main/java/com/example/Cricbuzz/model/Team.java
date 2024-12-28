package com.example.Cricbuzz.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int ranking;

    int iccPoints;

    String coach;

    int matchPlayed;

    @OneToMany(mappedBy = "team")
    @JsonBackReference
    List<Player> player;

    @ManyToMany(mappedBy = "teams")
    @JsonBackReference
    List<CricketMatch> matches;







}
