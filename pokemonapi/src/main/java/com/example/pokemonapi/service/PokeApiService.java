package com.example.pokemonapi.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.pokemonapi.PokeApiResponse;
import com.example.pokemonapi.model.Pokemon;

@Service
public class PokeApiService {
  private final RestTemplate restTemplate;

  public PokeApiService(RestTemplateBuilder builder) {
    this.restTemplate = builder.build();
  }

  public Pokemon fetchPokemonFromApi(String name) {
    String url = "https://pokeapi.co/api/v2/pokemon/" + name.toLowerCase();

    PokeApiResponse response = restTemplate.getForObject(url, PokeApiResponse.class);

    if (response == null) {
      throw new RuntimeException("Pokemon not found in PokeAPI: " + name);
    }

    // Map to Pokemon entity
    Pokemon pokemon = new Pokemon();
    pokemon.setName(response.getName());

    // handle types and dual types
    if (!response.getTypes().isEmpty()) {
      pokemon.setType1(response.getTypes().get(0).getType().getName());
      if (response.getTypes().size() > 1) {
        pokemon.setType2(response.getTypes().get(1).getType().getName());
      }
    }

    // map stats
    for (PokeApiResponse.StatSlot statSlot : response.getStats()) {
      switch (statSlot.getStat().getName()) {
        case "hp" -> pokemon.setHp(statSlot.getBase_stat());
        case "attack" -> pokemon.setAttack(statSlot.getBase_stat());
        case "defense" -> pokemon.setDefense(statSlot.getBase_stat());
        case "speed" -> pokemon.setSpeed(statSlot.getBase_stat());
      }
    }

    return pokemon;
  }
}