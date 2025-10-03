package com.example.pokemonapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pokemonapi.dto.PokemonDTO;
import com.example.pokemonapi.dto.TeamDTO;
import com.example.pokemonapi.model.Team;
import com.example.pokemonapi.service.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {

  private final TeamService teamService;

  public TeamController(TeamService teamService) {
    this.teamService = teamService;
  }

  @PostMapping
  public TeamDTO createTeam(@RequestParam Long trainerId, @RequestParam String name) {
    Team team = teamService.createTeam(trainerId, name);
    return mapToDTO(team);
  }

  @PutMapping("/{teamId}/add/{pokemonId}")
  public TeamDTO addPokemonToTeam(@PathVariable Long teamId, @PathVariable Long pokemonId) {
    Team team = teamService.addPokemonToTeam(teamId, pokemonId);
    return mapToDTO(team);
  }

  @GetMapping("/{id}")
  public TeamDTO getTeam(@PathVariable Long id) {
    Team team = teamService.getTeam(id);
    return mapToDTO(team);
  }

  private TeamDTO mapToDTO(Team team) {
    TeamDTO dto = new TeamDTO();
    dto.setId(team.getId());
    dto.setName(team.getName());
    dto.setTrainerId(team.getTrainer().getId());
    dto.setTrainerUsername(team.getTrainer().getUsername());
    dto.setPokemonList(
        team.getPokemonList().stream().map(p -> {
          PokemonDTO pdto = new PokemonDTO();
          pdto.setId(p.getId());
          pdto.setName(p.getName());
          pdto.setType1(p.getType1());
          pdto.setType2(p.getType2());
          pdto.setHp(p.getHp());
          pdto.setAttack(p.getAttack());
          pdto.setDefense(p.getDefense());
          pdto.setSpeed(p.getSpeed());
          return pdto;
        }).toList());
    return dto;
  }
}
