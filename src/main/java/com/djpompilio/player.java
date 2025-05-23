package com.djpompilio;

public class player {
    //health, level, luck, speed, strength, charisma, gold coins

    //Basic player stats
    String name = new String("Unknown");
    int hp = 100;
    int lvl = 0;
    int xp = 0; //max of 100
    int gc = 0;

    double diffMult = 0.5; //ratio of events triggered. 0.5 - Normal Difficulty: 50/50 split between triggering an event and being safe(either nothing happens, story progresses or loot or some other bonus)

    //Attributes
    int strength = 0;
    int speed = 0;
    int charisma = 0;
    int luck = 0;

    int getHealth(){
        return hp;
    }
    void setHealth(int x){
        hp = x;
    }
    void addHealth(int x){
        hp += x;
    }
    
    int getLevel(){
        return lvl;
    }
    boolean addXp(int x){
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
    int getCoins(){
        return gc;
    }
    void removeCoins(int x){
        gc -= x;
    }
    void addCoins(int x){
        gc += x;
    }

    int getStrength(){
        return strength;
    }
    int getSpeed(){
        return speed;
    }
    int getCharisma(){
        return charisma;
    }
    int getLuck(){
        return luck;
    }

    void addStrength(int x){
        strength += x;
    }
    void addSpeed(int x){
        speed += x;
    }
    void addCharisma(int x){
        charisma += x;
    }
    void addLuck(int x){
        luck += x;
    }

    void setDiffMult(int x){

    }
    
}
