package api.payload;

import java.util.Date;

public class user {

	// Create POJO (Plain Old Java Object) class
	  private String firstName;
	  private String middleName;
	  private String lastName;
	  private String emailId;
	  private String gender;
	  private Date dateOfBirth;
	  private String role;
	  
	  
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date date) {
		this.dateOfBirth = date;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}   
	  
}
