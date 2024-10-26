package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.ControllerTest;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.controller.PokemonController;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.helperClass.URLHelper;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.ImageDownloaderService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service.PokemonService;
import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Pokemon;
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

@WebMvcTest(PokemonController.class)
public class PokemonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @MockBean
    private ImageDownloaderService imageDownloaderService;

    @MockBean
    private URLHelper urlHelper;

    @Test
    public void testGetAllPokemonSets() throws Exception{

        Map<String, String> mockMap = new HashMap<>();
        mockMap.put("Set 1", "1");
        mockMap.put("Set 2", "2");

        when(pokemonService.allSets(anyString())).thenReturn(mockMap);
        when(pokemonService.getPokemonSets()).thenReturn("Json of all Sets");

        mockMvc.perform(get("/pokemon/set").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"Set 1\":\"1\",\"Set 2\":\"2\"}"));
    }

    @Test
    public void testGetDataById() throws Exception{

        ArrayList<Pokemon> mockArrayList = new ArrayList<>();
        mockArrayList.add(new Pokemon("name", "rarity", "imgURL", "tcgplayerUrl"));

        when(pokemonService.getPokemonSetCards(anyString())).thenReturn("Json String of all cards in set");
        when(pokemonService.mapData("Json String of all cards in set")).thenReturn(mockArrayList);

        mockMvc.perform(get("/pokemon/set/{id}", "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"name\":\"name\",\"rarity\":\"rarity\",\"imgURL\":\"imgURL\", \"tcgplayerUrl\":\"tcgplayerUrl\"}]"));
    }
}
