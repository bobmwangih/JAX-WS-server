package dao;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.ibatis.session.SqlSession;

import models.Employee;
import myBatis.MyBatisConfig;

@WebService(endpointInterface = "dao.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

	public Employee getEmployee(int id) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		Employee employee = session.selectOne("employeeMapper.getEmployee",id);
		session.commit();
		session.close();
		return employee;
	}

	@WebMethod(exclude=true)
	public Employee updateEmployee(int id, String name) {
		return null;
	}

	@WebMethod(exclude=true)
	public boolean deleteEmployee(int id) {
		return false;
	}


	public String addEmployee(Employee emp) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		int finished = session.insert("employeeMapper.insertEmployee", emp);
		String result = finished > 0 ? "Saved" : "Not Saved";
		session.commit();
		session.close();
		return result;
		
	}

	public List<Employee> getAllEmployee() {
	SqlSession session = MyBatisConfig.getSessionFactory().openSession();
	List<Employee> employees = session.selectList("employeeMapper.getAllEmployees");
	session.commit();
	session.close();
	return employees;
	}

}
