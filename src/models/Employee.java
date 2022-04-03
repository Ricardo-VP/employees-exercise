package models;

import java.util.ArrayList;

/**
 * This class defines the properties and methods for the object: Employee.
 * @author Ricardo Vaca P.
 * @version 2022/02
 */
public class Employee {
    // Properties
    private final String name;
    private final String schedule;
    protected String[] arr_of_time_frames;

    /**
     * Constructor.
     * @param name : Name of the employee. Example: "Ricardo V".
     * @param schedule : Schedule of the employee. Example: "MO10:00-12:00,TH12:00-14:00,SU20:00-21:00".
     */
    public Employee(String name, String schedule) {
        this.name = name;
        this.schedule = schedule;
        setArrOfTimeFrames();
    }

    /**
     * Getter.
     * @return name: Name of the employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Defines the value of the "arr_of_time_frames" property based on the "schedule" property by
     * creating an array of time frames separated by ",".
     * For example:
     *      "MO10:00-12:00,TH12:00-14:00,SU20:00-21:00"
     * to
     *      ["MO10:00-12:00", "TH12:00-14:00", "SU20:00-21:00"]
     */
    public void setArrOfTimeFrames() {
        this.arr_of_time_frames = this.schedule.split(",", 0);
        formatArrOfTimeFrames();
    }

    /**
     * Remove any blank spaces that may exist in elements of the time frame array.
     * For example:
     *      "MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00- 21:00"
     * to
     *      "MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00"
     */
    public void formatArrOfTimeFrames() {
        for (int i = 0; i < this.arr_of_time_frames.length; i++)
            this.arr_of_time_frames[i] = this.arr_of_time_frames[i].replace(" ", "");
    }

    /**
     * Create an ArrayList of String[] where the time frames separated by "-" are stored.
     * For example:
     *      ["MO10:00-12:00", "TH12:00-14:00", "SU20:00-21:00"]
     * to
     *      [
     *          ["MO10:00", "12:00"],
     *          ["TH12:00", "14:00"],
     *          ["SU20:00", "21:00"]
     *      ]
     * @return arrOfFormattedTimeFrames
     */
    public ArrayList<String[]> getArrOfTimeFrames() {
        ArrayList<String[]> arrOfFormattedTimeFrames = new ArrayList<String[]>();
        for (String timeFrame : this.arr_of_time_frames)
            arrOfFormattedTimeFrames.add(timeFrame.split("-"));
        return arrOfFormattedTimeFrames;
    }

}
