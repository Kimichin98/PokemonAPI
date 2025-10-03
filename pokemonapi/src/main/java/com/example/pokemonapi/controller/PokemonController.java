package com.example.pokemonapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pokemonapi.dto.PokemonDTO;
import com.example.pokemonapi.model.Pokemon;
import com.example.pokemonapi.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
  
  private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<PokemonDTO> getAllPokemon() {
        return pokemonService.getAllPokemon().stream()
                .map(this::mapToDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public PokemonDTO getPokemonById(@PathVariable Long id) {
        Pokemon pokemon = pokemonService.getPokemon(id);
        return mapToDTO(pokemon);
    }

    @PostMapping("import/{name}")
    public PokemonDTO createPokemon(@PathVariable String name) {
        Pokemon saved = pokemonService.createPokemonFromApi(name);
        return mapToDTO(saved);
    }

    private PokemonDTO mapToDTO(Pokemon pokemon) {
        PokemonDTO dto = new PokemonDTO();
        dto.setId(pokemon.getId());
        dto.setName(pokemon.getName());
        dto.setType1(pokemon.getType1());
        dto.setType2(pokemon.getType2());
        dto.setHp(pokemon.getHp());
        dto.setAttack(pokemon.getAttack());
        dto.setDefense(pokemon.getDefense());
        dto.setSpeed(pokemon.getSpeed());
        return dto;
    }
}
