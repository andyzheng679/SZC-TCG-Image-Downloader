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
public class LorcanaService {

    private RestTemplate restTemplate;

    private ObjectMapper objectMapper;

    String allSetsURL = "https://api.lorcana-api.com/sets/fetch?orderby=Set_Num";

    @Autowired
    public  LorcanaService(RestTemplate restTemplate, ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public Map<String, Integer> allSets(String getLorcanaSets){
        Map<String, Integer> mapSetToSetNum = new LinkedHashMap<>();

        try{

            JsonNode root = objectMapper.readTree(getLorcanaSets);

            Iterator<JsonNode> arrayData = root.elements();
            while(arrayData.hasNext()) {
                JsonNode setData = arrayData.next();

                String setName = setData.get("Name").asText();
                Integer setNum = setData.get("Set_Num").asInt();

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


}
