package com.example.pokemonapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pokemonapi.model.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

  Optional<Trainer> findByUsername(String username);
  Optional<Trainer> findByEmail(String email);
}
