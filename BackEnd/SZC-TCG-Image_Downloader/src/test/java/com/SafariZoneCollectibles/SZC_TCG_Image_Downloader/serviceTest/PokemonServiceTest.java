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

    private String json = "{\n" +
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

    @Test
    void testGetPokemonSets(){

        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(json);

        String result = pokemonService.getPokemonSets();

        assertNotNull(result);
        assertEquals(json, result);
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

        Map<String, String> result = pokemonService.allSets(json);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("base2", result.get("Jungle"));





    }
}
