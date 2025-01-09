package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import contact.Contact;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "Some Addr");
        assertEquals("ID123", contact.getContactID());
    }

    @Test
    public void testNullID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "Some Addr");
        });
        assertEquals("Contact ID cannot be null", exception.getMessage());
    }

    @Test
    public void testNullFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", null, "Doe", "1234567890", "Some Addr");
        });
        assertEquals("First name cannot be null", exception.getMessage());
    }

    @Test
    public void testNullLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", null, "1234567890", "Some Addr");
        });
        assertEquals("Last name cannot be null", exception.getMessage());
    }

    @Test
    public void testNullPhone() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "Doe", null, "Some Addr");
        });
        assertEquals("Phone number cannot be null", exception.getMessage());
    }

    @Test
    public void testNullAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "Doe", "1234567890", null);
        });
        assertEquals("Address cannot be null", exception.getMessage());
    }

    @Test
    public void testInvalidIDLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ThisIsALongID", "John", "Doe", "1234567890", "Some Addr");
        });
        assertEquals("Contact ID length must be <= 10", exception.getMessage());
    }

    @Test
    public void testInvalidFirstNameLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "VeryLongFirstName", "Doe", "1234567890", "Some Addr");
        });
        assertEquals("First name length must be <= 10", exception.getMessage());
    }

    @Test
    public void testInvalidLastNameLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "VeryLongLastName", "1234567890", "Some Addr");
        });
        assertEquals("Last name length must be <= 10", exception.getMessage());
    }

    @Test
    public void testInvalidPhoneLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "Doe", "123456789", "Some Addr");
        });
        assertEquals("Phone number must have exactly 10 digits", exception.getMessage());
    }

    @Test
    public void testInvalidAddressLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "Doe", "1234567890", "ThisIsAReallyLongAddressThatExceedsLimits");
        });
        assertEquals("Address length must be <= 30", exception.getMessage());
    }
    
 // *************BOUNDARY VALUE TESTS START HERE*****************
    @Test
    public void testMinIDLength() {
        Contact contact = new Contact("I", "John", "Doe", "1234567890", "Some Addr");
        assertEquals("I", contact.getContactID());
    }

    @Test
    public void testMaxIDLength() {
        Contact contact = new Contact("ABCDEFGHIJ", "John", "Doe", "1234567890", "Some Addr");
        assertEquals("ABCDEFGHIJ", contact.getContactID());
    }

    @Test
    public void testMinFirstNameLength() {
        Contact contact = new Contact("ID123", "J", "Doe", "1234567890", "Some Addr");
        assertEquals("J", contact.getFirstName());
    }

    @Test
    public void testMaxFirstNameLength() {
        Contact contact = new Contact("ID123", "ABCDEFGHIJ", "Doe", "1234567890", "Some Addr");
        assertEquals("ABCDEFGHIJ", contact.getFirstName());
    }

    @Test
    public void testMinLastNameLength() {
        Contact contact = new Contact("ID123", "John", "D", "1234567890", "Some Addr");
        assertEquals("D", contact.getLastName());
    }

    @Test
    public void testMaxLastNameLength() {
        Contact contact = new Contact("ID123", "John", "ABCDEFGHIJ", "1234567890", "Some Addr");
        assertEquals("ABCDEFGHIJ", contact.getLastName());
    }

    @Test
    public void testMinPhoneLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "Doe", "1", "Some Addr");
        });
        assertEquals("Phone number must have exactly 10 digits", exception.getMessage());
    }

    @Test
    public void testMaxPhoneLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "Doe", "1234567890123456", "Some Addr");
        });
        assertEquals("Phone number must have exactly 10 digits", exception.getMessage());
    }

    @Test
    public void testMinAddressLength() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "A");
        assertEquals("A", contact.getAddress());
    }

    @Test
    public void testMaxAddressLength() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "ABCDEFGHIJABCDEFGHIJABCDEFGHIJ");
    }
}
