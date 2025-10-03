package com.example.pokemonapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pokemonapi.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
  Optional<Pokemon> findByNameIgnoreCase(String name);
}
