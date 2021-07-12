package com.example.employeepayroll.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.employeepayroll.dto.ResponseDTO;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;



@ControllerAdvice
public class EmployeePayrollExceptionHandler{
	private static final String message ="Exception while processing REST Request";
	
//	@ExceptionHandler(HttpMessageNotReadableException.class)
//	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
//		ResponseDTO responseDTO=new ResponseDTO(message, "should have date in the format at dd MM yyyy");
//		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
//	}
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ResponseDTO> handleEmployeeException (EmployeeException exception){
		ResponseDTO respDTO = new ResponseDTO("Exception occured", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.BAD_REQUEST);	
	}
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
		ResponseDTO respDTO = new ResponseDTO("Exception occured", "Should have date in the format dd MMM yyyy");
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.BAD_REQUEST);
	}
}
