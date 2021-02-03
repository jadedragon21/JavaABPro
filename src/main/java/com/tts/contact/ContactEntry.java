package com.tts.contact;

public class ContactEntry {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;


    private ContactEntry(String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public static ContactEntry createBlankEntry() {
        return new ContactEntry("", "", "", "");
    }

    public static ContactEntry createEntry(String firstName, String lastName, String phoneNumber, String emailAddress) {
        return new ContactEntry(firstName, lastName, phoneNumber, emailAddress);
    }

    @Override
    public String toString() {
        return """
                    |-------------------------------------------------------------|
                    |                         **Entry**                           |
                    |-------------------------------------------------------------|
                    | first name: %s
                    | last name: %s
                    | phone number: %s
                    | email address: %s
                    """.formatted(firstName, lastName, phoneNumber, emailAddress);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


}