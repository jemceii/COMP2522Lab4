package ca.bcit.comp2522.lab4;

public class Biography extends Book implements Printable
{
    private final Person subject;

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

    public Person getSubject()
    {
        return subject;
    }

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


    @Override
    public void display()
    {
        super.display();

        System.out.println("Subject: " + getSubject());
    }
}
