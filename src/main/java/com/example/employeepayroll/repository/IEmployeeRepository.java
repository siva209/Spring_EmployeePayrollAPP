package com.example.employeepayroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.employeepayroll.model.EmployeePayrollData;
@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeePayrollData,Integer>{
	

	@Query(value = "select*from employee_payroll, employee_department where employee_id =id and department=:department",nativeQuery = true)
    
	List<EmployeePayrollData> findEmployeeByDepartment(String department);
}

