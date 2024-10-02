package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.tcgCard;

public class Mtg {

    private String name;

    private String rarity;

    private String imgURL;

    private String tcgplayerUrl;

    public Mtg(String name, String rarity, String imgURL, String tcgplayerUrl) {
        this.name = name;
        this.rarity = rarity;
        this.imgURL = imgURL;
        this.tcgplayerUrl = tcgplayerUrl;
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

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTcgplayerUrl() {
        return tcgplayerUrl;
    }

    public void setTcgplayerUrl(String tcgplayerUrl) {
        this.tcgplayerUrl = tcgplayerUrl;
    }
}
