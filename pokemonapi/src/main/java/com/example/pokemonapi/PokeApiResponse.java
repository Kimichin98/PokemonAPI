package com.example.pokemonapi;

import java.util.List;

public class PokeApiResponse {
  private int id;
  private String name;
  private List<TypeSlot> types;
  private List<StatSlot> stats;

  // inner DTOs -- Maping only the fields we need
  public static class TypeSlot {
    private Type type;

    public Type getType() {
      return type;
    }

    public void setType(Type type) {
      this.type = type;
    }
  }

  public static class Type {
    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  public static class StatSlot {
    private int base_stat;
    private Stat stat;

    public int getBase_stat() {
      return base_stat;
    }

    public void setBase_stat(int base_stat) {
      this.base_stat = base_stat;
    }

    public Stat getStat() {
      return stat;
    }

    public void setStat(Stat stat) {
      this.stat = stat;
    }
  }

  public static class Stat {
    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  // getters & setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<TypeSlot> getTypes() {
    return types;
  }

  public void setTypes(List<TypeSlot> types) {
    this.types = types;
  }

  public List<StatSlot> getStats() {
    return stats;
  }

  public void setStats(List<StatSlot> stats) {
    this.stats = stats;
  }
}