package com.example.pokemonapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.pokemonapi.service.PokemonService;

@Component
public class DatabaseSeeder implements CommandLineRunner {
  private final PokemonService pokemonService;

  public DatabaseSeeder(PokemonService pokemonService) {
    this.pokemonService = pokemonService;
  }

  @Override
  public void run(String... args) {
    System.out.println("Seeding database with Pokémon...");

    String[] starterPokemon = {
        "bulbasaur", "ivysaur", "venusaur",
        "charmander", "charmeleon", "charizard",
        "squirtle", "wartortle", "blastoise",
        "pikachu"
    };

    for (String name : starterPokemon) {
      try {
        pokemonService.createPokemonFromApi(name);
        System.out.println("Added " + name);
      } catch (Exception e) {
        System.err.println("Failed to fetch " + name + ": " + e.getMessage());
      }
    }
  }
}
