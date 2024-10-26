package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.helperClass;

import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class URLHelper {

    //go back when done and document this. converting imageURL to URL, this is a helper class, mainly due to better testing, WAS creating an instance in the method
    //resulting in making actual http request and we could not intercept it and mock the outcome. @Component bc it doesn't fall within a specific layer, and it will be
    //managed by spring. MalformedURLException bc in the event where the URL is constructed with an invalid syntax

    public URL convertStringToURL(String urlString) throws MalformedURLException {
        return new URL(urlString);
    }
}
