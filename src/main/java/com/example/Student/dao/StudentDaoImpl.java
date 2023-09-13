package com.example.Student.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Student.model.StudentDto;
@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	Logger logger = LoggerFactory.getLogger(StudentDao.class);
	 public StudentDto saveStudentDto(StudentDto studentDto) {
	        String insertQuery = "INSERT INTO student (studentId, studentName) VALUES (?, ?)";
	        jdbcTemplate.update(insertQuery, studentDto.getStudentId(), studentDto.getStudentName());
	        logger.info("Inserting data into the student table");
	        return studentDto;
	    }

	    @Override
	    public List<StudentDto> getStudentDto() {
	        String sql = "SELECT * FROM student";
	        logger.info("Find all the data");
	        List<StudentDto> studentDto = jdbcTemplate.query(sql,
	                new BeanPropertyRowMapper<>(StudentDto.class));
	        return studentDto;
	
       
}
}