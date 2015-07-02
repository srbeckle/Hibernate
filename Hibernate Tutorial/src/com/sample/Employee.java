package com.sample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity(name="Employee")
public class Employee 
{
	@Id
	int employeeID;
	@Column(name="firstname")
	String firstName;
	@Column(name="lastname")
    String lastName;
	@Column(name="ssn")
    String ssn;
	@Column(name="yearsservice")
    int yearsService;
 
    public int getYearsService() {
		return yearsService;
	}
	public void setYearsService(int yearsService) {
		this.yearsService = yearsService;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String name) {
        this.firstName = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String surname) {
        this.lastName = surname;
    }
    public String getSSN() {
        return ssn;
    }
    public void setSSN(String ssn) {
        this.ssn = ssn;
    }
    
    
}
