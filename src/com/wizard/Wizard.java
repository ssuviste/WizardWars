package com.wizard;

import java.util.HashMap;

/**
 * Task 1:
 * Wizard class must have fields.
 * A wizard must have health, money, name, surname
 * Money and health is 100 from the beginning.
 * If another class will create instance of Wizard; wizard class must provide data about all these (hint:use getters and setters) when we request from other class.
 * <p>
 * Please check what is class and what is class field/variable
 * https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html
 * http://tutorials.jenkov.com/java/fields.html
 */

public class Wizard {
    private String name;
    private String surname;
    private int health = 100;
    private int money = 100;
    private HashMap<String, Spell> spellsWizardKnows = new HashMap<>();

    public Wizard() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public HashMap<String, Spell> getSpellsWizardKnows() {
        return spellsWizardKnows;
    }
}
