package seedu.addressbook.data.person;

import org.junit.runners.BlockJUnit4ClassRunner;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Street McStreetStreet, #12-34, 123456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+, .+, .+, .+";;

    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;
    
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String[] addressArray = new String[4];
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        addressArray = trimmedAddress.split(", ");
        this.block = new Block(addressArray[0]);
        this.street = new Street(addressArray[1]);
        this.unit = new Unit(addressArray[2]);
        this.postalCode = new PostalCode(addressArray[3]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        String stringAddress = block.getBlock() + ", " + street.getStreet() + ", " + 
                unit.getUnit() + ", " + postalCode.getPostalCode();
        return stringAddress;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
