package tw.com.esumTest.seat_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.esumTest.seat_management.entity.Seatingchart;

public interface SeatingChartRepository extends JpaRepository<Seatingchart, Integer> {


}
