package tw.com.esumTest.seat_management.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Seatingchart")
public class Seatingchart{

    @Id
    @Column(name = "FLOOR_SEAT_SEQ")
    private Integer floorSeatSeq;

    @Column(name = "FLOOR_NO", nullable = false)
    private Integer floorNo;

    @Column(name = "SEAT_NO", nullable = false)
    private Integer seatNo;
    
    // 默認構造函數
    public Seatingchart() {
    }
    
    @JsonCreator
    public Seatingchart(@JsonProperty("floorSeatSeq") Integer floorSeatSeq,
                        @JsonProperty("floorNo") Integer floorNo,
                        @JsonProperty("seatNo") Integer seatNo) {
        this.floorSeatSeq = floorSeatSeq;
        this.floorNo = floorNo;
        this.seatNo = seatNo;
    }
    
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
