package com.javamc;

import java.util.ArrayList;
import java.util.Scanner;

// TEST QUERY OPTION

public class Main {

    private static Scanner scanner = new Scanner (System.in);
    private static MobilePhone phone = new MobilePhone();

    public static void main(String[] args) {
        Integer intValue = 90;
        boolean quit = false;
        int choice = 0;
        int options = printOptions();
        while(!quit) {
            System.out.println("Enter your choice (1 to print options): ");
            choice = inputChoice(options);

            switch(choice) {
                case 1:
                    printOptions();
                    break;
                case 2:
                    printListOfContacts();
                    break;
                case 3:
                    addNewContact();
                    break;
                case 4:
                    updateExistingContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    removeContact();
                case 0:
                    quit = true;
                    break;
            }
        }
    }

    private static boolean checkForExitChoice(String input) {
        return input.matches("0");
    }

    private static boolean checkForExitChoice(int input) {
        return input == -1;
    }

    private static void printListOfContacts() {
        phone.printContacts();
    }

    private static void addNewContact() {
        boolean quit = false;
        while(!quit) {
            System.out.println("Add new contact:");
            System.out.println("Name:");
            String name = scanner.nextLine();
            if(checkForExitChoice(name)) { break; }

            System.out.println("Phone Number:");
            String phoneNr = scanner.nextLine();
            if(checkForExitChoice(phoneNr)) { break; }

            quit = phone.addNewContact(name, phoneNr);
        }
    }

    private static void updateExistingContact() {
        boolean quit = false;
        while(!quit) {
            System.out.println("Name of contact to update:");
            String name = scanner.nextLine();
            if(checkForExitChoice(name)) { break; }

            int indexOfFieldToUpdate = indexOfFieldSelection("update");
            if(checkForExitChoice(indexOfFieldToUpdate)) { break; }
            Contact.ContactField fieldToUpdate = Contact.ContactField.getField(indexOfFieldToUpdate);

            System.out.println("Update to: ");
            String valueToUpdateTo = scanner.nextLine();
            if(checkForExitChoice(valueToUpdateTo)) { break; }

            Contact contactToUpdate = phone.findContact(Contact.ContactField.NAME, name);
            quit = phone.updateExistingContact(contactToUpdate, fieldToUpdate, valueToUpdateTo);
        }
    }

    private static int indexOfFieldSelection(String action) {
        System.out.println("Select contact field to " + action + ": ");
        int contactFieldOptions = printContactFields();
        int contactFieldChoice = inputChoice(contactFieldOptions);

        return contactFieldChoice - 1;
    }

    private static void queryContact() {
        boolean quit = false;
        while(!quit) {
            int indexOfFieldToSearchBy = indexOfFieldSelection("query");
            if(checkForExitChoice(indexOfFieldToSearchBy)) { break; }
            Contact.ContactField fieldToSearchBy = Contact.ContactField.getField(indexOfFieldToSearchBy);

            System.out.println("Input " + fieldToSearchBy.getName() + " to search by:");
            String value = scanner.nextLine();
            if(checkForExitChoice(value)) { break; }

            quit = phone.queryContact(fieldToSearchBy, value);
        }
    }

    private static void removeContact() {
        boolean quit = false;
        while(!quit) {
            System.out.println("Name of contact to remove:");
            String name = scanner.nextLine();
            if(checkForExitChoice(name)) { break; }
            Contact contactToRemove = phone.findContact(Contact.ContactField.NAME, name);

            quit = phone.removeContact(contactToRemove);
        }
    }

    private static int printContactFields() {
        Contact.ContactField[] contactFields = Contact.ContactField.values();
        for(int i = 0; i < contactFields.length; i++) {
            System.out.println((i + 1) + ". " + contactFields[i].getName());
        }
        System.out.println("0. Quit");

        return -2;
    }

    private static int printOptions() {
        System.out.println("\nPress ");
        System.out.println("\t1. Print Options");
        System.out.println("\t2. Print List of Contacts");
        System.out.println("\t3. Add New Contact");
        System.out.println("\t4. Update Existing Contact");
        System.out.println("\t5. Query Contact");
        System.out.println("\t6. Remove Contact");
        System.out.println("\t0. Quit (Can be pressed at any point)");

        return -6;
    }

    // Returns the user's choice.
    // A negative @choices indicates the option to not choose anything.
    // If @choices is positive, input between 1 and @choices is expected;
    // If @choices is negative, an input between 0 and the absolute value of @choices is expected.
    private static int inputChoice(int choices) {
        boolean zeroChoice = choices < 0;
        String zeroChoiceString = zeroChoice ? " or 0" : "";
        choices = Math.abs(choices); // Only the absolute value is needed from here on.
        int choice;

        while (true) {

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= (zeroChoice ? 0 : 1) && choice <= choices) {
                    scanner.nextLine();
                    return choice;
                }
            }

            scanner.nextLine();
            System.out.println("Input your choice (1-" + choices + zeroChoiceString + ")");
        }
    }
}
