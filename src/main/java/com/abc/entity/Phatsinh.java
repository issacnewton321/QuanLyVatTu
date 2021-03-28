package com.abc.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Phatsinh {
	@Id
	String phieu;
	Date ngay;
	String loai,hotenkh,manv;
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "phatsinh",cascade = CascadeType.ALL)
	List<CT_Phatsinh> listCTPS;

	public Phatsinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPhieu() {
		return phieu;
	}

	public void setPhieu(String phieu) {
		this.phieu = phieu;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getHotenkh() {
		return hotenkh;
	}

	public void setHotenkh(String hotenkh) {
		this.hotenkh = hotenkh;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public List<CT_Phatsinh> getListCTPS() {
		return listCTPS;
	}

	public void setListCTPS(List<CT_Phatsinh> listCTPS) {
		this.listCTPS = listCTPS;
	}
	
}
