package com.abc.controller;

import java.util.List;

import javax.persistence.PostRemove;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.entity.Vattu;
import com.abc.repository.VattuRepository;

@Controller
@RequestMapping("/vattu")
public class VattuController {
	public void home(Model model) {
		List<Vattu> listVT = (List<Vattu>) repo.findAll();
		model.addAttribute("listVT", listVT);
	}
	@Autowired
	VattuRepository repo;
	@Autowired
	ServletContext context;
	@RequestMapping("/addVT")
	public String addVattu(Model model) {
		List<Vattu> listVT = (List<Vattu>) repo.findAll();
		model.addAttribute("listVT", listVT);
		model.addAttribute("vattu",new Vattu());
		return "index.html";
	}
	@RequestMapping("/exitVattu")
	public String exitVattu() {
		return "redirect:/";
	}
	@RequestMapping("/insertVattu")
	public String updateVattu(@ModelAttribute("vattu") Vattu vt) {
		repo.save(vt);
		return "redirect:/";
	}
	@GetMapping("/updateVattu")
	public String updateVattu(Model model,@RequestParam("mavt") String mavt) {
		List<Vattu> listVT = (List<Vattu>) repo.findAll();
		model.addAttribute("listVT", listVT);
		Vattu vt = repo.findByMavt(mavt);
		model.addAttribute("vattu",vt);
		return "index.html";
	}
	@GetMapping("/deleteVattu")
	public String deleteVattu(Model model,@RequestParam("mavt") String mavt) {
		try {
			repo.deleteById(mavt);
		} catch (Exception e) {
			// TODO: handle exceptio
			home(model);
			model.addAttribute("message", "Không thể xóa vì vật tư có trong bảng CT_PHATSINH");
			return "index.html";
		}
		return "redirect:/";
	}
}
