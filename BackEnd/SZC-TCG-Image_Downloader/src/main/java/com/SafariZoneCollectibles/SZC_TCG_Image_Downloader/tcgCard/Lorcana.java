package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard;

public class Lorcana {

    private String name;

    private String rarity;

    private String imgURL;

    public Lorcana(String name, String rarity, String imgURL) {
        this.name = name;
        this.rarity = rarity;
        this.imgURL = imgURL;
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

    public String getImgURL() {
        return imgURL;
    }

    public void setImgUrl(String imgUrl) {
        this.imgURL = imgUrl;
    }
}
