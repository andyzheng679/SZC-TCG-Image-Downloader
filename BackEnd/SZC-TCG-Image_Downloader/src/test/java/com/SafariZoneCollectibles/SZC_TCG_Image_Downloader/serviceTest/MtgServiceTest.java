package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.serviceTest;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.MtgService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Mtg;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MtgServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private MtgService mtgService;

    private String allSets = "{\n" +
            "  \"object\": \"list\",\n" +
            "  \"has_more\": false,\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"object\": \"set\",\n" +
            "      \"id\": \"288bd996-960e-448b-a187-9504c1930c2c\",\n" +
            "      \"code\": \"lea\",\n" +
            "      \"tcgplayer_id\": 7,\n" +
            "      \"name\": \"Limited Edition Alpha\",\n" +
            "      \"uri\": \"https://api.scryfall.com/sets/288bd996-960e-448b-a187-9504c1930c2c\",\n" +
            "      \"scryfall_uri\": \"https://scryfall.com/sets/lea\",\n" +
            "      \"search_uri\": \"https://api.scryfall.com/cards/search?include_extras=true&include_variations=true&order=set&q=e%3Alea&unique=prints\",\n" +
            "      \"released_at\": \"1993-08-05\",\n" +
            "      \"set_type\": \"core\",\n" +
            "      \"card_count\": 295,\n" +
            "      \"digital\": false,\n" +
            "      \"nonfoil_only\": true,\n" +
            "      \"foil_only\": false,\n" +
            "      \"block_code\": \"lea\",\n" +
            "      \"block\": \"Core Set\",\n" +
            "      \"icon_svg_uri\": \"https://svgs.scryfall.io/sets/lea.svg?1728273600\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";


    private String allMtgCards = "{\n" +
            "  \"object\": \"list\",\n" +
            "  \"total_cards\": 276,\n" +
            "  \"has_more\": true,\n" +
            "  \"next_page\": \"https://api.scryfall.com/cards/search?format=json&include_extras=false&include_multilingual=false&include_variations=false&order=name&page=2&q=e%3Adsk&unique=cards\",\n" +
            "  \"data\": [\n" +
            "     {\n" +
            "      \"object\": \"card\",\n" +
            "      \"id\": \"60cf954a-5503-460c-8720-8960842eea47\",\n" +
            "      \"oracle_id\": \"8cbe71d3-b77b-49a7-9c51-ed308011b8b0\",\n" +
            "      \"multiverse_ids\": [673474],\n" +
            "      \"mtgo_id\": 130269,\n" +
            "      \"arena_id\": 92139,\n" +
            "      \"tcgplayer_id\": 578055,\n" +
            "      \"cardmarket_id\": 788280,\n" +
            "      \"name\": \"Paranormal Analyst\",\n" +
            "      \"lang\": \"en\",\n" +
            "      \"released_at\": \"2024-09-27\",\n" +
            "      \"uri\": \"https://api.scryfall.com/cards/60cf954a-5503-460c-8720-8960842eea47\",\n" +
            "      \"scryfall_uri\": \"https://scryfall.com/card/dsk/69/paranormal-analyst?utm_source=api\",\n" +
            "      \"layout\": \"normal\",\n" +
            "      \"highres_image\": true,\n" +
            "      \"image_status\": \"highres_scan\",\n" +
            "      \"image_uris\": {\n" +
            "        \"small\": \"https://cards.scryfall.io/small/front/6/0/60cf954a-5503-460c-8720-8960842eea47.jpg?1726286109\",\n" +
            "        \"normal\": \"https://cards.scryfall.io/normal/front/6/0/60cf954a-5503-460c-8720-8960842eea47.jpg?1726286109\",\n" +
            "        \"large\": \"https://cards.scryfall.io/large/front/6/0/60cf954a-5503-460c-8720-8960842eea47.jpg?1726286109\",\n" +
            "        \"png\": \"https://cards.scryfall.io/png/front/6/0/60cf954a-5503-460c-8720-8960842eea47.png?1726286109\",\n" +
            "        \"art_crop\": \"https://cards.scryfall.io/art_crop/front/6/0/60cf954a-5503-460c-8720-8960842eea47.jpg?1726286109\",\n" +
            "        \"border_crop\": \"https://cards.scryfall.io/border_crop/front/6/0/60cf954a-5503-460c-8720-8960842eea47.jpg?1726286109\"\n" +
            "      },\n" +
            "      \"mana_cost\": \"{1}{U}\",\n" +
            "      \"cmc\": 2,\n" +
            "      \"type_line\": \"Creature — Human Detective\",\n" +
            "      \"oracle_text\": \"Whenever you manifest dread, put a card you put into your graveyard this way into your hand.\",\n" +
            "      \"power\": \"1\",\n" +
            "      \"toughness\": \"3\",\n" +
            "      \"colors\": [\n" +
            "        \"U\"\n" +
            "      ],\n" +
            "      \"color_identity\": [\n" +
            "        \"U\"\n" +
            "      ],\n" +
            "      \"keywords\": [\n" +
            "        \"Manifest\",\n" +
            "        \"Manifest dread\"\n" +
            "      ],\n" +
            "      \"all_parts\": [\n" +
            "        {\n" +
            "          \"object\": \"related_card\",\n" +
            "          \"id\": \"60cf954a-5503-460c-8720-8960842eea47\",\n" +
            "          \"component\": \"combo_piece\",\n" +
            "          \"name\": \"Paranormal Analyst\",\n" +
            "          \"type_line\": \"Creature — Human Detective\",\n" +
            "          \"uri\": \"https://api.scryfall.com/cards/60cf954a-5503-460c-8720-8960842eea47\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"object\": \"related_card\",\n" +
            "          \"id\": \"01104ab1-84e1-4c78-853d-637c6554bdf9\",\n" +
            "          \"component\": \"combo_piece\",\n" +
            "          \"name\": \"Manifest\",\n" +
            "          \"type_line\": \"Creature\",\n" +
            "          \"uri\": \"https://api.scryfall.com/cards/01104ab1-84e1-4c78-853d-637c6554bdf9\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"legalities\": {\n" +
            "        \"standard\": \"legal\",\n" +
            "        \"future\": \"legal\",\n" +
            "        \"historic\": \"legal\",\n" +
            "        \"timeless\": \"legal\",\n" +
            "        \"gladiator\": \"legal\",\n" +
            "        \"pioneer\": \"legal\",\n" +
            "        \"explorer\": \"legal\",\n" +
            "        \"modern\": \"legal\",\n" +
            "        \"legacy\": \"legal\",\n" +
            "        \"pauper\": \"not_legal\",\n" +
            "        \"vintage\": \"legal\",\n" +
            "        \"penny\": \"legal\",\n" +
            "        \"commander\": \"legal\",\n" +
            "        \"oathbreaker\": \"legal\",\n" +
            "        \"standardbrawl\": \"legal\",\n" +
            "        \"brawl\": \"legal\",\n" +
            "        \"alchemy\": \"legal\",\n" +
            "        \"paupercommander\": \"restricted\",\n" +
            "        \"duel\": \"legal\",\n" +
            "        \"oldschool\": \"not_legal\",\n" +
            "        \"premodern\": \"not_legal\",\n" +
            "        \"predh\": \"not_legal\"\n" +
            "      },\n" +
            "      \"games\": [\n" +
            "        \"paper\",\n" +
            "        \"mtgo\",\n" +
            "        \"arena\"\n" +
            "      ],\n" +
            "      \"reserved\": false,\n" +
            "      \"foil\": true,\n" +
            "      \"nonfoil\": true,\n" +
            "      \"finishes\": [\n" +
            "        \"nonfoil\",\n" +
            "        \"foil\"\n" +
            "      ],\n" +
            "      \"oversized\": false,\n" +
            "      \"promo\": false,\n" +
            "      \"reprint\": false,\n" +
            "      \"variation\": false,\n" +
            "      \"set_id\": \"a111d8a9-b647-48ec-afab-2b78f92173f5\",\n" +
            "      \"set\": \"dsk\",\n" +
            "      \"set_name\": \"Duskmourn: House of Horror\",\n" +
            "      \"set_type\": \"expansion\",\n" +
            "      \"set_uri\": \"https://api.scryfall.com/sets/a111d8a9-b647-48ec-afab-2b78f92173f5\",\n" +
            "      \"set_search_uri\": \"https://api.scryfall.com/cards/search?order=set&q=e%3Adsk&unique=prints\",\n" +
            "      \"scryfall_set_uri\": \"https://scryfall.com/sets/dsk?utm_source=api\",\n" +
            "      \"rulings_uri\": \"https://api.scryfall.com/cards/60cf954a-5503-460c-8720-8960842eea47/rulings\",\n" +
            "      \"prints_search_uri\": \"https://api.scryfall.com/cards/search?order=released&q=oracleid%3A8cbe71d3-b77b-49a7-9c51-ed308011b8b0&unique=prints\",\n" +
            "      \"collector_number\": \"69\",\n" +
            "      \"digital\": false,\n" +
            "      \"rarity\": \"uncommon\",\n" +
            "      \"flavor_text\": \"\\\"If I've done this right, it should immobilize all spirits in the area. If I've done this wrong... you know what, let's just hope I did it right.\\\"\",\n" +
            "      \"card_back_id\": \"0aeebaf5-8c7d-4636-9e82-8c27447861f7\",\n" +
            "      \"artist\": \"James Ryman\",\n" +
            "      \"artist_ids\": [\n" +
            "        \"3852bbc9-11c0-4fe3-8722-a06ad7e2bcc5\"\n" +
            "      ],\n" +
            "      \"illustration_id\": \"2c00a8be-cfe1-4583-92b1-4e99fc9beae7\",\n" +
            "      \"border_color\": \"black\",\n" +
            "      \"frame\": \"2015\",\n" +
            "      \"full_art\": false,\n" +
            "      \"textless\": false,\n" +
            "      \"booster\": true,\n" +
            "      \"story_spotlight\": false,\n" +
            "      \"edhrec_rank\": 16185,\n" +
            "      \"penny_rank\": 4900,\n" +
            "      \"preview\": {\n" +
            "        \"source\": \"Wizards of the Coast\",\n" +
            "        \"source_uri\": \"\",\n" +
            "        \"previewed_at\": \"2024-09-10\"\n" +
            "      },\n" +
            "      \"prices\": {\n" +
            "        \"usd\": \"0.07\",\n" +
            "        \"usd_foil\": \"0.13\",\n" +
            "        \"usd_etched\": null,\n" +
            "        \"eur\": \"0.08\",\n" +
            "        \"eur_foil\": \"0.17\",\n" +
            "        \"tix\": \"0.01\"\n" +
            "      },\n" +
            "      \"related_uris\": {\n" +
            "        \"gatherer\": \"https://gatherer.wizards.com/Pages/Card/Details.aspx?multiverseid=673474&printed=false\",\n" +
            "        \"tcgplayer_infinite_articles\": \"https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&trafcat=infinite&u=https%3A%2F%2Finfinite.tcgplayer.com%2Fsearch%3FcontentMode%3Darticle%26game%3Dmagic%26partner%3Dscryfall%26q%3DParanormal%2BAnalyst\",\n" +
            "        \"tcgplayer_infinite_decks\": \"https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&trafcat=infinite&u=https%3A%2F%2Finfinite.tcgplayer.com%2Fsearch%3FcontentMode%3Ddeck%26game%3Dmagic%26partner%3Dscryfall%26q%3DParanormal%2BAnalyst\",\n" +
            "        \"edhrec\": \"https://edhrec.com/route/?cc=Paranormal+Analyst\"\n" +
            "      },\n" +
            "      \"purchase_uris\": {\n" +
            "        \"tcgplayer\": \"https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&u=https%3A%2F%2Fwww.tcgplayer.com%2Fproduct%2F578055%3Fpage%3D1\",\n" +
            "        \"cardmarket\": \"https://www.cardmarket.com/en/Magic/Products/Singles/Duskmourn-House-of-Horror/Paranormal-Analyst?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall\",\n" +
            "        \"cardhoarder\": \"https://www.cardhoarder.com/cards/130269?affiliate_id=scryfall&ref=card-profile&utm_campaign=affiliate&utm_medium=card&utm_source=scryfall\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}\n";

    @Test
    void testGetMtgSets(){
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(allSets);
        String result = mtgService.getMtgSets();

        assertNotNull(result);
        assertEquals(result, allSets);
    }

    @Test
    void testAllSets()throws Exception{

        JsonNode testRoot = mock(JsonNode.class);
        when(objectMapper.readTree(anyString())).thenReturn(testRoot);

        JsonNode testData = mock(JsonNode.class);
        when(testRoot.get("data")).thenReturn(testData);

        Iterator<JsonNode> testArrayData = mock(Iterator.class);
        when(testData.elements()).thenReturn(testArrayData);

        when(testArrayData.hasNext()).thenReturn(true, false);

        JsonNode testSetData = mock(JsonNode.class);
        when(testArrayData.next()).thenReturn(testSetData);

        when(testSetData.get("name")).thenReturn(mock(JsonNode.class));
        when(testSetData.get("name").asText()).thenReturn("Limited Edition Alpha");
        when(testSetData.get("code")).thenReturn(mock(JsonNode.class));
        when(testSetData.get("code").asText()).thenReturn("lea");

        Map<String, String> result = mtgService.allSets(allSets);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("lea", result.get("Limited Edition Alpha"));
    }

    @Test
    void testGetMtgCardSet(){
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(allMtgCards);
        String result = mtgService.getMtgCardSet("dsk");

        assertNotNull(result);
        assertEquals(result, allMtgCards);
    }


    @Test
    void testMapData() throws Exception{

        JsonNode testRoot = mock(JsonNode.class);
        when(objectMapper.readTree(anyString())).thenReturn(testRoot);

        JsonNode testData = mock(JsonNode.class);
        when(testRoot.get("data")).thenReturn(testData);

        Iterator<JsonNode> testArrayData = mock(Iterator.class);
        when(testData.elements()).thenReturn(testArrayData);

        when(testArrayData.hasNext()).thenReturn(true, false);

        JsonNode testCardInfo = mock(JsonNode.class);
        when(testArrayData.next()).thenReturn(testCardInfo);

        when(testCardInfo.has("image_uris")).thenReturn(true);

        when(testCardInfo.has("name")).thenReturn(true);
        when(testCardInfo.get("name")).thenReturn(mock(JsonNode.class));
        when(testCardInfo.get("name").asText()).thenReturn("Paranormal Analyst");

        when(testCardInfo.has("rarity")).thenReturn(true);
        when(testCardInfo.get("rarity")).thenReturn(mock(JsonNode.class));
        when(testCardInfo.get("rarity").asText()).thenReturn("uncommon");

        JsonNode testImageUris = mock(JsonNode.class);
        when(testCardInfo.get("image_uris")).thenReturn(testImageUris);
        when(testImageUris.has("large")).thenReturn(true);
        JsonNode testLarge = mock(JsonNode.class);
        when(testImageUris.get("large")).thenReturn(testLarge);
        when(testLarge.asText()).thenReturn("https://cards.scryfall.io/large/front/6/0/60cf954a-5503-460c-8720-8960842eea47.jpg?1726286109");

        when(testCardInfo.has("purchase_uris")).thenReturn(true);
        JsonNode testPurchaseUris = mock(JsonNode.class);
        when(testCardInfo.get("purchase_uris")).thenReturn(testPurchaseUris);
        when(testPurchaseUris.has("tcgplayer")).thenReturn(true);
        JsonNode testTcgplayer = mock(JsonNode.class);
        when(testPurchaseUris.get("tcgplayer")).thenReturn(testTcgplayer);
        when(testTcgplayer.asText()).thenReturn("https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&u=https%3A%2F%2Fwww.tcgplayer.com%2Fproduct%2F578055%3Fpage%3D1");

        ArrayList<Mtg> result = mtgService.mapData(allMtgCards);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("uncommon", result.get(0).getRarity());
        assertEquals("https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&u=https%3A%2F%2Fwww.tcgplayer.com%2Fproduct%2F578055%3Fpage%3D1", result.get(0).getTcgplayerUrl());
    }

    @Test
    void testMapData2() throws Exception{

        JsonNode testRoot = mock(JsonNode.class);
        when(objectMapper.readTree(anyString())).thenReturn(testRoot);

        JsonNode testData = mock(JsonNode.class);
        when(testRoot.get("data")).thenReturn(testData);

        Iterator<JsonNode> testArrayData = mock(Iterator.class);
        when(testData.elements()).thenReturn(testArrayData);

        when(testArrayData.hasNext()).thenReturn(true, false);

        JsonNode testCardInfo = mock(JsonNode.class);
        when(testArrayData.next()).thenReturn(testCardInfo);

        when(testCardInfo.has("image_uris")).thenReturn(false);
        when(testCardInfo.has("card_faces")).thenReturn(true);
        JsonNode testCardFace = mock(JsonNode.class);
        when(testCardInfo.get("card_faces")).thenReturn(testCardFace);
        JsonNode testFrontFace = mock(JsonNode.class);
        when(testCardFace.get(0)).thenReturn(testFrontFace);

        when(testFrontFace.has("name")).thenReturn(true);
        when(testFrontFace.get("name")).thenReturn(mock(JsonNode.class));
        when(testFrontFace.get("name").asText()).thenReturn("Paranormal Analyst");

        when(testCardInfo.has("rarity")).thenReturn(true);
        when(testCardInfo.get("rarity")).thenReturn(mock(JsonNode.class));
        when(testCardInfo.get("rarity").asText()).thenReturn("uncommon");

        when(testFrontFace.has("image_uris")).thenReturn(true);
        JsonNode testImageUris = mock(JsonNode.class);
        when(testFrontFace.get("image_uris")).thenReturn(testImageUris);
        when(testImageUris.has("large")).thenReturn(true);
        JsonNode testLarge = mock(JsonNode.class);
        when(testImageUris.get("large")).thenReturn(testLarge);
        when(testLarge.asText()).thenReturn("https://cards.scryfall.io/large/front/6/0/60cf954a-5503-460c-8720-8960842eea47.jpg?1726286109");

        when(testCardInfo.has("purchase_uris")).thenReturn(true);
        JsonNode testPurchaseUris = mock(JsonNode.class);
        when(testCardInfo.get("purchase_uris")).thenReturn(testPurchaseUris);
        when(testPurchaseUris.has("tcgplayer")).thenReturn(true);
        JsonNode testTcgplayer = mock(JsonNode.class);
        when(testPurchaseUris.get("tcgplayer")).thenReturn(testTcgplayer);
        when(testTcgplayer.asText()).thenReturn("https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&u=https%3A%2F%2Fwww.tcgplayer.com%2Fproduct%2F578055%3Fpage%3D1");

        ArrayList<Mtg> result = mtgService.mapData(allMtgCards);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("uncommon", result.get(0).getRarity());
        assertEquals("https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&u=https%3A%2F%2Fwww.tcgplayer.com%2Fproduct%2F578055%3Fpage%3D1", result.get(0).getTcgplayerUrl());
    }

//    @Test
//    void testMapData3() throws Exception {
//
//        JsonNode testRoot = mock(JsonNode.class);
//        when(objectMapper.readTree(anyString())).thenReturn(testRoot);
//
//        JsonNode testData = mock(JsonNode.class);
//        when(testRoot.get("data")).thenReturn(testData);
//
//        Iterator<JsonNode> testArrayData = mock(Iterator.class);
//        when(testData.elements()).thenReturn(testArrayData);
//
//        JsonNode testCardInfoWithImageUris = mock(JsonNode.class);
//        JsonNode testCardInfoWithCardFaces = mock(JsonNode.class);
//
//        when(testArrayData.hasNext()).thenReturn(true, true, false);
//        when(testArrayData.next()).thenReturn(testCardInfoWithImageUris, testCardInfoWithCardFaces);
//
//        when(testCardInfoWithImageUris.has("image_uris")).thenReturn(true);
//        JsonNode imageUrisNode = mock(JsonNode.class);
//        when(testCardInfoWithImageUris.get("image_uris")).thenReturn(imageUrisNode);
//        when(imageUrisNode.has("large")).thenReturn(true);
//        JsonNode largeImageNode = mock(JsonNode.class);
//        when(imageUrisNode.get("large")).thenReturn(largeImageNode);
//        when(largeImageNode.asText()).thenReturn("https://example.com/large.jpg");
//
//        when(testCardInfoWithImageUris.has("name")).thenReturn(true);
//        JsonNode nameNode = mock(JsonNode.class);
//        when(testCardInfoWithImageUris.get("name")).thenReturn(nameNode);
//        when(nameNode.asText()).thenReturn("Card with Image");
//
//        when(testCardInfoWithImageUris.has("rarity")).thenReturn(true);
//        JsonNode rarityNode = mock(JsonNode.class);
//        when(testCardInfoWithImageUris.get("rarity")).thenReturn(rarityNode);
//        when(rarityNode.asText()).thenReturn("rare");
//
//        when(testCardInfoWithImageUris.has("purchase_uris")).thenReturn(true);
//        JsonNode purchaseUrisNode1 = mock(JsonNode.class);
//        when(testCardInfoWithImageUris.get("purchase_uris")).thenReturn(purchaseUrisNode1);
//        JsonNode tcgplayerNode1 = mock(JsonNode.class);
//        when(purchaseUrisNode1.has("tcgplayer")).thenReturn(true);
//        when(purchaseUrisNode1.get("tcgplayer")).thenReturn(tcgplayerNode1);
//        when(tcgplayerNode1.asText()).thenReturn("https://example.com/tcgplayer-card1");
//
//
//        when(testCardInfoWithCardFaces.has("image_uris")).thenReturn(false);
//        when(testCardInfoWithCardFaces.has("card_faces")).thenReturn(true);
//
//        JsonNode cardFacesNode = mock(JsonNode.class);
//        when(testCardInfoWithCardFaces.get("card_faces")).thenReturn(cardFacesNode);
//
//        JsonNode frontFaceNode = mock(JsonNode.class);
//        when(cardFacesNode.get(0)).thenReturn(frontFaceNode);
//
//        when(frontFaceNode.has("name")).thenReturn(true);
//        JsonNode frontFaceNameNode = mock(JsonNode.class);
//        when(frontFaceNode.get("name")).thenReturn(frontFaceNameNode);
//        when(frontFaceNameNode.asText()).thenReturn("Card with Faces");
//
//        when(testCardInfoWithCardFaces.has("rarity")).thenReturn(true);
//        JsonNode rarityNode2 = mock(JsonNode.class);
//        when(testCardInfoWithCardFaces.get("rarity")).thenReturn(rarityNode2);
//        when(rarityNode2.asText()).thenReturn("uncommon");
//
//        JsonNode frontFaceImageUrisNode = mock(JsonNode.class);
//        when(frontFaceNode.has("image_uris")).thenReturn(true);
//        when(frontFaceNode.get("image_uris")).thenReturn(frontFaceImageUrisNode);
//        when(frontFaceImageUrisNode.has("large")).thenReturn(true);
//        JsonNode frontFaceLargeImageNode = mock(JsonNode.class);
//        when(frontFaceImageUrisNode.get("large")).thenReturn(frontFaceLargeImageNode);
//        when(frontFaceLargeImageNode.asText()).thenReturn("https://example.com/large-card-face.jpg");
//
//        when(testCardInfoWithCardFaces.has("purchase_uris")).thenReturn(true);
//        JsonNode purchaseUrisNode2 = mock(JsonNode.class);
//        when(testCardInfoWithCardFaces.get("purchase_uris")).thenReturn(purchaseUrisNode2);
//        JsonNode tcgplayerNode2 = mock(JsonNode.class);
//        when(purchaseUrisNode2.has("tcgplayer")).thenReturn(true);
//        when(purchaseUrisNode2.get("tcgplayer")).thenReturn(tcgplayerNode2);
//        when(tcgplayerNode2.asText()).thenReturn("https://example.com/tcgplayer-card2");
//
//        ArrayList<Mtg> result = mtgService.mapData("mock json data");
//
//        assertEquals(2, result.size());
//        assertEquals("Card with Image", result.get(0).getName());
//        assertEquals("rare", result.get(0).getRarity());
//        assertEquals("https://example.com/large.jpg", result.get(0).getImgURL());
//        assertEquals("https://example.com/tcgplayer-card1", result.get(0).getTcgplayerUrl());
//
//        assertEquals("Card with Faces", result.get(1).getName());
//        assertEquals("uncommon", result.get(1).getRarity());
//        assertEquals("https://example.com/large-card-face.jpg", result.get(1).getImgURL());
//        assertEquals("https://example.com/tcgplayer-card2", result.get(1).getTcgplayerUrl());
//    }





}
