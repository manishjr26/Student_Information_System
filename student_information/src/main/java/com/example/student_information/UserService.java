package com.example.student_information;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.student_information.repository.UserRepository;

public class UserService 
{

	@Autowired
	private UserRepository userRepository;
	
	// to display all the user
	public List<User_Table> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	// to get user by id
	public Optional<User_Table> getUserById(Long id)
	{
		return userRepository.findById(id);
	}
	
	// update/save the user
	public User_Table saveUser(User_Table table)
	{
		return userRepository.save(table);
	}
	
	public void deleteUser(Long id)
	{
		userRepository.deleteById(id);
	}
	
//	public String addNewStudent(String name, String nativeLocation, String presentLocation,
//            String course, long number) {
//// Create a new User object with the provided details
//User_Table newStudent = new User_Table();
//newStudent.setName(name);
//newStudent.setNativeLocation(nativeLocation);
//newStudent.setPresentLocation(presentLocation);
//newStudent.setCourse(course);
//newStudent.setNumber(number);
//
//// Save the new student to the database
//User savedStudent = userRepository.save(newStudent);
//
//// Add the saved student to the model for displaying on the browser
//model.addAttribute("newStudent", savedStudent);
//
//// Return the HTML template name to display the student details
//return "user/display-new-student";
//}
	
	
}
