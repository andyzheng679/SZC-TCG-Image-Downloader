package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.ControllerTest;


import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.controller.LorcanaController;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.ImageDownloaderService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.LorcanaService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Lorcana;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LorcanaController.class)
public class LorcanaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LorcanaService lorcanaService;

    @MockBean
    private ImageDownloaderService imageDownloaderService;

    @Test
    public void testGetAllSets() throws Exception{

        Map<String, String> mockMap = new HashMap<>();
        mockMap.put("Set 1", "1");
        mockMap.put("Set 2", "2");

        when(lorcanaService.allSets(anyString())).thenReturn(mockMap);
        when(lorcanaService.getLorcanaSets()).thenReturn("set url");

        mockMvc.perform(get("/lorcana/set").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"Set 1\":\"1\",\"Set 2\":\"2\"}"));
    }

    @Test
    public void testGetAllCards() throws Exception{

        List<Lorcana> mockArrayList = new ArrayList<>();
        mockArrayList.add(new Lorcana("name", "rarity", "imgURL"));

        when(lorcanaService.getAllCards(anyString())).thenReturn("Json String of all cards");
        when(lorcanaService.mapData("Json String of all cards")).thenReturn(mockArrayList);

        mockMvc.perform(get("/lorcana/set/{setNum}", "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"name\":\"name\",\"rarity\":\"rarity\",\"imgURL\":\"imgURL\"}]"));
    }


}
