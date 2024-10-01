package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Pokemon;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class PokemonService {

    private RestTemplate restTemplate;

    private ObjectMapper objectMapper;

    private Pokemon pokemon;

    private String pokemonAPIUrl = "https://api.pokemontcg.io/v2/cards?q=set.id:";

    private String pokemonAPISets = "https://api.pokemontcg.io/v2/sets";

    @Autowired
    public PokemonService(RestTemplate restTemplate, ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }


    public Map<String, String> allSets(String jsonData){
        Map<String, String> pokemonSetsData = new LinkedHashMap<>();

        try{
            JsonNode root = objectMapper.readTree(jsonData);

            JsonNode data = root.get("data");

            Iterator<JsonNode> arrayData = data.elements();
            while(arrayData.hasNext()){
                JsonNode setData = arrayData.next();

                String setName = setData.get("name").asText();
                String setID = setData.get("id").asText();

                pokemonSetsData.put(setName, setID);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return pokemonSetsData;
    }

    public String getPokemonSets(){
        String url = pokemonAPISets;
        return restTemplate.getForObject(url, String.class);
    }

    public ArrayList<Pokemon> mapData(String jsonData){

        ArrayList<Pokemon> pokemonCardsData = new ArrayList<>();

        try{
            JsonNode root = objectMapper.readTree(jsonData);

            JsonNode data = root.get("data");

            Iterator<JsonNode> arrayData = data.elements();
            while(arrayData.hasNext()){
                JsonNode cardInfo = arrayData.next();

                String name = cardInfo.has("name") ? cardInfo.get("name").asText() : "Unknown";
                String rarity = cardInfo.has("rarity") ? cardInfo.get("rarity").asText() : "Unknown";
                String imgURL = cardInfo.has("images") && cardInfo.get("images").has("large")
                        ? cardInfo.get("images").get("large").asText()
                        : "NoImageURL";
                String tcgplayerUrl = cardInfo.has("tcgplayer") && cardInfo.get("tcgplayer").has("url")
                        ? cardInfo.get("tcgplayer").get("url").asText()
                        : "NoTCGPlayerURL";
                String number = cardInfo.has("number") ? cardInfo.get("number").asText() : "Unknown";

                Pokemon pokemon = new Pokemon(name + "-" + number, rarity, imgURL, tcgplayerUrl);
                pokemonCardsData.add(pokemon);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pokemonCardsData;
    }

    public String getPokemonSetCards(String setID){
        String url = pokemonAPIUrl + setID;
        return restTemplate.getForObject(url, String.class);
    }
}
