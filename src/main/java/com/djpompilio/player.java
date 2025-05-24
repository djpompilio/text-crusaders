package com.djpompilio;

public class player {
    //health, level, luck, speed, strength, charisma, gold coins

    //Basic player stats
    static String name = new String("Unknown");
    static int hp = 100;
    static int lvl = 0;
    static int xp = 0; //max of 100
    static int gc = 0;

    static double diffMult = 0.5; //ratio of events triggered. 0.5 - Normal Difficulty: 50/50 split between triggering an event and being safe(either nothing happens, story progresses or loot or some other bonus)

    //Attributes
    static int strength = 0;
    static int speed = 0;
    static int charisma = 0;
    static int luck = 0;

    static int getHealth(){
        return hp;
    }
    static void setHealth(int x){
        hp = x;
    }
    static void addHealth(int x){
        hp += x;
    }
    
    static int getLevel(){
        return lvl;
    }
    static boolean addXp(int x){
        xp += x;
        if(xp == 100) {
            xp = 0;
            lvl++;
            return true;
        }
        else if (xp > 100) {
            xp -= 100;
            lvl++;
            return true;
        }
        else {
            return false;
        }

    }
    static int getCoins(){
        return gc;
    }
    static void removeCoins(int x){
        gc -= x;
    }
    static void addCoins(int x){
        gc += x;
    }

    static int getStrength(){
        return strength;
    }
    static int getSpeed(){
        return speed;
    }
    static int getCharisma(){
        return charisma;
    }
    static int getLuck(){
        return luck;
    }

    static void addStrength(int x){
        strength += x;
    }
    static void addSpeed(int x){
        speed += x;
    }
    static void addCharisma(int x){
        charisma += x;
    }
    static void addLuck(int x){
        luck += x;
    }

    static void setDiffMult(int Difficulty){
        if(Difficulty == 1){
            diffMult = 0.20;
            System.out.println("easy");
        }
        else if(Difficulty == 2){
            diffMult = 0.50;
            System.out.println("normal");
        }
        else if(Difficulty == 3){
            diffMult = 0.70;
            System.out.println("hard");
        }
        else if(Difficulty == 4){
            diffMult = 0.85;
            System.out.println("fucked");
        }
        else {
            System.out.println("Error: Value " + Difficulty + "Does not correspond to a valid difficulty level. Setting difficulty to Normal.");
            setDiffMult(2);
        }

    }

    static double getDiffMult(){
        return(diffMult);
    }
    
}
