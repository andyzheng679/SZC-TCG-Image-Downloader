package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCardTest;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonTest {
    //Arrange, Act, Assert

    @Test
    void testConstructorAndGetters(){
        String name = "Venusaur ex";
        String rarity = "Double Rare";
        String imgUrl = "https://images.pokemontcg.io/sv7/1_hires.png";
        String tcgplayerUrl = "https://prices.pokemontcg.io/tcgplayer/sv7-1";

        Pokemon pokemon = new Pokemon(name, rarity, imgUrl, tcgplayerUrl);

        assertEquals(name, pokemon.getName());
        assertEquals(rarity, pokemon.getRarity());
        assertEquals(imgUrl, pokemon.getImgURL());
        assertEquals(tcgplayerUrl, pokemon.getTcgplayerUrl());
    }

    @Test
    void testSetters(){
        Pokemon pokemon = new Pokemon("", "", "", "");

        pokemon.setName("Venusaur ex");
        pokemon.setRarity("Double Rare");
        pokemon.setImgURL("https://images.pokemontcg.io/sv7/1_hires.png");
        pokemon.setTcgplayerUrl("https://prices.pokemontcg.io/tcgplayer/sv7-1");

        assertEquals("Venusaur ex", pokemon.getName());
        assertEquals("Double Rare", pokemon.getRarity());
        assertEquals("https://images.pokemontcg.io/sv7/1_hires.png", pokemon.getImgURL());
        assertEquals("https://prices.pokemontcg.io/tcgplayer/sv7-1", pokemon.getTcgplayerUrl());
    }
}
