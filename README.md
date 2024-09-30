CST8288 Assignment01:
Focused on applying UML and SOLID principles to existing code regarding patients and their treatment plans.

There are seven main files to focus on;
1. Patient.java: A base class representing a generic patient.
2. Inpatient.java: A subclass of Patient representing patients who are admitted to the hospital.
3. Outpatient.java: A subclass of Patient representing patients who visit the hospital but are not admitted.
4. TreatmentPlan.java: Interface defining the treatment plan for patient.
5. PrescriptionService.java: Interface defining prescription generation mechanism
6. PatientManagement.java: The controller class of the application.
7. Physician: The main program to execute the application

Part I: Breaking down PatientManagement.java (the controller) to appeal to the Single Responsibility Principle, separating it into five seperate files dealing with validation,
age calculation, determining life stage, creating prescriptions, and creating treatment plans.

Part II: Refactored InPatient.java/OutPatient.java/Patient.Java to adhere to Liskov Substitution Principle, specifically the admit() method. 

Part III: 
