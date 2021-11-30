import com.wizard.*;

import java.util.ArrayList;

/**
 * Task 3:
 * Start character creation.
 * We want to get name and surname and then we will set it in wizard field surname and name.
 * But do not forget to validate first the name and surname then save it surname and name.
 */

public class WizardWars {
    public static void main(String[] args) {
        CharacterCreation characterCreation = new CharacterCreation();
        System.out.println("Welcome to Wizard Wars! Create your character.");
        Wizard player = new Wizard();
        characterCreation.requestNameFor(player);
        characterCreation.requestSurnameFor(player);
        System.out.println();

        System.out.println("Now buy the spells you desire, " + player.getName() + " " + player.getSurname() + "!");
        WizardShop wizardShop = new WizardShop();
        wizardShop.goShopping(player);
        System.out.println();

        System.out.println("Your list of spells: ");
        if(player.getSpellsWizardKnows().size() == 0) {
            System.out.println("EMPTY");
        } else {
            for (String s : new ArrayList<>(player.getSpellsWizardKnows().keySet())) {
                System.out.println(s);
            }
        }
        System.out.println();

        Arena arena = new Arena();
        arena.battleBetweenComputerAnd(player);
        /*SpellStorage spellStorage = new SpellStorage();
        Wizard player2 = new Wizard();
        player2.setName("Voldemort");
        player2.getSpellsWizardKnows().put("Lacarnum Inflamarae", spellStorage.getSpellMap().get("Lacarnum Inflamarae"));
        player2.getSpellsWizardKnows().put("Lumos Solem", spellStorage.getSpellMap().get("Lumos Solem"));
        player2.getSpellsWizardKnows().put("Everte Statum", spellStorage.getSpellMap().get("Everte Statum"));
        player2.getSpellsWizardKnows().put("Arania Exumai", spellStorage.getSpellMap().get("Arania Exumai"));
        player2.getSpellsWizardKnows().put("Bombarda", spellStorage.getSpellMap().get("Bombarda"));
        player2.getSpellsWizardKnows().put("Avada Kedavra", spellStorage.getSpellMap().get("Avada Kedavra"));
        player2.getSpellsWizardKnows().put("Vulnera Sanentur", spellStorage.getSpellMap().get("Vulnera Sanentur"));
        arena.battleBetweenPlayers(player, player2);*/
    }
}