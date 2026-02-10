package ca.bcit.comp2522.Lab4;

import java.util.Objects;

public class Person implements Comparable<Person>, Printable, Reversible
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
    public int compareTo(final Person o)
    {
        if (this.dateOfBirth.getYear() != o.dateOfBirth.getYear())
        {
            return o.dateOfBirth.getYear() - this.dateOfBirth.getYear();
        }

        if (this.dateOfBirth.getMonth() != o.dateOfBirth.getMonth())
        {
            return o.dateOfBirth.getMonth() - this.dateOfBirth.getMonth();
        }

        return o.dateOfBirth.getDay() - this.dateOfBirth.getDay();
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        final Person other = (Person) obj;

        return this.dateOfBirth.equals(other.dateOfBirth) &&
               this.name.equals(other.name) &&
               (Objects.equals(this.dateOfDeath, other.dateOfDeath));
    }

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

        System.out.println("Person: " + name.getFullName() + ", " + birthInfo + deathInfo + ".");
    }

    @Override
    public String backward()
    {
        return name.getReverseName();
    }
}
