package com.spring.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="EmployeeName")
	private String employeeName;
	
	@Column(name="EmployeeAddress")
	private String employeeAddress;
	
	@Column(name="EmployeePhone")
	private String employeePhone;
	
	@Column(name="EmployeeSalary")
	private String employeeSalary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(String employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	@Override
	public String toString(){
		return "id="+id+
	",EmployeeName = "+employeeName+
	",EmployeeAddress = "+employeeAddress+
	",EmployeePhone = "+employeePhone+
	",EmployeeSalary = "+employeeSalary;
	}
}
