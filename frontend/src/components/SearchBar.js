import React, { useState } from 'react';

function SearchBar({ sets, searchTerm, setSearchTerm }) {
  const [showDropDown, setShowDropDown] = useState(false);  

  const filteredSets = Object.entries(sets).filter(([key, value]) => 
    key.toLowerCase().includes(searchTerm.toLowerCase())  
  );

  const handleSelect = (selectedKey) => {
    setSearchTerm(selectedKey);  
    setShowDropDown(false);  
  };

  return (
    <div className="search-container">
      <input
        type="text"
        placeholder="Search sets..."
        value={searchTerm}
        onChange={(event) => {
          setSearchTerm(event.target.value);  
          setShowDropDown(true);  
        }}
        onClick={() => setShowDropDown(true)}  
      />

      {showDropDown && filteredSets.length > 0 &&(
        <ul className="dropdown">
          {filteredSets.map(([key, value]) => (
            <li key={key} onClick={() => handleSelect(key)}>
              {key}: {value} 
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default SearchBar;
