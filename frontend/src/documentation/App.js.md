import React, {useState, useEffect} from 'react'; - allows us to use react hooks, the useState and useEffect. useState is a variable that React keeps track of inside the function. useEffect contains code that updates the useState. 

function App() - responsible for defining the structure and logic of the application, tells react what to display on the screen.  

const [selectedTcg, setSelectedTcg] = useState(""); - constant array, useState, useEffect, selectedTcg will start as an empty String and setSelectedTcg will have code to change it. Keeping track of the selected TCG.

const [apiEndPoint, setApiEndPoint] = useState(""); - apiEndPoint will start as an empty String, but will change to the endpoint for the selected TCG. setApiEndPoint will contain code to change the state.

const [sets, setSets] = useState({}); - sets will start as an empty map, but will change to the data of the sets and the set id. setSets will contain code to change the state.

const [searchTerm, setSearchTerm] = useState("");  - searchedTerm will start as an empty string, this will hold what the user is typing in the search bar, input field. setSearchTerm will update the state. 


const handleTcgChange - constanst function that takes in one param, the event. The event is attached to onChange in TCGDropDown, onChange will call the function and pass the event through it. Then calls the setSelectedTcg to change the state of what value is. event.target give us access to the select element, and event.target.value gives us access to the value in the select.

useEffect [selectedTcg] - selectedTcg is the state this function depends on. Will trigger this funchtion when the state of selectedTcg changes. Depending on what selectedTcg is, a swtich statement will get the endpoint, pass it to setApiEndPoint to change the state of apiEndPoint.

useEffect [apiEndPoint] - apiEndPoint is the state this function depends on. Will trigger this function when the state of apiEndPoint changes. If the apiEndPoint is not empty then go fetch from 8080 plus the apiEndPoint. .then response will convert the response into JSON format. .then data will parse the data that is in JSON and pass it into setSets to change the empty map state to the data. Console.logs used for debugging. .catch, catch block, let's us know what the error message is. 



TCGDropDown - rendering, passing in the state selectedTcg and the function handleTcgChange as a prop. 

SearchBar - rendering, passing state sets, searchTerms and the function setSearchTerm as props.