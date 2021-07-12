package com.example.employeepayroll.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.dto.ResponseDTO;
import com.example.employeepayroll.exception.EmployeeException;
import com.example.employeepayroll.model.EmployeePayrollData;
import com.example.employeepayroll.service.IEmployeeService;


@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	@Autowired
	private IEmployeeService empService;
	@GetMapping(value="/get")
	public ResponseEntity<ResponseDTO> getAllEmployeeData(){
		List<EmployeePayrollData> empList = empService.getEmployeePayrolldata();
		System.out.println(empList);
		ResponseDTO respDTO = new ResponseDTO("Details of all Employees :", empList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeeDataById(@PathVariable("empId") int empId) throws EmployeeException{
		EmployeePayrollData employee = empService.getEmployeepayrollDataById(empId);
		ResponseDTO respDTO = new ResponseDTO("Employee Details of employee with Id : "+ empId, employee);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO>createEmployeePayrollData( @RequestBody  EmployeePayrollDTO empPayrollDTO)throws EmployeeException{
		EmployeePayrollData employee = empService.createEmployeePayrollData(empPayrollDTO);

		ResponseDTO respDTO = new ResponseDTO("Added Employee", employee);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO>updateEmployeePayrollData( @PathVariable int empId, @RequestBody EmployeePayrollDTO   employeePayrollDTO) throws EmployeeException{
		EmployeePayrollData employee = empService.updateEmployeePayrollData(empId, employeePayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Employee ", employee);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@GetMapping("/department/{department}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable ("department") String department) throws EmployeeException{
		List<EmployeePayrollData>empDataList=null;
		empDataList=empService.getEmployeeByDepartment(department);
		ResponseDTO respDTO=new ResponseDTO();
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeeById(@PathVariable("empId") int empId) throws EmployeeException{
		empService.deleteEmployeeById(empId);
		ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", empId);
		return new ResponseEntity<>(respDTO, HttpStatus.OK);
	}
	
}