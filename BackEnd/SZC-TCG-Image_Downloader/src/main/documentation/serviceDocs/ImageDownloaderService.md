Service class to handle the logic of downloading images from external URLs and preparing them for user download.

public ResponseEntity<InputStreamResource> downloadImage String imageUrl, String cardName, String rarity) throws Exception -
returns something that is downloadable. InputStreamResource is a class that wraps an InputStream. InputStream represents a sequence of data, so in this case, image data,
combined with HTTP headers, it signals to the browser that the response is a file download. This method takes three query parameters, ?imageUrl=...&cardName=...&rarity=...,
these are passed in the URL. Throws an exception. inputStream: creates a new URL object using the imageURL param. openStream() method opens an InputStream that allows reading data from the image URL.
fileName: naming the img that is being downloaded the card name plus rarity plus .png to add the .png extension (portable network graphics). Return:
.header(): HttpHeaders.CONTENT_DISPOSITION sets the CONTENT_DISPOSITION header, tells browser how to handle the response content. attachment tells the browser to download the file rather than display it.
filename tells the browser what the file should be named. .contentType() MediaType.IMAGE_PNG sets the content type to png, lets the browser know it is receiving an PNG image file.
.body() new InputStreamResource(inputStream) wraps inputStream, this allows Spring to directly stream the data to the client without having to save it to the server first, good for large files like images.