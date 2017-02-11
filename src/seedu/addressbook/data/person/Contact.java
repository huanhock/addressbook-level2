package seedu.addressbook.data.person;

/**
 * Represents a Contact parent class in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Contact {

    protected String value;
    protected boolean isPrivate;
    

    public String toString() {
        return value;
    }

    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
   