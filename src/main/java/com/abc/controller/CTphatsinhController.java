package com.abc.controller;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.JDBCException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateJdbcException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.entity.CTID;
import com.abc.entity.CT_Phatsinh;
import com.abc.entity.Phatsinh;
import com.abc.entity.Vattu;
import com.abc.repository.CtPhatSinhRepository;
import com.abc.repository.VattuRepository;

@Controller
@RequestMapping("/ctphatsinh")
public class CTphatsinhController {
	@Autowired
	CtPhatSinhRepository repo;
	@Autowired
	VattuRepository repoVT;
	public void home(Model model,String phieu) {
		List<CT_Phatsinh> listCT = (List<CT_Phatsinh>) repo.searchByPhieu(phieu);
		model.addAttribute("listCT", listCT);
		model.addAttribute("phieu", phieu);
	}
	
	@GetMapping("")
	public String getListCT(Model model,@RequestParam("phieu") String phieu){
		home(model,phieu);
		return "chitiet.html";
	}
	@GetMapping("/insertCT")
	public String insertCT(Model model,@RequestParam("phieu") String phieu) {
		List<Vattu> listVT = (List<Vattu>) repoVT.findAll();
		model.addAttribute("listVT", listVT);
		home(model,phieu);
		CTID id = new CTID();
		id.setPhieu(phieu);
		CT_Phatsinh ctps = new CT_Phatsinh();
		ctps.setId(id);
		model.addAttribute("ct",ctps );
		return "chitiet.html";
	}
	@GetMapping("/updateCT")
	public String updateCT(Model model,@RequestParam("phieu") String phieu,@RequestParam("mavt") String mavt) {
		List<Vattu> listVT = (List<Vattu>) repoVT.findAll();
		model.addAttribute("listVT", listVT);
		home(model,phieu);
		CTID id = new CTID();
		id.setPhieu(phieu);
		id.setMavt(mavt);
		CT_Phatsinh ctps = repo.findByCTID(phieu, mavt);
		model.addAttribute("ct",ctps );
		return "chitiet.html";
	}
	@PostMapping("/insertCT")
	public String insertCT2(Model model,@ModelAttribute("ct") CT_Phatsinh ct,@RequestParam("phieu") String phieu) {
		try {
			Vattu vt = new Vattu();
			vt.setMavt(ct.getId().getMavt());
			Phatsinh ps = new Phatsinh();
			ps.setPhieu(ct.getId().getPhieu());
			ct.setVattu(vt);
			ct.setPhatsinh(ps);
			repo.save(ct);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			
			e.printStackTrace();
			List<Vattu> listVT = (List<Vattu>) repoVT.findAll();
			model.addAttribute("listVT", listVT);
			home(model,phieu);
			CTID id = new CTID();
			id.setPhieu(phieu);
			CT_Phatsinh ctps = new CT_Phatsinh();
			ctps.setId(id);
			model.addAttribute("ct",ctps );
			return "chitiet.html";
		}
		return "redirect:/ctphatsinh?phieu="+phieu;
	}
	@GetMapping("/deleteCT")
	public String deleteCT(Model model,@RequestParam("phieu") String phieu,@RequestParam("mavt") String mavt) {
		CTID id = new CTID();
		id.setMavt(mavt);
		id.setPhieu(phieu);
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message", e.getMessage());
			List<Vattu> listVT = (List<Vattu>) repoVT.findAll();
			model.addAttribute("listVT", listVT);
			home(model,phieu);
			id = new CTID();
			id.setPhieu(phieu);
			CT_Phatsinh ctps = new CT_Phatsinh();
			ctps.setId(id);
			model.addAttribute("ct",ctps );
			return "chitiet.html";
		}
		return "redirect:/ctphatsinh?phieu="+phieu;
	}

}
