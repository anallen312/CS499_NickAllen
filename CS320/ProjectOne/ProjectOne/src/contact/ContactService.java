package contact;

import java.util.HashMap;

/**
 * Manages Contact objects, offering add, delete, and update functionality.
 */
public class ContactService {
    // HashMap to store Contact objects, keyed by contactID
    private HashMap<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a Contact object to the HashMap. 
     * Also checks against ID's that already exist.
     * Ensuring unique IDs is more about the collection 
     * of contacts rather than individual contacts, 
     * so it generally makes more sense to handle this in 
     * ContactService rather than in the Contact constructor.
     */
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("ID already exists");
        }
        contacts.put(contact.getContactID(), contact);
    }

    /**
     * Deletes a Contact object from the HashMap by its ID.
     */
    public boolean deleteContact(String contactID) {
        if (contacts.containsKey(contactID)) {
            contacts.remove(contactID);
            return true;
        }
        return false;
    }

    /**
     * Updates fields of an existing Contact object.
     */
    public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setPhone(phone);
            contact.setAddress(address);
            return true;
        }
        return false;
    }

    /**
     * Returns the size of the contacts HashMap.
     */
    public int getContactsSize() {
        return contacts.size();
    }

    /**
     * Returns a specific Contact by its ID.
     */
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
