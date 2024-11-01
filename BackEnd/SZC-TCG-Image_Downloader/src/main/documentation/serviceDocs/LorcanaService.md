Service Class: business logic.

private RestTemplate restTemplate - Used to perform HTTP requests to external API's.

private ObjectMapper objectMapper - Used to map JSON data into Java objects, vice versa.

private String allSetsURL - url for all lorcana sets.

private String allCardFromSetURL - url for all cards in a set, need to add the set number.

private Lorcana lorcana - instance of Lorcana class to map data, not needed since we can just instantiate it in the method.

Constructor, Constructor injection.

public Map<String, String> allSets(String getLorcanaSets) - returns a Map of key value pairs, set name and set number. Param of all the lorcana sets, string.
Created a Map<String, String> to hold all the key value pairs.
Uses LinkedHashMap<>(); bc want data in the order they were inserted. In a try - catch loop, in the event there is an issue with the mapping.
Catches the exception in variable e, then .printStackTrace will provide a report that includes: type of exception, error message, and all the actions that led up to the error and the file/line.
.readTree() method of ObjectMapper turns the JSON string into a tree-like structure. JsonNode datatype is used to hold and navigate the tree-like structure. 
Using Iterator to loop through the elements in the Json Array in data variable. Iterating over a collection of JsonNodes.
.elements() method is used to return an Iterator of elements in the Json array.
While there is still another element in the array, set that element to a JsonNode variable. 
Get the value of Name and Set_Num, converting value of Set_Num bc it's an Integer in the Json, converting it to a string, so it can be used in the allCardFromSetURL URL.
Put the setName as key and the setID as value in the LinkedHashMap<>();

public String getLorcanaSets() - Returns raw JSON response from the API as a string, .getForObject() is used to send HTTP GET request to the URL,
the String.class tells the restTemplate that the response should be returned as a string. This is needed for public Map<String, String> allSets(String getLorcanaSets).

public List<Lorcana> mapData(String getAllCards) - Returns an ArrayList of Lorcana objects, take param of the String version of the Json data of all cards in set.
Create an ArrayList<Lorcana> to hold all Lorcana objects. In a try - catch loop, in the event there is an issue with the mapping.
Catches the exception in variable e, then .printStackTrace will provide a report that includes: type of exception, error message, and all the actions that led up to the error and the file/line.
.readTree() method of ObjectMapper turns the JSON string into a tree-like structure. JsonNode datatype is used to hold and navigate the tree-like structure.
Using Iterator to loop through the elements in the Json Array in data variable. Iterating over a collection of JsonNodes.
.elements() method is used to return an Iterator of elements in the Json array.
While there is still another element in the array, set that element to a JsonNode variable.
Get the card "name", "rarity", "images", set all of them as a String.
Using the ternary operator: condition ? valueIfTrue : valueIfFalse. It evaluates the condition before the ?, and depending on true or false, returns the value.
Create instance of Lorcana and map all of that to it, combine the name and the number together. Add the instance to the ArrayList.

public String getAllCards(String setNum) - Returns raw JSON response from the API as a string, .getForObject() is used to send HTTP GET request to the URL,
the String.class tells the restTemplate that the response should be returned as a string. This is needed for public List<Lorcana> mapData(String getAllCards)