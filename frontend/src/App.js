import './App.css';
import React, {useState, useEffect} from 'react';
import TCGDropDown from './components/TCGDropDown';


function App() {

  const [selectedTcg, setSelectedTcg] = useState("");
  const [apiEndPoint, setApiEndPoint] = useState("");

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



  return (
    <div className="App">

      <TCGDropDown selectedTcg={selectedTcg} handleTcgChange={handleTcgChange}/>

    </div>
  );
}

export default App;
