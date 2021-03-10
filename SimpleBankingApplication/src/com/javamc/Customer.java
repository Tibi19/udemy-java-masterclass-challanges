package com.javamc;

import java.util.ArrayList;

public class Customer {

    private ArrayList<Double> transactions;
    private String name;

    public Customer(String name, double initialTransaction) {
        transactions = new ArrayList<Double>();
        this.name = name;

        if(!makeTransaction(initialTransaction)) {
            System.out.println("Initial transaction failed.");
        }
    }

    public boolean isValidCustomer() {
        return !transactions.isEmpty();
    }

    public boolean makeTransaction(double transaction) {
        if(transaction <= 0.0) {
            System.out.println("Negative transaction not allowed.");
            return false;
        }

        System.out.println("Transaction of value " + transaction + " made for customer " + name);
        transactions.add(transaction);
        return true;
    }

    public Double[] getTransactions() {
        return transactions.toArray(new Double[transactions.size()]);
    }

    public String getName() {
        return name;
    }
}
