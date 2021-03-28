package com.abc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Check;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Vattu {
	@Id
	String mavt;
	String tenvt;
	String dvt;
	int soluongton;
	@JsonManagedReference
	@OneToMany(mappedBy = "vattu",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	List<CT_Phatsinh> listCTPS;
	public Vattu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMavt() {
		return mavt;
	}
	public void setMavt(String mavt) {
		this.mavt = mavt;
	}
	public String getTenvt() {
		return tenvt;
	}
	public void setTenvt(String tenvt) {
		this.tenvt = tenvt;
	}
	public String getDvt() {
		return dvt;
	}
	public void setDvt(String dvt) {
		this.dvt = dvt;
	}
	public int getSoluongton() {
		return soluongton;
	}
	public void setSoluongton(int soluongton) {
		this.soluongton = soluongton;
	}
	public List<CT_Phatsinh> getListCTPS() {
		return listCTPS;
	}
	public void setListCTPS(List<CT_Phatsinh> listCTPS) {
		this.listCTPS = listCTPS;
	}
	
	
	
}
