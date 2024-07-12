package tw.com.esumTest.seat_management.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import tw.com.esumTest.seat_management.entity.EmployeeRequest;
import tw.com.esumTest.seat_management.service.SeatAssignmentService;

@Service
public class SeatAssignmentServiceImpl implements SeatAssignmentService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private SimpleJdbcCall assignSeatCall;
	private SimpleJdbcCall removeSeatCall;

	@Override
	@PostConstruct //預先載入
	public void init() {
		this.assignSeatCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("AssignSeatToEmployee");
		this.removeSeatCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("RemoveSeatAssignment");

	}

	@Override
	@Transactional
	public void assignSeatToEmployee(EmployeeRequest request) {
		Map<String, Object> params = new HashMap<>();
		params.put("in_emp_id", request.getEmpId());
		params.put("in_floor_seat_seq", request.getFloorSeatSeq());
		try {
			assignSeatCall.execute(params);
		} catch (DataAccessException e) {
			throwException(e);
		}
	}

	@Override
	@Transactional
	public void removeSeatAssignment(String empId) {
		Map<String, Object> params = new HashMap<>();
        params.put("in_empId", empId);

        try {
            removeSeatCall.execute(params);
        } catch (DataAccessException e) {
        	throwException(e);
        }
	}
	
	private void throwException(DataAccessException e) {
		Throwable cause = e.getCause();
        if (cause instanceof SQLException) {
            SQLException sqlException = (SQLException) cause;
            if ("45000".equals(sqlException.getSQLState())) {
                throw new RuntimeException("存儲過程錯誤: " + sqlException.getMessage(), sqlException);
            }
        }
        throw new RuntimeException("資料庫操作異常: " + e.getMessage(), e);
	}

}
