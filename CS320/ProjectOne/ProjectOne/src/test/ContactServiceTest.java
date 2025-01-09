package test;
import contact.Contact;
import contact.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for ContactService.
 */
public class ContactServiceTest {
    // Test fixture for ContactService
    private ContactService contactService;

    /**
     * Setup method for each test case.
     */
    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    /**
     * Test case for adding a contact.
     */
    @Test
    public void testAddContact() {
        int initialSize = contactService.getContactsSize();
        Contact newContact = new Contact("ID1", "John", "Doe", "1234567890", "Address1");
        contactService.addContact(newContact);
        assertEquals(initialSize + 1, contactService.getContactsSize());
    }

    /**
     * Test case for deleting a contact.
     */
    @Test
    public void testDeleteContact() {
        Contact newContact = new Contact("ID1", "John", "Doe", "1234567890", "Address1");
        contactService.addContact(newContact);
        boolean isDeleted = contactService.deleteContact("ID1");
        assertEquals(true, isDeleted);
    }

    /**
     * Test case for updating a contact.
     */
    @Test
    public void testUpdateContact() {
        Contact newContact = new Contact("ID1", "John", "Doe", "1234567890", "Address1");
        contactService.addContact(newContact);

        boolean isUpdated = contactService.updateContact("ID1", "Jane", "Doe", "0987654321", "Address2");
        assertEquals(true, isUpdated);

        Contact updatedContact = contactService.getContact("ID1");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("Address2", updatedContact.getAddress());
    }
    /**
     * Test case for unique ID.
     */
    @Test
    public void testAddUniqueContactID() {
        ContactService service = new ContactService();
        
        // Add first contact
        Contact firstContact = new Contact("ID123", "John", "Doe", "1234567890", "Some Addr");
        service.addContact(firstContact);
        
        // Try to add a second contact with the same ID
        Contact secondContact = new Contact("ID123", "Jane", "Doe", "1234567890", "Another Addr");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(secondContact);
        });
        
        // Check if the correct exception message is thrown
        assertEquals("ID already exists", exception.getMessage());
    }
}

