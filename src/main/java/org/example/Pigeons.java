package org.example;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pigeons {
    private String pigeonID;
    private String PigeonCallingCard;
    private String pigeonYear;
    private int pigeonScore;
    private double pigeonScorePercentage;
    private int pigeonWins;
    private String pigeonFather;
    private String pigeonMother;
    private String pigeonColour;
    private String pigeonGender;
    private String pigeonLetters;
    private String pigeonWeaned;

    public Pigeons(String pigeonID, String pigeonCallingCard, String pigeonYear,
                   int pigeonScore, double pigeonScorePercentage, int pigeonWins,
                   String pigeonFather, String pigeonMother, String pigeonLetters,
                   String pigeonColour, String pigeonGender,String pigeonWeaned) {

        this.pigeonID = pigeonID;
        this.PigeonCallingCard = pigeonCallingCard;
        this.pigeonYear = pigeonYear;
        this.pigeonScore = pigeonScore;
        this.pigeonScorePercentage = pigeonScorePercentage;
        this.pigeonWins = pigeonWins;
        this.pigeonFather = pigeonFather;
        this.pigeonMother = pigeonMother;
        this.pigeonColour = pigeonColour;
        this.pigeonGender = pigeonGender;
        this.pigeonLetters = pigeonLetters;
        this.pigeonWeaned = pigeonWeaned;
    }
  //ID methods
    public String getPigeonID() {
        return pigeonID;
    }

    public void setPigeonID(String pigeonID) {
        this.pigeonID = pigeonID;
    }
//---
//Calling card methods
    public String getPigeonCallingCard() {
        return PigeonCallingCard;
    }

    public void setPigeonCallingCard(String pigeonCallingCard) {
        this.PigeonCallingCard = pigeonCallingCard;
    }
//---
//Year methods
    public String getPigeonYear() {
        return pigeonYear;
    }

    public void setPigeonYear(String pigeonYear) {
        this.pigeonYear = pigeonYear;
    }
//---
//Score methods
    public int getPigeonScore() {
        return pigeonScore;
    }

    public void setPigeonScore(int pigeonScore) {
        this.pigeonScore = pigeonScore;
    }
//---
//Score percentage methods
    public double getPigeonScorePercentage() {
        return pigeonScorePercentage;
    }

    public void setPigeonScorePercentage(double pigeonScorePercentage) {
        this.pigeonScorePercentage = pigeonScorePercentage;
    }
//---
//Wins methods
    public int getPigeonWins() {
        return pigeonWins;
    }

    public void setPigeonWins(int pigeonWins) {
        this.pigeonWins = pigeonWins;
    }
//---
//Father methods
    public String getPigeonFather() {
        return pigeonFather;
    }

    public void setPigeonFather(String pigeonFather) {
        this.pigeonFather = pigeonFather;
    }
//---
//Mother methods
    public String getPigeonMother() {
        return pigeonMother;
    }

    public void setPigeonMother(String pigeonMother) {
        this.pigeonMother = pigeonMother;
    }
//---
//Colour methods
    public String getPigeonColour() {
        return pigeonColour;
    }

    public void setPigeonColour(String pigeonColour) {
        this.pigeonColour = pigeonColour;
    }
//---
//Gender methods
    public String getPigeonGender() {
        return pigeonGender;
    }

    public void setPigeonGender(String pigeonGender) {
        this.pigeonGender = pigeonGender;
    }
//---
//Weaned methods
    public String getPigeonWeaned() {
        return pigeonWeaned;
    }

    public void setPigeonWeaned(String pigeonWeaned) {
        this.pigeonWeaned = pigeonWeaned;
    }
//---
//Letters methods
    public String getPigeonLetters() {
        return pigeonLetters;
    }

    public void setPigeonLetters(String pigeonLetters) {
        this.pigeonLetters = pigeonLetters;
    }
//---

    public static ArrayList<Pigeons> data = new ArrayList<>();

}
