import './App.css';
import React, {useState, useEffect} from 'react';
import TCGDropDown from './components/TCGDropDown';
import SearchBar from './components/SearchBar';
import CardList from './components/CardList';
import DownloadButton from './components/DownloadButton';


function App() {

  const [selectedTcg, setSelectedTcg] = useState("");
  const [apiEndPoint, setApiEndPoint] = useState("");
  const [sets, setSets] = useState({});
  const [searchTerm, setSearchTerm] = useState(""); 
  const [tcgSetData, setTcgSetData] = useState([]);

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

  const fetchSetData = (setID) => {
    fetch(`http://localhost:8080${apiEndPoint}/${setID}`)
    .then((response) => response.json())
      .then((data) => {
        setTcgSetData(data);
        console.log("Fetched data:", data);
      })
      .catch((error) => console.error("Error fetching set data:", error));
  };


  return (

    <div className="App">
      <h1>TCG Image Downloader</h1>
      
      <div className="input-container">
        <TCGDropDown selectedTcg={selectedTcg} handleTcgChange={handleTcgChange} className="tcg-dropdown" />

        <SearchBar sets={sets} searchTerm={searchTerm} setSearchTerm={setSearchTerm} fetchSetData={fetchSetData}/>
        <DownloadButton tcgSetData={tcgSetData}/>
        <CardList tcgSetData={tcgSetData}/>
        

        </div>
    </div>
  );
}

export default App;
