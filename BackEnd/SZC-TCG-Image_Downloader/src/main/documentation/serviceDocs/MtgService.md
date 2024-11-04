Service Class: business logic.

private RestTemplate restTemplate - Used to perform HTTP requests to external API's.

private ObjectMapper objectMapper - Used to map JSON data into Java objects, vice versa.

private String allMtgSets - url to find all mtg sets.

private String allMtgCards - url to find all the cards in the set, url is missing the set code.

Constructor, Constructor injection.

public ArrayList<Mtg> mapData(String jsonData) - Returns an ArrayList of Mtg objects, take param of the String version of the Json data of all cards in set.
Create an ArrayList<Mtg> to hold all Mtg objects. In a try - catch loop, in the event there is an issue with the mapping.
Catches the exception in variable e, then .printStackTrace will provide a report that includes: type of exception, error message, and all the actions that led up to the error and the file/line.
.readTree() method of ObjectMapper turns the JSON string into a tree-like structure. JsonNode datatype is used to hold and navigate the tree-like structure.
Then we get the value associated with the key "data".
Using Iterator to loop through the elements in the Json Array in data variable. Iterating over a collection of JsonNodes.
.elements() method is used to return an Iterator of elements in the Json array.
While there is still another element in the array, set that element to a JsonNode variable. Get the next element using .next() and assign it to cardInfo.
if cardInfo has image_uris, check if cardInfo has name, rarity, image_uris large, purchase_uris tcgplayer.
Then assign the values to variables, create new instance of Mtg with those variables, add it to the arraylist
Else if cardInfo has card_faces, since this is for double faced cards, we're getting the image of the front card.
Get the first element of card_faces and assign it to frontFace, since the first element represents the face card.
check if frontFace has name, cardInfo if it has rarity, frontFace if it has image_uris large, cardInfo if it has purchase_uris tcgplayer.
Then assign them to variables, make a new instance of Mtg using those variables, add it to the arraylist.
else, check if it has ......, assign to variables, make new instance of Mtg with those variables and add it to the arraylist.
Using the ternary operator: condition ? valueIfTrue : valueIfFalse. It evaluates the condition before the ?, and depending on true or false, returns the value.
if statement to see if there are more pages, see's if it contains "has_more", and if the "has_more" is true.
if all is true, set the url for the next page to nextPageUrl, then use the URI class to take the URL String that contains a special character (%3A, which is a :),
and converts it into a properly encoded URI, a safe format that can be processed.
UriComponentsBuilder is an utility class, ensure correct formatting and applies encoding, helps construct and modify URIs, UriComponent.
.fromHttpUrl() takes in the URL String to modify or encode. .build(true) makes sure to encode the URL, the URL is already encoded, but it is in just in case.
.toUri() converts the UriComponent into a URI. 
then perform a HTTP GET request to obtain all the data from the next page.
Calls mapData recursively and takes all the arrays created and adds them to the end of the existing mtgCardsData.

public String getMtgCardSet(String code) - Returns raw JSON response from the API as a string, .getForObject() is used to send HTTP GET request to the URL,
the String.class tells the restTemplate that the response should be returned as a string. This is needed for public ArrayList<Mtg> mapData(String jsonData)

public Map<String, String> allSets(String jsonData) - returns a Map of key value pair, set name as the key and the set id as the value.
Takes in param of the String version of the Json data of all sets. Created a Map<String, String> to hold all the key value pairs.
Uses LinkedHashMap<>(); bc want data in the order they were inserted. In a try - catch loop, in the event there is an issue with the mapping.
Catches the exception in variable e, then .printStackTrace will provide a report that includes: type of exception, error message, and all the actions that led up to the error and the file/line.
.readTree() method of ObjectMapper turns the JSON string into a tree-like structure. JsonNode datatype is used to hold and navigate the tree-like structure.
Then we get the value associated with the key "data".
Using Iterator to loop through the elements in the Json Array in data variable. Iterating over a collection of JsonNodes.
.elements() method is used to return an Iterator of elements in the Json array.
While there is still another element in the array, set that element to a JsonNode variable.
Get the set "name" and the "id", set both to String variable.
Put the setName as key and the setID as value in the LinkedHashMap<>();

public String getMtgSets() - Returns raw JSON response from the API as a string, .getForObject() is used to send HTTP GET request to the URL,
the String.class tells the restTemplate that the response should be returned as a string. This is needed for public Map<String, String> allSets(String jsonData).

