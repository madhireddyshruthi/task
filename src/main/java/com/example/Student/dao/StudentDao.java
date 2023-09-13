package com.example.Student.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Student.model.StudentDto;

@Component
public interface StudentDao {
	public List<StudentDto> getStudentDto();
	public StudentDto saveStudentDto(StudentDto studentDto);

}
