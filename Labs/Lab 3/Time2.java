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
     * This constructor initializes the instance variables of this
     * Time1 object using the values of formal parameters hours,
     * minutes and seconds.
     *
     * @param hours
     *            the initial number of hours
     * @param minutes
     *            the initial number of minutes
     * @param seconds
     *            the initial number of seconds
     */

    public Time2(int hours, int minutes, int seconds) {
        this.time =
                seconds + minutes * SECONDS_PER_MINUTE + hours
                        * SECONDS_PER_HOUR;
    }

    /**
     * An access method (getter) that returns the number of hours of
     * this object.
     *
     * @return returns the number of hours of this object
     */

    public int getHours() {
        return (time / SECONDS_PER_HOUR);
    }

    /**
     * An access method (getter) that returns the number of minutes of
     * this object.
     *
     * @return returns the number of minutes of this object
     */

    public int getMinutes() {
        return (time % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE;
    }

    /**
     * An access method (getter) that returns the number of seconds of
     * this object.
     *
     * @return returns the number of seconds of this object
     */

    public int getSeconds() {
        return time % SECONDS_PER_MINUTE;
    }

    /**
     * Returns a String representation of this Time1 object.
     *
     * @return a String representation of this Time1 object
     */

    public String toString() {
        return getHours() + ":" + getMinutes() + ":" + getSeconds();
    }

    /**
     * Returns a true if and only if other designates an object that
     * has the same content as this Time1 object.
     *
     * @param other
     *            is a reference to a Time1 object
     * @return a String representation of this Time1 object
     */

    public boolean equals(Time2 other) {
        System.out.println(other.time);
        return other != null && (getHours() == other.getHours())
                && (getMinutes() == other.getMinutes())
                && (getSeconds() == other.getSeconds());
    }

    /**
     * Increments by one second the time value represented by this
     * object.
     */

    public void increase() {
        this.time = (time++) % SECONDS_PER_DAY;
    }

    /**
     * 
     * @param other
     * @return
     */
    public Time2 plus(Time2 other) {
        int hours = this.getHours() + other.getHours();
        int minutes = this.getMinutes() + other.getMinutes();
        int seconds = this.getSeconds() + other.getSeconds();
        return new Time2(hours, minutes, seconds);
    }

    /**
     * 
     * @param other
     * @return
     */
    public boolean before(Time2 other) {
        return this.getHours() < other.getHours() ? true
                : this.getMinutes() < other.getMinutes() ? true : this
                        .getSeconds() < other.getSeconds() ? true : false;
    }

}