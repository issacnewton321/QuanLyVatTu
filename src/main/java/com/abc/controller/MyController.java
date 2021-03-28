package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abc.entity.Vattu;
import com.abc.repository.VattuRepository;

@Controller
public class MyController {
	@Autowired
	VattuRepository repo;
	
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Vattu> listVT = (List<Vattu>) repo.findAll();
		model.addAttribute("listVT", listVT);
		return "index.html";
	}
}
