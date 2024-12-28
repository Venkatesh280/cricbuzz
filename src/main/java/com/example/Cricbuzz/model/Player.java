package com.example.Cricbuzz.model;

import com.example.Cricbuzz.model.enums.Gender;
import com.example.Cricbuzz.model.enums.Speciality;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    int age;

    String email;

    @Enumerated(EnumType.STRING)
    Speciality speciality;

    @Enumerated(EnumType.STRING)
    Gender gender;

   @OneToOne(mappedBy="player",cascade=CascadeType.ALL)
   @JsonManagedReference
   Stats stats;


   @ManyToOne
    @JoinColumn
    @JsonManagedReference
    Team team;







}
