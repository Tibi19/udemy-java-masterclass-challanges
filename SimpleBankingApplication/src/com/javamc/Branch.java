package com.javamc;

import java.util.ArrayList;

public class Branch {

    private ArrayList<Customer> customers;
    private int id;
    private static int branches = 0;

    public Branch() {
        customers = new ArrayList<Customer>();
        id = ++branches;
    }

    private boolean existsCustomer(Customer customer) {
        return queryCustomer(customer.getName()) != null;
    }

    public boolean addCustomer(Customer customer) {
        if(!customer.isValidCustomer()) {
            System.out.println("Customer " + customer.getName() + " is not allowed with no transactions.");
            return false;
        }

        if(existsCustomer(customer)) {
            System.out.println("Customer " + customer.getName() + " already exists.");
            return false;
        }

        System.out.println("Customer " + customer.getName() + " added to branch " + id);
        customers.add(customer);
        return true;
    }

    public Customer queryCustomer(String name) {
        for(int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if(customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    public boolean makeTransaction(String customerName, double transaction) {
        Customer customer = queryCustomer(customerName);
        if(customer == null) {
            System.out.println("Customer " + customerName + " does not exist.");
            return false;
        }

        return customer.makeTransaction(transaction);
    }

    public boolean addCustomer(String name, Double initialTransaction) {
        return addCustomer(new Customer(name, initialTransaction));
    }

    public Customer[] getCustomers() {
        return customers.toArray(new Customer[customers.size()]);
    }

    public int getId() {
        return id;
    }
}
