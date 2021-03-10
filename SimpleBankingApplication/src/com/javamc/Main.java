package com.javamc;

// AUTOBOXING AND UNBOXING CHALLENGE
// CONTINUE WITH MAKE TRANSACTION IN BANK
// LIST OF CUSTOMERS FOR A BRANCH
// WITH OPTIONAL LIST OF TRANSACTIONS

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("Chimichaching Bank");

    public static void main(String[] args) {
        app();
    }

    private static void app() {
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
                    printBankInfo();
                    break;
                case 3:
                    addNewBranch();
                    break;
                case 4:
                    printListOfCustomers();
                    break;
                case 5:
                    addCustomerToBranch();
                    break;
                case 6:
                    makeTransaction();
                    break;
                case 0:
                    quit = true;
                    break;
            }
        }
    }

    public static int printOptions() {
        System.out.println("\n Press ");
        System.out.println("\t1. Print Options");
        System.out.println("\t2. Print Bank Info");
        System.out.println("\t3. Add new Branch");
        System.out.println("\t4. List of Customers");
        System.out.println("\t5. Add Customer to Bank Branch");
        System.out.println("\t6. Make Transaction");
        System.out.println("\t0. Quit");

        return -6;
    }

    public static void addNewBranch() {
        bank.addNewBranch();
    }

    public static void printBankInfo() {
        bank.printBankInfo();
    }

    public static int inputBranchId() {
        return inputChoice(bank.getBranches().length);
    }

    public static void printListOfCustomers() {
        boolean quit = false;
        while(!quit) {
            System.out.println("Branch id:");
            int branchId = inputBranchId();

            System.out.println("Do you want to see transactions for each customer?");
            int yesNoOptions = printYesNo();
            int choice = inputChoice(yesNoOptions);
            boolean showTransactions = choice == 1;

            quit = bank.printCustomers(branchId, showTransactions);
        }
    }

    public static void addCustomerToBranch() {
        boolean quit = false;
        while(!quit) {
            System.out.println("Name:");
            String name = scanner.nextLine();

            System.out.println("Initial transaction of value:");
            double value = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Add customer to Branch with id:");
            int branchId = inputBranchId();

            quit = bank.addCustomerToBranch(new Customer(name, value), branchId);
        }
    }

    public static void makeTransaction() {
        boolean quit = false;
        while(!quit) {
            System.out.println("Customer name:");
            String name = scanner.nextLine();

            System.out.println("Make transaction in Branch with id:");
            int branchId = inputBranchId();

            System.out.println("Make transaction of value:");
            double value = scanner.nextDouble();
            scanner.nextLine();

            Branch branch = bank.queryBranch(branchId);
            quit = bank.makeTransaction(value, branch, name);
        }
    }

    public static int printYesNo() {
        System.out.println("1. Yes");
        System.out.println("2. No");

        return 2;
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
