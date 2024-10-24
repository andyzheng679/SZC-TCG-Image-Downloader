package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.ControllerTest;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.controller.MtgController;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.ImageDownloaderService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.MtgService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MtgController.class)
public class MtgControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MtgService mtgService;

    @MockBean
    private ImageDownloaderService imageDownloaderService;

    @Test
    public void testGetAllMtgSets() throws Exception{

        Map<String, String> mockMap = new HashMap<>();
        mockMap.put("Set 1", "1");
        mockMap.put("Set 2", "2");

        when(mtgService.allSets(anyString())).thenReturn(mockMap);
        when(mtgService.getMtgSets()).thenReturn("Json String of all sets");

        mockMvc.perform(get("/mtg/set").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"Set 1\":\"1\",\"Set 2\":\"2\"}"));

    }
}
