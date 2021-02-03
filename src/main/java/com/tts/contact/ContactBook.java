package com.tts.contact;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class ContactBook {

    private final ArrayList<ContactEntry> myContactList;

    public enum SearchType {
        FIRSTNAME,
        LASTNAME,
        PHONE,
        EMAIL
    }

    public static ContactBook createEmptyContacts() {
        return new ContactBook();
    }

    private ContactBook() {
        myContactList = new ArrayList<>();
    }

    public void addContact(ContactEntry newContact) throws InputMismatchException {
        ArrayList<ContactEntry> searchResults = searchEntries(newContact.getEmailAddress(), SearchType.EMAIL);
        if (searchResults.isEmpty()) {
            myContactList.add(newContact);
        } else {
            throw new InputMismatchException("Pusheen said this email address already exists in your contacts!");
        }
    }

    public void removeEntry(String email) throws NullPointerException {
        ContactEntry searchContactEntry;
        try {
            searchContactEntry = searchEntries(email, SearchType.EMAIL).get(0);
        } catch (NullPointerException e) {
            throw new NullPointerException("Pusheen has been hoodwinked! There is no contact entry with this email address.");
        }
        if (searchContactEntry != null) {
            myContactList.remove(searchContactEntry);
        }
    }

    public ArrayList<ContactEntry> searchEntries(String searchInquiry) {
        ArrayList<ContactEntry> searchContactList = new ArrayList<>();
        for (ContactEntry contactEntry : myContactList) {
            if ((contactEntry.getFirstName().contains(searchInquiry) ||
                    contactEntry.getLastName().contains(searchInquiry) ||
                    contactEntry.getPhoneNumber().contains(searchInquiry) ||
                    contactEntry.getEmailAddress().contains(searchInquiry)) &&
                    !(searchContactList.contains(contactEntry))) {
                searchContactList.add(contactEntry);
            }
        }
        return searchContactList;
    }

    public ArrayList<ContactEntry> searchEntries(String searchQuery, SearchType searchType) {
        ArrayList<ContactEntry> searchList = new ArrayList<>();
        for (ContactEntry contactEntry : myContactList) {
            String searchResult = "";
            switch (searchType) {
                case FIRSTNAME -> searchResult = contactEntry.getFirstName();
                case LASTNAME -> searchResult = contactEntry.getLastName();
                case PHONE -> searchResult = contactEntry.getPhoneNumber();
                case EMAIL -> searchResult = contactEntry.getEmailAddress();
            }

            if ((searchResult.contains(searchQuery)) &&
                    !(searchList.contains(contactEntry))) {
                searchList.add(contactEntry);
            }
        }
        return searchList;

    }

    public void printAddressBook() {
        if (myContactList.isEmpty()) {
            System.out.println("Pusheen is so sad because it has no friends here....");
        } else {
            System.out.println("Pusheen has seen the donut list and it was good. Now it will show the donuts:");
            for (ContactEntry contactEntry : myContactList) {
                System.out.println(contactEntry.toString());
            }
        }
    }

    public void deleteAddressBook() {
        myContactList.clear();
    }
}