package ca.bcit.comp2522.lab4;

/**
 * Represents a biography book.
 * .
 * A Biography is a type of Book that focuses on the life of a specific person,
 * referred to as the subject.
 *
 * @author Faida Espiritu
 * @author Jemsel Jumapit
 *
 * @version 2026
 */
public class Biography extends Book implements Printable
{
    private final Person subject;

    /**
     * Creates a new Biography with the given details.
     *
     * @param title the name of the biography
     * @param yearPublished the year the book was published
     * @param author the author who wrote the biography
     * @param subject the person whose life the book describes
     */
    public Biography(final String title,
                     final int yearPublished,
                     final Author author,
                     final Person subject)
    {
        super(title, yearPublished, author);


        validateSubject(subject);


        this.subject = subject;
    }

    private static void validateSubject(final Person subject)
    {
        if (subject == null)
        {
            throw new IllegalArgumentException("Subject cannot be null.");
        }
    }

    /**
     * Returns the subject of the biography.
     *
     * @return the person the biography is about
     */
    public Person getSubject()
    {
        return subject;
    }

    /**
     * Compares this Biography to another object for equality.
     * Two biographies are considered equal if they are about the same subject.
     *
     * @param obj the object to compare with
     * @return true if both biographies have the same subject, false otherwise
     */
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        // Null or different class → not equal
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        final Biography other;
        other = (Biography) obj;

        return getSubject().equals(other.getSubject());
    }

    /**
     * Displays the biography information, including the book details
     * and the subject.
     */
    @Override
    public void display()
    {
        super.display();

        System.out.println("Subject: " + getSubject());
    }
}
