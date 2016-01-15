package com.example.domain;

import com.fasterxml.jackson.annotation.JsonView;

public class Person {

	@JsonView(Views.Summary.class)
	private String firstName;

	@JsonView(Views.Summary.class)
	private String lastName;

	@JsonView(Views.Normal.class)
	private String address;

	@JsonView(Views.Full.class)
	private String bio;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Person{" + "firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", address='" + address + '\'' +
				", bio='" + bio + '\'' +
				'}';
	}
}
