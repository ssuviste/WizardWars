package com.wizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class WizardShop {
    private HashMap<String, Spell> spellMap = new HashMap<>(new SpellStorage().getSpellMap());

    public void goShopping(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        printShop();
        System.out.print("Enter the spell you want to buy or \"done\" to exit shop (you have $" + wizard.getMoney() + "): ");
        String spellInput = scanner.nextLine();
        while (!spellInput.equalsIgnoreCase("done")) {
            validateSpellAndBuy(spellInput, wizard);
            System.out.print("Enter the spell you want to buy or \"done\" to exit shop (you have $" + wizard.getMoney() + "): ");
            spellInput = scanner.nextLine();
        }
        System.out.println("Exiting shop...");
    }

    private void printShop() {
        List<String> keys = new ArrayList<>(spellMap.keySet());
        System.out.println("WIZARD SPELL SHOP (available spells):");
        for (String key : keys) {
            System.out.println(key + ": $" + spellMap.get(key).getPrice());
        }
    }

    private void validateSpellAndBuy(String spell, Wizard wizard) {
        if (!spellMap.containsKey(spell)) {
            System.out.println("This spell is not in the shop!");
        } else if (wizard.getSpellsWizardKnows().containsKey(spell)) {
            System.out.println("You already have that spell!");
        } else if (wizard.getMoney() < spellMap.get(spell).getPrice()) {
            System.out.println("You dont have enough money for that spell!");
        } else {
            wizard.getSpellsWizardKnows().put(spell, spellMap.get(spell));
            wizard.setMoney(wizard.getMoney() - spellMap.get(spell).getPrice());
            System.out.println("You bought " + spell + " for $" + spellMap.get(spell).getPrice() + ".");
        }
    }
}
