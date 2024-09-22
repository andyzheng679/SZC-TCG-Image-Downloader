import React, { useState, useEffect } from 'react';
import './App.css';  // Ensure you have your styles imported

function TcgDropDown() {
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
        endpoint = '/pokemon/set';
        break;
      default:
        return;
    }

    fetch(`http://localhost:8080${endpoint}`)
      .then((response) => response.json())
      .then((data) => {
        setSets(data);  // Store fetched sets as a map
        setFilteredSets(Object.entries(data));  // Initialize with all data converted to an array
        setShowSets(true); // Show the sets dropdown when new sets are loaded
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
    setShowSets(true);  // Show the sets dropdown while searching
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

  // Function to reset the search bar and show the set dropdown
  const resetSearch = () => {
    setSearchTerm("");  // Clear the search term
    setShowSets(true);  // Show the sets dropdown again
  };

  return (
    <div className="App">
      <h1>Select a TCG</h1>

      {/* Container to align dropdown and search bar side by side */}
      <div className="input-container">
        {/* Dropdown for selecting TCG */}
        <select value={selectedTcg} onChange={(e) => {
          setSelectedTcg(e.target.value);
          resetSearch();  // Reset the search when a new TCG is selected
        }}>
          <option value="">--Select a TCG--</option>
          <option value="pokemon">Pokémon</option>
          {/* Add more TCG options as needed */}
        </select>

        {/* Wrap search bar and dropdown in relative container */}
        <div className="search-container">
          {/* Search bar for filtering sets */}
          <input
            type="text"
            placeholder={`Search ${selectedTcg} sets...`}
            value={searchTerm}
            onChange={handleSearchChange}
          />

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
        </div>
      </div>

      {/* Display detailed set data */}
      {pokemonSetData && (
        <div>
          <h2>Details for Set: {selectedSetName}</h2>
          <table>
            <thead>
              <tr>
                <th>Image</th>
                <th>Name & Rarity</th>
                <th>TCGPlayer URL</th>
              </tr>
            </thead>
            <tbody>
              {pokemonSetData.map(pokemon => (
                <tr key={pokemon.name}>
                  <td><img src={pokemon.imgURL} alt={pokemon.name} style={{ width: '100px' }} /></td>
                  <td><strong>{pokemon.name}</strong> - {pokemon.rarity}</td>
                  <td><a href={pokemon.tcgplayerUrl} target="_blank" rel="noopener noreferrer">Buy on TCGPlayer</a></td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default TcgDropDown;
