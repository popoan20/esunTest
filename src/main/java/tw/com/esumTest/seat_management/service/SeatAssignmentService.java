package tw.com.esumTest.seat_management.service;

import jakarta.transaction.Transactional;
import tw.com.esumTest.seat_management.entity.EmployeeRequest;

public interface SeatAssignmentService {
	
	void init();
	@Transactional
	void assignSeatToEmployee(EmployeeRequest request);
	@Transactional
	void removeSeatAssignment(String empId);
}
