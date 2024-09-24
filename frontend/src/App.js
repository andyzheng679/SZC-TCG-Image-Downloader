import './App.css';
import React, {useState, useEffect} from 'react';
import TCGDropDown from './components/TCGDropDown';


function App() {

  const [selectedTcg, setSelectedTcg] = useState("");

  const handleTcgChange = (event) => {
    setSelectedTcg(event.target.value);
  }




  return (
    <div className="App">

      <TCGDropDown selectedTcg={selectedTcg} handleTcgChange={handleTcgChange}/>

    </div>
  );
}

export default App;
