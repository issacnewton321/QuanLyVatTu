package com.abc.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class CTID implements Serializable {
	String phieu;
	String mavt;
	public String getPhieu() {
		return phieu;
	}
	public void setPhieu(String phieu) {
		this.phieu = phieu;
	}
	public String getMavt() {
		return mavt;
	}
	public void setMavt(String mavt) {
		this.mavt = mavt;
	}
	
}
