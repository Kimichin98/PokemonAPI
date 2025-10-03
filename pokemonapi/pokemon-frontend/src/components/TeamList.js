import React, { useEffect, useState } from "react";
import axios from "axios";

function TeamList() {
  const [teams, setTeams] = useState([]);
  const [teamName, setTeamName] = useState("");
  const [pokemonId, setPokemonId] = useState("");
  const [selectedTeam, setSelectedTeam] = useState(null);

  // Load all teams
  useEffect(() => {
    axios.get("http://localhost:8080/teams")
      .then(res => setTeams(res.data))
      .catch(err => console.error(err));
  }, []);

  // Create team (hardcoded trainerId=1 for now)
  const createTeam = () => {
    axios.post(`http://localhost:8080/teams?trainerId=1&name=${teamName}`)
      .then(res => setTeams([...teams, res.data]))
      .catch(err => console.error(err));
  };

  // Delete team
  const deleteTeam = (id) => {
    axios.delete(`http://localhost:8080/teams/${id}`)
      .then(() => setTeams(teams.filter(t => t.id !== id)))
      .catch(err => console.error(err));
  };

  // Add Pokémon to team
  const addPokemonToTeam = (teamId) => {
    axios.put(`http://localhost:8080/teams/${teamId}/add/${pokemonId}`)
      .then(res => {
        setTeams(teams.map(t => t.id === teamId ? res.data : t));
        setPokemonId("");
        setSelectedTeam(null);
      })
      .catch(err => console.error(err));
  };

  return (
    <div style={{ marginTop: "40px" }}>
      <h2>Teams</h2>

      {/* Create Team */}
      <input
        type="text"
        placeholder="Team name"
        value={teamName}
        onChange={(e) => setTeamName(e.target.value)}
      />
      <button onClick={createTeam}>Create Team</button>

      {/* List Teams */}
      {teams.map(team => (
        <div key={team.id} style={{ border: "1px solid gray", margin: "10px", padding: "10px" }}>
          <h3>{team.name}</h3>
          <button onClick={() => deleteTeam(team.id)}>Delete Team</button>

          {/* Show Pokémon */}
          <ul>
            {team.pokemon.map(p => (
              <li key={p.id}>{p.name} ({p.type1}/{p.type2 || "-"})</li>
            ))}
          </ul>

          {/* Add Pokémon to this team */}
          {selectedTeam === team.id ? (
            <div>
              <input
                type="text"
                placeholder="Pokemon ID"
                value={pokemonId}
                onChange={(e) => setPokemonId(e.target.value)}
              />
              <button onClick={() => addPokemonToTeam(team.id)}>Add</button>
            </div>
          ) : (
            <button onClick={() => setSelectedTeam(team.id)}>Add Pokémon</button>
          )}
        </div>
      ))}
    </div>
  );
}

export default TeamList;