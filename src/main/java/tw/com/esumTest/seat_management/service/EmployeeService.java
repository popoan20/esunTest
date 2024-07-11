package tw.com.esumTest.seat_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tw.com.esumTest.seat_management.entity.Employee;
import tw.com.esumTest.seat_management.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional
	public void assignSeat(Employee employee) {
		// 清除該員工原有的座位
		Employee existingEmployee = employeeRepository.findById(employee.getEmpId()).orElse(null);
		if (existingEmployee != null && existingEmployee.getFloorSeatSeq() != null) {
			existingEmployee.setFloorSeatSeq(null);
			employeeRepository.save(existingEmployee);
		}
		// 分配新座位
		employeeRepository.save(employee);
	}

	@Transactional
	public void clearSeat(String empId) {
		Employee employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new RuntimeException("未查找到該員工"));
		employee.setFloorSeatSeq(null);
		employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}
