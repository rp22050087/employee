/**
 * 
 */
package com.example.employee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.employee.model.Employee;


class EmployeeTest {
	
	Employee e1;

	@BeforeEach
	void setUp() throws Exception {
		e1 = new Employee();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetId() {
		long id = e1.getId();
		assertEquals(id, e1.getId());
	}

	@Test
	void testSetId() {
		long id = e1.getId();
		e1.setId(id+1);
		assertEquals(id+1, e1.getId());
	}

	@Test
	void testGetFirstName() {
		String firstName = e1.getFirstName();
		assertEquals(firstName, e1.getFirstName());
	}

	@Test
	void testSetFirstName() {
		e1.setFirstName("John");
		assertEquals("John", e1.getFirstName());
	}

	@Test
	void testGetLastName() {
		String lastName = e1.getLastName();
		assertEquals(lastName, e1.getLastName());
	}

	@Test
	void testSetLastName() {
		e1.setLastName("Doe");
		assertEquals("Doe", e1.getLastName());
	}

	@Test
	void testGetEmail() {
		String email = e1.getEmail();
		assertEquals(email, e1.getEmail());
	}

	@Test
	void testSetEmail() {
		e1.setEmail("John.Doe@example.com");
		assertEquals("John.Doe@example.com", e1.getEmail());
	}

}
