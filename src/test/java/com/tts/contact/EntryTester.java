package com.tts.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactEntryTest {

    ContactEntry testContactEntry;
    ContactEntry testBlankContactEntry;

    final static String TEST_FIRSTNAME = "TestFirst";
    final static String TEST_LASTNAME = "TestLast";
    final static String TEST_PHONE = "TestPhone";
    final static String TEST_EMAIL = "TestEmail@Email.com";

    enum TEST_DATA{
        testEntryFilled(TEST_FIRSTNAME, TEST_LASTNAME, TEST_PHONE, TEST_EMAIL);

        private final String firstName;
        private final String lastName;
        private final String phone;
        private final String email;

        TEST_DATA(String firstname, String lastname, String phone, String email){
            this.firstName = firstname;
            this.lastName = lastname;
            this.phone = phone;
            this.email = email;
        }
    }

    @BeforeEach
    void setUp() {
        testContactEntry = ContactEntry.createEntry(
                TEST_DATA.testEntryFilled.firstName,
                TEST_DATA.testEntryFilled.lastName,
                TEST_DATA.testEntryFilled.phone,
                TEST_DATA.testEntryFilled.email);
        testBlankContactEntry = ContactEntry.createBlankEntry();
    }

    @Test
    void constructorEmpty(){
        assertNotEquals(testBlankContactEntry, null);
    }
    @Test
    void constructorFull(){
        assertNotEquals(testContactEntry, null);
    }

    @Test
    void getFirstName() {
        String expected = TEST_DATA.testEntryFilled.firstName;
        String actual = testContactEntry.getFirstName();

        assertEquals(expected, actual);
    }

    @Test
    void setFirstName() {
        String expected = "NEWTESTDATA";
        testContactEntry.setFirstName(expected);

        String actual = testContactEntry.getFirstName();

        assertEquals(expected, actual);
    }

    @Test
    void getLastName() {
        String expected = TEST_DATA.testEntryFilled.lastName;
        String actual = testContactEntry.getLastName();

        assertEquals(expected, actual);
    }

    @Test
    void setLastName() {
        String expected = "NEWTESTDATA";
        testContactEntry.setLastName(expected);

        String actual = testContactEntry.getLastName();

        assertEquals(expected, actual);
    }

    @Test
    void getPhoneNumber() {
        String expected = TEST_DATA.testEntryFilled.phone;
        String actual = testContactEntry.getPhoneNumber();

        assertEquals(expected, actual);
    }

    @Test
    void setPhoneNumber() {
        String expected = "NEWTESTDATA";
        testContactEntry.setPhoneNumber(expected);

        String actual = testContactEntry.getPhoneNumber();

        assertEquals(expected, actual);
    }

    @Test
    void getEmailAddress() {
        String expected = TEST_DATA.testEntryFilled.email;
        String actual = testContactEntry.getEmailAddress();

        assertEquals(expected, actual);
    }

    @Test
    void setEmailAddress() {
        String expected = "NEWTESTDATA";
        testContactEntry.setEmailAddress(expected);

        String actual = testContactEntry.getEmailAddress();

        assertEquals(expected, actual);
    }
}