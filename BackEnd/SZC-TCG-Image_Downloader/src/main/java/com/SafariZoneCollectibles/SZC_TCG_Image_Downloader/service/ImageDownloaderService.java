package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.io.InputStream;
import java.net.URL;

@Service
public class ImageDownloaderService {


    public ResponseEntity<InputStreamResource> downloadImage( String imageUrl, String cardName, String rarity) throws Exception {
        InputStream inputStream = new URL(imageUrl).openStream();

        String fileName = cardName + "_" + rarity + ".png";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(inputStream));
    }
}
