package seedu.addressbook.data.person;

/**
 * A read-only immutable interface for a Person in the addressbook.
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface Printable {
    public static final String SEPARATOR = ": ";
    
    /**
     * Returns a concatenated version of the printable strings of each object.
     */
   default String getPrintableString(){
       return getClass().getName() + SEPARATOR + toString();
   }
}
