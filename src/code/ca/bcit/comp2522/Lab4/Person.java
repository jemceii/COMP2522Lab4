package ca.bcit.comp2522.Lab4;

public class Person implements Comparable, Printable, Reversible
{
    private final Date dateOfBirth;
    private final Date dateOfDeath;
    private final Name name;

    public Person(final Date dateOfBirth, final Date dateOfDeath, final Name name)
    {
        validateDate(dateOfBirth, dateOfDeath);
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.name = name;
    }

    public static void validateDate(
        final Date dateOfBirth,
        final Date dateOfDeath)
    {
        if (dateOfBirth == null)
        {
            throw new IllegalArgumentException("The date of birth cannot be NULL!");
        }

        if (dateOfDeath != null)
        {
            if (dateOfDeath.getYear() < dateOfBirth.getYear())
            {
                throw new IllegalArgumentException("Date of death must be after date of birth!");
            }
            else if (dateOfDeath.getYear() == dateOfBirth.getYear())
            {
                if (dateOfDeath.getMonth() < dateOfBirth.getMonth())
                {
                    throw new IllegalArgumentException("Date of death must be after date of birth!");
                }
                else if (dateOfDeath.getMonth() == dateOfBirth.getMonth())
                {
                    if (dateOfDeath.getDay() <= dateOfBirth.getDay())
                    {
                        throw new IllegalArgumentException("Date of death must be after date of birth!");
                    }
                }
            }
        }
    }

    @Override
    public int compareTo(Object o)
    {
        return 0;
    }
}
