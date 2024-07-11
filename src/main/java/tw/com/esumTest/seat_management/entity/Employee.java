package tw.com.esumTest.seat_management.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    private String empId;
	
    private String name;

    private String email;

    @OneToOne
    @JoinColumn(name = "FLOOR_SEAT_SEQ")
    private Seatingchart floorSeatSeq;

    // Getters and Setters
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

	public Seatingchart getFloorSeatSeq() {
		return floorSeatSeq;
	}

	public void setFloorSeatSeq(Seatingchart floorSeatSeq) {
		this.floorSeatSeq = floorSeatSeq;
	}

}