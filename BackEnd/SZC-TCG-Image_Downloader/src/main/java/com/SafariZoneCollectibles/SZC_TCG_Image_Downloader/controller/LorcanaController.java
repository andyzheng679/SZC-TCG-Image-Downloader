package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.controller;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.ImageDownloaderService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.LorcanaService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Lorcana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://szc-tcg-image-downloader-1.onrender.com")
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/lorcana")
public class LorcanaController {

    @Autowired
    private LorcanaService lorcanaService;

    @Autowired
    private ImageDownloaderService imageDownloaderService;

    @GetMapping("/set")
    public ResponseEntity<Map<String, String>> getAllSets(){
        Map<String, String> getAllSets = lorcanaService.allSets(lorcanaService.getLorcanaSets());
        return ResponseEntity.ok(getAllSets);
    }

    @GetMapping("/set/{setNum}")
    public ResponseEntity<List<Lorcana>> getAllCards(@PathVariable String setNum){
        String allCards = lorcanaService.getAllCards(setNum);
        List<Lorcana> lorcanaArray = lorcanaService.mapData(allCards);

        return ResponseEntity.ok(lorcanaArray);
    }

    @GetMapping("/download-image")
    public ResponseEntity<InputStreamResource> downloadImage(@RequestParam String imageUrl, @RequestParam String cardName, @RequestParam String rarity) throws Exception {
        return imageDownloaderService.downloadImage(imageUrl, cardName, rarity);
    }

}
