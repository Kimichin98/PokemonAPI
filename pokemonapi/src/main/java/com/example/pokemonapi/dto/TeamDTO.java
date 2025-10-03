package com.example.pokemonapi.dto;

import java.util.List;

public class TeamDTO {
  
  private Long id;
  private String name;
  private Long trainerId;
  private String trainerUsername;
  private List<PokemonDTO> pokemonList;


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getTrainerId() {
    return this.trainerId;
  }

  public void setTrainerId(Long trainerId) {
    this.trainerId = trainerId;
  }

  public String getTrainerUsername() {
    return this.trainerUsername;
  }

  public void setTrainerUsername(String trainerUsername) {
    this.trainerUsername = trainerUsername;
  }

  public List<PokemonDTO> getPokemonList() {
    return this.pokemonList;
  }

  public void setPokemonList(List<PokemonDTO> pokemonList) {
    this.pokemonList = pokemonList;
  }

}
