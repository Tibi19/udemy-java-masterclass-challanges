package com.javamc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {

    private List<String> inventory;
    private String name;

    private static final String PLAYER_PATH = "player.dat";

    public Player() {
        this.inventory = new ArrayList<String>();
    }

    public Player(String name) {
        this();
        this.name = name;
    }

    public void addLoot(List<String> loot) {
        addLoot(loot.toArray(new String[0]));
    }

    public void addLoot(String[] loot) {
        for(String item : loot) {
            this.inventory.add(item);
        }
    }

    @Override
    public void save() throws IOException {
        FileWriter writer = null;
        writer = new FileWriter(PLAYER_PATH);

        //writer.write(Integer.toString(name.length()));
        writer.write(name.length());
        writer.write(name + ",");

        for(String item : inventory) {
            //writer.write(Integer.toString(item.length()));
            writer.write(item.length());
            writer.write(item + ",");
        }
        writer.close();

        System.out.println("Player " + name + " saved");
    }

    @Override
    public void load() throws IOException {
        FileReader reader = null;

        try {
            reader = new FileReader(PLAYER_PATH);
        } catch (FileNotFoundException fe) {
            System.out.println("File not found");
            return;
        }

        int character;
        char[] charsToLoad = null;
        boolean nameLoaded = false;
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

                // load type first if not loaded, then set it to true (@nameLoaded)
                // reset @charsToLoad, then continue to next iteration;
                if(!nameLoaded) {
                    name = stringToLoad;
                    nameLoaded = true;
                    charsToLoad = null;
                    continue;
                }

                // add the current string to the list of items (@loot), then reset @charsToLoad.
                inventory.add(stringToLoad);
                charsToLoad = null;
            }
        }

        if(reader != null) {
            reader.close();
        }

        System.out.println("Player " + name + " loaded");
    }

    @Override
    public String toString() {
        System.out.println("Player " + name + ":");
        for(String item : inventory) {
            System.out.println("\t" + (inventory.indexOf(item) + 1) + ". " + item);
        }
        System.out.println();

        return super.toString();
    }
}
