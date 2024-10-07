ontroller Class: handling HTTP requests, endpoint.

@CrossOrigin(origins = "http://localhost:3000") - used to handle CORS (Cross-Origin Resource Sharing). Allows backend to accept request from a different origin.
Example: Backend is on localhost:8080 while the frontend is on localhost:3000. The browser blocks request due to Same-Origin Policy. This annotation will bypass that.

@RestController - handles web requests, returns data as a JSON.

@RequestMapping("/lorcana") - used to map request to controller, this will be mapped to lorcana endpoint. Used bc other TCG's will have other endpoints.

@Autowired
private LorcanaService lorcanaService; - field injection lorcana business logic.

@GetMapping("/set")
public ResponseEntity<Map<String, String>> getAllSets() - sending a get request to /lorcana/all, ResponseEntity is used to allow us to have control over HTTP responses,
like status codes and error handling. Returns a Map, key value, String, String. This will return all lorcana sets in a Map, Name of set, set id.

@GetMapping("/set/{setNum}")
public ResponseEntity<List<Lorcana>> getAllCards(@PathVariable String setNum) - sending get request to /lorcana/set/{setNum}, using @PathVariable for the set id, extracts the id from the URL,
don't use @RequestParam bc we're not filtering, modifying result, we're directly accessing the resource. Think of custom queries. This will return a List of Lorcana objects based on the set id.

@GetMapping("/download-image")
public ResponseEntity<InputStreamResource> downloadImage(@RequestParam String imageUrl, @RequestParam String cardName, @RequestParam String rarity) throws Exception -
returns something that is downloadable. InputStreamResource is a class that wraps an InputStream. InputStream represents a sequence of data, so in this case, image data,
combined with HTTP headers, it signals to the browser that the response is a file download. This method takes three query parameters, ?imageUrl=...&cardName=...&rarity=...,
these are passed in the URL. Throws an exception. inputStream: creates a new URL object using the imageURL param. openStream() method opens an InputStream that allows reading data from the image URL.
fileName: naming the img that is being downloaded the card name plus rarity plus .png to add the .png extension (portable network graphics). Return:
.header(): HttpHeaders.CONTENT_DISPOSITION sets the CONTENT_DISPOSITION header, tells browser how to handle the response content. attachment tells the browser to download the file rather than display it.
filename tells the browser what the file should be named. .contentType() MediaType.IMAGE_PNG sets the content type to png, lets the browser know it is receiving an PNG image file.
.body() new InputStreamResource(inputStream) wraps inputStream, this allows Spring to directly stream the data to the client without having to save it to the server first, good for large files like images.
Moved this to ImageDownloaderService.