package tw.com.esumTest.seat_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.esumTest.seat_management.entity.Seatingchart;
import tw.com.esumTest.seat_management.service.SeatingChartService;

@RestController
@RequestMapping("/api/seats")
public class SeatingChartController {
	@Autowired
    private SeatingChartService seatingChartService;

    @GetMapping
    public List<Seatingchart> getAllEmployees() {
        return seatingChartService.getAllSeats();
    }
}
