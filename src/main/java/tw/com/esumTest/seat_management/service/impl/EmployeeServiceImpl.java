package tw.com.esumTest.seat_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tw.com.esumTest.seat_management.entity.Employee;
import tw.com.esumTest.seat_management.entity.EmployeeRequest;
import tw.com.esumTest.seat_management.entity.Seatingchart;
import tw.com.esumTest.seat_management.repository.EmployeeRepository;
import tw.com.esumTest.seat_management.repository.SeatingChartRepository;
import tw.com.esumTest.seat_management.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private SeatingChartRepository seatingChartRepository;

	@Transactional
	public void assignSeat(EmployeeRequest request) {
		Employee employee = employeeRepository.findById(request.getEmpId())
		.orElseThrow( ()-> new RuntimeException("未查找到該員工"));
		Seatingchart seatingchart  = seatingChartRepository.findById(request.getFloorSeatSeq())
				.orElseThrow(() -> new RuntimeException("未查找到該座位"));
		employee.setFloorSeatSeq(seatingchart);
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
