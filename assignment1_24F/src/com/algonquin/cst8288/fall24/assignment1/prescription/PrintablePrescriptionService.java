package com.algonquin.cst8288.fall24.assignment1.prescription;

import com.algonquin.cst8288.fall24.assignment1.patient.*;
import com.algonquin.cst8288.fall24.assignment1.treatment.*;

/**
 * 
 * PrintablePrescriptionService which creates a txt file for patient data
 * 
 */

public class PrintablePrescriptionService implements PrescriptionService {

    @Override
    public String generatePrescription(Patient patient) {
        StringBuilder txtPrescription = new StringBuilder();

        txtPrescription.append("--Patient Data--\n")
                       .append("Patient Name: ").append(patient.getName()).append("\n")
                       .append("Date of Birth: ").append(patient.getDateOfBirth()).append("\n")
                       .append("Diagnose: ").append(patient.getPlannedTreatment()).append("\n");

        if (patient instanceof Inpatient) {
            Inpatient inPatient = (Inpatient) patient;
            txtPrescription.append("Rx:").append(inPatient.getRoomNumber()).append("\n");
        }
        else if (patient instanceof Outpatient) {
            Outpatient OutPatient = (Outpatient) patient;
            txtPrescription.append("Next App.:").append(OutPatient.getAppointmentDate()).append("\n");
        }
        
        txtPrescription.append("Details:\n");
        TreatmentPlan treatmentPlan = new SurgeryTreatmentPlan();
        String treatmentPlanDetails = treatmentPlan.createTreatmentPlan(patient);
        txtPrescription.append(treatmentPlanDetails).append("\n");

        return txtPrescription.toString();
    }
}