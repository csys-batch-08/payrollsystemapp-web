package com.payroll.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.entity.GradeEntity;
import com.payroll.model.Grade;

@Repository
public interface GradeDao extends JpaRepository<GradeEntity, Integer>{

	
}
