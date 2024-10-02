package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.controller;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.MtgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
