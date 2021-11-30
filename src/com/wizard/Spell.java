package com.wizard;

public class Spell {
    private String spellWord;
    private String spellType;
    private int price;
    private int minSpellPower;
    private int maxSpellPower;
    private int successRate;

    Spell(String spellWord, String spellType, int price, int minSpellPower, int maxSpellPower, int successRate) {
        this.spellWord = spellWord;
        this.spellType = spellType;
        this.price = price;
        this.minSpellPower = minSpellPower;
        this.maxSpellPower = maxSpellPower;
        this.successRate = successRate;
    }

    public String getSpellWord() {
        return spellWord;
    }

    public void setSpellWord(String spellWord) {
        this.spellWord = spellWord;
    }

    public String getSpellType() {
        return spellType;
    }

    public void setSpellType(String spellType) {
        this.spellType = spellType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMinSpellPower() {
        return minSpellPower;
    }

    public void setMinSpellPower(int minSpellPower) {
        this.minSpellPower = minSpellPower;
    }

    public int getMaxSpellPower() {
        return maxSpellPower;
    }

    public void setMaxSpellPower(int maxSpellPower) {
        this.maxSpellPower = maxSpellPower;
    }

    public int getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(int successRate) {
        this.successRate = successRate;
    }
}
