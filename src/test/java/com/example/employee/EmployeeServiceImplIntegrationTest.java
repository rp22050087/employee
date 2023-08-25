package com.example.employee;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeNotFoundException;
import com.example.employee.service.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplIntegrationTest {
	
	@Mock
    private EmployeeRepository employeeRepository;
	
	@InjectMocks
	EmployeeServiceImpl employeeService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// JUnit test for getAllEmployees method
    @DisplayName("JUnit test for getAllEmployees method")
	@Test
	void testGetAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		
	    Employee empOne = new Employee();
	    empOne.setFirstName("John");
	    empOne.setLastName("John");
	    
	    Employee empTwo = new Employee();
	    empTwo.setFirstName("Alex");
	    empTwo.setLastName("Kolenchiski");
	    
	    Employee empThree = new Employee();
	    empThree.setFirstName("Steve");
	    empThree.setLastName("Waugh");

	    list.add(empOne);
	    list.add(empTwo);
	    list.add(empThree);

	    when(employeeRepository.findAll()).thenReturn(list);

	    //test
	    List<Employee> empList = employeeService.getAllEmployees();

	    assertEquals(3, empList.size());
	    verify(employeeRepository, times(1)).findAll();
	}

    // JUnit test for saveEmployee method
    @DisplayName("JUnit test for saveEmployee method")
	@Test
	void testSaveEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("Lokesh");
		employee.setLastName("Gupta");
	    
		//test
		employeeService.saveEmployee(employee);
		
		verify(employeeRepository, times(1)).save(employee);
	}

    // JUnit test for getEmployeeById method
    @DisplayName("JUnit test for getEmployeeById method")
	@Test
	void testGetEmployeeById_whenFindEmployee_thenReturnEmployeeObject() {
		long id = 1L;
		Employee employee = new Employee();
		employee.setFirstName("Tony");
		employee.setLastName("Stark");
	    
		when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
		
		//test
		employeeService.getEmployeeById(id);
		
		verify(employeeRepository, times(1)).findById(id);
	}
    
 // JUnit test for getEmployeeById method
    @DisplayName("JUnit test for getEmployeeById method which throws exception")
	@Test
	void testGetEmployeeById_whenFindEmployee_thenThrowsException() {
		long id = 1L;
	    
		when(employeeRepository.findById(id)).thenReturn(Optional.empty());
		
		Exception exception = assertThrows(EmployeeNotFoundException.class, () -> {
			employeeService.getEmployeeById(id);
	    });
		
		String expectedMessage = "Employee not found for id :: 1";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	// JUnit test for deleteEmployee method
    @DisplayName("JUnit test for deleteEmployee method")
	@Test
	void testDeleteEmployeeById() {
    	long id = 1L;

    	//test
        employeeService.deleteEmployeeById(id);

        verify(employeeRepository, times(1)).deleteById(id);
	}

}
