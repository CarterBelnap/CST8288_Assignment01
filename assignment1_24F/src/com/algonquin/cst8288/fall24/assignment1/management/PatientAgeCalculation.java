package com.algonquin.cst8288.fall24.assignment1.management;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class PatientAgeCalculation {

	/**
	 * Calculate patient age based on date of birth
	 * 
	 * @param dob
	 * @return
	 */
	public long calulatePatientAge(String dob) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(dob, formatter);
		
        LocalDate currentDate = LocalDate.now();
        long age = Period.between(dateOfBirth, currentDate).getYears();
        
        return age;
      
	}
	
}
