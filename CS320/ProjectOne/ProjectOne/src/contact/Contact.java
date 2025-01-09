package contact;

public class Contact {
    private final String contactID;  // Immutable & unique, max 10 characters
    private String firstName;        // Required, max 10 characters
    private String lastName;         // Required, max 10 characters
    private String phone;            // Required, 10 digits exactly
    private String address;          // Required, max 30 characters

    // Constructor
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        if (contactID == null) {
        	throw new IllegalArgumentException("Contact ID cannot be null");
        }
        if (contactID.length() > 10) {
        	throw new IllegalArgumentException("Contact ID length must be <= 10");
        }
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }
        if (firstName.length() > 10) {
            throw new IllegalArgumentException("First name length must be <= 10");
        }
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        if (lastName.length() > 10) {
            throw new IllegalArgumentException("Last name length must be <= 10");
        }
        if (phone == null) {
            throw new IllegalArgumentException("Phone number cannot be null");
        }
        if (phone.length() != 10) {
            throw new IllegalArgumentException("Phone number must have exactly 10 digits");
        }
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        if (address.length() > 30) {
            throw new IllegalArgumentException("Address length must be <= 30");
        }
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }


    // Getters
    public String getContactID() {
        return this.contactID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }

    // Setters. Added 3 tests per string object.
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty() || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty() || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty() || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
