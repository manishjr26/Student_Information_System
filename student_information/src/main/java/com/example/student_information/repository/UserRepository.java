package com.example.student_information.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_information.User_Table;

public interface UserRepository extends JpaRepository<User_Table, Long> 
{

	
}
