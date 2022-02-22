package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	
	private ArrayList<String> patientNotes;
	private int userId;
	private int userPin;
	
	public Physician(int id) {
		super(id);
		this.patientNotes = new ArrayList<String>();
		this.setUserId(id);

	}

	public boolean assignPin(int pin) {
		if(pin>999 && pin<10000){
	        this.setUserPin(pin);
	        return true;
	    }
	    	return false;
	}

	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.userId == confirmedAuthID) {
			return true;
		}
		return false;
	}
	
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
		
	}
		
	public int getUserPin() {
		return userPin;
	}

	public void setUserPin(int userPin) {
		this.userPin = userPin;
	}


}
