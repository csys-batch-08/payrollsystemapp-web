package com.payroll.daoimpl;


import java.util.List;

import com.payroll.model.Grade;

public interface GradeDao {
	public boolean insertGrade(Grade grade) ;
	public  int findGradeID(Grade grade);
	public boolean updateGrade(Long basic,Long bonus,Long pf,Long pt,String gdName);
	public boolean deleteGrade(int  gradeId);
	public List<Grade> showGrade();
	public  Long grossSalary(String grdName);
	public  Grade findGrade(int gradeId) ;
	public  Grade findGrade(String gradeName) ;
	public  long perDaySalary(String gradeName);
	
}
