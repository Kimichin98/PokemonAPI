import React, { useEffect, useState } from "react";
import axios from "axios";

function PokemonList() {
  const [pokemon, setPokemon] = useState([]);
  const [name, setName] = useState("");

  // Load all Pokémon
  useEffect(() => {
    axios.get("http://localhost:8080/pokemon")
      .then(res => setPokemon(res.data))
      .catch(err => console.error(err));
  }, []);

  // Import Pokémon from PokeAPI
  const addPokemon = () => {
    axios.post(`http://localhost:8080/pokemon/import/${name}`)
      .then(res => setPokemon([...pokemon, res.data]))
      .catch(err => console.error(err));
  };

  // Delete Pokémon
  const deletePokemon = (id) => {
    axios.delete(`http://localhost:8080/pokemon/${id}`)
      .then(() => setPokemon(pokemon.filter(p => p.id !== id)))
      .catch(err => console.error(err));
  };

  return (
    <div>
      <h2>Pokémon List</h2>

      {/* Add new Pokémon */}
      <input
        type="text"
        placeholder="Enter Pokémon name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <button onClick={addPokemon}>Add Pokémon</button>

      {/* Table of Pokémon */}
      <table border="1" style={{ marginTop: "10px" }}>
        <thead>
          <tr>
            <th>Name</th><th>Type1</th><th>Type2</th>
            <th>HP</th><th>Attack</th><th>Defense</th><th>Speed</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {pokemon.map(p => (
            <tr key={p.id}>
              <td>{p.name}</td>
              <td>{p.type1}</td>
              <td>{p.type2 || "-"}</td>
              <td>{p.hp}</td>
              <td>{p.attack}</td>
              <td>{p.defense}</td>
              <td>{p.speed}</td>
              <td>
                <button onClick={() => deletePokemon(p.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default PokemonList;