package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class MtgService {

    private RestTemplate restTemplate;

    private ObjectMapper objectMapper;

    private String allMtgSets = "https://api.scryfall.com/sets";

    private String allMtgCards = "https://api.scryfall.com/cards/search?q=s:";

    @Autowired
    public MtgService(RestTemplate restTemplate, ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    

    public String getMtgCardSet(String code){
        String url = allMtgCards + code;
        return(restTemplate.getForObject(url, String.class));
    }

    public Map<String, String> allSets(String jsonData){
        Map<String, String> mtgSetsData = new LinkedHashMap<>();

        try{
            JsonNode root = objectMapper.readTree(jsonData);

            JsonNode data = root.get("data");

            Iterator<JsonNode> arrayData = data.elements();
            while(arrayData.hasNext()){
                JsonNode setData = arrayData.next();

                String setName = setData.get("name").asText();
                String setID = setData.get("code").asText();

                mtgSetsData.put(setName, setID);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return mtgSetsData;
    }

    public String getMtgSets(){
        String url = allMtgSets;
        return restTemplate.getForObject(url, String.class);
    }
}
