package org.example;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pigeons {
    private String pigeonID;
    private String PigeonCallingCard;
    private String pigeonYear;
    private int pigeonScored;
    private double pigeonScorePercentage;
    private int pigeonWins;
    private String pigeonFather;
    private String pigeonMother;
    private String pigeonColour;
    private String pigeonGender;
    private String pigeonLetters;
    private String pigeonWeaned;
    private int pigeonFlyed;
    private String gC1;
    private String gC2;
    private String gC3;
    private String gC4;
    private String gC5;
    private String gC6;
    private String gC7;
    private String gC8;

    public Pigeons(String pigeonID, String pigeonCallingCard, String pigeonYear,
                   int pigeonScored, double pigeonScorePercentage, int pigeonWins,
                   String pigeonFather, String pigeonMother, String pigeonLetters,
                   String pigeonColour, String pigeonGender,String pigeonWeaned,
                   int PigeonFlyed, String gC1, String gC2, String gC3, String gC4,
                   String gC5, String gC6, String gC7, String gC8) {

        this.pigeonID = pigeonID;
        this.PigeonCallingCard = pigeonCallingCard;
        this.pigeonYear = pigeonYear;
        this.pigeonScored = pigeonScored;
        this.pigeonScorePercentage = pigeonScorePercentage;
        this.pigeonWins = pigeonWins;
        this.pigeonFather = pigeonFather;
        this.pigeonMother = pigeonMother;
        this.pigeonColour = pigeonColour;
        this.pigeonGender = pigeonGender;
        this.pigeonLetters = pigeonLetters;
        this.pigeonWeaned = pigeonWeaned;
        this.gC1 = gC1;
        this.gC2 = gC2;
        this.gC3 = gC3;
        this.gC4 = gC4;
        this.gC5 = gC5;
        this.gC6 = gC6;
        this.gC7 = gC7;
        this.gC8 = gC8;
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
//Scored methods
    public int getPigeonScored() {
        return pigeonScored;
    }

    public void setPigeonScored(int pigeonScore) {
        this.pigeonScored = pigeonScore;
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
    public String getgC1(){
        return gC1;
    }
    public void setgC1(String gC1){
        this.gC1 = gC1;
    }

    public String getgC2(){
        return gC2;
    }
    public void setgC2(String gC2){
        this.gC2 = gC2;
    }

    public String getgC3(){
        return gC3;
    }
    public void setgC3(String gC3){
        this.gC3 = gC3;
    }

    public String getgC4(){
        return gC4;
    }
    public void setgC4(String gC4){
        this.gC4 = gC4;
    }

    public String getgC5(){
        return gC5;
    }
    public void setgC5(String gC5){
        this.gC5 = gC5;
    }

    public String getgC6(){
        return gC6;
    }
    public void setgC6(String gC6){
        this.gC6 = gC6;
    }

    public String getgC7(){
        return gC7;
    }
    public void setgC7(String gC7){
        this.gC7 = gC7;
    }

    public String getgC8(){
        return gC8;
    }
    public void setgC8(String gC8){
        this.gC8 = gC8;
    }

}
