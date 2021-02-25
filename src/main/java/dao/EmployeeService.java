package dao;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import models.Employee;

@WebService
public interface EmployeeService {

	@WebMethod
	Employee getEmployee(int id);

	@WebMethod
	List<Employee> getAllEmployee();
	
	@WebMethod
	Employee updateEmployee(int id,String name);
	
	@WebMethod
	boolean deleteEmployee(int id);
	
	@WebMethod
	String addEmployee(Employee employee);
}
