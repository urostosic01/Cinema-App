package com.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.model.User;
import com.cinema.model.UserRole;
import com.cinema.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@ControllerAdvice
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/loginPage")
	public String loginPage() {
		return "login";
	}
	
//	@PostMapping("/register")
//	public String saveUser(@ModelAttribute("user") User user) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		
//		userRepo.save(user);
//		return "login";
//	}
	
	
	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/auth/loginPage";
	}
}
