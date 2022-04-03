package controllers;

import models.Employee;
import models.TimeFrame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains the methods used to solve the exercise.
 *
 * @author Ricardo Vaca P.
 * @version 2022/02
 */
public class EmployeesController {
    /**
     * ArrayList of Employee class objects.
     * The employees found in the file with the list of employees will be stored here.
     */
    static ArrayList<Employee> listOfEmployees = new ArrayList<Employee>();

    /**
     * Method that initializes the app.
     */
    public static void start() {
        readEmployeesTextFile(listOfEmployees);
        compareEmployeesSchedules(listOfEmployees);
    }

    /**
     * This method is used to store the available employees in the .txt file
     * in the previously declared variable "listOfEmployees".
     *
     * @param listOfEmployees : ArrayList of Employee class objects.
     */
    public static void readEmployeesTextFile(ArrayList<Employee> listOfEmployees) {
        try {
            File employees = new File("employees-list.txt");
            Scanner fileReader = new Scanner(employees);
            while (fileReader.hasNextLine()) {
                String employee = fileReader.nextLine();
                addEmployeesToList(employee, listOfEmployees);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method creates a new instance of the "Employee" object with the data obtained
     * from the text string "employee".
     * Once created, the new instance is stored in the employee array.
     *
     * @param employee        : Employee that will be added to the array of employees called "listOfEmployees".
     * @param listOfEmployees : ArrayList of Employee class objects.
     */
    public static void addEmployeesToList(String employee, ArrayList<Employee> listOfEmployees) {
        // Extracting the name and the schedule from the param "employee"
        String[] employeeData = employee.split("=", 2);
        String employeeName = employeeData[0];
        String employeeSchedule = employeeData[1];
        // Creating new Models.Employee instance
        Employee newEmployee = new Employee(employeeName, employeeSchedule);
        // Add the new employee to the list
        listOfEmployees.add(newEmployee);
    }

    /**
     * This method iterates through the list of employees, checking if the employees match
     * in some time frame. If some coincide, the name of these two employees and the number of times
     * their schedules coincide will be returned through a console message.
     *
     * @param listOfEmployees : List with employees.
     */
    public static void compareEmployeesSchedules(ArrayList<Employee> listOfEmployees) {
        int numberOfMatchesOfTimeFrames = 0;
        for (int i = 0; i < listOfEmployees.size(); i++) {
            for (int j = i + 1; j < listOfEmployees.size(); j++) {
                Employee employeeOne = listOfEmployees.get(i);
                Employee employeeTwo = listOfEmployees.get(j);
                for (String[] timeFramesOfEmployeeOne : employeeOne.getArrOfTimeFrames()) {
                    for (String[] timeFramesOfEmployeeTwo : employeeTwo.getArrOfTimeFrames()) {
                        if (compareTwoTimeFrames(timeFramesOfEmployeeOne, timeFramesOfEmployeeTwo))
                            numberOfMatchesOfTimeFrames++;
                    }
                }
                System.out.println(employeeOne.getName() + "-" + employeeTwo.getName() + "=" + numberOfMatchesOfTimeFrames);
                numberOfMatchesOfTimeFrames = 0;
            }
        }
    }

    /**
     * This method compares two time frames and returns a boolean true if they match
     * or are within each other. Otherwise, it returns a boolean value of false.
     *
     * @param timeFrame     : Array with one time frame.
     * @param nextTimeFrame : Array with another one time frame.
     * @return isValid : Boolean value that return true if the time frames match.
     */
    public static boolean compareTwoTimeFrames(String[] timeFrame, String[] nextTimeFrame) {
        boolean isValid = false;
        // Create two new instances of Models.TimeFrame class
        TimeFrame timeFrameOne = getNewTimeFrame(timeFrame);
        TimeFrame timeFrameTwo = getNewTimeFrame(nextTimeFrame);
        // Comparing the time frames
        if (timeFrameOne.getTime_zone().equals(timeFrameTwo.getTime_zone())) {
            if (String.valueOf(timeFrameOne.getInitial_hour()).length() == String.valueOf(timeFrameTwo.getInitial_hour()).length()) {
                if (timeFrameOne.getInitial_hour() >= timeFrameTwo.getInitial_hour()) {
                    if (timeFrameOne.getFinal_hour() >= timeFrameTwo.getFinal_hour()) {
                        isValid = true;
                    } else {
                        isValid = true;
                    }
                } else {
                    if (timeFrameTwo.getFinal_hour() >= timeFrameOne.getFinal_hour()) {
                        isValid = true;
                    } else {
                        isValid = true;
                    }
                }
            }
        }
        return isValid;
    }

    /**
     * This method is responsible for creating a new "TimeFrame" object.
     *
     * @param timeFrame : String containing the information needed to create a new TimeFrame.
     * @return new TimeFrame object.
     */
    public static TimeFrame getNewTimeFrame(String[] timeFrame) {
        /*
            Defines the time zone of the time frame.
            Example: "MO".
         */
        String timeZone = timeFrame[0].replaceAll("[^a-zA-Z].*", "");
        /*
            Defines the initial time of the time frame: "10:00-12:00" -> "10:00".
         */
        String initialTimeFrame = timeFrame[0];
        /*
            Defines the final time of the time frame: "10:00-12:00" -> "12:00".
         */
        String finalTimeFrame = timeFrame[1];
        /*
            Remove the "-" from the initial and final time of the time frame:
            Example: "10:00-12:00" to "1000" and "1200".
         */
        int initialHourOfTimeFrame = Integer.parseInt(initialTimeFrame.replaceAll("[^0-9]", ""));
        int finalHourOfTimeFrame = Integer.parseInt(finalTimeFrame.replaceAll("[^0-9]", ""));
        return new TimeFrame(timeZone, initialHourOfTimeFrame, finalHourOfTimeFrame);
    }
}
