package org.example;

public class RaceData {
    private String pigeonID;
    private String pigeonCC;
    private String Year;
    private int placement;
    private int score;

    public RaceData(String pigeonID, String pigeonCC, String Year, int placement, int score) {
        this.pigeonID = pigeonID;
        this.pigeonCC = pigeonCC;
        this.Year = Year;
        this.placement = placement;
        this.score = score;
    }
    public String getPigeonID() {
        return pigeonID;
    }
    public void setPigeonID(String pigeonID) {
        this.pigeonID = pigeonID;
    }

    public String getPigeonCC() {
        return pigeonCC;
    }
    public void setPigeonCC(String pigeonCC) {
        this.pigeonCC = pigeonCC;
    }

    public String getYear() {
        return Year;
    }
    public void setYear(String year) {
        Year = year;
    }

    public int getPlacement() {
        return placement;
    }
    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
