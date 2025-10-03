package com.example.pokemonapi.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "pokemon")
public class Pokemon {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

   @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 30)
    private String type1;

    @Column(length = 30)
    private String type2;

    private int hp;
    private int attack;
    private int defense;
    private int speed;

    // Many-to-Many with Team
    @ManyToMany(mappedBy = "pokemonList")
    private Set<Team> teams;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType1() {
        return type1;
    }
    public void setType1(String type1) {
        this.type1 = type1;
    }
    public String getType2() {
        return type2;
    }
    public void setType2(String type2) {
        this.type2 = type2;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public Set<Team> getTeams() {
        return teams;
    }
    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

}
