package com.algonquin.cst8288.fall24.assignment1.treatment;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;

/**
 * 
 * This class is responsible for implementing the business logic related to generating a treatment plan. Specifically Surgery
 * 
 * */


public class SurgeryTreatmentPlan implements TreatmentPlan{

	@Override
    public String createTreatmentPlan(Patient patient) {
        long age = patient.getAge();  // Get patient's age
        String condition = patient.getPlannedTreatment();  // Planned treatment or condition

        // Determine the risk factor based on age
        String riskFactor = getRiskFactor(age);
        // Determine the fasting instructions based on age
        String fastingInstructions = getFastingInstructions(age);
        // Determine the follow-up schedule based on age
        String followUpSchedule = getFollowUpSchedule(age);

        // Use StringBuilder to construct the surgery plan summary
        StringBuilder plan = new StringBuilder();
        plan.append("The patient is diagnosed with ").append(condition)
            .append(" and requires surgery.\n")
            .append("The patient is ").append(age).append(" years old with a risk factor of ")
            .append(riskFactor).append(".\n")
            .append("Fasting instructions: ").append(fastingInstructions).append(".\n")
            .append("Follow-up schedule: ").append(followUpSchedule).append(".");

        return plan.toString();
    }

    // Determines the risk factor based on age
    private String getRiskFactor(long age) {
        if (age < 6) {
            return "High";
        } else if (age >= 6 && age <= 18) {
            return "Medium";
        } else {
            return "Low";
        }
    }

    // Determines the fasting instructions based on age
    private String getFastingInstructions(long age) {
        if (age < 6) {
            return "No Fasting";
        } else if (age >= 6 && age <= 18) {
            return "Fasting 2 Hours Before";
        } else {
            return "Fasting 8 Hours Before";
        }
    }

    // Determines the follow-up schedule based on age
    private String getFollowUpSchedule(long age) {
        if (age < 6) {
            return "Next Day";
        } else if (age >= 6 && age <= 18) {
            return "In a Week";
        } else {
            return "In a Month";
        }
    }
}
