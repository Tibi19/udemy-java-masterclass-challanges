package com.javamc;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Branch> branches;
    private String name;

    public Bank(String name) {
        branches = new ArrayList<Branch>();
        this.name = name;
    }

    public boolean printCustomers(Branch branch, boolean showTransactions) {
        if(!existsBranch(branch)) {
            System.out.println("Branch does not exist.");
            return false;
        }

        return printCustomers(branch.getId(), showTransactions);
    }

    public boolean printCustomers(int branchId, boolean showTransactions) {
        Branch branch = queryBranch(branchId);
        if(branch == null) {
            System.out.println("Branch " + branchId + " does not exist.");
            return false;
        }

        Customer[] customers = branch.getCustomers();
        System.out.println("Customers in branch " + branchId + ":");
        for(int i = 0; i < customers.length; i++) {
            Customer customer = customers[i];
            System.out.println("\t" + customer.getName());
            if(showTransactions) {
                printTransactions(customer);
            }
        }

        return true;
    }

    public void printTransactions(Customer customer){
        Double[] transactions = customer.getTransactions();
        for(int i = 0; i < transactions.length; i++) {
            System.out.println("\t\t" + (i + 1) + ". " + transactions[i]);
        }
    }

    public void addNewBranch() {
        Branch branch = new Branch();
        System.out.println("Added branch with id " + branch.getId() + " to Bank " + this.name);
        branches.add(branch);
    }

    public boolean addCustomerToBranch(Customer customer, Branch branch) {
        if (!existsBranch(branch)) {
            System.out.println("Branch does not exist.");
            return false;
        }

        return addCustomerToBranch(customer, branch.getId());
    }

    public boolean addCustomerToBranch(Customer customer, int branchId) {
        Branch branch = queryBranch(branchId);
        if(branch == null) {
            System.out.println("Branch with id " + branchId + " not found.");
            return false;
        }

        return branch.addCustomer(customer);
    }

    public boolean makeTransaction(double transaction, Branch branch, Customer customer) {
        return makeTransaction(transaction, branch, customer.getName());
    }

    public boolean makeTransaction(double transaction, Branch branch, String customerName) {
        if(!existsBranch(branch)) {
            System.out.println("Branch does not exist.");
            return false;
        }

        return branch.makeTransaction(customerName, transaction);
    }

    private boolean existsBranch(Branch branch) {
        return queryBranch(branch.getId()) != null;
    }

    public Branch queryBranch(int branchId) {
        for(int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            if(branch.getId() == branchId) {
                return branch;
            }
        }

        return null;
    }

    public Branch[] getBranches() {
        return branches.toArray(new Branch[branches.size()]);
    }

    public void printBankInfo() {
        System.out.print("Bank " + name + " with " + branches.size() + " branches: ");
        for(int i = 0; i < branches.size(); i++) {
            System.out.print(branches.get(i).getId() + " ");
        }
        System.out.println();
    }
}
