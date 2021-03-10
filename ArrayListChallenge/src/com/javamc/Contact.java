package com.javamc;

public class Contact {

    public enum ContactField {

        NAME, PHONE_NUMBER;

        public String getName(){
            return this.toString().toLowerCase().replace('_', ' ');
        }

        // Returns a ContactField by @index;
        // @index 0 - returns NAME;
        // @index 1 - return PHONE_NUMBER;
        // returns null in case of another @index;
        public static ContactField getField(int index) {
            ContactField[] fields = ContactField.values();
            if(index > fields.length || index < 0) { return null; }

            return fields[index];
        }
    }

    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void update(ContactField fieldToUpdate, String newValue) {
        if (fieldToUpdate == ContactField.NAME) {
            System.out.println("Contact name updated from " + this.name + " to " + newValue);
            this.name = newValue;
        } else if (fieldToUpdate == ContactField.PHONE_NUMBER) {
            System.out.println("Contact number updated from " + this.phoneNumber + " to " + newValue);
            this.phoneNumber = newValue;
        }
    }

    public static Contact createContct(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }
}
