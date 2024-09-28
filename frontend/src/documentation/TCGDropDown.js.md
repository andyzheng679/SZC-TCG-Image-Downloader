This component renders a dropdown using select element, allowing user to select TCG

Passing in the state selectedTcg and the function handleTcgChange as props. {} is need, called destructuring, makes the props specific by extracting only the values you need from the props. 

Passing the selectedTcg as a prop, will start off as an empty String, but will change when user selects a value. The onChange is an event handler that calls the handleTcgChange function in App.js, will pass the event (what value the user picks) into the function. 

option element used in the select element to define the options the user can select. The value attribute contains data that will be passed to the handleTcgChange function. 