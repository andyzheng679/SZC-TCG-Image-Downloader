package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.controller;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.MtgService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Mtg;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Pokemon;
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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/mtg")
public class MtgController {

    @Autowired
    private MtgService mtgService;

    @GetMapping("/set")
    public ResponseEntity<Map<String, String>> getAllMtgSets(){
        Map<String, String> allSets = mtgService.allSets(mtgService.getMtgSets());
        return ResponseEntity.ok(allSets);
    }

    @GetMapping("/set/{code}")
    public ResponseEntity<List<Mtg>> getDataByCode(@PathVariable String code){
        String allCards = mtgService.getMtgCardSet(code);
        List<Mtg> mtgArray = mtgService.mapData(allCards);
        return ResponseEntity.ok(mtgArray);
    }

    @GetMapping("/download-image")
    public ResponseEntity<InputStreamResource> downloadImage(@RequestParam String imageUrl, @RequestParam String cardName, @RequestParam String rarity) throws Exception {
        InputStream inputStream = new URL(imageUrl).openStream();

        String fileName = cardName + "_" + rarity + ".png";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(inputStream));
    }

}
