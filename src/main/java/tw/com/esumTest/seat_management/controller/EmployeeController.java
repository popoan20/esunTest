package tw.com.esumTest.seat_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.esumTest.seat_management.entity.Employee;
import tw.com.esumTest.seat_management.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public void assignSeat(@RequestBody Employee employee) {
        employeeService.assignSeat(employee);
    }

    @PutMapping("/{empId}")
    public void clearSeat(@PathVariable String empId) {
        employeeService.clearSeat(empId);
    }
}
