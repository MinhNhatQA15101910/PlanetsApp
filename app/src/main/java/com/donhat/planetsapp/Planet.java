package com.donhat.planetsapp;

public class Planet {
    private final String name;
    private final String moonCount;
    private final int image;

    public Planet(String name, String moonCount, int image) {
        this.name = name;
        this.moonCount = moonCount;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getMoonCount() {
        return moonCount;
    }

    public int getImage() {
        return image;
    }
}
