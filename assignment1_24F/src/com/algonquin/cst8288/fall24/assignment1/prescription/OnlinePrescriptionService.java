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

        // Start HTML document
        htmlPrescription.append("<html>\n")
                        .append("<body>\n")
                        .append("<h1>Patient Data</h1>\n")
                        .append("<p><strong>Patient Name:</strong> ").append(patient.getName()).append("</p>\n")
                        .append("<p><strong>Date of Birth:</strong> ").append(patient.getDateOfBirth()).append("</p>\n")
                        .append("<p><strong>Diagnose:</strong> ").append(patient.getPlannedTreatment()).append("</p>\n");

        if (patient instanceof Inpatient) {
            Inpatient inPatient = (Inpatient) patient;
            htmlPrescription.append("<p><strong>Rx: </strong>").append(inPatient.getRoomNumber()).append("</p>\n");
        }
        htmlPrescription.append("<p><strong>Details:</strong></p> \n");
        TreatmentPlan treatmentPlan = new SurgeryTreatmentPlan(); // Instantiate appropriate treatment plan
        String treatmentPlanDetails = treatmentPlan.createTreatmentPlan(patient);
        htmlPrescription.append("<p>").append(treatmentPlanDetails).append("</p>\n");

        // End HTML document
        htmlPrescription.append("</body>\n")
                        .append("</html>");

        return htmlPrescription.toString();
    }
}
