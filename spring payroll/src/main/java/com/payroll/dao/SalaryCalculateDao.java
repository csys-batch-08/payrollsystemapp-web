package com.payroll.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.entity.EmpSalaryEntity;


@Repository
public interface SalaryCalculateDao extends JpaRepository<EmpSalaryEntity, Integer>{

}
