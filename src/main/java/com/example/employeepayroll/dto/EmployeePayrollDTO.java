package com.example.employeepayroll.dto;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class EmployeePayrollDTO {
	@Pattern(regexp = "^[A-Z][a-zA-z\\s]{2,}$", message = "Employee name invalid")
	public String name;
	@Min(value = 1000, message = "Minimum wage should be atleast 500")
	public double salary;
	@Pattern(regexp = "Male|Female", message = "Gender needs to be Male or Female")
	public String gender;
	@JsonFormat(pattern = "dd MMM yyyy")
	@NotNull(message = "Start date cannot be empty")
	@PastOrPresent(message = "Startdate cannot be a future date")
	public String startDate;
	@NotBlank(message = "Note cannot be blank")
	public String note;
	@NotNull(message = "Department should not be empty")
	public List<String> department;
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
		return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + ", gender=" + gender + ", startDate="
				+ startDate + ", note=" + note + ", department=" + department + "]";
	}


}
