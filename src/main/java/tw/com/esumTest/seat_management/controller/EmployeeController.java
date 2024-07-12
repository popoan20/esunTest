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

	// 預防 Sql injection
	private void validateEmployeeRequest(EmployeeRequest request) {
		if (request == null) {
	        throw new IllegalArgumentException("EmployeeRequest為空");
	    }
	    
	    // 驗證員工 ID 是否有效
	    String empId = request.getEmpId();
	    validateEmpId(empId);
	    // 驗證座位 Seq 是否有效
	    Integer floorSeatSeq = request.getFloorSeatSeq();
	    if (floorSeatSeq == null || floorSeatSeq <= 0) {
	        throw new IllegalArgumentException("FloorSeatSeq為空");
	    }
	}

	private void validateEmpId(String empId) {
		if (empId == null || empId.trim().isEmpty()) {
	        throw new IllegalArgumentException("ID不得為空");
	    }
	    
	    // 確保 empId 符合特定的格式
	    if (empId.length() != 5) { // 假設 ID 長度應等於 5
	        throw new IllegalArgumentException("ID應等於5");
	    }
	    
	    // 確保 empId 只包含有效的字符
	    if (!empId.matches("^[a-zA-Z0-9]+$")) { // 只允許字母和數字
	        throw new IllegalArgumentException("ID僅准輸入英文及數字");
	    }
	}

}
