package com.javamc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{

    enum MonsterType {
        ZOMBIE, DEMON, VAMPIRE, WEREWOLF, GHOST
    }

    private static int monsters_nr = 0;
    private static int highest_id = -1;
    private static final String MONSTERS_NR_PATH = "monstersnr.dat";
    private static final String EXTENSION_PATH = ".dat";

    private MonsterType monsterType;
    private List<String> loot;
    private int id;

    public Monster() {
        id = ++highest_id;
        monsters_nr++;

        loot = new ArrayList<String>();
        monsterType = null;
    }

    public Monster(MonsterType monsterType) {
        this();
        this.monsterType = monsterType;
    }

    public Monster(MonsterType monsterType, ArrayList<String> loot) {
        this(monsterType);
        addLoot(loot);
    }

    public void addLoot(List<String> loot) {
        addLoot(loot.toArray(new String[0]));
    }

    public void addLoot(String[] loot) {
        for(String item : loot) {
            this.loot.add(item);
        }
    }

    public static void saveMonstersNr() throws IOException {
        FileWriter writer = null;
        writer = new FileWriter(MONSTERS_NR_PATH);

        writer.write(monsters_nr);
        writer.close();

        System.out.println("Number of monsters " + "[" + monsters_nr + "] saved");
    }

    @Override
    public void save() throws IOException {
        FileWriter writer = null;
        writer = new FileWriter("monster" + id + EXTENSION_PATH);

        String typeString  = monsterType.toString();
        writer.write(typeString.length());
        writer.write(typeString + ",");

        for(String item : loot) {
            writer.write(item.length());
            writer.write(item + ",");
        }
        writer.close();

        System.out.println(monsterType + "[" + id + "] saved");
    }

    public static int loadMonstersNr() throws IOException {
        FileReader reader = null;

        try {
            reader = new FileReader(MONSTERS_NR_PATH);
        } catch (FileNotFoundException fe) {
            System.out.println("File not found");
            return -1;
        }

        int character = reader.read();

        if(character == -1) {
            System.out.println(MONSTERS_NR_PATH + " is empty");
            return -1;
        }

        System.out.println("Number of monsters " + "[" + monsters_nr + "] loaded");
        return character;
    }

    @Override
    public void load() throws IOException{
        FileReader reader = null;

        try {
            reader = new FileReader("monster" + id + EXTENSION_PATH);
        } catch (FileNotFoundException fe) {
            System.out.println("File not found");
            return;
        }

        int character;
        char[] charsToLoad = null;
        boolean typeLoaded = false;
        while(true) {
            // if we have a @charsToLoad that we can load to, read while populating it.
            // otherwise, only read to @character.
            // if int, might read the entire value, or just the first character, here I assume it read the entire value;
            if(charsToLoad != null) {
                character = reader.read(charsToLoad);
            } else {
                character = reader.read();
            }

            // if character is -1, we reached the end of the file;
            if(character == -1) {
                break;
            }

            // try to create array that will be saved with the current character as length + 1 to check for comma.
            if(charsToLoad == null) {
                charsToLoad = new char[character + 1];
            }

            // if reaching a comma, we have a string to load.
            if(charsToLoad[charsToLoad.length - 1] == ',') {
                // prepare the string to load by omitting the comma at the end.
                String stringToLoad = "";
                for(int i = 0; i < charsToLoad.length - 1; i++) {
                    stringToLoad += charsToLoad[i];
                }

                // load type first if not loaded, then set it to true (@typeLoaded)
                // reset @charsToLoad, then continue to next iteration;
                if(!typeLoaded) {
                    setType(stringToLoad);
                    typeLoaded = true;
                    charsToLoad = null;
                    continue;
                }

                // add the current string to the list of items (@loot), then reset @charsToLoad.
                loot.add(stringToLoad);
                charsToLoad = null;
            }
        }

        if(reader != null) {
            reader.close();
        }

        System.out.println(monsterType + "[" + id + "] loaded");
    }

    private void setType(String typeString) {
        MonsterType[] types = MonsterType.values();
        for(MonsterType type : types) {
            if(type.toString().equals(typeString)) {
                monsterType = type;
                break;
            }
        }
    }

    public List<String> getLoot() {
        return loot;
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }

    public int getId() {
        return id;
    }

//    public void die() {
//        loot = null;
//        monsters_nr--;
//    }

    @Override
    public String toString() {
        System.out.println(monsterType + "[" + id + "] drops:");
        for(String item : loot) {
            System.out.println("\t" + (loot.indexOf(item) + 1) + ". " + item);
        }
        System.out.println();

        return super.toString();
    }

    public static int getMonsters_nr() {
        return monsters_nr;
    }
}

