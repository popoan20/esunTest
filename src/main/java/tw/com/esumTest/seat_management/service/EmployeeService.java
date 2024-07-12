package tw.com.esumTest.seat_management.service;

import java.util.List;

import jakarta.transaction.Transactional;
import tw.com.esumTest.seat_management.entity.Employee;
import tw.com.esumTest.seat_management.entity.EmployeeRequest;

public interface EmployeeService {

	@Transactional
	void assignSeat(EmployeeRequest request);

	@Transactional
	void clearSeat(String empId);

	List<Employee> getAllEmployees();

}
