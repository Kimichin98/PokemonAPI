package com.example.pokemonapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pokemonapi.model.Pokemon;
import com.example.pokemonapi.model.Team;
import com.example.pokemonapi.model.Trainer;
import com.example.pokemonapi.repository.PokemonRepository;
import com.example.pokemonapi.repository.TeamRepository;
import com.example.pokemonapi.repository.TrainerRepository;

@Service
public class TeamService {
  private final TeamRepository teamRepository;
  private final TrainerRepository trainerRepository;
  private final PokemonRepository pokemonRepository;

  public TeamService(TeamRepository teamRepository,
      TrainerRepository trainerRepository,
      PokemonRepository pokemonRepository) {
    this.teamRepository = teamRepository;
    this.trainerRepository = trainerRepository;
    this.pokemonRepository = pokemonRepository;
  }

  public Team createTeam(Long trainerId, String name) {
    Trainer trainer = trainerRepository.findById(trainerId)
        .orElseThrow(() -> new RuntimeException("Trainer not found"));

    Team team = new Team();
    team.setName(name);
    team.setTrainer(trainer);
    return teamRepository.save(team);
  }

  public Team addPokemonToTeam(Long teamId, Long pokemonId) {
    Team team = teamRepository.findById(teamId)
        .orElseThrow(() -> new RuntimeException("Team not found"));
    Pokemon pokemon = pokemonRepository.findById(pokemonId)
        .orElseThrow(() -> new RuntimeException("Pokemon not found"));

    if (team.getPokemonList().size() >= 6) {
      throw new RuntimeException("Team cannot have more than 6 Pokémon");
    }

    if (team.getPokemonList().contains(pokemon)) {
      throw new RuntimeException("This Pokémon is already in the team");
    }

    team.getPokemonList().add(pokemon);
    return teamRepository.save(team);
  }

  public Team getTeam(Long id) {
    return teamRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Team not found"));
  }

  public List<Team> getTrainerTeams(Long trainerId) {
    return teamRepository.findByTrainerId(trainerId);
  }
}
