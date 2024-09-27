package com.algonquin.cst8288.fall24.assignment1.management;

import com.alognquin.cst8288.fall24.assignment1.Constants;

public class PatientLifeStage {
	
	/**
	 * Determine life stage based on age
	 * 
	 * @param age
	 * @return
	 */
	public String determineLifeStage(long age) {
		
		return (age <= 6) ? Constants.CHILD : 
     	   (age <= 18) ? Constants.YOUTH : 
     		  Constants.ADULT;   
	}
	
}
