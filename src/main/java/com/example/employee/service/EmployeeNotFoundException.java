package com.example.employee.service;

public class EmployeeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
