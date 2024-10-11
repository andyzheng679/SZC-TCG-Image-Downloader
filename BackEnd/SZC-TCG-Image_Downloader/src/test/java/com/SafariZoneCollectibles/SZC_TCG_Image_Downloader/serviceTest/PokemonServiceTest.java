package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.serviceTest;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.PokemonService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private ObjectMapper objectMapper;
    @InjectMocks
    private PokemonService pokemonService;

    private String setJson = "{\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"id\": \"base2\",\n" +
            "      \"name\": \"Jungle\",\n" +
            "      \"series\": \"Base\",\n" +
            "      \"printedTotal\": 64,\n" +
            "      \"total\": 64,\n" +
            "      \"legalities\": {\n" +
            "        \"unlimited\": \"Legal\"\n" +
            "      },\n" +
            "      \"ptcgoCode\": \"JU\",\n" +
            "      \"releaseDate\": \"1999/06/16\",\n" +
            "      \"updatedAt\": \"2020/08/14 09:35:00\",\n" +
            "      \"images\": {\n" +
            "        \"symbol\": \"https://images.pokemontcg.io/base2/symbol.png\",\n" +
            "        \"logo\": \"https://images.pokemontcg.io/base2/logo.png\"\n" +
            "      }\n" +
            "    }\n" +
            "]\n" +
            "}";

    private String cardJson = "{\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"id\": \"base2-1\",\n" +
            "      \"name\": \"Clefable\",\n" +
            "      \"supertype\": \"Pokémon\",\n" +
            "      \"subtypes\": [\n" +
            "        \"Stage 1\"\n" +
            "      ],\n" +
            "      \"level\": \"34\",\n" +
            "      \"hp\": \"70\",\n" +
            "      \"types\": [\n" +
            "        \"Colorless\"\n" +
            "      ],\n" +
            "      \"evolvesFrom\": \"Clefairy\",\n" +
            "      \"attacks\": [\n" +
            "        {\n" +
            "          \"name\": \"Metronome\",\n" +
            "          \"cost\": [\n" +
            "            \"Colorless\"\n" +
            "          ],\n" +
            "          \"convertedEnergyCost\": 1,\n" +
            "          \"damage\": \"\",\n" +
            "          \"text\": \"Choose 1 of the Defending Pokémon's attacks. Metronome copies that attack except for its Energy costs and anything else required in order to use that attack, such as discarding Energy cards. (No matter what type the Defending Pokémon is, Clefable's type is still Colorless.)\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Minimize\",\n" +
            "          \"cost\": [\n" +
            "            \"Colorless\",\n" +
            "            \"Colorless\"\n" +
            "          ],\n" +
            "          \"convertedEnergyCost\": 2,\n" +
            "          \"damage\": \"\",\n" +
            "          \"text\": \"All damage done by attacks to Clefable during your opponent's next turn is reduced by 20 (after applying Weakness and Resistance).\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"weaknesses\": [\n" +
            "        {\n" +
            "          \"type\": \"Fighting\",\n" +
            "          \"value\": \"×2\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"resistances\": [\n" +
            "        {\n" +
            "          \"type\": \"Psychic\",\n" +
            "          \"value\": \"-30\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"retreatCost\": [\n" +
            "        \"Colorless\",\n" +
            "        \"Colorless\"\n" +
            "      ],\n" +
            "      \"convertedRetreatCost\": 2,\n" +
            "      \"set\": {\n" +
            "        \"id\": \"base2\",\n" +
            "        \"name\": \"Jungle\",\n" +
            "        \"series\": \"Base\",\n" +
            "        \"printedTotal\": 64,\n" +
            "        \"total\": 64,\n" +
            "        \"legalities\": {\n" +
            "          \"unlimited\": \"Legal\"\n" +
            "        },\n" +
            "        \"ptcgoCode\": \"JU\",\n" +
            "        \"releaseDate\": \"1999/06/16\",\n" +
            "        \"updatedAt\": \"2020/08/14 09:35:00\",\n" +
            "        \"images\": {\n" +
            "          \"symbol\": \"https://images.pokemontcg.io/base2/symbol.png\",\n" +
            "          \"logo\": \"https://images.pokemontcg.io/base2/logo.png\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"number\": \"1\",\n" +
            "      \"artist\": \"Mitsuhiro Arita\",\n" +
            "      \"rarity\": \"Rare Holo\",\n" +
            "      \"flavorText\": \"A timid Fairy Pokémon that is rarely seen. It will run and hide the moment it senses people.\",\n" +
            "      \"nationalPokedexNumbers\": [36],\n" +
            "      \"legalities\": {\n" +
            "        \"unlimited\": \"Legal\"\n" +
            "      },\n" +
            "      \"images\": {\n" +
            "        \"small\": \"https://images.pokemontcg.io/base2/1.png\",\n" +
            "        \"large\": \"https://images.pokemontcg.io/base2/1_hires.png\"\n" +
            "      },\n" +
            "      \"tcgplayer\": {\n" +
            "        \"url\": \"https://prices.pokemontcg.io/tcgplayer/base2-1\",\n" +
            "        \"updatedAt\": \"2024/10/10\",\n" +
            "        \"prices\": {\n" +
            "          \"1stEditionHolofoil\": {\n" +
            "            \"low\": 26,\n" +
            "            \"mid\": 44.99,\n" +
            "            \"high\": 62.99,\n" +
            "            \"market\": 48.81,\n" +
            "            \"directLow\": null\n" +
            "          },\n" +
            "          \"unlimitedHolofoil\": {\n" +
            "            \"low\": 3.75,\n" +
            "            \"mid\": 15,\n" +
            "            \"high\": 34.97,\n" +
            "            \"market\": 19.62,\n" +
            "            \"directLow\": null\n" +
            "          }\n" +
            "        }\n" +
            "      },\n" +
            "      \"cardmarket\": {\n" +
            "        \"url\": \"https://prices.pokemontcg.io/cardmarket/base2-1\",\n" +
            "        \"updatedAt\": \"2024/10/10\",\n" +
            "        \"prices\": {\n" +
            "          \"averageSellPrice\": 0,\n" +
            "          \"lowPrice\": 200,\n" +
            "          \"trendPrice\": 135.68,\n" +
            "          \"germanProLow\": 0,\n" +
            "          \"suggestedPrice\": 0,\n" +
            "          \"reverseHoloSell\": 0,\n" +
            "          \"reverseHoloLow\": 0,\n" +
            "          \"reverseHoloTrend\": 122.22,\n" +
            "          \"lowPriceExPlus\": 200,\n" +
            "          \"avg1\": 600,\n" +
            "          \"avg7\": 97.64,\n" +
            "          \"avg30\": 123.22,\n" +
            "          \"reverseHoloAvg1\": 122.22,\n" +
            "          \"reverseHoloAvg7\": 122.22,\n" +
            "          \"reverseHoloAvg30\": 122.22\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "]\n" +
            "}";

    @Test
    void testGetPokemonSets(){

        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(setJson);

        String result = pokemonService.getPokemonSets();

        assertNotNull(result);
        assertEquals(setJson, result);
    }

    @Test
    void testAllSets() throws Exception{
        JsonNode mockRootNode = mock(JsonNode.class);
        JsonNode mockDataNode = mock(JsonNode.class);
        JsonNode mockSetDataNode = mock(JsonNode.class);

        when(objectMapper.readTree(anyString())).thenReturn(mockRootNode);
        when(mockRootNode.get("data")).thenReturn(mockDataNode);

        Iterator<JsonNode> mockArrayData = mock(Iterator.class);
        when(mockDataNode.elements()).thenReturn(mockArrayData);
        when(mockArrayData.hasNext()).thenReturn(true, false);
        when(mockArrayData.next()).thenReturn(mockSetDataNode);

        when(mockSetDataNode.get("name")).thenReturn(mock(JsonNode.class));
        when(mockSetDataNode.get("id")).thenReturn(mock(JsonNode.class));
        when(mockSetDataNode.get("name").asText()).thenReturn("Jungle");
        when(mockSetDataNode.get("id").asText()).thenReturn("base2");

        Map<String, String> result = pokemonService.allSets(setJson);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("base2", result.get("Jungle"));
    }

    @Test
    void testGetPokemonSetCards(){
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(cardJson);
        String results = pokemonService.getPokemonSetCards("base2");

        assertNotNull(results);
        assertEquals(cardJson, results);
    }

    
}
