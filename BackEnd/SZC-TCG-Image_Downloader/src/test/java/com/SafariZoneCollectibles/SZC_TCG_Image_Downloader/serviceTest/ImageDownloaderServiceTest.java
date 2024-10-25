package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.serviceTest;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.ImageDownloaderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


//@ExtendWith(MockitoExtension.class)
//public class ImageDownloaderServiceTest {
//
//    @InjectMocks
//    private ImageDownloaderService imageDownloaderService;
//
//    @Test
//    void testDownloadImage() throws Exception{
//
//        InputStream mockInputStream =  new ByteArrayInputStream("Image data".getBytes());
//
//        String cardName = "Name";
//        String rarity = "Rarity";
//        String imageUrl = "http://url.com";
//
//        ResponseEntity<InputStreamResource> response = imageDownloaderService.downloadImage(imageUrl, cardName, rarity);
//
//        assertNotNull(response);
//        assertEquals("attachment; filename=\"Name_Rarity.png\"", response.getHeaders().getContentDisposition().toString());
//        assertEquals("image/png", response.getHeaders().getContentType().toString());
//    }
//}

// test takes 400 - 700ms to execute. Issue lies in making real HTTP requests, need to look into PowerMockito to solve this.
