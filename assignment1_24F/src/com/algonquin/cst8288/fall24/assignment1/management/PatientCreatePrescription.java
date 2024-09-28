package com.algonquin.cst8288.fall24.assignment1.management;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;
import com.algonquin.cst8288.fall24.assignment1.prescription.OnlinePrescriptionService;
import com.algonquin.cst8288.fall24.assignment1.prescription.PrescriptionService;

public class PatientCreatePrescription {

	/**
	 * Create prescription
	 * 
	 * @param patient
	 * @param filename
	 * @throws IOException
	 */
	public void generatePrescription(Patient patient, String filename, PrescriptionService prescriptionService) throws IOException {
		BufferedWriter bwriter;
		bwriter = new BufferedWriter(new FileWriter(filename));	
		bwriter.write(prescriptionService.generatePrescription(patient));
		bwriter.close();
	}

}
