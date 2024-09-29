function CardList - accepts one prop, the tcgSetData, all the cards in the set. Takes the data and displays it. 

The if statement checks if at least one of the condition is true, then don't return anything. Due to the original state of tcgSetData being an empty array, we need to check if the length is zero.

return:

classname - used for styling.
tcgSetData.map(card) - takes the array and iterates over it using .map, takes that object card and passes it into the function.
key - used to help React identify and update.
strong - displays the card name in bold.
Displays the name of the card - card rarity.
br - line break, moves the img to the next line.
img src - displays the card's image using imgURL.
alt - in event where img can't be displayed, show card name.
style - inline CSS, sets the width of the image to 150 pixels, then line break.
a href - creates a hyperlink that directs to tcgplayerUrl.
target - opens the link in a new tab.
rel - noopener prevents the new tab of window from being able to access the original page through window.opener, prevents a form of phishing called tabnabbing. noreferrer prevents browser from sending the Referer header to the new page, it tells the new page what website the user came from, noreferrer prevents that.  