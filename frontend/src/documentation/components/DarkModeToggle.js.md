Adding Dark mode toggle slider.

imports React, useState and useEffect, useState is a variable that React keeps track of inside the function. useEffect contains code that updates the useState.

Imports ./DarkModeToggle.css

DarkModeToggle function component.

Setting darkMode state to false.

const toggleDarkMode - Defining a toggleDarkMode function, since React knows that setDarkMode is working with darkMode, it takes the darkMode state, assigns it to prevMode. prevMode => !prevMode inverses the state and passes in in setDarkMode. Used to change the dark mode toggle. 

useEffect - triggers when darkMode changes, if darkMode state is true, then React will active all dark-mode class in each imported .css file, else, remove all the dark-mode class.

return - label className="switch" creates a toggle switch. Inside the label tag, checkbox signifies if the dark mode is turned on or off, checked={darkMode} keeps the current darkMode state, when that changes the component rerenders. onChange={toggleDarkMode}, on change it will change the state the the inverse. span className="slider round" makes the toggle look like a rounded slider. Ternary Operator, if darkMode is true, display Dark Mode, if false, display Light Mode.