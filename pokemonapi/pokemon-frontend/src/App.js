import React from "react";
import PokemonList from "./components/PokemonList";
import TeamList from "./components/TeamList";

function App() {
  return (
    <div>
      <h1>Pokémon Trainer App</h1>
      <PokemonList />
      <TeamList />
    </div>
  );
}

export default App;