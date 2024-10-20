package com.fullstack.clubs.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Evenement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private float cout;

    @ManyToOne
    private Club club;

    @ManyToMany(mappedBy = "events")
    private List<Participant> participants;

    @OneToMany
    List<Logistique> logs;

}
