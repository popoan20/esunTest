package tw.com.esumTest.seat_management.entity;

import jakarta.persistence.Entity;

public class EmployeeRequest {
	private String empId;
	private String name;
	private String email;
	private Integer floorSeatSeq;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getFloorSeatSeq() {
		return floorSeatSeq;
	}

	public void setFloorSeatSeq(Integer floorSeatSeq) {
		this.floorSeatSeq = floorSeatSeq;
	}
}
