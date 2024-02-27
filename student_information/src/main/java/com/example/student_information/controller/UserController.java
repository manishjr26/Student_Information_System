package com.example.student_information.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.example.student_information.UserService;
import com.example.student_information.User_Table;

public class UserController 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String listUsers(Model model)
	{
		List<User_Table> users=userService.getAllUsers();
		model.addAttribute("users",users);
		return "user/list";
	}
	
	@GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("user", new User_Table());
        return "user/user-form";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User_Table user) {
        userService.saveUser(user);
        return "redirect:/users/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") Long id, Model model) {
        User_Table user = userService.getUserById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        model.addAttribute("user", user);
        return "user/user-form";
    }
    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/users/list";
    }
	
}
