package ca.bcit.comp2522.lab4;

/**
 * The Date class.
 * <p>
 * Handles basic date validation and storage, formats dates as strings,
 * and calculates the day of the week.
 * <p>
 * Checks that the year, month, and day are valid for the calendar.
 * Also provides access to each part of the date.
 * <p>
 * The day‑of‑week is computed using the last two digits of the year,
 * leap‑year adjustments, and month codes.
 *
 * @author Jemsel Jumapit
 * @author Faida Espiritu
 *
 * @version 2026
 */
public class Date implements Printable
{
    // Date Variables
    private static final int SHORT_FEB;
    private static final int LONG_MONTH;
    private static final int SHORT_MONTH;

    private static final int DAYS_OF_THE_WEEK;
    private static final int MAXIMUM_MONTHS;
    private static final int ZERO_MONTHS;
    private static final int INVALID_MONTH;


    private static final int MINIMUM_YEAR;

    private static final int CURRENT_YEAR;

    // Months
    private static final int JANUARY;
    private static final int FEBRUARY;
    private static final int MARCH;
    private static final int APRIL;
    private static final int MAY;
    private static final int JUNE;
    private static final int JULY;
    private static final int AUGUST;
    private static final int SEPTEMBER;
    private static final int OCTOBER;
    private static final int NOVEMBER;
    private static final int DECEMBER;

    // Months
    private static final int JANUARY_CODE;
    private static final int FEBRUARY_CODE;
    private static final int MARCH_CODE;
    private static final int APRIL_CODE;
    private static final int MAY_CODE;
    private static final int JUNE_CODE;
    private static final int JULY_CODE;
    private static final int AUGUST_CODE;
    private static final int SEPTEMBER_CODE;
    private static final int OCTOBER_CODE;
    private static final int NOVEMBER_CODE;
    private static final int DECEMBER_CODE;

    // Days
    private static final int ONE_DAY;

    // Date Input
    private final int yearNumber;
    private final int monthNumber;
    private final int dayNumber;

    // Calculation Variables

    private static final int MODULUS_DIVIDER;
    private static final int LEAP_YEAR_CYCLE;

    // Remainder Months

    private static final int SATURDAY;
    private static final int SUNDAY;
    private static final int MONDAY;
    private static final int TUESDAY;
    private static final int WEDNESDAY;
    private static final int THURSDAY;
    private static final int FRIDAY;


    static
    {
        SHORT_FEB   = 28;
        LONG_MONTH  = 31;
        SHORT_MONTH = 30;

        DAYS_OF_THE_WEEK = 7;
        MAXIMUM_MONTHS   = 12;
        ZERO_MONTHS      = 0;

        MODULUS_DIVIDER = 100;

        ONE_DAY         = 1;
        LEAP_YEAR_CYCLE = 4;

        MINIMUM_YEAR = 1;
        CURRENT_YEAR = 2026;

        JANUARY   = 1;
        FEBRUARY  = 2;
        MARCH     = 3;
        APRIL     = 4;
        MAY       = 5;
        JUNE      = 6;
        JULY      = 7;
        AUGUST    = 8;
        SEPTEMBER = 9;
        OCTOBER   = 10;
        NOVEMBER  = 11;
        DECEMBER  = 12;

        JANUARY_CODE   = 1;
        FEBRUARY_CODE  = 4;
        MARCH_CODE     = 4;
        APRIL_CODE     = 0;
        MAY_CODE       = 2;
        JUNE_CODE      = 5;
        JULY_CODE      = 0;
        AUGUST_CODE    = 3;
        SEPTEMBER_CODE = 6;
        OCTOBER_CODE   = 1;
        NOVEMBER_CODE  = 4;
        DECEMBER_CODE  = 6;

        INVALID_MONTH = 0;

        SATURDAY  = 0;
        SUNDAY    = 1;
        MONDAY    = 2;
        TUESDAY   = 3;
        WEDNESDAY = 4;
        THURSDAY  = 5;
        FRIDAY    = 6;
    }

    /**
     * Date Constructor.
     *
     * @param year  year of date.
     * @param month month of date.
     * @param day   day of date.
     */
    public Date(final int year,
                final int month,
                final int day)
    {
        // Check if date is valid.
        validateYear(year);
        validateMonth(month);
        validateDay(day, month);

        this.dayNumber   = day;
        this.monthNumber = month;
        this.yearNumber  = year;
    }

    /**
     * Gets the day of the date.
     *
     * @return the day.
     */
    public int getDay()
    {
        return this.dayNumber;
    }

    /**
     * Gets the month of the date.
     *
     * @return the month.
     */
    public int getMonth()
    {
        return this.monthNumber;
    }

    /**
     * Gets the year of the date.
     *
     * @return the year.
     */
    public int getYear()
    {
        return this.yearNumber;
    }

    /**
     * Returns the full date as a readable string.
     * Converts the month number into the month name and combines it
     * with the day and year.
     *
     * @return the date formatted as YYYY-MM-DD
     * @throws IllegalArgumentException if the month number is not valid
     */

    public String getYYYYMMDD()
    {
        return this.yearNumber + "-" + this.monthNumber + "-" + this.dayNumber;
    }

    public String getYearMonthDay()
    {
        final String month;
        if (this.monthNumber == JANUARY)
        {
            month = "January";
        }
        else if (this.monthNumber == FEBRUARY)
        {
            month = "February";
        }
        else if (this.monthNumber == MARCH)
        {
            month = "March";
        }
        else if (this.monthNumber == APRIL)
        {
            month = "April";
        }
        else if (this.monthNumber == MAY)
        {
            month = "May";
        }
        else if (this.monthNumber == JUNE)
        {
            month = "June";
        }
        else if (this.monthNumber == JULY)
        {
            month = "July";
        }
        else if (this.monthNumber == AUGUST)
        {
            month = "August";
        }
        else if (this.monthNumber == SEPTEMBER)
        {
            month = "September";
        }
        else if (this.monthNumber == OCTOBER)
        {
            month = "October";
        }
        else if (this.monthNumber == NOVEMBER)
        {
            month = "November";
        }
        else if (this.monthNumber == DECEMBER)
        {
            month = "December";
        }
        else
        {
            throw new IllegalArgumentException("Invalid Month!");
        }

        return month + " " + this.dayNumber + ", " + this.yearNumber;
    }


    /**
     * Calculates the offset based on the last two digits of the year.
     * The calculation uses the number of full twelve‑month cycles,
     * the remaining months, and the number of four-year cycles
     * within that remainder. These values are added to the day number
     * to produce the final offset.
     *
     * @return the computed year offset
     */
    private int calculateYearOffset()
    {
        final int lastTwoDigits;
        final int firstRemainder;
        final int amountOfTwelves;
        final int amountOfFours;

        lastTwoDigits   = yearNumber % MODULUS_DIVIDER;
        amountOfTwelves = lastTwoDigits / MAXIMUM_MONTHS;
        firstRemainder  = lastTwoDigits - (MAXIMUM_MONTHS * amountOfTwelves);
        amountOfFours   = firstRemainder / LEAP_YEAR_CYCLE;

        return this.dayNumber + amountOfTwelves + firstRemainder + amountOfFours;
    }

    /**
     * Maps the month number to its specific calculation code.
     * @param month the month number
     * @return the integer code for that month
     */
    private int getMonthCode(final int month)
    {
        final int monthCode;

        if (month == JANUARY)
        {
            monthCode = JANUARY_CODE;
        }
        else if (month == FEBRUARY)
        {
            monthCode = FEBRUARY_CODE;
        }
        else if (month == MARCH)
        {
            monthCode = MARCH_CODE;
        }
        else if (month == APRIL)
        {
            monthCode = APRIL_CODE;
        }
        else if (month == MAY)
        {
            monthCode = MAY_CODE;
        }
        else if (month == JUNE)
        {
            monthCode = JUNE_CODE;
        }
        else if (month == JULY)
        {
            monthCode = JULY_CODE;
        }
        else if (month == AUGUST)
        {
            monthCode = AUGUST_CODE;
        }
        else if (month == SEPTEMBER)
        {
            monthCode = SEPTEMBER_CODE;
        }
        else if (month == OCTOBER)
        {
            monthCode = OCTOBER_CODE;
        }
        else if (month == NOVEMBER)
        {
            monthCode = NOVEMBER_CODE;
        }
        else if (month == DECEMBER)
        {
            monthCode = DECEMBER_CODE;
        }
        else
        {
            monthCode = INVALID_MONTH;
        }

        return monthCode;
    }

    /**
     * Converts the calculated remainder into a String day name.
     * @param index the modulo remainder
     * @return the String representation of the day
     */
    private String getDayFromCode(final int index)
    {
        final String dayOfWeek;

        if (index == SATURDAY)
        {
            dayOfWeek = "Saturday";
        }
        else if (index == SUNDAY)
        {
            dayOfWeek = "Sunday";
        }
        else if (index == MONDAY)
        {
            dayOfWeek = "Monday";
        }
        else if (index == TUESDAY)
        {
            dayOfWeek = "Tuesday";
        }
        else if (index == WEDNESDAY)
        {
            dayOfWeek = "Wednesday";
        }
        else if (index == THURSDAY)
        {
            dayOfWeek = "Thursday";
        }
        else if (index == FRIDAY)
        {
            dayOfWeek = "Friday";
        }
        else
        {
            throw new IllegalArgumentException("Invalid day!");
        }

        return dayOfWeek;
    }

    /**
     * GETTING THE DAY OF THE WEEK:
     * Determines the day of the week for this date.
     * The method calculates a total offset by combining a year-based offset
     * (derived from the last two digits of the year and leap year cycles)
     * with a specific month code. The resulting total is then processed
     * using a modulo operation by the number of days in a week to identify
     * the specific day name.
     * --------------------------------------------
     * CALCULATE YEAR OFFSET:
     * Calculate the offset based on the last two digits of the year.
     * The calculation uses the number of full twelve‑month cycles,
     * the remaining months, and the number of four-year cycles
     * within that remainder. These values are added to the day number
     * to produce the final offset.
     *   The steps are
     *     1. Take the last two digits of the year
     *     2. Calculate how many twelve-month cycles can fit into that value.
     *     3. Find the remainder after calculating, giving you the remaining months.
     *     4. With the results, calculate the number of fours.
     *     5. Add the day number, the number of 12‑month cycles, the remaining months,
     *        and the number of 4‑year cycles to produce the totalOffset.
     *    `
     *    Example
     *      step one: calculate the number of twelves in seventy-seven:
     *          six
     *      step two: calculate the remainder from step one: seventy-seven - twelve*six = seventy-seven - seventy-two =
     *          five
     *      step three: calculate the number of fours in step 2: five/4 = 1.25, so
     *          one
     *      step four: add the day of the month to each step above: thirty-one + six + five + one =
     *          forty-three
     *      step five: add the month code (for jfmamjjasond: 144025036146): for October it is one: forty-three + one =
     *          forty-four
     *      step six: add the previous five numbers: (forty-four) and mod by seven:
     *          forty-four%seven = two (fourty-four/seven = six remainder two)
     *      step seven: sat sun mon tue wed thu fri is zero one two three four five six;
     *          our two means Oct thirty-one nineteen-seventy-seven was Monday.
     *--------------------------------------------
     * GET MONTH CODE:
     * Maps the month number to its specific calculation code using
     * the getMonthCode Method. Any inserted parameters will be assigned a month
     * code resulting its code as a return.
     *
     * @return the name of the day of the week (e.g., "Monday")
     * @throws IllegalArgumentException if the calculated day index is invalid
     */
    public final String getDayOfTheWeek()
    {
        final int yearOffset;
        final int monthCode;
        final int totalOffset;
        final int moduloRemainder;

        yearOffset = calculateYearOffset();
        monthCode = getMonthCode(this.monthNumber);

        totalOffset = yearOffset + monthCode;
        moduloRemainder = totalOffset % DAYS_OF_THE_WEEK;

        return getDayFromCode(moduloRemainder);
    }

    /**
     *
     * Validates the year.
     *
     * @param yearNum The year
     * @throws IllegalArgumentException If the year is not in the valid range
     *
     */
    private static void validateYear(final int yearNum)
    {
        if (yearNum < MINIMUM_YEAR || yearNum > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Invalid year. Must provide a year between " +
                                               MINIMUM_YEAR + "-" + CURRENT_YEAR + ".");
        }
    }

    /**
     *
     * Validates the month.
     *
     * @param monthNum The month
     * @throws IllegalArgumentException If the month is not between 1-12
     *
     */
    private static void validateMonth(final int monthNum)
    {
        if (monthNum < JANUARY || monthNum > DECEMBER)
        {
            throw new IllegalArgumentException("Invalid month. Must provide a month between " +
                                               JANUARY + "-" + DECEMBER + ".");
        }
    }

    /**
     *
     * Validates the day for the given month.
     *
     * @param dayNum   The day
     * @param monthNum The month the day belongs to
     * @throws IllegalArgumentException If the day is not valid for the specified month
     *
     */
    private static void validateDay(final int dayNum,
                                    final int monthNum)
    {
        if (monthNum == FEBRUARY)
        {
            if (dayNum < ONE_DAY || dayNum > SHORT_FEB)
            {
                throw new IllegalArgumentException(
                    "Invalid day. Must provide a day between " + ONE_DAY + "-" + SHORT_FEB + " for this month."
                );
            }
        }
        else if (monthNum == APRIL || monthNum == JUNE ||
                 monthNum == SEPTEMBER || monthNum == NOVEMBER)
        {
            if (dayNum < ONE_DAY || dayNum > SHORT_MONTH)
            {
                throw new IllegalArgumentException(
                    "Invalid day. Must provide a day between " + ONE_DAY + "-" + SHORT_MONTH + " for this month."
                );
            }
        }
        else
        {
            if (dayNum < ONE_DAY || dayNum > LONG_MONTH)
            {
                throw new IllegalArgumentException(
                    "Invalid day. Must provide a day between " + ONE_DAY + "-" + LONG_MONTH + " for this month."
                );
            }
        }
    }

    /**
     * Displays the date as such: year, month, day.
     */
    @Override
    public void display()
    {
        System.out.println("Date: Year " + this.yearNumber +
                           ", Month " + this.monthNumber +
                           ", Day " + this.dayNumber +
                           " (" + getYearMonthDay() + ", " + getDayOfTheWeek() + ").");
    }
}


// get rid of numbers in exceptions, use else for validate Day, use final, get YYYYMMDD should be numbers