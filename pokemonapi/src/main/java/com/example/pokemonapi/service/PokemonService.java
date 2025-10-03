package com.example.pokemonapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.pokemonapi.model.Pokemon;
import com.example.pokemonapi.repository.PokemonRepository;

@Service
public class PokemonService {
  private final PokemonRepository pokemonRepository;
  private final PokeApiService pokeApiService;

  public PokemonService(PokemonRepository pokemonRepository, PokeApiService pokeApiService) {
    this.pokemonRepository = pokemonRepository;
    this.pokeApiService = pokeApiService;
  }

  public Pokemon createPokemonFromApi(String name) {
    // check if already exists
    Optional<Pokemon> existing = pokemonRepository.findByNameIgnoreCase(name);
    if (existing.isPresent()) {
      return existing.get();
    }
    // Fetch from PokeAPI
    Pokemon pokemon = pokeApiService.fetchPokemonFromApi(name);
    // Save to DB
    return pokemonRepository.save(pokemon);
  }

  // Instead of creating pokemons manually, we're fetching from the API

  // public Pokemon createPokemon(Pokemon pokemon) {
  // return pokemonRepository.save(pokemon);
  // }

  public Pokemon getPokemon(Long id) {
    return pokemonRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Pokemon not found"));
  }

  public List<Pokemon> getAllPokemon() {
    return pokemonRepository.findAll();
  }

  public Pokemon findByName(String name) {
    return pokemonRepository.findByNameIgnoreCase(name)
        .orElseThrow(() -> new RuntimeException("Pokemon not found: " + name));
  }
}
