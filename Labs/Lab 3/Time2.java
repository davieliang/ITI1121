/**
 *
 * @author Matt Langlois (fletchto99@gmail.com)
 */

public class Time2 {

    /**
     * A constant to represent the number of seconds per day
     */

    static public final int SECONDS_PER_DAY = 86399;

    /**
     * A constant to represent the number of hours per day
     */

    static public final int SECONDS_PER_HOUR = 3600;

    /**
     * A constant to represent the number of seconds per minutes
     */

    static public final int SECONDS_PER_MINUTE = 60;

    /**
     * An instance variable to store the time.
     */

    private int time;

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

    public Time2(final int hours, final int minutes, final int seconds) {
        time = seconds + minutes * Time2.SECONDS_PER_MINUTE + hours
                * Time2.SECONDS_PER_HOUR;
    }

    /**
     *
     * @param other
     * @return
     */
    public boolean before(final Time2 other) {
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

    public boolean equals(final Time2 other) {
        System.out.println(other.time);
        return other != null && (this.getHours() == other.getHours())
                && (this.getMinutes() == other.getMinutes())
                && (this.getSeconds() == other.getSeconds());
    }

    /**
     * An access method (getter) that returns the number of hours of this object.
     *
     * @return returns the number of hours of this object
     */

    public int getHours() {
        return (time / Time2.SECONDS_PER_HOUR);
    }

    /**
     * An access method (getter) that returns the number of minutes of this object.
     *
     * @return returns the number of minutes of this object
     */

    public int getMinutes() {
        return (time % Time2.SECONDS_PER_HOUR) / Time2.SECONDS_PER_MINUTE;
    }

    /**
     * An access method (getter) that returns the number of seconds of this object.
     *
     * @return returns the number of seconds of this object
     */

    public int getSeconds() {
        return time % Time2.SECONDS_PER_MINUTE;
    }

    /**
     * Increments by one second the time value represented by this object.
     */

    public void increase() {
        time = (time++) % Time2.SECONDS_PER_DAY;
    }

    /**
     *
     * @param other
     * @return
     */
    public Time2 plus(final Time2 other) {
        final int hours = this.getHours() + other.getHours();
        final int minutes = this.getMinutes() + other.getMinutes();
        final int seconds = this.getSeconds() + other.getSeconds();
        return new Time2(hours, minutes, seconds);
    }

    /**
     * Returns a String representation of this Time1 object.
     *
     * @return a String representation of this Time1 object
     */

    @Override
    public String toString() {
        return this.getHours() + ":" + this.getMinutes() + ":"
                + this.getSeconds();
    }

}