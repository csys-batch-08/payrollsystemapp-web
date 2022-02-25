package com.payroll.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.entity.LeaveEntity;

@Repository
public interface LeaveDao extends JpaRepository<LeaveEntity, Integer>{

	
}
