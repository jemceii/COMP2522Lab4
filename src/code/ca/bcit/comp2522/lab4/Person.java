package ca.bcit.comp2522.lab4;

import java.util.Objects;

/**
 * Represents a person with a name, a birthdate,
 * and a death date if applicable.
 * A Person can be compared by age, printed, and displayed in reverse order.
 *
 * @author Jemsel Jumapit
 * @author Faida Espiritu
 *
 * @version 2026
 */
public class Person implements Comparable<Person>,
                                Printable,
                                Reversible
{
    private final Date dateOfBirth;
    private final Date dateOfDeath;
    private final Name name;

    /**
     * Constructs a Person with the given birth
     * and death date information.
     *
     * @param dateOfBirth the person's date of birth; must not be null
     * @param dateOfDeath the person's date of death; may be null
     * @param name the person's name; must not be null
     */
    public Person(final Date dateOfBirth,
                  final Date dateOfDeath,
                  final Name name)
    {
        validateDate(dateOfBirth, dateOfDeath);
        validateName(name);

        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.name = name;
    }

    private static void validateDate(final Date dateOfBirth,
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

    private static void validateName(final Name name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Name cannot be null.");
        }
    }

    /**
     * Compares two Person objects by age.
     * Older people are considered larger.
     *
     * @param o the Person to compare to
     * @return a positive value if this person is older,
     *         negative if younger, or zero if equal in age
     */
    @Override
    public int compareTo(final Person o)
    {
        if (this.dateOfBirth.getYear() != o.dateOfBirth.getYear())
        {
            return o.dateOfBirth.getYear() - this.dateOfBirth.getYear();
        }
        else if (this.dateOfBirth.getMonth() != o.dateOfBirth.getMonth())
        {
            return o.dateOfBirth.getMonth() - this.dateOfBirth.getMonth();
        }

        return o.dateOfBirth.getDay() - this.dateOfBirth.getDay();
    }

    /**
     * Determines whether this Person is equal to another object.
     *
     * @param obj the object to compare
     * @return true if the objects represent the same person
     */
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        else if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        final Person other;
        other = (Person) obj;


        return this.dateOfBirth.equals(other.dateOfBirth) &&
               this.name.equals(other.name) &&
               (Objects.equals(this.dateOfDeath, other.dateOfDeath));
    }

    /**
     * Returns a hash code for this Person.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode()
    {
        if (dateOfDeath != null)
        {
            return dateOfBirth.hashCode() + name.hashCode() + dateOfDeath.hashCode();
        }
        else
        {
            return dateOfBirth.hashCode() + name.hashCode();
        }
    }

    /**
     * Displays the person's information, including birth and death details.
     */
    @Override
    public void display()
    {
        final String birthInfo;
        final String deathInfo;

        birthInfo = "was born on " + dateOfBirth.getYearMonthDay();

        if (dateOfDeath != null)
        {
            deathInfo = ", died on " + dateOfDeath.getYearMonthDay();
        }
        else
        {
            deathInfo = ", and is still alive";
        }


        System.out.println(name.getFullName() +
                ", " + birthInfo + deathInfo);
    }

    /**
     * Returns the person's full name in reverse order.
     *
     * @return the reversed name
     */
    @Override
    public String backward()
    {
        return name.getReverseName();
    }

}
