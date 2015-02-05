/**
 * ITI1121. Introduction to Computing II<br/>
 * ITI1521. Introduction … l'informatique II.
 * <p/>
 *
 * Laboratory/laboratoire 3
 *
 * @author Marcel Turcotte (turcotte@site.uottawa.ca)
 */

public class Time1 {

    /**
     * A constant to represent the number of hours per day
     */

    static public final int HOURS_PER_DAY = 24;

    /**
     * A constant to represent the number of minutes per hour
     */

    static public final int MINUTES_PER_HOUR = 60;

    /**
     * A constant to represent the number of seconds per minutes
     */

    static public final int SECONDS_PER_MINUTE = 60;

    /**
     * An instance variable to store the number of hours of this Time1 object. The range of valid values is 0..23.
     */

    private int hours;

    /**
     * An instance variable to store the number of minutes of this Time1 object. The range of valid values is 0..59.
     */

    private int minutes;

    /**
     * An instance variable to store the number of minutes of this Time1 object. The range of valid values is 0..59.
     */

    private int seconds;

    /**
     * This constructor initializes the instance variables of this Time1 object using the values of formal parameters hours, minutes and seconds.
     *
     * @param hours
     *            the initial number of hours
     * @param minutes
     *            the initial number of minutes
     * @param seconds
     *            the initial number of seconds
     */

    public Time1(final int hours, final int minutes, final int seconds) {

        this.seconds = seconds % Time1.SECONDS_PER_MINUTE;

        final int m = (seconds / Time1.SECONDS_PER_MINUTE) + minutes;
        this.minutes = m % Time1.MINUTES_PER_HOUR;

        this.hours = ((m / Time1.MINUTES_PER_HOUR) + hours)
                % Time1.HOURS_PER_DAY;
    }

    public boolean before(final Time1 other) {
        return this.getHours() < other.getHours() ? true
                : this.getMinutes() < other.getMinutes() ? true : this
                        .getSeconds() < other.getSeconds() ? true : false;
    }

    /**
     * Returns a true if and only if other designates an object that has the same content as this Time1 object.
     *
     * @param other
     *            is a reference to a Time1 object
     * @return a String representation of this Time1 object
     */

    public boolean equals(final Time1 other) {
        return other != null && (hours == other.getHours())
                && (minutes == other.getMinutes())
                && (seconds == other.getSeconds());
    }

    /**
     * An access method (getter) that returns the number of hours of this object.
     *
     * @return returns the number of hours of this object
     */

    public int getHours() {
        return hours;
    }

    /**
     * An access method (getter) that returns the number of minutes of this object.
     *
     * @return returns the number of minutes of this object
     */

    public int getMinutes() {
        return minutes;
    }

    /**
     * An access method (getter) that returns the number of seconds of this object.
     *
     * @return returns the number of seconds of this object
     */

    public int getSeconds() {
        return seconds;
    }

    /**
     * Increments by one second the time value represented by this object.
     */

    public void increase() {
        seconds++;
        int carry = seconds / Time1.SECONDS_PER_MINUTE;
        seconds = seconds % Time1.SECONDS_PER_MINUTE;
        minutes = minutes + carry;
        carry = minutes / Time1.MINUTES_PER_HOUR;
        minutes = minutes % Time1.MINUTES_PER_HOUR;
        hours = (hours + carry) % Time1.HOURS_PER_DAY;
    }

    public Time1 plus(final Time1 other) {
        final int hours = this.getHours() + other.getHours();
        final int minutes = this.getMinutes() + other.getMinutes();
        final int seconds = this.getSeconds() + other.getSeconds();
        return new Time1(hours, minutes, seconds);
    }

    /**
     * Returns a String representation of this Time1 object.
     *
     * @return a String representation of this Time1 object
     */

    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }

}