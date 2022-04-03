package models;

/**
 * This class defines the properties and methods for the object: TimeFrame.
 * @author Ricardo Vaca P.
 * @version 2022/02
 */
public class TimeFrame {
    // Properties
    private final String time_zone;
    private final int initial_hour;
    private final int final_hour;

    /**
     * Constructor.
     * @param time_zone : Time zone of the time frame. Example: "MO".
     * @param initial_hour : Initial hour of the time frame. Example: "10:00".
     * @param final_hour : Schedule of the employee. Example: "12:00".
     */
    public TimeFrame(String time_zone, int initial_hour, int final_hour) {
        this.time_zone = time_zone;
        this.initial_hour = initial_hour;
        this.final_hour = final_hour;
    }

    /**
     * Getter.
     * @return time_zone: Time zone of the time frame.
     */
    public String getTime_zone() {
        return time_zone;
    }

    /**
     * Getter.
     * @return initial_hour: Initial hour of the time frame.
     */
    public int getInitial_hour() {
        return initial_hour;
    }

    /**
     * Getter.
     * @return final_hour: Final hour of the time frame.
     */
    public int getFinal_hour() {
        return final_hour;
    }

}
