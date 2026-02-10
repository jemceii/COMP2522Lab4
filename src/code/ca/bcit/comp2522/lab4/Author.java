package ca.bcit.comp2522.lab4;

/**
 * Represents an author in the bookstore system.
 * An Author is a Person with an associated genre.
 *
 * @author Faida Espiritu
 * @author Jemsel Jumapit
 *
 * @version 2026
 */
public class Author extends Person implements Printable
{
    public static final int MAX_LENGTH_GENRE = 30;
    private final String genre;

    /**
     * Constructs an Author with personal information and a genre.
     *
     * @param dateOfBirth the author's date of birth; must not be null
     * @param dateOfDeath the author's date of death; may be null if living
     * @param name the author's name; must not be null
     * @param genre the author's genre; must not be null, blank, or 30+ characters
     */
    public Author(final Date dateOfBirth,
                  final Date dateOfDeath,
                  final Name name,
                  final String genre)
    {
        super(dateOfBirth, dateOfDeath, name);

        validateGenre(genre);

        this.genre = genre;

    }

    private static void validateGenre(final String genre)
    {
        if (genre == null)
        {
            throw new IllegalArgumentException("Genre cannot be null.");
        }

        else if (genre.isBlank())
        {
            throw new IllegalArgumentException("Genre cannot be blank.");
        }

        else if (genre.length() >= MAX_LENGTH_GENRE)
        {
            throw new IllegalArgumentException("Genre must be less than " +
                    MAX_LENGTH_GENRE + ".");
        }
    }

    /**
     * Returns the author's genre.
     *
     * @return the genre of the author
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * Displays the author's information, including personal details
     * inherited from Person and the author's genre.
     */
    @Override
    public void display()
    {
        // prints Person info first
        super.display();

        System.out.println("Genre: " + getGenre() + ".");
    }


}
