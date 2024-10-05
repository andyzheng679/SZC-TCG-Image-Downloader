import React, { useState, useEffect } from 'react';
import './DarkModeToggle.css'; // Make sure to include the CSS file

function DarkModeToggle() {
  const [darkMode, setDarkMode] = useState(false);

  const toggleDarkMode = () => {
    setDarkMode(prevMode => !prevMode);
  };

  // Apply or remove the dark-mode class based on the state
  useEffect(() => {
    if (darkMode) {
      document.body.classList.add('dark-mode');
    } else {
      document.body.classList.remove('dark-mode');
    }
  }, [darkMode]);

  return (
    <div className="dark-mode-toggle">
      <label className="switch">
        <input type="checkbox" checked={darkMode} onChange={toggleDarkMode} />
        <span className="slider round"></span>
      </label>
      <p>{darkMode ? 'Dark Mode' : 'Light Mode'}</p>
    </div>
  );
}

export default DarkModeToggle;
