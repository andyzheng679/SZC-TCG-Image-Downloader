function SearchBar - component accepts four props, sets: a map containing the data to be searched, searchTerm: the current value in the search input field, setSearchTerm: code to change searchTerm, fetchSetData: will take in the key from the set and fetch all the card data from it. 

const [showDropDown, setShowDropDown] = useState(false); - showDropDown will start as false, and setShowDropDown will change the state. Use to show the dropdown of the sets or not.

const filteredSets - takes the state sets which is a map and converts it into an array of key-value pairs so it can be filtered. Takes and converts all the keys to lowercase and the state of the searchTerm into lowercase, the .include checks if the key contains the searchTerm. 

const handleSelect - handles when user clicks on an item from the set dropdown. Takes in param of selectedKey, which is the key from the key-value pair. setSearchTerm() will update the state of the searchTerm to the selectedKey. The idea is to use that state to display the set the user clicked. setShowDropDown() will hide the dropdown after the user selects. 

return: 

className="search-container" - class name used for css styling. 
Creates the input field, the searchbar. 
value is set to the state of the searchTerm.
onChange will trigger everytime the input value changes. An event is passed through, that event is what the user is entering, setSearchTerm will set the state of searchTerm to the event using event.target.value. setShowDownDrop sets the state of showDropDown to true so the dropdown will appear. OnClick will show the drop down when the user clicks on the input box. 

{showDropDown && filteredSets.length > 0 && ...} - this will check if showDropDown is true, and if the length of filteredSets is greater than 0, which means there is an option. We are using && after each check to short circuit multiple conditionals. If there is a false, it will just stop and nothing is rendered. ul element is an unordered list. li is list items. .map loops through the array created by filteredSets, ([key, value]) is destructuring, since each element is a pair, this will split it into two variables. key={key} each li must have a unique key prop when rendering, the key is set to the key from the key value pairs in filteredSets. onClick will call handleSelected when user clicks on a list item, what will happen is that it will update the input field to the key and hide the dropdown. {key}: {value} is the key value that is being displayed, from the destructuring. 

whenever the user types in the search bar, the state of searchTerm will change, and in React, when a state changes, the component will rerender, causing const filteredSets to trigger and filter based on what the searchTerm is.