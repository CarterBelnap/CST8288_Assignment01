package com.algonquin.cst8288.fall24.assignment1.prescription;

import com.algonquin.cst8288.fall24.assignment1.patient.*;
import com.algonquin.cst8288.fall24.assignment1.treatment.*;

/**
 * 
 * Online prescription file which creates an html file to show patient data 
 * 
 */

public class OnlinePrescriptionService implements PrescriptionService {

    @Override
    public String generatePrescription(Patient patient) {
        StringBuilder htmlPrescription = new StringBuilder();
        MedicationTreatmentPlan medicationTreatmentPlan = new MedicationTreatmentPlan();
        SurgeryTreatmentPlan surgeryTreatmentPlan = new SurgeryTreatmentPlan();

        htmlPrescription.append("<html>\n")
                        .append("<body>\n")
                        .append("<h1>Patient Data</h1>\n")
                        .append("<p><strong>Patient Name:</strong> ").append(patient.getName()).append("</p>\n")
                        .append("<p><strong>Date of Birth:</strong> ").append(patient.getDateOfBirth()).append("</p>\n")
                        .append("<p><strong>Diagnose:</strong> ").append(patient.getPlannedTreatment()).append("</p>\n");

        if (patient instanceof Inpatient) {
            Inpatient inPatient = (Inpatient) patient;
            htmlPrescription.append("<p><strong>Rx: </strong>").append(inPatient.admit()).append("</p>\n");
            htmlPrescription.append(medicationTreatmentPlan.createTreatmentPlan(inPatient));
        }
        else if (patient instanceof Outpatient) {
            Outpatient OutPatient = (Outpatient) patient;
            
            htmlPrescription.append("<p><strong>Next App.: </strong>").append(OutPatient.getAppointmentDate()).append("</p>\n");
            htmlPrescription.append(surgeryTreatmentPlan.createTreatmentPlan(OutPatient));
        }

        htmlPrescription.append("</body>\n")
                        .append("</html>");

        return htmlPrescription.toString();
    }
}
