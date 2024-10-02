package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.controller;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.LorcanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/lorcana")
public class LorcanaController {

    @Autowired
    private LorcanaService lorcanaService;

    @GetMapping("/set")
    public ResponseEntity<Map<String, Integer>> getAllSets(){
        Map<String, Integer> getAllSets = lorcanaService.allSets(lorcanaService.getLorcanaSets());
        return ResponseEntity.ok(getAllSets);
    }

}
