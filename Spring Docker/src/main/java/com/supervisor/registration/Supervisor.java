package com.supervisor.registration;

public class Supervisor implements Comparable<Supervisor>{
	private String jurisdiction;
	private String lastName;
	private String firstName;
	
	public Supervisor(String jurisdiction, String lastName, String firstName) {
		this.jurisdiction=jurisdiction;
		this.lastName=lastName;
		this.firstName=firstName;
	}
	
	@Override
	public String toString() {
		return jurisdiction + " - " + lastName + ", " + firstName;
	}

	//Sorts alphabetically by jurisdiction, then last name, then first name, ignoring case.
	@Override
	public int compareTo(Supervisor s) {
		if (!jurisdiction.equalsIgnoreCase(s.jurisdiction))
			return jurisdiction.compareToIgnoreCase(s.jurisdiction);
		else if(!lastName.equalsIgnoreCase(s.lastName))
			return lastName.compareToIgnoreCase(lastName);
		else
			return firstName.compareToIgnoreCase(firstName);
	}
}
