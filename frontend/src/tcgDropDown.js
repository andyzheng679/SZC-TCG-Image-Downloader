import React, { useState, useEffect } from 'react';

function TcgSelector() {
  const [selectedTcg, setSelectedTcg] = useState("");  // Store the selected TCG
  const [sets, setSets] = useState({});  // Store fetched sets as a map
  const [searchTerm, setSearchTerm] = useState("");  // Store search term
  const [filteredSets, setFilteredSets] = useState([]);  // Store filtered sets
  const [pokemonSetData, setPokemonSetData] = useState(null);  // Store detailed set data
  const [showSets, setShowSets] = useState(true);  // Control visibility of the sets dropdown
  const [selectedSetName, setSelectedSetName] = useState("");  // Store the name of the selected set

  // Fetch TCG sets based on the selected TCG
  useEffect(() => {
    if (selectedTcg) {
      fetchTcgSets(selectedTcg);
    }
  }, [selectedTcg]);

  // Function to fetch sets based on selected TCG
  const fetchTcgSets = (tcg) => {
    let endpoint = '';
    switch (tcg) {
      case 'pokemon':
        endpoint = '/pokemon/all';
        break;
      default:
        return;
    }

    fetch(`http://localhost:8080${endpoint}`)
      .then((response) => response.json())
      .then((data) => {
        setSets(data);  // Store fetched sets as a map
        setFilteredSets(Object.entries(data));  // Initialize with all data converted to an array
      })
      .catch((error) => console.error('Error fetching TCG sets:', error));
  };

  // Handle search input change
  const handleSearchChange = (event) => {
    const term = event.target.value.toLowerCase();
    setSearchTerm(term);

    // Filter sets based on the search term by filtering the key of each map entry
    const filtered = Object.entries(sets).filter(([key]) => 
      key.toLowerCase().includes(term)
    );
    setFilteredSets(filtered);  // Update filtered sets
  };

  // Fetch detailed set data when a set is selected
  const handleSetSelect = (setName, setId) => {
    setSelectedSetName(setName);  // Store the name of the selected set
    setSearchTerm(setName);  // Fill the search bar with the selected set name
    setShowSets(false);  // Hide the set list but keep the TCG dropdown

    fetch(`http://localhost:8080/pokemon/set/${setId}`)
      .then(response => response.json())
      .then(data => {
        setPokemonSetData(data);  // Store the detailed set data (cards)
      })
      .catch((error) => console.error('Error fetching set data:', error));
  };

  return (
    <div className="App">
      <h1>Select a TCG</h1>

      {/* Container to align dropdown and search bar side by side */}
      <div className="input-container">
        {/* Dropdown for selecting TCG */}
        <select value={selectedTcg} onChange={(e) => setSelectedTcg(e.target.value)}>
          <option value="">--Select a TCG--</option>
          <option value="pokemon">Pokémon</option>
          {/* Add more TCG options as needed */}
        </select>

        {/* Search bar for filtering sets */}
        <input
          type="text"
          placeholder={`Search ${selectedTcg} sets...`}
          value={searchTerm}
          onChange={handleSearchChange}
        />
      </div>

      {/* Display filtered sets and allow selecting a set */}
      {filteredSets.length > 0 && showSets && (
        <ul>
          {filteredSets.map(([setName, setId]) => (
            <li key={setId} onClick={() => handleSetSelect(setName, setId)}>
              {setName} (ID: {setId})
            </li>
          ))}
        </ul>
      )}

      {/* Display detailed set data */}
      {pokemonSetData && (
        <div>
          <h2>Details for Set: {selectedSetName}</h2>
          <ul>
            {pokemonSetData.map(pokemon => (
              <li key={pokemon.name}>
                <strong>{pokemon.name}</strong> - {pokemon.rarity}
                <br />
                <img src={pokemon.imgURL} alt={pokemon.name} style={{ width: '100px' }} />
                <br />
                <a href={pokemon.tcgplayerUrl} target="_blank" rel="noopener noreferrer">Buy on TCGPlayer</a>
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
}

export default TcgSelector;
