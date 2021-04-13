package ap.week29;

/**
 * <h3>APCalendar</h3>
 * 
 * APCalendar calculates the day of the week given a date
 * 
 * @author Alexander Taylor
 * @since 12 April 2021
 * @version 1.0
 */
public class APCalendar {
    /**
     * The first day of 1800 was a Wednesday
     */
    private static final int START_DAY_FOR_JANUARY_1_1800 = 3;

    /**
     * Checks whether the passed year is a leap year
     * 
     * @param year the year to check
     * @return whether the year is a leap year or not
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    /**
     * Calculate the number of leap years from <b>startYear</b> to <b>endYear</b>
     * 
     * @param startYear the start year
     * @param endYear   the end year
     * @return the number of leap years from start to end
     */
    public static int numberOfLeapYears(int startYear, int endYear) {
        double totalYears = (endYear - startYear);
        return (int) Math.round(totalYears / 4 - totalYears / 100 + totalYears / 400);
    }

    /**
     * Gets the number of days in the specified month
     * 
     * @param month the month of the year
     * @param year  the year
     * @return the number of days
     */
    public static int getNumberOfDaysInMonth(int month, int year) {
        final int[] numbers = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        return numbers[month] + ((isLeapYear(year) && month == 1) ? 1 : 0);
    }

    /**
     * Calculates the first day of the year in the specified year
     * 
     * @param year the year for which to calculate
     * @return the first day of the year
     */
    public static int firstDayOfYear(int year) {
        return START_DAY_FOR_JANUARY_1_1800 + (year * 365 + numberOfLeapYears(1800, year)) % 7;
    }

    /**
     * Gets what day of the year the specified date is
     * 
     * @param month
     * @param day
     * @param year
     * @return the day of the year
     */
    public static int dayOfYear(int month, int day, int year) {
        int days = day;
        int loopCount = month - 1;
        for (int i = 0; i < loopCount; i++) {
            days += getNumberOfDaysInMonth(i, year);
        }
        return days;
    }

    /**
     * Gets what day of the week the specified date is.
     * 
     * @param month
     * @param day
     * @param year
     * @return the day of the week from 1 to 7, 1 being Sunday and 7 being Saturday
     */
    public static int dayOfWeek(int month, int day, int year) {
        int dayOfWeek = (firstDayOfYear(year) + dayOfYear(month, day, year) - 1) % 7;
        return dayOfWeek != 0 ? dayOfWeek : 7;
    }

    /**
     * Converts the number returned from {@link #dayOfWeek(int, int, int) dayOfWeek}
     * to a human readable string
     * 
     * @param month
     * @param day
     * @param year
     * @return the human readable string
     */
    public static String dayOfWeekToString(int month, int day, int year) {
        final String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
                "Saturday" };
        return String.format("%d/%d/%d was a %s", month, day, year, days[dayOfWeek(month, day, year) - 1]);
    }
}