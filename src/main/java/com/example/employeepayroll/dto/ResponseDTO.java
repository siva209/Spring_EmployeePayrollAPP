package com.example.employeepayroll.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
//@NoArgsConstructor
//@Data
public class ResponseDTO {
	private String message;
	private Object data;
	public ResponseDTO(String message, Object data) {
		this.message = message;
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResponseDTO [message=" + message + ", data=" + data + "]";
	}
	
	
}