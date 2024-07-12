CREATE DATABASE IF NOT EXISTS `seat_management` /*!40100 COLLATE 'utf8mb4_bin' */;
USE `seat_management`;

CREATE TABLE IF NOT EXISTS SeatingChart (
  FLOOR_SEAT_SEQ INT PRIMARY KEY,
  FLOOR_NO INT,
  SEAT_NO INT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS Employee (
  EMP_ID VARCHAR(5) PRIMARY KEY,
  NAME VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  EMAIL VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  FLOOR_SEAT_SEQ INT,
  FOREIGN KEY (FLOOR_SEAT_SEQ) REFERENCES SeatingChart(FLOOR_SEAT_SEQ)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO SeatingChart (FLOOR_SEAT_SEQ, FLOOR_NO, SEAT_NO) VALUES 
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 2, 1),
(6, 2, 2),
(7, 2, 3),
(8, 2, 4),
(9, 3, 1),
(10, 3, 2),
(11, 3, 3),
(12, 3, 4),
(13, 4, 1),
(14, 4, 2),
(15, 4, 3),
(16, 4, 4)
ON DUPLICATE KEY UPDATE FLOOR_NO = VALUES(FLOOR_NO), SEAT_NO = VALUES(SEAT_NO);

INSERT INTO Employee (EMP_ID, NAME, EMAIL, FLOOR_SEAT_SEQ) VALUES 
('10001', '小明', 'xiaoming1@esunbank.com', 1),
('10002', '小華', 'xiaohua2@esunbank.com', NULL),
('10003', '小強', 'xiaoqiang3@esunbank.com', NULL),
('10004', '美麗', 'meili4@esunbank.com', NULL),
('10005', '大偉', 'dawwei5@esunbank.com', NULL),
('10006', '阿珍', 'azhen6@esunbank.com', NULL),
('10007', '阿蘭', 'alan7@esunbank.com', NULL),
('10008', '小婷', 'xiaoting8@esunbank.com', NULL),
('10009', '志明', 'zhiming9@esunbank.com', NULL),
('10010', '建華', 'jianhua10@esunbank.com', 5),
('10011', '佳美', 'jiamei11@esunbank.com', NULL),
('10012', '忠義', 'zhongyi12@esunbank.com', NULL),
('10013', '文秀', 'wenxiu13@esunbank.com', NULL),
('10014', '瑞華', 'ruihua14@esunbank.com', NULL),
('10015', '國強', 'guoqiang15@esunbank.com', 16),
('10016', '玉珍', 'yuzhen16@esunbank.com', NULL)
ON DUPLICATE KEY UPDATE NAME = VALUES(NAME), EMAIL = VALUES(EMAIL), FLOOR_SEAT_SEQ = VALUES(FLOOR_SEAT_SEQ);

DELIMITER //

CREATE OR REPLACE PROCEDURE AssignSeatToEmployee(
    IN in_emp_id INT,
    IN in_floor_seat_seq INT
)
BEGIN
    DECLARE empCount INT DEFAULT 0;
    DECLARE seatCount INT DEFAULT 0;

    -- 檢查員工是否存在
    SELECT COUNT(*)
    INTO empCount
    FROM Employee
    WHERE emp_id = in_emp_id;

    IF empCount = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = '未查找到該員工';
    END IF;

    -- 檢查座位是否存在
    SELECT COUNT(*)
    INTO seatCount
    FROM Seatingchart
    WHERE floor_seat_seq = in_floor_seat_seq;

    IF seatCount = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = '未查找到該座位';
    END IF;

    -- 更新員工座位
    UPDATE Employee
    SET floor_seat_seq = in_floor_seat_seq
    WHERE emp_id = in_emp_id;
END //

CREATE OR REPLACE PROCEDURE RemoveSeatAssignment(
    IN in_empId VARCHAR(5)
)
BEGIN
    UPDATE Employee
    SET FLOOR_SEAT_SEQ = NULL
    WHERE EMP_ID = in_empId;
    
    IF ROW_COUNT() = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = '未查找到該員工';
    END IF;
END //

DELIMITER ;

