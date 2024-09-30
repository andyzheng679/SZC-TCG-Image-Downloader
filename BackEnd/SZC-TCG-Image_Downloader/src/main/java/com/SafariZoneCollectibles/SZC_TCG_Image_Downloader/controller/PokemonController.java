package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.controller;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.FileService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.PokemonService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private FileService fileService;


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

//    @GetMapping("/download-zip/{setId}")
//    public ResponseEntity<Resource> downloadZipFile(@PathVariable String setId) throws IOException{
//        Path tempDirectory = fileService.createTempDirectory();
//
//        String pokemonCardJson = pokemonService.getPokemonSetCards(setId);
//        List<Pokemon> setOfCards = pokemonService.mapData(pokemonCardJson);
//
//        for (Pokemon card : setOfCards) {
//            fileService.saveImagesSetName(card.getName(), card.getRarity(), card.getImgURL(), tempDirectory);
//        }
//
//        Path zipFilePath = tempDirectory.resolve(setId + "_images.zip");
//        fileService.createZipFile(tempDirectory, zipFilePath);
//
//        Resource resource = new UrlResource(zipFilePath.toUri());
//        ResponseEntity<Resource> response = ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + setId + "_images.zip\"")
//                .body(resource);
//
//        fileService.deleteTempDirectory(tempDirectory);
//
//        return response;
//    }

//    @GetMapping("/download-zip/{setId}")
//    public ResponseEntity<Resource> downloadZipFile(@PathVariable String setId) {
//        try {
//            // Log when the request starts
//            System.out.println("Starting download-zip for setId: " + setId);
//
//            // Create temp directory
//            Path tempDirectory = fileService.createTempDirectory(setId);
//            System.out.println("Created temp directory: " + tempDirectory);
//
//            // Retrieve set of cards from service
//            String pokemonCardJson = pokemonService.getPokemonSetCards(setId);
//            List<Pokemon> setOfCards = pokemonService.mapData(pokemonCardJson);
//            System.out.println("Retrieved set of cards: " + setOfCards.size());
//
//            // Save images to temp directory
//            for (Pokemon card : setOfCards) {
//                fileService.saveImagesSetName(card.getName(), card.getRarity(), card.getImgURL(), tempDirectory);
//            }
//
//            // Create the zip file from images
//            Path zipFilePath = tempDirectory.resolve(setId + "_images.zip");
//            fileService.createZipFile(tempDirectory, zipFilePath);
//            System.out.println("Created zip file: " + zipFilePath);
//
//            // Load the ZIP file as a resource
//            Resource resource = new UrlResource(zipFilePath.toUri());
//
//            // Log before sending response
//            System.out.println("Sending response to download ZIP: " + zipFilePath);
//
//            // Prepare the response entity with appropriate headers
//            ResponseEntity<Resource> response = ResponseEntity.ok()
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + setId + "_images.zip\"")
//                    .header(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate")
//                    .header(HttpHeaders.PRAGMA, "no-cache")
//                    .header(HttpHeaders.EXPIRES, "0")
//                    .contentType(MediaType.parseMediaType("application/zip"))  // Set MIME type for ZIP files
//                    .body(resource);
//
//            // Return the response and cleanup the temp directory after response has been processed
//            new Thread(() -> {
//                try {
//                    Thread.sleep(5000);  // Give some time for the download to complete
//                    fileService.deleteTempDirectory(tempDirectory);
//                    System.out.println("Deleted temp directory: " + tempDirectory);
//                } catch (IOException | InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//
//            return response;
//
//        } catch (Exception e) {
//            e.printStackTrace();  // Log any unexpected exceptions
//            return ResponseEntity.status(500).body(null);  // Return a 500 error in case of issues
//        }
//    }




}
