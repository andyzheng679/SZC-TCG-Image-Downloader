package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class LorcanaService {

    private RestTemplate restTemplate;

    private ObjectMapper objectMapper;

    String allSetsURL = "https://api.lorcana-api.com/sets/fetch";

    @Autowired
    public  LorcanaService(RestTemplate restTemplate, ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    

    private String getLorcanaSets(){
        String url = allSetsURL;
        return(restTemplate.getForObject(url, String.class));
    }


}
