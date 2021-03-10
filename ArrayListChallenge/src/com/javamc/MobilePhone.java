package com.javamc;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact> contacts;

    public MobilePhone() {
        contacts = new ArrayList<Contact>();
    }

    public boolean queryContact(Contact.ContactField fieldToSearchBy, String searchValue) {
        Contact contact = findContact(fieldToSearchBy, searchValue);
        if (contact != null) {
            System.out.println("Found contact " + contact.getName() + " (" + contact.getPhoneNumber() + ")");
            return true;
        }

        System.out.println("Did not find contact with " + fieldToSearchBy.getName() + " " + searchValue);
        return false;
    }

    private boolean canFindContact(Contact contact) {
        return canFindContact(contact.getName(), contact.getPhoneNumber());
    }

    private boolean canFindContact(String name, String phoneNr) {
        boolean existsName = findContact(Contact.ContactField.NAME, name) != null;
        boolean existsPhoneNr = findContact(Contact.ContactField.PHONE_NUMBER, phoneNr) != null;
        return existsName || existsPhoneNr;
    }

    public Contact findContact(Contact.ContactField fieldToSearchBy, String searchValue) {
        if(fieldToSearchBy == Contact.ContactField.NAME) {
            return findContactByName(searchValue);
        }

        if(fieldToSearchBy == Contact.ContactField.PHONE_NUMBER) {
            return findContactByPhoneNumber(searchValue);
        }

        return null;
    }

    private Contact findContactByName(String name) {
        for(int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().matches(name)) {
                return contact;
            }
        }
        return null;
    }

    private Contact findContactByPhoneNumber(String phoneNr) {
        for(int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getPhoneNumber().matches(phoneNr)) {
                return contact;
            }
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contacts: ");
        for(int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + ": " + contact.getPhoneNumber());
        }
    }

    public boolean addNewContact(Contact contact) {
        if(canFindContact(contact)){
            System.out.println("Contact already exists.");
            return false;
        }

        System.out.println(contact.getName() + " (" + contact.getPhoneNumber() + ") added to contacts");
        contacts.add(contact);
        return true;
    }

    public boolean addNewContact(String name, String phoneNr) {
        return addNewContact(new Contact(name, phoneNr));
    }

    public boolean updateExistingContact(Contact targetContact, Contact.ContactField fieldToUpdate, String newValue) {
        if(!canFindContact(targetContact)) {
            System.out.println("Can't find contact to update");
            return false;
        }

        Contact contact = findContact(fieldToUpdate, newValue);
        if(contact != null) {
            System.out.println("Contact " + contact.getName() + " - " + contact.getPhoneNumber() + " already exists.");
            return false;
        }

        targetContact.update(fieldToUpdate, newValue);

        return false;
    }

    public boolean updateExistingContact(Contact.ContactField searchContactByField, String valueToSearchFor,
                                         Contact.ContactField fieldToUpdate, String newValue) {
        return updateExistingContact(findContact(searchContactByField, valueToSearchFor), fieldToUpdate, newValue);
    }

    public boolean removeContact(Contact contactToRemove) {
        if (canFindContact(contactToRemove)) {
            System.out.println(contactToRemove.getName() + " (" + contactToRemove.getPhoneNumber() +
                    ") removed from contacts");
            contacts.remove(contactToRemove);
            return true;
        }

        return false;
    }

    public boolean removeContact(Contact.ContactField searchContactByField, String valueToSearchFor) {
        return removeContact(findContact(searchContactByField, valueToSearchFor));
    }
}
