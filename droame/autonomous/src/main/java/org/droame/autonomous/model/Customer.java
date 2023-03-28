package org.droame.autonomous.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")

public class Customer {
	 private long id;
	    private String name;
	    private String emailId;
	    private String phoneNumber;
	    private String address;
	    private String city;
	    private String state;
	    private String pincode;

	    public Customer() {
	    	
	    }
	    public Customer(String name, String emailId, String phoneNumber, String address, String city, String state, String pincode) {
	    	this.name = name;
	    	this.emailId = emailId;
	    	this.phoneNumber = phoneNumber;
	    	this.address = address;
	    	this.city = city;
	    	this.state = state;
	    	this.pincode = pincode;
	       }
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		
	    
		@Column(name = "name", nullable = false)
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	    @Column(name = "email_id", nullable = false)
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		
	    @Column(name = "phone_number", nullable = false)
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
	    @Column(name = "address", nullable = false)
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
	    @Column(name = "city", nullable = false)
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		
	    @Column(name = "state", nullable = false)
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		
	    @Column(name = "pincode", nullable = false)
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		@Override
		public String toString() {
			return "Customer [id=" + id + ", name=" + name + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber
					+ ", address=" + address + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
		}
		
	    
	  
	    
}
