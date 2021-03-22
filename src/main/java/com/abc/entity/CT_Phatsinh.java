package com.abc.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name ="CT_PHATSINH")
public class CT_Phatsinh {
	@EmbeddedId
	CTID id;
	int soluong;
	float dongia;
	@ManyToOne
	@MapsId("phieu")
	@JoinColumn(name ="phieu")
	Phatsinh phatsinh;
	@ManyToOne
	@MapsId("mavt")
	@JoinColumn(name ="mavt")
	Vattu vattu;
	
	public CT_Phatsinh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CTID getId() {
		return id;
	}
	public void setId(CTID id) {
		this.id = id;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public float getDongia() {
		return dongia;
	}
	public void setDongia(float dongia) {
		this.dongia = dongia;
	}
	public Phatsinh getPhatsinh() {
		return phatsinh;
	}
	public void setPhatsinh(Phatsinh phatsinh) {
		this.phatsinh = phatsinh;
	}
	public Vattu getVattu() {
		return vattu;
	}
	public void setVattu(Vattu vattu) {
		this.vattu = vattu;
	}
	
	
}
