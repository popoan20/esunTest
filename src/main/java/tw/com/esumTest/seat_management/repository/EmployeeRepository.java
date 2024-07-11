package tw.com.esumTest.seat_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.esumTest.seat_management.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
	
	
}
