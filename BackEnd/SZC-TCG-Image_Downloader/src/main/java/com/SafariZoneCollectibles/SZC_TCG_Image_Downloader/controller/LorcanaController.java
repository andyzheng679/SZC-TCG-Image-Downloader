package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.controller;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.LorcanaService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Lorcana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/lorcana")
public class LorcanaController {

    @Autowired
    private LorcanaService lorcanaService;

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

}
