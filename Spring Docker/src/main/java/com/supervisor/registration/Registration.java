package com.supervisor.registration;

public class Registration {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String supervisor;
	
	public Registration(String firstName, String lastName, String email, String phoneNumber, String supervisor) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.supervisor=supervisor;
	}
	
	public void submit() {
		System.out.print("First Name: " + firstName + ", Last Name: " + lastName);
		if(email != null)
			System.out.print(", Email: " + email);
		if(phoneNumber != null)
			System.out.print(", Phone: " + phoneNumber);
		System.out.println(", Supervisor: " + supervisor);
		return;
	}
}
