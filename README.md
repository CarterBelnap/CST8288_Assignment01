CST8288 Assignment01:

Carter Belnap - 041128249 - beln0004@algonquinlive.com

Focused on applying UML and SOLID principles to existing code regarding patients and their treatment plans.

There are seven main files to focus on;
1. Patient.java: A base class representing a generic patient.
2. Inpatient.java: A subclass of Patient representing patients who are admitted to the hospital.
3. Outpatient.java: A subclass of Patient representing patients who visit the hospital but are not admitted.
4. TreatmentPlan.java: Interface defining the treatment plan for patient.
5. PrescriptionService.java: Interface defining prescription generation mechanism
6. PatientManagement.java: The controller class of the application.
7. Physician: The main program to execute the application

Part I: Breaking down PatientManagement.java (the controller) to appeal to the Single Responsibility Principle, separating it into five separate files dealing with validation,
age calculation, determining life stage, creating prescriptions, and creating treatment plans.

Part II: Refactored InPatient.java/OutPatient.java/Patient.Java to adhere to the Liskov Substitution Principle, specifically the admit() method. 

Part III: Refactored PatientManagement.java to follow Dependancy Inversion Principle.

Part IV: Created MedicationTreatmentPlan.java and SurgeryTreatmentPlan.java, which both implement TreatmentPlan.java and get their necessary variables depending on whether the patient needs surgery or medication. Specifically following the business rules provided.

Part V: Implemented OnlinePrescriptionService.java and PrintablePrescriptionService.java to print out data regarding each patient. I used a StringBuilder to achieve this.

Part VI: Implemented Physician.java which serves as the main file, using two patients and their data, John Doe and Jane Smith. Create the files stated in part V.

Also created two JUnit files, named SurgeryJUnitTests.java and TreatmentJUnitTests.java. Which both test the data stated in the business rules given.
