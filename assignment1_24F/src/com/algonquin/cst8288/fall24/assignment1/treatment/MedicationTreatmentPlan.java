package com.algonquin.cst8288.fall24.assignment1.treatment;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;


/**
 * 
 * This class is responsible for implementing the business logic related to generating a treatment plan. Specifically Treatments.
 * 
 * */

public class MedicationTreatmentPlan implements TreatmentPlan {

    @Override
    public String createTreatmentPlan(Patient patient) {
        // Using patient's life stage (which corresponds to the age group)
        String lifeStage = patient.getLifeStage();  // CHILD, YOUTH, ADULT
        String conditionType = patient.getPlannedTreatment();  // Acute, Infection, Chronic

        // Determine number of doses per day based on life stage
        int dosesPerDay = getDosesPerDay(lifeStage);
        // Determine type of medication based on condition type
        String medicationType = getMedicationType(conditionType);
        // Determine duration of treatment based on condition type
        int duration = getTreatmentDuration(conditionType);
        
        StringBuilder plan = new StringBuilder();
        plan.append("Medication Treatment Plan:\n")
            .append("Patient Life Stage: ").append(lifeStage).append(".\n")
            .append("Doses per day: ").append(dosesPerDay).append(".\n")
            .append("Duration: ").append(duration).append(" days.\n")
            .append("Medication: ").append(medicationType).append(".");

        return plan.toString();
    }
    
    // Determines the number of doses per day based on life stage (age group)
    private int getDosesPerDay(String lifeStage) {
        switch (lifeStage.toUpperCase()) {
            case "CHILD":
                return 1;
            case "YOUTH":
                return 2;
            case "ADULT":
                return 3;
            default:
                throw new IllegalArgumentException("Unknown life stage: " + lifeStage);
        }
    }

    // Determines the duration of the treatment based on the condition type
    private int getTreatmentDuration(String conditionType) {
        switch (conditionType.toUpperCase()) {
            case "ACUTE":
                return 7;
            case "INFECTION":
                return 14;
            case "CHRONIC":
                return 180;
            default:
                throw new IllegalArgumentException("Unknown condition type: " + conditionType);
        }
    }

    // Determines the type of medication based on the condition
    private String getMedicationType(String conditionType) {
        switch (conditionType.toUpperCase()) {
            case "ACUTE":
                return "No Medication";
            case "INFECTION":
                return "Antibiotics";
            case "CHRONIC":
                return "Specialized Medication";
            default:
                throw new IllegalArgumentException("Unknown condition type: " + conditionType);
        }
    }
}