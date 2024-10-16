package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Mtg;
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
public class MtgService {

    private RestTemplate restTemplate;

    private ObjectMapper objectMapper;

    private String allMtgSets = "https://api.scryfall.com/sets";

    private String allMtgCards = "https://api.scryfall.com/cards/search?q=e:";

    private Mtg mtg;

    @Autowired
    public MtgService(RestTemplate restTemplate, ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ArrayList<Mtg> mapData(String jsonData){

        ArrayList<Mtg> mtgCardsData = new ArrayList<>();

        try{
            JsonNode root = objectMapper.readTree(jsonData);

            JsonNode data = root.get("data");

            Iterator<JsonNode> arrayData = data.elements();
            while(arrayData.hasNext()){

                JsonNode cardInfo = arrayData.next();

                if (cardInfo.has("image_uris")){
                    String name = cardInfo.has("name") ? cardInfo.get("name").asText() : "Unknown";
                    String rarity = cardInfo.has("rarity") ? cardInfo.get("rarity").asText() : "Unknown";
                    String imgURL = cardInfo.get("image_uris").has("large")
                            ? cardInfo.get("image_uris").get("large").asText()
                            : "NoImageURL";
                    String tcgplayerUrl = cardInfo.has("purchase_uris") && cardInfo.get("purchase_uris").has("tcgplayer")
                            ? cardInfo.get("purchase_uris").get("tcgplayer").asText()
                            : "NoTCGPlayerURL";

                    Mtg mtg = new Mtg(name, rarity, imgURL, tcgplayerUrl);
                    mtgCardsData.add(mtg);
                } else if (cardInfo.has("card_faces")) {
                    JsonNode frontFace = cardInfo.get("card_faces").get(0);

                    String name = frontFace.has("name") ? frontFace.get("name").asText() : "Unknown";
                    String rarity = cardInfo.has("rarity") ? cardInfo.get("rarity").asText() : "Unknown";
                    String imgURL = frontFace.has("image_uris") && frontFace.get("image_uris").has("large")
                            ? frontFace.get("image_uris").get("large").asText()
                            : "NoImageURL";
                    String tcgplayerUrl = cardInfo.has("purchase_uris") && cardInfo.get("purchase_uris").has("tcgplayer")
                            ? cardInfo.get("purchase_uris").get("tcgplayer").asText()
                            : "NoTCGPlayerURL";

                    Mtg mtg = new Mtg(name, rarity, imgURL, tcgplayerUrl);
                    mtgCardsData.add(mtg);
                } else {
                    String name = cardInfo.has("name") ? cardInfo.get("name").asText() : "Unknown";
                    String rarity = cardInfo.has("rarity") ? cardInfo.get("rarity").asText() : "Unknown";
                    String imgURL = cardInfo.has("image_uris") && cardInfo.get("image_uris").has("large")
                            ? cardInfo.get("image_uris").get("large").asText()
                            : "NoImageURL";
                    String tcgplayerUrl = cardInfo.has("purchase_uris") && cardInfo.get("purchase_uris").has("tcgplayer")
                            ? cardInfo.get("purchase_uris").get("tcgplayer").asText()
                            : "NoTCGPlayerURL";

                    Mtg mtg = new Mtg(name, rarity, imgURL, tcgplayerUrl);
                    mtgCardsData.add(mtg);
                }
            }

            if (root.has("has_more") && root.get("has_more").asBoolean()) {

                String nextPageUrl = root.get("next_page").asText();
                String nextPageData = restTemplate.getForObject(nextPageUrl, String.class);

                mtgCardsData.addAll(mapData(nextPageData));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return mtgCardsData;
    }



    public String getMtgCardSet(String code) {
        String url = allMtgCards + code;
        return restTemplate.getForObject(url, String.class);
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
