Class that converts String url to URL object. 

@Component bc it doesn't fall within a specific layer, and it will be managed by Spring, so it can be injected into the controllers.

The method takes in the String URL and converts it to URL object. 
MalformedURLException if the URL is invalid or not formatted correctly.

This is a helper class. This was created mainly for better testing. WAS creating an instance of URL in ImageDownloaderService, resulting in making an actual HTTP request
and could not intercept it and mock.
