package com.example.pokemonapi.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "team")
public class Team {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    // Many teams belong to one trainer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;

    // Many-to-Many relationship with Pokémon
    @ManyToMany
    @JoinTable(
        name = "team_pokemon",
        joinColumns = @JoinColumn(name = "team_id"),
        inverseJoinColumns = @JoinColumn(name = "pokemon_id")
    )
    private Set<Pokemon> pokemonList;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Trainer getTrainer() {
        return trainer;
    }
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
    public Set<Pokemon> getPokemonList() {
        return pokemonList;
    }
    public void setPokemonList(Set<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
    
}
