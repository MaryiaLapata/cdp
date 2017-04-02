package com.epam.cdp.userManagement.model;

public class Address {
	
	private long id;	
	private String city;
	private String street;
	private int houseNumber;
	private int flatNumber;
	
	public Address(){}
	
	public Address(long id){
		this.id = id;
	}
	
	public Address(String city, String street, int houseNumber, int flatNumber){
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
		this.flatNumber = flatNumber;
	}
	
	public Address(long id, String city, String street, int houseNumber, int flatNumber){
		this.id = id;
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
		this.flatNumber = flatNumber;
	}	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public int getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}
	
}
