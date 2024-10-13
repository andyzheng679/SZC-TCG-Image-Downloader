package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.serviceTest;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.LorcanaService;
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
public class LorcanaServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private LorcanaService lorcanaService;

    private String allSets = "[\n" +
            "  {\n" +
            "    \"Set_Num\": 1,\n" +
            "    \"Release_Date\": \"2023-08-18\",\n" +
            "    \"Cards\": 204,\n" +
            "    \"Name\": \"The First Chapter\",\n" +
            "    \"Set_ID\": \"TFC\"\n" +
            "  }]";

    private String getCards = "[\n" +
            "  {\n" +
            "    \"Artist\": \"Matthew Robert Davies\",\n" +
            "    \"Set_Name\": \"The First Chapter\",\n" +
            "    \"Classifications\": \"Storyborn, Hero, Princess\",\n" +
            "    \"Date_Added\": \"2023-08-18T12:00\",\n" +
            "    \"Set_Num\": 1,\n" +
            "    \"Color\": \"Amber\",\n" +
            "    \"Gamemode\": \"Lorcana\",\n" +
            "    \"Franchise\": \"\",\n" +
            "    \"Image\": \"https://lorcana-api.com/images/ariel/on_human_legs/ariel-on_human_legs-large.png\",\n" +
            "    \"Cost\": 4,\n" +
            "    \"Inkable\": true,\n" +
            "    \"Name\": \"Ariel - On Human Legs\",\n" +
            "    \"Type\": \"Character\",\n" +
            "    \"Lore\": 2,\n" +
            "    \"Rarity\": \"Uncommon\",\n" +
            "    \"Flavor_Text\": \"\\\"...\\\"\",\n" +
            "    \"Unique_ID\": \"TFC-001\",\n" +
            "    \"Card_Num\": 1,\n" +
            "    \"Body_Text\": \"Voiceless - This character can't {e} to sing songs.\",\n" +
            "    \"Willpower\": 4,\n" +
            "    \"Card_Variants\": \"\",\n" +
            "    \"Date_Modified\": \"2024-08-29 16:27:12.0\",\n" +
            "    \"Strength\": 3,\n" +
            "    \"Set_ID\": \"TFC\"\n" +
            "  }]";

    @Test
    void testGetLorcanaSets(){
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(allSets);
        String result = lorcanaService.getLorcanaSets();

        assertNotNull(true);
        assertEquals(result, allSets);
    }

    @Test
    void testGetAllCards(){
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(getCards);
        String result = lorcanaService.getAllCards("1");

        assertNotNull(true);
        assertEquals(result, getCards);
    }
}
