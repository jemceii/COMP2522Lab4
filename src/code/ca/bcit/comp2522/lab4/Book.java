package ca.bcit.comp2522.lab4;

/**
 * Represents a book in the bookstore system.
 * A Book has a title, publication year, and an author.
 *
 * @author Faida Espiritu
 * @author Jemsel Jumapit
 *
 * @version 2026
 */
public class Book implements Comparable<Book>,
                                Printable,
                                Reversible
{
    public static final int MAX_LENGTH_TITLE;
    public static final int MINIMUM_YEAR;
    public static final int CURRENT_YEAR;

    private final String title;
    private final int yearPublished;
    private final Author author;

    static
    {
        MAX_LENGTH_TITLE = 100;
        MINIMUM_YEAR = 1;
        CURRENT_YEAR = 2026;
    }

    /**
     * Constructs a Book with the given title, publication year, and author.
     *
     * @param title the title of the book; must not be null or blank
     * @param yearPublished the year the book was published
     * @param author the author of the book; must not be null
     */
    public Book(final String title,
                final int yearPublished,
                final Author author)
    {
        validateTitle(title);
        validateYearPublished(yearPublished);
        validateAuthor(author);

        this.title = title;
        this.yearPublished = yearPublished;
        this.author = author;
    }

    /**
     *
     * @param title
     */
    private static void validateTitle(final String title)
    {
        if (title == null)
        {
            throw new IllegalArgumentException("Title cannot be null.");
        }

        else if (title.isBlank())
        {
            throw new IllegalArgumentException("Title cannot be blank.");
        }

        else if (title.length() > MAX_LENGTH_TITLE)
        {
            throw new IllegalArgumentException("Title cannot be more than " +
                    MAX_LENGTH_TITLE + " characters long.");
        }
    }

    /**
     *
     * @param yearPublished
     */
    private static void validateYearPublished(final int yearPublished)
    {
        if (yearPublished < MINIMUM_YEAR || yearPublished > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Year must be between year " +
                    MINIMUM_YEAR + " and " + CURRENT_YEAR + ".");
        }
    }

    /**
     *
     * @param author
     */
    private static void validateAuthor(final Author author)
    {
        if (author == null)
        {
            throw new IllegalArgumentException("Author name cannot be null.");
        }
    }

    /**
     * Returns the tile of the book.
     *
     * @return the book title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Returns the author of the book.
     *
     * @return the author of the book
     */
    public Author getAuthor()
    {
        return author;
    }

    /**
     * Returns the year the book was published.
     *
     * @return the book's publication date
     */
    public int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Compares two books by publication year. Most recently
     * published books are considered larger.
     *
     * @param o the object to be compared.
     * @return a positive value if this book is newer,
     *          negative if older, or zero if published the same year
     */
    @Override
    public int compareTo(final Book o)
    {
        return o.getYearPublished() - this.getYearPublished();
    }

    /**
     * Displays the book's information such as the title,
     * publication year, and the author.
     */
    @Override
    public void display()
    {
        System.out.println("\nTitle: " + getTitle() +
                "\nYear Published: " + getYearPublished());
        System.out.print("Author: ");
        getAuthor().display();
    }

    /**
     * Returns the author's name in reverse.
     *
     * @return the reverse author name
     */
    @Override
    public String backward() {
        return getAuthor().backward();
    }

}
