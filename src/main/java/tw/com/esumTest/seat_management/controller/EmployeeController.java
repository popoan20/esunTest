package tw.com.esumTest.seat_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.esumTest.seat_management.entity.Employee;
import tw.com.esumTest.seat_management.entity.EmployeeRequest;
import tw.com.esumTest.seat_management.service.EmployeeService;
import tw.com.esumTest.seat_management.service.SeatAssignmentService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private SeatAssignmentService seatAssignmentService;

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@PostMapping
	public void assignSeat(@RequestBody EmployeeRequest[] requests) {
		for (EmployeeRequest request : requests) {
			// employeeService.assignSeat(request);
			validateEmployeeRequest(request);
			seatAssignmentService.assignSeatToEmployee(request);
		}
	}

	@PutMapping("/{empId}")
	public void clearSeat(@PathVariable String empId) {
		// employeeService.clearSeat(empId);
		validateEmpId(empId);
		seatAssignmentService.removeSeatAssignment(empId);
	}

	private void validateEmployeeRequest(EmployeeRequest request) {
		
	}

	private void validateEmpId(String empId) {
		
	}

}
