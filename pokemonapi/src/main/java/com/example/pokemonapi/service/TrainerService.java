package com.example.pokemonapi.service;

import org.springframework.stereotype.Service;

import com.example.pokemonapi.model.Trainer;
import com.example.pokemonapi.repository.TrainerRepository;

@Service
public class TrainerService {

  private final TrainerRepository trainerRepository;

  public TrainerService(TrainerRepository trainerRepository) {
    this.trainerRepository = trainerRepository;
  }

  public Trainer registerTrainer(Trainer trainer) {
    // TODO: hash password here before saving
    return trainerRepository.save(trainer);
  }

  public Trainer getTrainer(Long id) {
    return trainerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Trainer not found"));
  }
}
