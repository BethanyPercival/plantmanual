package com.bethanypercival.rxjavatestapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bethanypercival on 07/03/2018.
 */

public class PlantOverview {
    @SerializedName("tfvname")
    private String name;
    @SerializedName("botname")
    private String botanicalName;
    @SerializedName("othname")
    private String otherName;
    @SerializedName("imageurl")
    private String imageUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBotanicalName() {
        return botanicalName;
    }

    public void setBotanicalName(String botanicalName) {
        this.botanicalName = botanicalName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
