package tw.com.esumTest.seat_management.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Seatingchart")
public class Seatingchart implements Serializable{

    @Id
    @Column(name = "FLOOR_SEAT_SEQ")
    private Integer floorSeatSeq;

    private Integer floorNo;

    private Integer seatNo;
    
    // Getters and Setters
    public Integer getFloorSeatSeq() {
        return floorSeatSeq;
    }

    public void setFloorSeatSeq(Integer floorSeatSeq) {
        this.floorSeatSeq = floorSeatSeq;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }
}
