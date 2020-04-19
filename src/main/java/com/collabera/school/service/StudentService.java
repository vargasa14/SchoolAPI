package com.collabera.school.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.collabera.school.model.Student;

@Service
public class StudentService {
	
	//mock database
	private static List<Student> students = new ArrayList<Student>();
	private static int idCounter = 1;
	
	static {
		students.add(new Student(idCounter++, "Lebron", "James", 
				LocalDate.of(1984, 12, 30), "Basketball"));
		
		students.add(new Student(idCounter++, "John", "Truong",
				LocalDate.of(1997, 8, 7), "Software Engineering"));
		
		students.add(new Student(idCounter++, "Jeffrey", "Epstein",
				LocalDate.of(1953, 3, 14), "Finance"));
		
		students.add(new Student(idCounter++, "Emma", "Stone",
				LocalDate.of(1992, 7, 10), "Acting"));
		
		students.add(new Student(idCounter++, "Barack", "Obama",
				LocalDate.of(1961, 8, 4), "Law"));
		
		students.add(new Student(idCounter++, "Shia", "LaBeouf",
				LocalDate.of(1986, 6, 11), "Acting"));
	}
	//C.R.U.D.
	//create
	//read
	//update
	//delete
	
	//Create
	public Student addStudent(String firstName, String lastName, 
			LocalDate dob, String major) {
		
		Student newStudent = new Student(idCounter++, firstName, lastName, dob, major);
		students.add(newStudent);
		return newStudent;	
	}
	
	//Read all students
	public List<Student> getAllStudents() {
		return students;
	}
	
	//Read one Student based on their ID
	public Student getStudent(int id) {
		
		Student student = new Student();
		for (int s = 0; s <students.size(); s++) {
			if (students.get(s).getId() == id) 
			{
				student = students.get(s);
				break;
			}
		}
		return student;	
	}
	
	//Read all students from same major
	public List<Student> getStudentsInMajor(String major){
		List<Student> studentMajor = new ArrayList<Student>();
		
		for (int s = 0; s <students.size(); s++) {
			if (students.get(s).getMajor().toLowerCase().equals(major.toLowerCase())) 
			{
				studentMajor.add(students.get(s));
			}
		}
		return studentMajor;
	}
	
	//Update
	public Student updateStudent(Student student) {
		Student studentToUpdate = getStudent(student.getId());
		
		if (studentToUpdate.getId() != -1) {
			studentToUpdate.setFirstName(student.getFirstName());
			studentToUpdate.setLastName(student.getLastName());
			studentToUpdate.setDateOfBirth(student.getDateOfBirth());
			studentToUpdate.setMajor(student.getMajor());
		}	
		return student;
	}
	
	//Delete
	public Student deleteStudent (int id ) {
		Student studentToRemove = new Student();
		
		for (int s =0; s <students.size(); s++) {
			
			if (students.get(s).getId()== id) {
				students.remove(s);
				break;
			}
		}
		return studentToRemove;
	}
	
	public void deleteAllStudents() {
		students.clear();
	}
	
}