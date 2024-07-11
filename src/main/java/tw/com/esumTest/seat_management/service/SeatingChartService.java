package tw.com.esumTest.seat_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.esumTest.seat_management.entity.Seatingchart;
import tw.com.esumTest.seat_management.repository.SeatingChartRepository;

@Service
public class SeatingChartService {
	@Autowired
	private SeatingChartRepository seatingChartRepository;

	public List<Seatingchart> getAllSeats() {
		return seatingChartRepository.findAll();
	}

}
