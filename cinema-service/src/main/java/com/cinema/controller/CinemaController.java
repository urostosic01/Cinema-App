package com.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.model.Genre;
import com.cinema.model.Movie;
import com.cinema.model.Projection;
import com.cinema.services.CinemaService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cinema")
public class CinemaController {

	@Autowired
	CinemaService cinemaService;

	@GetMapping("/reserve")
	public String getNewReservation() {
		return "view/ViewReservations";
	}
}
