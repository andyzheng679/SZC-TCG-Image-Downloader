package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.helperClass;

import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class URLHelper {

    public URL convertStringToURL(String urlString) throws MalformedURLException {
        return new URL(urlString);
    }
}
