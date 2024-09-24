import React, {useState, useEffect} from 'react'; - allows us to use react hooks, the useState and useEffect. useState is a variable that React keeps track of inside the function. useEffect contains code that updates the useState. 

function App() - responsible for defining the structure and logic of the application, tells react what to display on the screen.  

const [selectedTcg, setSelectedTcg] = useState(""); - constant array, useState, useEffect, selectedTcg will start as an empty String and setSelectedTcg will have code to change it. Keeping track of the selected TCG.

const handleTcgChange - constanst function that takes in one param, the event. The event is attached to onChange in TCGDropDown, onChange will call the function and pass the event through it. Then calls the setSelectedTcg to change the state of what value is. event.target give us access to the <select> element, and event.target.value gives us access to the value in the select. 


<TCGDropDown selectedTcg={selectedTcg} handleTcgChange={handleTcgChange}/> - rendering, passing in the state selectedTcg and the function handleTcgChange as a prop. 
