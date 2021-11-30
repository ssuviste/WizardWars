package com.wizard;

import java.util.Scanner;

public class Arena {
    public void battleBetweenComputerAnd(Wizard player) {
        Wizard computer = new Wizard();
        ArtificialIntelligence artificialIntelligence = new ArtificialIntelligence();
        System.out.println("Let the duel begin!");
        while (player.getHealth() > 0 && computer.getHealth() > 0) {
            System.out.println("Player health: " + player.getHealth());
            System.out.println("Opponent health: " + computer.getHealth());
            System.out.print("Your turn, cast your spell: ");
            int playerValue = tryToCastSpellFrom(player);
            System.out.println();
            System.out.println("Opponent's turn:");
            int computerValue = artificialIntelligence.castDecision(player, computer);

            if (playerValue > 0) {
                if (player.getHealth() + playerValue > 100) {
                    player.setHealth(100);
                } else {
                    player.setHealth(player.getHealth() + playerValue);
                }
            }
            if (computerValue > 0) {
                if (computer.getHealth() + computerValue > 100) {
                    computer.setHealth(100);
                } else {
                    computer.setHealth(computer.getHealth() + computerValue);
                }
            }
            if (playerValue < 0) {
                computer.setHealth(computer.getHealth() + playerValue);
            }
            if (computerValue < 0) {
                player.setHealth(player.getHealth() + computerValue);
            }
        }
        System.out.println("The duel is over.");
        if (computer.getHealth() <= 0 && player.getHealth() <= 0) {
            System.out.println("It's a draw!");
        } else if (computer.getHealth() <= 0) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost!");
        }
    }

    public void battleBetweenPlayers(Wizard player1, Wizard player2) {
        System.out.println("Let the duel begin!");
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            System.out.println(player1.getName() + "'s health: " + player1.getHealth());
            System.out.println(player2.getName() + "'s health: " + player2.getHealth());
            System.out.print(player1.getName() + ", cast your spell: ");
            int player1Value = tryToCastSpellFrom(player1);
            System.out.println();
            System.out.print(player2.getName() + ", cast your spell: ");
            int player2Value = tryToCastSpellFrom(player2);

            if (player1Value > 0) {
                if (player1.getHealth() + player1Value > 100) {
                    player1.setHealth(100);
                } else {
                    player1.setHealth(player1.getHealth() + player1Value);
                }
            }
            if (player2Value > 0) {
                if (player2.getHealth() + player2Value > 100) {
                    player2.setHealth(100);
                } else {
                    player2.setHealth(player2.getHealth() + player2Value);
                }
            }
            if (player1Value < 0) {
                player2.setHealth(player2.getHealth() + player1Value);
            }
            if (player2Value < 0) {
                player1.setHealth(player1.getHealth() + player2Value);
            }
        }
        System.out.println("The duel is over.");
        if (player2.getHealth() <= 0 && player1.getHealth() <= 0) {
            System.out.println("It's a draw!");
        } else if (player2.getHealth() <= 0) {
            System.out.println(player1.getName() + " won!");
        } else {
            System.out.println(player2.getName() + " won!");
        }
    }

    private int tryToCastSpellFrom(Wizard wizard) {
        SpellStorage spellStorage = new SpellStorage();
        SpellUsage spellUsage = new SpellUsage();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (wizard.getSpellsWizardKnows().containsKey(input)
                && wizard.getSpellsWizardKnows().get(input) != null
        && wizard.getSpellsWizardKnows().get(input).getSpellWord()
                .equals(spellStorage.getSpellMap().get(input).getSpellWord())) {
            return spellUsage.castSpell(input);
        } else if (spellStorage.getSpellMap().containsKey(input)) {
            System.out.println("You do not know this spell!");
        } else if (input.isEmpty()) {
            System.out.println("You decided to cast no spell.");
        } else {
            System.out.println("This spell does not exist!");
        }
        return 0;
    }
}
