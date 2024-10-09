package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCardTest;

import com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard.Lorcana;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LorcanaTest {
    //Arrange, Act, Assert

    @Test
    void testConstructorAndGetters(){
        String name = "Ariel - On Human Legs";
        String rarity = "Uncommon";
        String imgUrl = "https://lorcana-api.com/images/ariel/on_human_legs/ariel-on_human_legs-large.png";


        Lorcana lorcana = new Lorcana(name, rarity, imgUrl);

        assertEquals(name, lorcana.getName());
        assertEquals(rarity, lorcana.getRarity());
        assertEquals(imgUrl, lorcana.getImgURL());
    }

    @Test
    void testSetters(){
        Lorcana lorcana = new Lorcana("", "", "");

        lorcana.setName("Ariel - On Human Legs");
        lorcana.setRarity("Uncommon");
        lorcana.setImgUrl("https://lorcana-api.com/images/ariel/on_human_legs/ariel-on_human_legs-large.png");

        assertEquals("Ariel - On Human Legs", lorcana.getName());
        assertEquals("Uncommon", lorcana.getRarity());
        assertEquals("https://lorcana-api.com/images/ariel/on_human_legs/ariel-on_human_legs-large.png", lorcana.getImgURL());

    }
}
