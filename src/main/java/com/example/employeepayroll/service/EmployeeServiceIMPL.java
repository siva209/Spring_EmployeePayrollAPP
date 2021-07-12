package com.example.employeepayroll.service;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.exception.EmployeeException;
import com.example.employeepayroll.model.EmployeePayrollData;
import com.example.employeepayroll.repository.IEmployeeRepository;
@Service
public class EmployeeServiceIMPL implements IEmployeeService{
	@Autowired
	IEmployeeRepository employeeRepository;

	@Override
	public List<EmployeePayrollData> getEmployeePayrolldata() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeepayrollDataById(int empId) throws EmployeeException {
		return employeeRepository
				.findById(empId)
				.orElseThrow( () -> new EmployeeException("Employee with employeeId" + empId + "does not exist "));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData=new EmployeePayrollData();
		BeanUtils.copyProperties(empPayrollDTO,empData);
		System.out.println(empData);
		return employeeRepository.save(empData);
		
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) throws EmployeeException {
		EmployeePayrollData empdata=this.getEmployeepayrollDataById(empId);
		empdata.setName(employeePayrollDTO.getName());
		empdata.setSalary(employeePayrollDTO.getSalary());
		empdata.setGender(employeePayrollDTO.getGender());
		empdata.setNote(employeePayrollDTO.getNote());
		empdata.setStartDate(employeePayrollDTO.getStartDate());
		empdata.setDepartment(employeePayrollDTO.getDepartment());
		employeeRepository.save(empdata);
		return employeeRepository.findById(empId).get()	;	
	}

	@Override
	public void deleteEmployeeById(int empId) throws EmployeeException {
		EmployeePayrollData empdata=this.getEmployeepayrollDataById(empId);
		employeeRepository.delete(empdata);
		
	}

	@Override
	public List<EmployeePayrollData> getEmployeeByDepartment(String department) throws EmployeeException{
		List<EmployeePayrollData> empdata=this.getEmployeeByDepartment(department);
		return employeeRepository.findEmployeeByDepartment(department);
		
	}
}