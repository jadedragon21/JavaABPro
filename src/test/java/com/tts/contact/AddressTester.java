package com.tts.contact;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContactBookTest {

    ContactBook testContactBook;
    ContactEntry testContactEntry;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUp() {
        testContactBook = ContactBook.createEmptyContacts();
        testContactEntry = ContactEntry.createEntry(
                "TestFirst",
                "TestLast",
                "TestPhone",
                "TestEmail");
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void createEmptyAddressor() {
        ContactBook newContactBook = ContactBook.createEmptyContacts();
//        assertTrue(newContactBook instanceof ContactBook);
        assertNotEquals(newContactBook, null);
    }

    @Test
    void addEntry() {
        testContactBook.addContact(testContactEntry);
        ArrayList<ContactEntry> searchResult = testContactBook.searchEntries(testContactEntry.getEmailAddress(), ContactBook.SearchType.EMAIL);

        String expected = testContactEntry.getEmailAddress();
        String actual = searchResult.get(0).getEmailAddress();
        assertTrue(actual.contains(expected));
    }

    @Test
    void removeEntry() {
        testContactBook.addContact(testContactEntry);
        testContactBook.removeEntry(testContactEntry.getEmailAddress());
        ArrayList<ContactEntry> searchResult = testContactBook.searchEntries(testContactEntry.getEmailAddress(), ContactBook.SearchType.EMAIL);

        boolean expected = true;
        boolean actual = searchResult.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    void searchEntries() {
        testContactBook.addContact(testContactEntry);
        ArrayList<ContactEntry> searchResult = testContactBook.searchEntries(testContactEntry.getEmailAddress());

        String expected = testContactEntry.getEmailAddress();
        String actual = searchResult.get(0).getEmailAddress();
        assertTrue(actual.contains(expected));
    }

    @Test
    void searchEntriesByType() {
        testContactBook.addContact(testContactEntry);
        ArrayList<ContactEntry> searchResult = testContactBook.searchEntries(testContactEntry.getEmailAddress(), ContactBook.SearchType.EMAIL);

        String expected = testContactEntry.getEmailAddress();
        String actual = searchResult.get(0).getEmailAddress();
        assertTrue(actual.contains(expected));
    }

    @Test
    void printAddressBook() {
        testContactBook.printAddressBook();
        assertNotEquals(null, outContent.toString());
    }

    @Test
    void deleteAddressBook() {
        testContactBook.addContact(testContactEntry);
        testContactBook.deleteAddressBook();

        ArrayList<ContactEntry> searchResult = testContactBook.searchEntries(testContactEntry.getEmailAddress(), ContactBook.SearchType.EMAIL);

        boolean expected = true;
        boolean actual = searchResult.isEmpty();
        assertEquals(expected,actual);
    }
}