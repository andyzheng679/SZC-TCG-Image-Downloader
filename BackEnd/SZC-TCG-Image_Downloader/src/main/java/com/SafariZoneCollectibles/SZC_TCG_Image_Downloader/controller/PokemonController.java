package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.controller;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.PokemonService;
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
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;


    @GetMapping("/set")
    public ResponseEntity<Map<String, String>> getAllPokemonSets(){
        Map<String, String> allSets = pokemonService.allSets(pokemonService.getPokemonSets());
        return ResponseEntity.ok(allSets);
    }

    @GetMapping("/set/{id}")
    public ResponseEntity<List<Pokemon>> getDataById(@PathVariable String id){
        String allCards = pokemonService.getPokemonSetCards(id);
        List<Pokemon> pokemonArray = pokemonService.mapData(allCards);

        return ResponseEntity.ok(pokemonArray);
    }

    @GetMapping("/download-image")
    public ResponseEntity<InputStreamResource> downloadImage(@RequestParam String imageUrl, @RequestParam String cardName, @RequestParam String rarity) throws Exception {
        InputStream inputStream = new URL(imageUrl).openStream();

        // Construct the file name using the card name and rarity, replacing spaces with underscores
        String fileName = cardName + "_" + rarity + ".png";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(inputStream));
    }

}
