package com.wizard;

import java.util.HashMap;

public class SpellStorage {
    private HashMap<String, Spell> spellMap = new HashMap<>();
    public SpellStorage() {
        spellMap.put("Lacarnum Inflamarae", new Spell("Lacarnum Inflamarae", "damage",25,10,25,70));
        spellMap.put("Lumos Solem", new Spell("Lumos Solem", "damage",45,17,35,60));
        spellMap.put("Everte Statum", new Spell("Everte Statum", "damage",45,23,29,65));
        spellMap.put("Arania Exumai", new Spell("Arania Exumai", "damage",50,30,45,50));
        spellMap.put("Bombarda", new Spell("Bombarda", "damage",60,37,45,65));
        spellMap.put("Avada Kedavra", new Spell("Avada Kedavra", "damage",100,100,100,10));
        spellMap.put("Vulnera Sanentur", new Spell("Vulnera Sanentur", "healing",25,10,20,70));
    }

    public HashMap<String, Spell> getSpellMap() {
        return spellMap;
    }
}
