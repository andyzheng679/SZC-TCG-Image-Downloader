package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

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

        return mapSetToSetNum;
    }

    private String getLorcanaSets(){
        String url = allSetsURL;
        return(restTemplate.getForObject(url, String.class));
    }


}
