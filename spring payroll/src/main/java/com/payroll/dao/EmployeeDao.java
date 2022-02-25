package com.payroll.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.payroll.entity.EmployeeEntity;
import com.payroll.model.Employee;


@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer>{
	


}
