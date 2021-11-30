package com.wizard;

import java.util.HashMap;

public class SpellUsage {
    private HashMap<String, Spell> spellMap = new HashMap<>(new SpellStorage().getSpellMap());

    public int castSpell(String spell) {
        if (spell == null || spell.isEmpty()) {
            System.out.println("No spell was casted.");
            return 0;
        }
        Spell castedSpell = spellMap.get(spell);
        if (castedSpell == null) {
            System.out.println("Spell casting failed, spell \"" + spell + "\" does not exist.");
            return 0;
        }
        if (castedSpell.getSpellType().equalsIgnoreCase("damage")) {
            return castDamage(castedSpell);
        }
        if (castedSpell.getSpellType().equalsIgnoreCase("healing")) {
            return castHealing(castedSpell);
        }
        System.out.println("Spell casting failed, unknown spell type.");
        return 0;
    }

    private int castHealing(Spell spell) {
        int successRate = spell.getSuccessRate();
        int totalHealing = 0;
        boolean firstTime = true;
        while (totalHealing < 100) {
            if ((int) (Math.random() * 100) + 1 <= successRate) {
                if (firstTime) {
                    System.out.print(spell.getSpellWord() + " has been casted. Health added: ");
                    firstTime = false;
                }
                totalHealing += getRandomNumberInRange(spell.getMinSpellPower(), spell.getMaxSpellPower());
                successRate -= getRandomNumberInRange(5, 10);
            } else {
                if (firstTime) {
                    System.out.println(spell.getSpellWord() + " failed to cast.");
                } else {
                    System.out.println(totalHealing);
                }
                return totalHealing;
            }
        }
        return totalHealing;
    }

    private int castDamage(Spell spell) {
        if ((int) (Math.random() * 100) + 1 <= spell.getSuccessRate()) {
            int damage = getRandomNumberInRange(spell.getMinSpellPower(), spell.getMaxSpellPower());
            System.out.println(spell.getSpellWord() + " has been casted. Damage done: " + damage);
            return (-1) * damage;
        } else {
            System.out.println(spell.getSpellWord() + " failed to cast.");
            return 0;
        }
    }

    private int getRandomNumberInRange(int min, int max) {
        if (min > max) {
            System.out.println("Max must be greater than or equal to min!");
            return 0;
        }
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
