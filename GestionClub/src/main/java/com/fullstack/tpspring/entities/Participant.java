package com.fullstack.tpspring.entities;

import com.fullstack.tpspring.enums.Tache;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Participant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Tache tache;

    @ManyToMany(cascade = CascadeType.PERSIST)

    private List<Evenement> events;

}
