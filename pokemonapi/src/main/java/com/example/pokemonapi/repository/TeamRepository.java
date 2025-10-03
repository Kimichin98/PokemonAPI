package com.example.pokemonapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pokemonapi.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
   List<Team> findByTrainerId(Long trainerId);
}
