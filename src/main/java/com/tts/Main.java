package com.tts;

import com.tts.contact.ContactBook;
import com.tts.contact.ContactEntry;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final ContactBook MY_CONTACT_BOOK = ContactBook.createEmptyContacts();
    private static final Scanner redQueenPusheen = new Scanner(System.in);
    private static boolean keepOnRolling = true;

    public static void main(String[] args) {

        System.out.println("Welcome to Pusheen's Address Book!");

        do {
            System.out.println("1) Pusheen wants to Add a new friend... ");
            System.out.println("2) Pusheen wants to Remove a friend because they aren't friends anymore...");
            System.out.println("3) Pusheen wants to Search for a specific friend...");
            System.out.println("4) Print Pusheen's contact book...");
            System.out.println("5) Empty Pusheen's contact book...");
            System.out.println("6) Quit Pusheen's contact book...\n");
            System.out.println("Pusheen wants you to pick a number, any number:");
            String feedback = redQueenPusheen.nextLine();

            switch (feedback) {
                case "1" -> addContact();
                case "2" -> removeContact();
                case "3" -> searchContacts();
                case "4" -> printPusheensAddressBook();
                case "5" -> emptyPusheensAddressBook();
                case "6" -> quitPusheensAddressBook();
                default -> {
                    System.out.println("There is no cake. The cake is a lie. Please choose again wisely.");
                    TheEnterKey();
                }
            }
        } while (keepOnRolling);
    }

    private static void addContact() {
        System.out.println("Hooray! Pusheen wants to add you to it's contact list!");
        System.out.println("Pusheen wants you to type in your FIRST NAME: ");
        String entryFirstName = redQueenPusheen.nextLine();
        System.out.println("Pusheen wants you to type in your LAST NAME: ");
        String entryLastName = redQueenPusheen.nextLine();
        System.out.println("Pusheen wants you to type in your PHONE NUMBER(Don't forget the dashes!): ");
        String entryPhone = redQueenPusheen.nextLine();
        System.out.println("Pusheen wants you to type in your EMAIL ADDRESS (It must be UNIQUE!): ");
        String entryEmail = redQueenPusheen.nextLine();

        ContactEntry newContactEntry = ContactEntry.createEntry(entryFirstName, entryLastName, entryPhone, entryEmail);

        try {
            MY_CONTACT_BOOK.addContact(newContactEntry);
            System.out.println("Pusheen has added the following contact:");
            System.out.println(newContactEntry.toString());

        } catch (InputMismatchException e) {
            System.out.println("Pusheen went to get more donuts and play games so the Contact has not been added: " + e.getMessage());
        }
        TheEnterKey();
    }

    private static void removeContact() {
        System.out.println("Boom! Pusheen says to enter the email address of the contact you would like to obliterate:");
        String removeChoice = redQueenPusheen.nextLine();
        try {
            MY_CONTACT_BOOK.removeEntry(removeChoice);
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
        TheEnterKey();
    }

    private static void searchContacts() {
        System.out.println("Pusheen is searching hard for those donut Contacts!");
        ArrayList<ContactEntry> searchResults = new ArrayList<>();
        boolean searchChoice;
        do {
            searchChoice = true;
            System.out.println("""
                    1) Search all fields
                    2) First Name
                    3) Last Name
                    4) Phone Number
                    5) Email Address
                    6) Cancel
                    """);
            System.out.println("Enter the number of the option you would like to search by:");
            String response = redQueenPusheen.nextLine();

            switch (response) {
                case "1" -> {
                    System.out.println("Enter a word or a letter to search all the beautiful fields:");
                    response = redQueenPusheen.nextLine();
                    searchResults = MY_CONTACT_BOOK.searchEntries(response);
                }
                case "2" -> {
                    System.out.println("Pusheen said to enter a FIRST NAME to start the search with:");
                    response = redQueenPusheen.nextLine();
                    searchResults = MY_CONTACT_BOOK.searchEntries(response, ContactBook.SearchType.FIRSTNAME);
                }
                case "3" -> {
                    System.out.println("Pusheen said to enter a LAST NAME to start the search with:");
                    response = redQueenPusheen.nextLine();
                    searchResults = MY_CONTACT_BOOK.searchEntries(response, ContactBook.SearchType.LASTNAME);
                }
                case "4" -> {
                    System.out.println("Pusheen said to enter a PHONE NUMBER to start the search with:");
                    response = redQueenPusheen.nextLine();
                    searchResults = MY_CONTACT_BOOK.searchEntries(response, ContactBook.SearchType.PHONE);
                }
                case "5" -> {
                    System.out.println("Pusheen wants you to enter an EMAIL ADDRESS to start the search with:");
                    response = redQueenPusheen.nextLine();
                    searchResults = MY_CONTACT_BOOK.searchEntries(response, ContactBook.SearchType.EMAIL);
                }
                case "6" -> System.out.println("Pusheen CANCELLED the search party! No donuts here!");
                default -> {
                    System.out.println("Pusheen says he doesn't recognize your input so you're going to have to try again!");
                    searchChoice = false;
                }
            }
        } while (!searchChoice);

        if (searchResults.isEmpty()) {
            System.out.println("Pusheen sees no matching entries in this contact book!");
        } else {
            System.out.println("Pusheen shows the resulting contents of this contact book:");
            for (ContactEntry contactEntry : searchResults) {
                System.out.println(contactEntry.toString());
            }
        }
        TheEnterKey();
    }

    private static void printPusheensAddressBook() {
        System.out.println("Pusheen is printing out the contact book!");
        MY_CONTACT_BOOK.printAddressBook();
        TheEnterKey();
    }

    private static void emptyPusheensAddressBook() {
        System.out.println("Pusheen said to not press this button.\nPusheen doesn't recommend doing this at all.");
        System.out.println("You made Pusheen mad by pressing the button. So it blew the contact book up!");
        MY_CONTACT_BOOK.deleteAddressBook();
        System.out.println("What have you done! Now Pusheen is sad because it can't find it's friend's contact info.");
        TheEnterKey();
    }

    private static void quitPusheensAddressBook() {
        System.out.println("Pusheen wants a donut! Time to quit and go find one.");
        keepOnRolling = false;
    }

    private static void TheEnterKey() {
        System.out.println("Pusheen wants you to press the enter key here:");
        redQueenPusheen.nextLine();
    }


}