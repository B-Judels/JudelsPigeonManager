package org.example;

import java.util.ArrayList;

public class Pigeons {
    private String pigeonID;
    private String pigeonColour;

    public Pigeons(String pigeonID, String pigeonColour) {
        this.pigeonID = pigeonID;
        this.pigeonColour = pigeonColour;
    }

    public String getPigeonID() {
        return pigeonID;
    }

    public void setPigeonID(String pigeonID) {
        this.pigeonID = pigeonID;
    }

    public String getPigeonColour() {
        return pigeonColour;
    }

    public static ArrayList<Pigeons> data = new ArrayList<>();
}
