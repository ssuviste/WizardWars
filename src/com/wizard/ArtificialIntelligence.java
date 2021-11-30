package com.wizard;

public class ArtificialIntelligence {
    /**
     * If health below 35, 50% chance of casting Vulnera Sanentur. If fails, then:
     * If players health is <11, Lacarnum Inflamarae
     * Else if playerHealth <17, Lumos Solem
     * Else if playerHealth <23, Everte Statum
     * Else if playerHealth <30, Arania Exumai
     * Else if playerHealth <37, Bombarda
     * Else if playerHealth <75, Avada Kedavra
     * <p>
     * If health of computer's health is bigger than the player's:
     * 20% Lumos Solem
     * 20% Arania Exumai
     * 20% Everte Statum
     * 20% Lacarnum Inflamarae
     * 20% Bombarda
     * <p>
     * Otherwise:
     * 15% Lumos Solem
     * 10% Arania Exumai
     * 15% Everte Statum
     * 20% Lacarnum Inflamarae
     * 20% Bombarda
     * 20% Vulnera Sanentur
     */
    public int castDecision(Wizard player, Wizard computer) {
        SpellUsage spellUsage = new SpellUsage();
        int randomNumber = (int) (Math.random() * 100) + 1;
        if (computer.getHealth() < 35) {
            if (randomNumber <= 50) {
                return spellUsage.castSpell("Vulnera Sanentur");
            } else {
                if (player.getHealth() < 11) {
                    return spellUsage.castSpell("Lacarnum Inflamarae");
                } else if (player.getHealth() < 17) {
                    return spellUsage.castSpell("Lumos Solem");
                } else if (player.getHealth() < 23) {
                    return spellUsage.castSpell("Everte Statum");
                } else if (player.getHealth() < 30) {
                    return spellUsage.castSpell("Arania Exumai");
                } else if (player.getHealth() < 37) {
                    return spellUsage.castSpell("Bombarda");
                } else {
                    return spellUsage.castSpell("Avada Kedavra");
                }
            }
        } else if (computer.getHealth() > player.getHealth()) {
            if (randomNumber <= 20) {
                return spellUsage.castSpell("Lumos Solem");
            } else if (randomNumber <= 40) {
                return spellUsage.castSpell("Arania Exumai");
            } else if (randomNumber <= 60) {
                return spellUsage.castSpell("Everte Statum");
            } else if (randomNumber <= 80) {
                return spellUsage.castSpell("Lacarnum Inflamarae");
            } else {
                return spellUsage.castSpell("Bombarda");
            }
        } else {
            if (randomNumber <= 15) {
                return spellUsage.castSpell("Lumos Solem");
            } else if (randomNumber <= 25) {
                return spellUsage.castSpell("Arania Exumai");
            } else if (randomNumber <= 40) {
                return spellUsage.castSpell("Everte Statum");
            } else if (randomNumber <= 60) {
                return spellUsage.castSpell("Lacarnum Inflamarae");
            } else if (randomNumber <= 80) {
                return spellUsage.castSpell("Bombarda");
            } else {
                return spellUsage.castSpell("Vulnera Sanentur");
            }
        }
    }
}
