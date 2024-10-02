package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard;

public class Lorcana {

    private String name;

    private String rarity;

    private String imgUrl;

    public Lorcana(String name, String rarity, String imgUrl) {
        this.name = name;
        this.rarity = rarity;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
