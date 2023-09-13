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
	@Override
	public StudentDto saveStudentDto(StudentDto studentDto) {
		String query = "insert into studentVo values('"+studentDto.getStudentId()+"','"+studentDto.getStudentName()+"')";
		jdbcTemplate.update(query);
		logger.info("Creating");
		return studentDto;
	}
	@Override
	public List<StudentDto> getStudentDto() {
		
		String sql = "select*from studentVo";
		logger.info("Find all the data");
        List<StudentDto> studentDto = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<StudentDto>(StudentDto.class));
        return studentDto;
	
       
}
}