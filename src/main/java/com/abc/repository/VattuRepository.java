package com.abc.repository;

import org.springframework.data.repository.CrudRepository;

import com.abc.entity.Vattu;

public interface VattuRepository extends CrudRepository<Vattu, String>{
	Vattu findByMavt(String mavt);
}
