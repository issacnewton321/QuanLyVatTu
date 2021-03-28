package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.abc.entity.CTID;
import com.abc.entity.CT_Phatsinh;

public interface CtPhatSinhRepository extends CrudRepository<CT_Phatsinh, CTID>{
	@Query(value = "Select * from CT_Phatsinh where phieu = ?1",nativeQuery = true)
	List<CT_Phatsinh> searchByPhieu(String phieu);
	@Query(value = "select * from CT_Phatsinh where phieu = ?1 and mavt = ?2",nativeQuery = true)
	CT_Phatsinh findByCTID(String phieu,String mavt);
}
