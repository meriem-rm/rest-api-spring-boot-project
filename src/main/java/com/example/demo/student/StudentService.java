package com.example.demo.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<>(); 
		
		studentRepository.findAll() 
		// lambda exprexion is an iterable method like for loop 
		// here it adds the record to the student List
		.forEach(students::add); 
		return students;
	} 
	
	public void addStudent(Student student) {
		studentRepository.save(student);
	}
	
	public Optional<Student> getStudentById(String id) {
		return studentRepository.findById(id);
	}
	
	public void updateStudent(String id, Student student) {
		studentRepository.save(student);
	} 
	
	public void deleteStudent(String id) {
		studentRepository.deleteById(id);
	}
}
