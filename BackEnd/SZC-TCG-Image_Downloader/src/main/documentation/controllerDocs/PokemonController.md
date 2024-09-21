Controller Class: handling HTTP requests, endpoint.

@CrossOrigin(origins = "http://localhost:3000") - used to handle CORS (Cross-Origin Resource Sharing). Allows backend to accept request from a different origin.
Example: Backend is on localhost:8080 while the frontend is on localhost:3000. The browser blocks request due to Same-Origin Policy. This annotation will bypass that.

@RestController - handles web requests, returns data as a JSON.

@RequestMapping("/pokemon") - used to map request to controller, this will be mapped to pokemon endpoint. Used bc other TCG's will have other endpoints.

@Autowired
private PokemonService pokemonService; - field injection pokemon business logic.

@GetMapping("/all")
public ResponseEntity<Map<String, String>> getAllPokemonSets() - sending a get request to /pokemon/all, ResponseEntity is used to allow us to have control over HTTP responses,
like status codes and error handling. Returns a Map, key value, String, String. This will return all pokemon sets in a Map, Name of set, set id.

@GetMapping("/set/{id}")
public ResponseEntity<List<Pokemon>> getDataById(@PathVariable String id) - sending get request to /pokemon/set/{id}, using @PathVariable for the set id, extracts the id from the URL,
don't use @RequestParam bc we're not filtering, modifying result, we're directly accessing the resource. Think of custom queries. This will return a List of Pokemon objects based on the set id.

