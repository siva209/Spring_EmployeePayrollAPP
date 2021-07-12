package com.example.employeepayroll.service;

import java.util.List;

import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.exception.EmployeeException;
import com.example.employeepayroll.model.EmployeePayrollData;

public interface IEmployeeService {
	List<EmployeePayrollData> getEmployeePayrolldata();
	EmployeePayrollData getEmployeepayrollDataById(int empId) throws EmployeeException;
	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO)throws EmployeeException;
	EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO) throws EmployeeException;
	void deleteEmployeeById(int empId) throws EmployeeException;
	List<EmployeePayrollData> getEmployeeByDepartment(String department)throws EmployeeException;
	
	
}
