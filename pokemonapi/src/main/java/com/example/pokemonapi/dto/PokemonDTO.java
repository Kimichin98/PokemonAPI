package com.example.pokemonapi.dto;

public class PokemonDTO {
    private Long id;
    private String name;
    private String type1;
    private String type2;
    private int hp;
    private int attack;
    private int defense;
    private int speed;


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType1() {
    return this.type1;
  }

  public void setType1(String type1) {
    this.type1 = type1;
  }

  public String getType2() {
    return this.type2;
  }

  public void setType2(String type2) {
    this.type2 = type2;
  }

  public int getHp() {
    return this.hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public int getAttack() {
    return this.attack;
  }

  public void setAttack(int attack) {
    this.attack = attack;
  }

  public int getDefense() {
    return this.defense;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }

  public int getSpeed() {
    return this.speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

}
