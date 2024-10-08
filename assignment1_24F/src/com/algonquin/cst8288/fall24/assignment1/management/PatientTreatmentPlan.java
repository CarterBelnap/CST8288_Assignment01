package com.algonquin.cst8288.fall24.assignment1.management;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;
import com.algonquin.cst8288.fall24.assignment1.treatment.SurgeryTreatmentPlan;
import com.algonquin.cst8288.fall24.assignment1.treatment.TreatmentPlan;

public class PatientTreatmentPlan {

	/**
	 * Create treatment plan
	 * 
	 * @param patient
	 */
	public void createTreatmentPlan(Patient patient, TreatmentPlan treatment, PatientAgeCalculation patientAge, PatientLifeStage patientLifeStage) {
		patient.setAge(patientAge.calculatePatientAge(patient.getDateOfBirth()));
		patient.setLifeStage(patientLifeStage.determineLifeStage(patient.getAge()));
		treatment.createTreatmentPlan(patient);
		
	}

}
