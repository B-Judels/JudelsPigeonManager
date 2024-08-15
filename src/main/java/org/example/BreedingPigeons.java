package org.example;

import java.util.ArrayList;

public class BreedingPigeons {
        private String bPigeonID;
        private String bPigeonName;
        private String bPigeonYear;
        private String bPigeonColour;
        private String bPigeonGender;
        private String bPigeonLetters;

        public BreedingPigeons(String bPigeonID, String bPigeonName, String bPigeonYear,
                       String bPigeonLetters, String bPigeonColour, String bPigeonGender) {

            this.bPigeonID = bPigeonID;
            this.bPigeonName = bPigeonName;
            this.bPigeonYear = bPigeonYear;
            this.bPigeonColour = bPigeonColour;
            this.bPigeonGender = bPigeonGender;
            this.bPigeonLetters = bPigeonLetters;
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
    }

