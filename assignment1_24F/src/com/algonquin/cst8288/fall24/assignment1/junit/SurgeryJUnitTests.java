package com.algonquin.cst8288.fall24.assignment1.junit;


import static org.junit.jupiter.api.Assertions.*;
import com.algonquin.cst8288.fall24.assignment1.patient.*;
import com.algonquin.cst8288.fall24.assignment1.treatment.SurgeryTreatmentPlan;
import org.junit.jupiter.api.Test;

public class SurgeryJUnitTests {

    @Test
    void testSurgeryTreatmentForChild() {
        Patient childPatient = new Inpatient("1", "Child Patient", "child@email.com", "213-123-432", "2018-05-10", "2024-09-25");
        childPatient.setAge(5);

        SurgeryTreatmentPlan surgeryTreatmentPlan = new SurgeryTreatmentPlan();
        String result = surgeryTreatmentPlan.createTreatmentPlan(childPatient);

        assertTrue(result.contains("High"));
        assertTrue(result.contains("No Fasting"));
        assertTrue(result.contains("Next Day"));
    }

    @Test
    void testSurgeryTreatmentForYouth() {
        Patient youthPatient = new Outpatient("2", "Youth Patient", "youth@email.com", "987654321", "2007-05-10", "2024-10-07");
        youthPatient.setAge(15);

        SurgeryTreatmentPlan surgeryTreatmentPlan = new SurgeryTreatmentPlan();
        String result = surgeryTreatmentPlan.createTreatmentPlan(youthPatient);

        assertTrue(result.contains("Medium"));
        assertTrue(result.contains("Fasting 2 Hours Before"));
        assertTrue(result.contains("In a Week"));
    }

    @Test
    void testSurgeryTreatmentForAdult() {
        Patient adultPatient = new Outpatient("3", "Adult Patient", "adult@email.com", "987654321", "1980-05-10", "2024-11-04");
        adultPatient.setAge(40);

        SurgeryTreatmentPlan surgeryTreatmentPlan = new SurgeryTreatmentPlan();
        String result = surgeryTreatmentPlan.createTreatmentPlan(adultPatient);

        assertTrue(result.contains("Low"));
        assertTrue(result.contains("Fasting 8 Hours Before"));
        assertTrue(result.contains("In a Month"));
    }
}