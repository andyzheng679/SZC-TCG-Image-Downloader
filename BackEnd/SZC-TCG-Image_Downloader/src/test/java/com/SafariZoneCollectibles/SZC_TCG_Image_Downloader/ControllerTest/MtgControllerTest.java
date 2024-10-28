package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.ControllerTest;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.controller.MtgController;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.helperClass.URLHelper;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.ImageDownloaderService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.MtgService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Mtg;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
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

    @MockBean
    private URLHelper urlHelper;

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

    @Test
    public void testGetDataByCode() throws Exception{
        ArrayList<Mtg> mockArrayList = new ArrayList<>();
        mockArrayList.add(new Mtg("name", "rarity", "imgURL", "tcgplayerUrl"));

        when(mtgService.getMtgCardSet(anyString())).thenReturn("Json String of all cards in set");
        when(mtgService.mapData("Json String of all cards in set")).thenReturn(mockArrayList);

        mockMvc.perform(get("/mtg/set/{code}", "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"name\":\"name\",\"rarity\":\"rarity\",\"imgURL\":\"imgURL\", \"tcgplayerUrl\":\"tcgplayerUrl\"}]"));

    }


}
