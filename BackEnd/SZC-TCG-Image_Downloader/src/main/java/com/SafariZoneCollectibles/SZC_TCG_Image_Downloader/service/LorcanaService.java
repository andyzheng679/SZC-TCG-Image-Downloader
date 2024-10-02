package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Lorcana;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class LorcanaService {

    private RestTemplate restTemplate;

    private ObjectMapper objectMapper;

    private String allSetsURL = "https://api.lorcana-api.com/sets/fetch?orderby=Set_Num";

    private String allCardFromSetURL = "https://api.lorcana-api.com/cards/fetch?search=set_num=";

    private Lorcana lorcana;



    @Autowired
    public  LorcanaService(RestTemplate restTemplate, ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public Map<String, String> allSets(String getLorcanaSets){
        Map<String, String> mapSetToSetNum = new LinkedHashMap<>();

        try{

            JsonNode root = objectMapper.readTree(getLorcanaSets);

            Iterator<JsonNode> arrayData = root.elements();
            while(arrayData.hasNext()) {
                JsonNode setData = arrayData.next();

                String setName = setData.get("Name").asText();
                String setNum = String.valueOf(setData.get("Set_Num").asInt());

                mapSetToSetNum.put(setName, setNum);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return mapSetToSetNum;
    }

    public String getLorcanaSets(){
        String url = allSetsURL;
        return(restTemplate.getForObject(url, String.class));
    }

    public List<Lorcana> mapData(String getAllCards){
        ArrayList<Lorcana> allCards = new ArrayList<>();

        try{
            JsonNode root = objectMapper.readTree(getAllCards);

            Iterator<JsonNode> arrayData = root.elements();
            while(arrayData.hasNext()){
                JsonNode setData = arrayData.next();

                String name = setData.has("Name") ? setData.get("Name").asText() : "Unknown";
                String rarity = setData.has("Rarity") ? setData.get("Rarity").asText() : "Unknown";
                String imgUrl = setData.has("Image") ? setData.get("Image").asText() : "No Image";

                Lorcana lorcana = new Lorcana(name, rarity, imgUrl);

                allCards.add(lorcana);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return allCards;
    }

    public String getAllCards(String setNum){
        String url = allCardFromSetURL + setNum;
        return(restTemplate.getForObject(url, String.class));
    }


}
