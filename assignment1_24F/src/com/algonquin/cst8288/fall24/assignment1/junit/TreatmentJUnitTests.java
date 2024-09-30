package com.algonquin.cst8288.fall24.assignment1.junit;


import static org.junit.jupiter.api.Assertions.*;
import com.algonquin.cst8288.fall24.assignment1.patient.*;
import com.algonquin.cst8288.fall24.assignment1.treatment.MedicationTreatmentPlan;
import org.junit.jupiter.api.Test;

public class TreatmentJUnitTests {

    @Test
    void testChildMedicationTreatment() {
        Patient childPatient = new Inpatient("1", "John Doe", "john.doe@example.com", "123456789", "2015-05-05", "B304");
        childPatient.setLifeStage("CHILD");
        childPatient.setPlannedTreatment("Infection");

        MedicationTreatmentPlan treatmentPlan = new MedicationTreatmentPlan();
        String result = treatmentPlan.createTreatmentPlan(childPatient);

        assertTrue(result.contains("1"));
        assertTrue(result.contains("14 days"));
        assertTrue(result.contains("Antibiotics"));
    }

    @Test
    void testYouthMedicationTreatment() {
        Patient youthPatient = new Inpatient("2", "Jane Doe", "jane.doe@example.com", "123456789", "2008-01-01", "X101");
        youthPatient.setLifeStage("YOUTH");
        youthPatient.setPlannedTreatment("Chronic");

        MedicationTreatmentPlan treatmentPlan = new MedicationTreatmentPlan();
        String result = treatmentPlan.createTreatmentPlan(youthPatient);

        assertTrue(result.contains("2"));
        assertTrue(result.contains("180 days"));
        assertTrue(result.contains("Specialized Medication"));
    }

    @Test
    void testAdultMedicationTreatment() {
        Patient adultPatient = new Inpatient("3", "John Smith", "john.smith@example.com", "123456789", "1980-02-20", "S215");
        adultPatient.setLifeStage("ADULT");
        adultPatient.setPlannedTreatment("Acute");

        MedicationTreatmentPlan treatmentPlan = new MedicationTreatmentPlan();
        String result = treatmentPlan.createTreatmentPlan(adultPatient);

        assertTrue(result.contains("3"));
        assertTrue(result.contains("7 days"));
        assertTrue(result.contains("No Medication"));
    }
}