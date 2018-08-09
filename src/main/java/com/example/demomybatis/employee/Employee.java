package com.example.demomybatis.employee;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String job;
	private String address;

	@JsonCreator
	public Employee(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, 
	@JsonProperty("age") int age, @JsonProperty("job") String job, @JsonProperty("address") String address) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.setAge(age);
		this.job = job;
		this.address = address;
	}
	
	
	public Employee( int id, String firstName, String lastName, int age, String job, String address) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.setAge(age);
		this.job = job;
		this.address = address;
	}
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


}
