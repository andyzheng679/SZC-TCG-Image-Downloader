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
            "  }";

    @Test
    void testGetLorcanaSets(){
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(allSets);
        String result = lorcanaService.getLorcanaSets();

        assertNotNull(true);
        assertEquals(result, allSets);
    }
}
