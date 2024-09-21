package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.controller;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.PokemonService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pokemon")
public class Controller {

    @Autowired
    private PokemonService pokemonService;

//    @GetMapping("/test")
//    public ResponseEntity<String> testing(){
//        String allCards = pokemonService.getPokemonSetCards("sv7");
//
//        return ResponseEntity.ok(allCards);
//    }
//
//    @GetMapping("/test2")
//    public ResponseEntity<List<Pokemon>> testing2(){
//        String allCards = pokemonService.getPokemonSetCards("sv7");
//        List<Pokemon> pokemonArray = pokemonService.mapData(allCards);
//
//        return ResponseEntity.ok(pokemonArray);
//    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, String>> testing3(){
        Map<String, String> allSets = pokemonService.allSets(pokemonService.getPokemonSets());
        return ResponseEntity.ok(allSets);
    }

    @GetMapping("/set/{id}")
    public ResponseEntity<List<Pokemon>> getDataById(@PathVariable String id){
        String allCards = pokemonService.getPokemonSetCards(id);
        List<Pokemon> pokemonArray = pokemonService.mapData(allCards);

        return ResponseEntity.ok(pokemonArray);
    }
}
