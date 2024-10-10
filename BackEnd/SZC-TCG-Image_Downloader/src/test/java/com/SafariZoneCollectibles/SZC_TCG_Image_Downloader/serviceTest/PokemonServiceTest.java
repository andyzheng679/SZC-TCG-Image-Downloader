package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.serviceTest;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.PokemonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private ObjectMapper objectMapper;
    @InjectMocks
    private PokemonService pokemonService;

    @Test
    void testGetPokemonSets(){
        String json = "{\n" +
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

        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(json);

        String result = pokemonService.getPokemonSets();

        assertNotNull(result);
        assertEquals(json, result);
    }
}
