package com.javamc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// INTERFACE CHALLENGE
//
// TO DO:
//
// X setType class in Monster
// X create static save and load for monsters_nr
// X create player
// test stuff
//
// ! look at the challenge (downloads: lecture 72 challenge)

public class Main {

    private static List<ISaveable> gameObjects;

    public static void main(String[] args) {
        gameObjects = new ArrayList<ISaveable>();

        //playThrough();
        loadGame();

        printGame();
    }

    public static void printGame() {
        for(ISaveable gameObject : gameObjects) {
            gameObject.toString();
        }
    }

//    public static void playThrough2() {
//        Player player = (Player) gameObjects.get(0);
//        for(ISaveable gameObject : gameObjects) {
//            if(!(gameObject instanceof Monster)) {
//                continue;
//            }
//
//            Monster monster = (Monster) gameObject;
//            if(monster.getMonsterType() == Monster.MonsterType.VAMPIRE) {
//                player.addLoot(monster.getLoot());
//                gameObjects.remove(monster);
//                monster.die();
//                break;
//            }
//        }
//
//        Monster monster1 = new Monster(Monster.MonsterType.ZOMBIE);
//        String[] monster1Inventory = {"Axe", "Extra Hand"};
//        monster1.addLoot(monster1Inventory);
//
//        Monster monster2 = new Monster(Monster.MonsterType.ZOMBIE);
//        String[] monster2Inventory = {"Dirt", "Shovel", "Amethyst", "Rock", "Grandma's Wedding Ring"};
//        monster2.addLoot(monster2Inventory);
//
//        gameObjects.add(monster1);
//        gameObjects.add(monster2);
//
//        saveGame();
//    }

    public static void playThrough() {
        Player player = new Player("Agon19");
        String[] playerInventory = {"Hammer of Dragonfall", "Dwemer Armor",
                "Potion of Superior Healing", "Coin of Ra"};
        player.addLoot(playerInventory);

        Monster monster1 = new Monster(Monster.MonsterType.DEMON);
        String[] monster1Inventory = {"Boots", "Fiery Tooth"};
        monster1.addLoot(monster1Inventory);

        Monster monster2 = new Monster(Monster.MonsterType.WEREWOLF);
        String[] monster2Inventory = {"Moon Fur", "Silver repellent", "Bronze Coin", "Gold Coin", "Platinum Coin"};
        monster2.addLoot(monster2Inventory);

        Monster monster3 = new Monster(Monster.MonsterType.GHOST);
        String[] monster3Inventory = {"Ectoplasm"};
        monster3.addLoot(monster3Inventory);

        Monster monster4 = new Monster(Monster.MonsterType.VAMPIRE);
        String[] monster4Inventory = {"Cape of Nostradamus", "Vial of Blood", "Star of Astaroth"};
        monster4.addLoot(monster4Inventory);

        gameObjects.add(player);
        gameObjects.add(monster1);
        gameObjects.add(monster2);
        gameObjects.add(monster3);
        gameObjects.add(monster4);

        saveGame();
    }

    public static void saveGame(){
        try {
            Monster.saveMonstersNr();

            for(ISaveable gameObject : gameObjects) {
                gameObject.save();
            }
        } catch (IOException e) {
            System.out.println("Can't save Game");
        }

        System.out.println();
    }

    public static void loadGame(){
        try {
            int monstersNrToLoad = Monster.loadMonstersNr();

            gameObjects.add(new Player());
            for(int i = 0; i < monstersNrToLoad; i++) {
                gameObjects.add(new Monster());
            }

            for(ISaveable gameObject : gameObjects) {
                gameObject.load();
            }
        } catch (IOException e) {
            System.out.println("Can't load Game");
        }

        System.out.println();
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1. to enter a string\n" +
                "0. to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
}

