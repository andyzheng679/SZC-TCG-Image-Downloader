package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.helperClassTest;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.helperClass.URLHelper;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class URLHelperTest {

    @Test
    void testConvertStringToURL() throws MalformedURLException{
        URLHelper urlHelper = new URLHelper();

        URL result = urlHelper.convertStringToURL("https://testing.com");

        assertEquals(result, new URL("https://testing.com"));
    }
}
