package org.example;

import java.util.ArrayList;

public class Pigeons {
    private String pigeonID;
    private String pigeonColour;
    private String pigeonGender;

    public Pigeons(String pigeonID, String pigeonColour, String pigeonGender) {
        this.pigeonID = pigeonID;
        this.pigeonColour = pigeonColour;
        this.pigeonGender = pigeonGender;
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

    public String getPigeonGender() {
        return pigeonGender;
    }

    public static ArrayList<Pigeons> data = new ArrayList<>();

}
