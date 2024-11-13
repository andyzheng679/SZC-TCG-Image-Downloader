function CardList - accepts two prop, the tcgSetData, all the cards in the set. Takes the data and displays it. selectedTcg, mainly used for the handleDownload function to know what endpoint to hit.

The if statement checks if at least one of the condition is true, then don't return anything. Due to the original state of tcgSetData being an empty array, we need to check if the length is zero. Can take off the is array since the state will always be an array.

const handleDownload - function takes in three arguments: imgURL, cardName, and rarity. window.location.href this is used to navigate the browser to a new URL, sends a request to that URL. encodeURIComponent encodes the value of imgURL, cardName, and rarity to make sure they are safely included in the query string, special characters like spaces, &, ? are converted into their encoded forms to avoid breaking the URL.

return:

classname - used for styling.
tcgSetData.map(card) - takes the array and iterates over it using .map, takes that object card and passes it into the function.
key - used to help React identify and update.
strong - displays the card name in bold.
Displays the name of the card - card rarity.
br - line break, moves the img to the next line.
button - creates a button, onClick is event handler that triggers when the button is clicked, calls the handleDownload function, passing in card.imgURL, card.name, card.rarity.
img src - displays the card's image using imgURL.
alt - in event where img can't be displayed, show card name.
style - inline CSS, sets the width of the image to 150 pixels, then line break.
Ternary operator: condition ? valueIfTrue : valueIfFalse, checks if there is a tcgplayerUrl.
a href - creates a hyperlink that directs to tcgplayerUrl.
span - an inline element, it won't disrupt the layout or break the flow of the content.
target - opens the link in a new tab.
rel - noopener prevents the new tab of window from being able to access the original page through window.opener, prevents a form of phishing called tabnabbing. noreferrer prevents browser from sending the Referer header to the new page, it tells the new page what website the user came from, noreferrer prevents that.  