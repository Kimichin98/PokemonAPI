package com.example.pokemonapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pokemonapi.dto.TeamDTO;
import com.example.pokemonapi.dto.TrainerDTO;
import com.example.pokemonapi.model.Team;
import com.example.pokemonapi.model.Trainer;
import com.example.pokemonapi.service.TeamService;
import com.example.pokemonapi.service.TrainerService;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

  private final TrainerService trainerService;
  private final TeamService teamService;

  public TrainerController(TrainerService trainerService, TeamService teamService) {
    this.trainerService = trainerService;
    this.teamService = teamService;
  }

  @PostMapping("/register")
  public TrainerDTO registerTrainer(@RequestBody Trainer trainer) {
    Trainer saved = trainerService.registerTrainer(trainer);
    return mapToDTO(saved);
  }

  @GetMapping("/{id}")
  public TrainerDTO getTrainer(@PathVariable Long id) {
    Trainer trainer = trainerService.getTrainer(id);
    return mapToDTO(trainer);
  }

  @GetMapping("/{id}/teams")
  public List<TeamDTO> getTrainerTeams(@PathVariable Long id) {
    return teamService.getTrainerTeams(id).stream()
        .map(this::mapTeamToDTO)
        .toList();
  }

  private TrainerDTO mapToDTO(Trainer trainer) {
    TrainerDTO dto = new TrainerDTO();
    dto.setId(trainer.getId());
    dto.setUsername(trainer.getUsername());
    dto.setEmail(trainer.getEmail());
    return dto;
  }

  private TeamDTO mapTeamToDTO(Team team) {
    TeamDTO dto = new TeamDTO();
    dto.setId(team.getId());
    dto.setName(team.getName());
    dto.setTrainerId(team.getTrainer().getId());
    dto.setTrainerUsername(team.getTrainer().getUsername());
    return dto;
  }
}
