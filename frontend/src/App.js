import './App.css';
import React, {useState, useEffect} from 'react';
import TCGDropDown from './components/TCGDropDown';
import SearchBar from './components/SearchBar';


function App() {

  const [selectedTcg, setSelectedTcg] = useState("");
  const [apiEndPoint, setApiEndPoint] = useState("");
  const [sets, setSets] = useState({});

  const handleTcgChange = (event) => {
    setSelectedTcg(event.target.value);
  };

  useEffect(() => {
    switch(selectedTcg){
      case "pokemon":
        setApiEndPoint("/pokemon/set");
        break;
      case "testing":
        setApiEndPoint("/testing/set");
        break;
      case "testing2":
        setApiEndPoint("/testing2/set");
        break;
      default:
        setApiEndPoint("");
    }
  }, [selectedTcg]);

  useEffect(() => {
    if(apiEndPoint){
      fetch(`http://localhost:8080${apiEndPoint}`)
      .then((response) => response.json())
      .then((data) => {
        setSets(data);
        console.log("Fetched data:", data);
      })
      .catch((error) => console.error("Error fetching data:", error));
    }
  }, [apiEndPoint]);


  return (
    <div className="App">

      <TCGDropDown selectedTcg={selectedTcg} handleTcgChange={handleTcgChange}/>
      <SearchBar/>
    </div>
  );
}

export default App;
