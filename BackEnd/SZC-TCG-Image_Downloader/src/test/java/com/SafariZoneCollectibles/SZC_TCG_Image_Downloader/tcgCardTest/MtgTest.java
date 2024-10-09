package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCardTest;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Mtg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MtgTest {
    //Arrange, Act, Assert

    @Test
    void testConstructorAndGetters(){
        String name = "Abandoned Campground";
        String rarity = "common";
        String imgUrl = "https://cards.scryfall.io/large/front/e/e/ee0565f5-ebdb-43f9-bbb4-0485b1968937.jpg?1726286826";
        String tcgplayerUrl = "https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&u=https%3A%2F%2Fwww.tcgplayer.com%2Fproduct%2F575112%3Fpage%3D1";

        Mtg mtg = new Mtg(name, rarity, imgUrl, tcgplayerUrl);

        assertEquals(name, mtg.getName());
        assertEquals(rarity, mtg.getRarity());
        assertEquals(imgUrl, mtg.getImgURL());
        assertEquals(tcgplayerUrl, mtg.getTcgplayerUrl());
    }

    @Test
    void testSetters(){
        Mtg mtg = new Mtg("", "", "", "");

        mtg.setName("Abandoned Campground");
        mtg.setRarity("common");
        mtg.setImgURL("https://cards.scryfall.io/large/front/e/e/ee0565f5-ebdb-43f9-bbb4-0485b1968937.jpg?1726286826");
        mtg.setTcgplayerUrl("https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&u=https%3A%2F%2Fwww.tcgplayer.com%2Fproduct%2F575112%3Fpage%3D1");

        assertEquals("Abandoned Campground", mtg.getName());
        assertEquals("common", mtg.getRarity());
        assertEquals("https://cards.scryfall.io/large/front/e/e/ee0565f5-ebdb-43f9-bbb4-0485b1968937.jpg?1726286826", mtg.getImgURL());
        assertEquals("https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&u=https%3A%2F%2Fwww.tcgplayer.com%2Fproduct%2F575112%3Fpage%3D1", mtg.getTcgplayerUrl());
    }
}
