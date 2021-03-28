package com.abc.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.entity.Phatsinh;
import com.abc.repository.PhatsinhRepository;

@Controller
@RequestMapping("/phatsinh")
public class PhatsinhController {
	@Autowired
	PhatsinhRepository repo;
	public void home(Model model) {
		List<Phatsinh> listPS = (List<Phatsinh>) repo.findAll();
		model.addAttribute("listPS", listPS);
	}
	
	@RequestMapping("")
	public String getListPS(Model model){
		home(model);
		return "phatsinh.html";
	}
	@GetMapping("/insertPhatsinh")
	public String insertPhatsinh(Model model){
		home(model);
		model.addAttribute("phatsinh",new Phatsinh());
		return "phatsinh.html";
	}
	@PostMapping("/insertPhatsinh")
	public String insertPhatsinh2(@ModelAttribute("phatsinh") Phatsinh ps){
		ps.setNgay(new Date(System.currentTimeMillis()));
		repo.save(ps);
		return "redirect:/phatsinh";
	}
	@GetMapping("/deletePhatsinh")
	public String insertPhatsinh(@RequestParam("phieu") String phieu,Model model){
		try {
			repo.deleteById(phieu);
		} catch (Exception e) {
			// TODO: handle exception
			home(model);
			model.addAttribute("message", "Không thể xóa vì phiếu tồn tại trong CT_PHATSINH");
			return "phatsinh.html";
		}
		return "redirect:/phatsinh";
	}
}
