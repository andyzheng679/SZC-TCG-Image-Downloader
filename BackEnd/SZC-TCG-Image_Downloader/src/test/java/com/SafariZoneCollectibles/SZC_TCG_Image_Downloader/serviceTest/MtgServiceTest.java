package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.serviceTest;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.MtgService;
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

    


    @Test
    void testGetMtgSets(){
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(allSets);
        String result = mtgService.getMtgSets();

        assertNotNull(true);
        assertEquals(result, allSets);
    }


}
