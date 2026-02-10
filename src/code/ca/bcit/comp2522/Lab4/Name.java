package ca.bcit.comp2522.Lab4;


/**
 * The Name class.
 * ---------------
 * Represents a person's name and provides utility methods
 * for validating, formatting, and retrieving different
 * representations of that name.
 * ---------------
 * Stores a first name and last name, ensures they meet
 * validation rules, and offers formatted outputs such as
 * initials, full name, and reversed name.
 *
 * @author Jemsel Jumapit
 * @author Hazen Yang
 *
 * @version 2026
 */
public class Name
{
    private static final int    MAX_LEN_NAME;
    private static final int    FIRST_CHAR;
    private final        String firstName;
    private final        String lastName;

    static
    {
        MAX_LEN_NAME = 99;
        FIRST_CHAR   = 0;
    }

    /**
     * Constructor for name
     *
     * @param firstName First Name of client
     * @param lastName  Last name of client
     */
    public Name(final String firstName,
                final String lastName)
    {
        validateFirstName(firstName);
        validateLastName(lastName);

        validateFullNameLength(firstName, lastName);

        this.firstName = firstName;
        this.lastName  = lastName;
    }

    /**
     * Gets the first name of the user
     *
     * @return the first name of the user
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Gets the last name of the user
     *
     * @return the last name of the user
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Gets the initials of the user
     *
     * @return the initials of first name, last name
     */
    public String getInitials()
    {
        return firstName.toUpperCase().charAt(FIRST_CHAR) + "." + lastName.toUpperCase().charAt(FIRST_CHAR) + ".";
    }

    /**
     * Gets the full name of the user
     *
     * @return the full name of the user
     */
    public String getFullName()
    {
        final String firstNameFormatted;
        final String lastNameFormatted;

        firstNameFormatted =
            firstName.substring(0, 1).toUpperCase() +
            firstName.substring(1).toLowerCase();

        lastNameFormatted =
            lastName.substring(0, 1).toUpperCase() +
            lastName.substring(1).toLowerCase();

        return firstNameFormatted + " " + lastNameFormatted;
    }

    /**
     * Gets the reversed name of the user using string builder
     *
     * @return the reversed string of full name
     */
    public String getReverseName()
    {
        return new StringBuilder(getFullName()).reverse().toString();
    }

    /**
     *
     * Validates the First name
     *
     * @param first The first name of client
     * @throws IllegalArgumentException If the first name is null, empty or contains the words "admin"
     *
     */
    private static void validateFirstName(final String first)
    {
        if (first == null || first.isEmpty() || first.toLowerCase().contains("admin"))
        {
            throw new IllegalArgumentException("Illegal name: " + first);
        }
    }

    /**
     *
     * Validates the Last name
     *
     * @param last The last name of client
     * @throws IllegalArgumentException If the last name is null, empty or contains the words "admin"
     *
     */
    private static void validateLastName(final String last)
    {
        if (last == null || last.isEmpty() || last.toLowerCase().contains("admin"))
        {
            throw new IllegalArgumentException("Illegal name: " + last);
        }
    }

    /**
     *
     * Validates the Full name
     *
     * @param first The first name of client
     * @param last  The last name of client
     * @throws IllegalArgumentException If the full name's length exceeds MAX_LEN_NAME (45)
     *
     */
    private static void validateFullNameLength(final String first,
                                               final String last)
    {
        if (first.length() + last.length() > MAX_LEN_NAME)
        {
            throw new IllegalArgumentException("Full name exceeds maximum length: " + first + " " + last);
        }
    }

}
