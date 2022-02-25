package com.payroll.dao;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.entity.AdminEntity;
import com.payroll.model.Admin;

@Repository
public interface AdminDao extends JpaRepository<AdminEntity, Integer>{
	
	
}
