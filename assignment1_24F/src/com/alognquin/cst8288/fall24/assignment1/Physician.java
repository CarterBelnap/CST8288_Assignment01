package com.alognquin.cst8288.fall24.assignment1;

import java.io.IOException;
import com.algonquin.cst8288.fall24.assignment1.patient.*;
import com.algonquin.cst8288.fall24.assignment1.prescription.*;
import com.algonquin.cst8288.fall24.assignment1.management.*;

import java.io.FileWriter;


/**
 * 
 * This class is responsible for instantiating two examples of patients OUTSIDE OF JUNIT TESTS, acts as the "main" file
 * 
 * */

public class Physician {

    public static void main(String[] args) {
        // Create two Patient objects
        Patient patient1 = new Outpatient("1", "John Doe", "john.doe@example.com", "123-456-7890", "1987-10-17", "2024-12-05");
        Patient patient2 = new Inpatient("2", "Jane Smith", "jane.smith@example.com", "098-765-4321", "2009-05-22", "B304");

        // Validate the patients
        PatientValidation validator = new PatientValidation();
        if (validator.validatePatientData(patient1) || validator.validatePatientData(patient2)) {
            System.out.println("Patient validation failed.");
            return;
        }
        
        // Assign some planned treatments
        patient1.setPlannedTreatment("Acute");
        patient2.setPlannedTreatment("Infection");

        // Utilize different patient management components
        PatientAgeCalculation ageCalculator = new PatientAgeCalculation();
        PatientLifeStage lifeStageManager = new PatientLifeStage();
        PatientTreatmentPlan treatmentPlanner = new PatientTreatmentPlan();

        // Set age and life stage for each patient
        patient1.setAge(ageCalculator.calculatePatientAge(patient1.getDateOfBirth()));
        patient1.setLifeStage(lifeStageManager.determineLifeStage(patient1.getAge()));

        patient2.setAge(ageCalculator.calculatePatientAge(patient2.getDateOfBirth()));
        patient2.setLifeStage(lifeStageManager.determineLifeStage(patient2.getAge()));

        // Create treatment plans and prescriptions
        PatientCreatePrescription prescriptionCreator = new PatientCreatePrescription();

        // For Patient 1
        System.out.println("Generating prescription for " + patient1.getName() + "\n");
        generateAndSavePrescriptions(patient1, treatmentPlanner, prescriptionCreator);

        // For Patient 2
        System.out.println("Generating prescription for " + patient2.getName() + "\n");
        generateAndSavePrescriptions(patient2, treatmentPlanner, prescriptionCreator);
        System.out.println("FILES CAN BE FOUND IN: \n" + System.getProperty("user.dir"));
    }

    public static void generateAndSavePrescriptions(Patient patient, PatientTreatmentPlan treatmentPlanner, PatientCreatePrescription prescriptionCreator) {

        // Generate prescriptions in online .html and printable .txt formats
        PrescriptionService onlineService = new OnlinePrescriptionService();
        PrescriptionService printableService = new PrintablePrescriptionService();

        String htmlPrescription = onlineService.generatePrescription(patient);
        String txtPrescription = printableService.generatePrescription(patient);

        // Save the HTML and TXT prescriptions to files
        saveToFile(patient.getName() + "_prescription.html", htmlPrescription);
        saveToFile(patient.getName() + "_prescription.txt", txtPrescription);
        
    }
    
    // Save to file using FileWriter, try catch to check for IO exception
    public static void saveToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("File saved: " + fileName + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file: " + fileName);
            e.printStackTrace();
        }
        
    }
    
}