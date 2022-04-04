package controllers;

import models.Employee;
import models.TimeFrame;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesControllerTest {

    @org.junit.jupiter.api.Test
    void start() {
        EmployeesController.start();
    }

    @org.junit.jupiter.api.Test
    void readEmployeesTextFile() {
        ArrayList<Employee> listOfEmployees = new ArrayList<Employee>();
        String fileNameToOpen = "employees-list.txt";
        EmployeesController.readEmployeesTextFile(listOfEmployees, fileNameToOpen);
    }

    @org.junit.jupiter.api.Test
    void addEmployeesToList() {
        ArrayList<Employee> listOfEmployees = new ArrayList<Employee>();
        String employee = "ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00";
        EmployeesController.addEmployeesToList(employee, listOfEmployees);
    }

    @org.junit.jupiter.api.Test
    void compareEmployeesSchedules() {
        ArrayList<Employee> listOfEmployees = new ArrayList<Employee>();
        Employee employee = new Employee("Ricardo", "MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00");
        Employee otherEmployee = new Employee("Ricardo", "MO10:00-12:00,TH12:00-14:00,SU20:00-21:00");
        listOfEmployees.add(employee);
        listOfEmployees.add(otherEmployee);
        assertEquals("Ricardo-Ricardo=2",EmployeesController.compareEmployeesSchedules(listOfEmployees));
    }

    @org.junit.jupiter.api.Test
    void compareTwoTimeFrames() {
        String[] timeFrame = {"MO10:00", "12:00"};
        String[] otherTimeFrame = {"MO10:00", "12:00"};
        assertTrue(EmployeesController.compareTwoTimeFrames(timeFrame, otherTimeFrame));
    }

    @org.junit.jupiter.api.Test
    void getNewTimeFrame() {
        String[] timeFrame = {"MO10:00", "12:00"};
        TimeFrame timeFrameResult = new TimeFrame("MO", 1000,1200);
        String timeZoneOfResultTimeFrame = timeFrameResult.getTime_zone();
        int initialHourOfResultTimeFrame = timeFrameResult.getInitial_hour();
        int finalHourOfResultTimeFrame = timeFrameResult.getFinal_hour();
        assertEquals( timeZoneOfResultTimeFrame ,EmployeesController.getNewTimeFrame(timeFrame).getTime_zone());
        assertEquals( initialHourOfResultTimeFrame, EmployeesController.getNewTimeFrame(timeFrame).getInitial_hour());
        assertEquals( finalHourOfResultTimeFrame, EmployeesController.getNewTimeFrame(timeFrame).getFinal_hour());
    }
}