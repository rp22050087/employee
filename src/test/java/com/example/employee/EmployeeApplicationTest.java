package com.example.employee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.employee.controller.EmployeeController;

@SpringBootTest
class EmployeeApplicationTest {
	
	@Autowired
	private EmployeeController controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
