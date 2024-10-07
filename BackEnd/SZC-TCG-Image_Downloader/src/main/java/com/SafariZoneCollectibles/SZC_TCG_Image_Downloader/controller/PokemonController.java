package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.controller;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.ImageDownloaderService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.PokemonService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://szc-tcg-image-downloader-1.onrender.com")
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private ImageDownloaderService imageDownloaderService;


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
        return imageDownloaderService.downloadImage(imageUrl, cardName, rarity);
    }

}
