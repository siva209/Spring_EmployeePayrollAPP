package com.example.employeepayroll.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.example.employeepayroll.dto.EmployeePayrollDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "employee_payroll")
public  class EmployeePayrollData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="name")
	private String name;
	private double salary;
	private String gender;
	private String startDate;
	private String note;
	
	
	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
	private List<String> department;
	public EmployeePayrollData(){
	}
	public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.updateEmployeePayrolldata(empPayrollDTO);
	}
	private void updateEmployeePayrolldata(EmployeePayrollDTO empPayrollDTO) {
		this.name=empPayrollDTO.name;
		this.salary=empPayrollDTO.salary;
		this.gender=empPayrollDTO.gender;
		this.note=empPayrollDTO.note;
		this.startDate=empPayrollDTO.startDate;
		this.department=empPayrollDTO.department;
		
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<String> getDepartment() {
		return department;
	}
	public void setDepartment(List<String> department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "EmployeePayrollData [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", gender="
				+ gender + ", startDate=" + startDate + ", note=" + note + ", department=" + department + "]";
	}
	public EmployeePayrollData(int employeeId, EmployeePayrollDTO empPayrollDTO, int empId) {
		super();
		this.employeeId = empId;
		this.name = empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
		this.gender = empPayrollDTO.gender;
		this.startDate = empPayrollDTO.startDate;
		this.note = empPayrollDTO.note;
		this.department =empPayrollDTO. department;
	}
	
}
