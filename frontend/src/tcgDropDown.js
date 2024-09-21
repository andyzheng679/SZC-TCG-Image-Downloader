import React, { useState, useEffect } from 'react';

function TcgDropDown() {
  const [data, setData] = useState([]);   // To store the fetched data
  const [filteredData, setFilteredData] = useState([]);  // To store filtered data for the dropdown
  const [searchTerm, setSearchTerm] = useState("");  // To store the user's search term
  const [selectedSet, setSelectedSet] = useState(null); // Store the selected TCG set

  // Fetch data when the component mounts
  useEffect(() => {
    fetch('http://localhost:8080/test3')
      .then(response => response.json())
      .then(data => {
        const entries = Object.entries(data);
        setData(entries); // Store the data from the backend
        setFilteredData(entries); // Initialize the filtered data with all options
      })
      .catch(error => console.error('Error fetching data:', error));
  }, []);

  // Function to handle user typing in the search bar
  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
    const filtered = data.filter(([key]) => key.toLowerCase().includes(event.target.value.toLowerCase()));
    setFilteredData(filtered);
  };

  // Function to handle selection of a set
  const handleSelectSet = (setName) => {
    setSelectedSet(setName);  // Set the selected set name
    setSearchTerm(setName);   // Put the selected set into the search bar
  };

  return (
    <div className="App">
      <h1>Search for a TCG Set</h1>
      
      {/* Search input field */}
      <input 
        type="text" 
        placeholder="Search TCG Sets..." 
        value={searchTerm} 
        onChange={handleSearchChange} 
        onFocus={() => setFilteredData(data)}  // Show dropdown when the input is focused
      />

      {/* Display the dropdown options */}
      {filteredData.length > 0 && (
        <ul>
          {filteredData.map(([key]) => (
            <li key={key} onClick={() => handleSelectSet(key)}>
              {key}
            </li>
          ))}
        </ul>
      )}

      {/* Display the selected set if available */}
      {selectedSet && (
        <div>
          <h2>Selected Set: {selectedSet}</h2>
        </div>
      )}
    </div>
  );
}

export default TcgDropDown;
