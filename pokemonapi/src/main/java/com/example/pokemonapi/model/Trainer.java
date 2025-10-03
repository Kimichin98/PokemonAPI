package com.example.pokemonapi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "trainers")
public class Trainer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 50)
  private String username;

  @Column(nullable = false, unique = true, length = 100)
  private String email;

  @Column(nullable = false)
  private String password; // store hashed passwords!

  // One trainer -> Many teams
  @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Team> teams;

  // Getters and Setters
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public List<Team> getTeams() {
    return teams;
  }
  public void setTeams(List<Team> teams) {
    this.teams = teams;
  }
  
}
