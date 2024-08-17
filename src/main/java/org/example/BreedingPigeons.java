package org.example;

import java.util.ArrayList;

public class BreedingPigeons {
        private String bPigeonID;
        private String bPigeonName;
        private String bPigeonYear;
        private String bPigeonColour;
        private String bPigeonGender;
        private String bPigeonLetters;
        private String bGeneticCode1;
        private String bGeneticCode2;
        private String bGeneticCode3;
        private String bGeneticCode4;


        public BreedingPigeons(String bPigeonID, String bPigeonName, String bPigeonYear,
                                    String bPigeonLetters, String bPigeonGender, String bPigeonColour,
                                        String bGeneticCode1, String bGeneticCode2, String bGeneticCode3, String bGeneticCode4) {

            this.bPigeonID = bPigeonID;
            this.bPigeonName = bPigeonName;
            this.bPigeonYear = bPigeonYear;
            this.bPigeonLetters = bPigeonLetters;
            this.bPigeonGender = bPigeonGender;
            this.bPigeonColour = bPigeonColour;
            this.bGeneticCode1 = bGeneticCode1;
            this.bGeneticCode2 = bGeneticCode2;
            this.bGeneticCode3 = bGeneticCode3;
            this.bGeneticCode4 = bGeneticCode4;
        }
        //ID methods
        public String getBPigeonID() {
            return bPigeonID;
        }

        public void setBPigeonID(String bPigeonID) {
            this.bPigeonID = bPigeonID;
        }
        //---
//Name methods
        public String getBPigeonName() {
            return bPigeonName;
        }

        public void setBPigeonName(String bPigeonName) {
            this.bPigeonName = bPigeonName;
        }
        //---
//Year methods
        public String getBPigeonYear() {
            return bPigeonYear;
        }

        public void setBPigeonYear(String bPigeonYear) {
            this.bPigeonYear = bPigeonYear;
        }
        //---
//Colour methods
        public String getBPigeonColour() {
            return bPigeonColour;
        }

        public void setBPigeonColour(String bPigeonColour) {
            this.bPigeonColour = bPigeonColour;
        }
        //---
//Gender methods
        public String getBPigeonGender() {
            return bPigeonGender;
        }

        public void setBPigeonGender(String bPigeonGender) {
            this.bPigeonGender = bPigeonGender;
        }
        //---
//Letters methods
        public String getBPigeonLetters() {
            return bPigeonLetters;
        }

        public void setBPigeonLetters(String bPigeonLetters) {
            this.bPigeonLetters = bPigeonLetters;
        }
//---
    public String getBGeneticCode1() {
            return bGeneticCode1;
    }
    public void setBGeneticCode1(String bGeneticCode1) {
            this.bGeneticCode1 = bGeneticCode1;
    }

    public String getBGeneticCode2() {
            return bGeneticCode2;
    }
    public void setBGeneticCode2(String bGeneticCode2) {
            this.bGeneticCode2 = bGeneticCode2;
    }

    public String getBGeneticCode3() {
            return bGeneticCode3;
    }
    public void setBGeneticCode3(String bGeneticCode3) {
            this.bGeneticCode3 = bGeneticCode3;
        }

    public String getBGeneticCode4() {
            return bGeneticCode4;
    }
    public void setBGeneticCode4(String bGeneticCode4) {
            this.bGeneticCode4 = bGeneticCode4;
    }

    }

