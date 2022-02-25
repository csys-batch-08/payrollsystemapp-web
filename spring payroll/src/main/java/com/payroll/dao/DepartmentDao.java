package com.payroll.dao;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.entity.DepartmentEntity;
import com.payroll.model.Departments;

@Repository
public interface DepartmentDao extends JpaRepository<DepartmentEntity, Integer>{
	


}
