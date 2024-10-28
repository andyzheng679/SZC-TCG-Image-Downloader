package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.serviceTest;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.ImageDownloaderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ImageDownloaderServiceTest {

    @Mock
    private URL mockUrl;

    @InjectMocks
    private ImageDownloaderService imageDownloaderService;

    @Test
    void testDownloadImage() throws Exception{

        InputStream mockInputStream = new ByteArrayInputStream(new byte[]{1,2,3});
        when(mockUrl.openStream()).thenReturn(mockInputStream);

        String cardName = "Name";
        String rarity = "Rarity";


        ResponseEntity<InputStreamResource> response = imageDownloaderService.downloadImage(mockUrl, "Name", "Rarity");

        assertNotNull(response);
        assertEquals("attachment; filename=\"Name_Rarity.png\"", response.getHeaders().getContentDisposition().toString());
        assertEquals("image/png", response.getHeaders().getContentType().toString());


    }


}


