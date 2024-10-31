Controller Class: handling HTTP requests, endpoint.

@CrossOrigin(origins = "http://localhost:3000") - used to handle CORS (Cross-Origin Resource Sharing). Allows backend to accept request from a different origin.
Example: Backend is on localhost:8080 while the frontend is on localhost:3000. The browser blocks request due to Same-Origin Policy. This annotation will bypass that.

@RestController - handles web requests, returns data as a JSON.

@RequestMapping("/pokemon") - used to map request to controller, this will be mapped to pokemon endpoint. Used bc other TCG's will have other endpoints.

@Autowired
private PokemonService pokemonService; - field injection pokemon business logic.

@Autowired
private ImageDownloaderService imageDownloaderService; - field injection the logic of downloading images.

@Autowired
private URLHelper urlHelper; - field injection helper class, this will convert String url to an URL object

@GetMapping("/set")
public ResponseEntity<Map<String, String>> getAllPokemonSets() - sending a get request to /pokemon/set, ResponseEntity is used to allow us to have control over HTTP responses,
like status codes and error handling. Returns a Map, key value, String, String. This will return all pokemon sets in a Map, Name of set, set id.

@GetMapping("/set/{id}")
public ResponseEntity<List<Pokemon>> getDataById(@PathVariable String id) - sending get request to /pokemon/set/{id}, using @PathVariable for the set id, extracts the id from the URL,
don't use @RequestParam bc we're not filtering, modifying result, we're directly accessing the resource. Think of custom queries. This will return a List of Pokemon objects based on the set id.

@GetMapping("/download-image")
public ResponseEntity<InputStreamResource> downloadImage(@RequestParam String imageUrl, @RequestParam String cardName, @RequestParam String rarity) throws Exception -
returns a ResponseEntity that includes a downloadable file, by preparing the image as an attachment with headers and content type.
This method takes three query parameters, ?imageUrl=...&cardName=...&rarity=..., these are passed in the URL.
This method works with the helper class URLHelper to convert the String imageUrl to a URL object, which is then passes with the cardName and rarity as the parameters to
the downloadImage method in the service class, imageDownloaderService.