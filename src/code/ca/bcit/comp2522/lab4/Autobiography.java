package ca.bcit.comp2522.lab4;

/**
 * Represents an autobiography.
 * .
 * An autobiography is a type of Biography where the subject of the book
 * is the same person as the author.
 *
 * @author Faida Espiritu
 * @author Jemsel Jumapit
 *
 * @version 2026
 */
public class Autobiography extends Biography implements Printable
{
    /**
     * Constructs a new Autobiography object The subject of the
     * biography is automatically set to the author as
     * a parameter for the parent constructor.
     *
     * @param title the title of the autobiography
     * @param yearPublished the year the book was published
     * @param author the author of the autobiography
     */
    public Autobiography(final String title,
                         final int yearPublished,
                         final Author author) {
        super(title, yearPublished, author, author);
    }

    /**
     * Displays all the information about the autobiography,
     * including book details, author, and subject.
     */
    @Override
    public void display()
    {
        System.out.println("Title: " + getTitle());
        System.out.println("Year Published: " + getYearPublished());
        System.out.println("Author: " + getAuthor().getFullName());
        System.out.println("Subject: " + getAuthor().getFullName());
        System.out.println();
    }

}
