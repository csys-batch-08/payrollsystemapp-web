package com.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.payroll.Interface.DepartmentDao;
import com.payroll.model.Departments;
import com.payroll.model.Employee;
import com.payroll.model.Grade;

public class DepartmentsDaoImpl implements DepartmentDao{
	public int insertDep(Departments dprt) 
	
	{	
		String insertQuery="insert into departments (DEPT_NAME) values (?)";
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		int i=0;
		try {
			

			PreparedStatement pstmt=con.prepareStatement(insertQuery);
			pstmt.setString(1, dprt.getDeptName());
			
			
			i=pstmt.executeUpdate();
			
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return i;
		
		
		}
	
	
	public int findDepartmentID(Departments dept)
	{
		GradeDaoImpl gradeDaoImpl=new GradeDaoImpl();

		String findId="select dept_id from departments where dept_name = '"+dept.getDeptName()+"'";
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		Statement stmt;
		int id = 0;
		try {
			stmt = con.createStatement();
			
			ResultSet rs=stmt.executeQuery(findId);
			while(rs.next()) {
				id=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return id;
	}
	public int updateDept(Departments depart)
	{
		String insertQuery = "update departments set dept_name=? where dept_id=?";
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		PreparedStatement pstmt = null;
		int i=0;
		try {

			pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1,depart.getDeptName());
			pstmt.setLong(2, depart.getDeptId());
			i=pstmt.executeUpdate();

		} catch (SQLException e) {
			//catch the exception and get that message
			e.printStackTrace();
		}
		return i;
		
	}
	public boolean deleteDept(int  deptId)
	{
		String deleteQuery = "delete from departments where dept_id=?";
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		boolean result=false;
		PreparedStatement pstmt = null;
		try {
			

			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, deptId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Departments> showDepartments()
	{
		List<Departments> departmentList=new ArrayList<Departments>();
		
		String showQuery="select DEPT_ID,DEPT_NAME from Departments";
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		GradeDaoImpl gradeDaoImpl=new GradeDaoImpl();

		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(showQuery);
			while(rs.next())
			{
				Departments department=new Departments(rs.getInt(1),rs.getString(2));
				departmentList.add(department);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return departmentList;
	}
	public  Departments	findDepartment(int id)
	{
		String query="select DEPT_ID,DEPT_NAME from departments where dept_id="+id;
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();		
		Departments depart=null;
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				depart=new Departments(rs.getInt(1),rs.getString(2));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return depart;
		
	}
	public  Departments	findDepartment(String deptName)
	{
		String query="select DEPT_ID,DEPT_NAME from departments where dept_name= '"+deptName+"'";
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		Departments depart=null;
		GradeDaoImpl gradeDaoImpl=new GradeDaoImpl();

		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				
				depart=new Departments(rs.getInt(1),rs.getString(2));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return depart;
		
	}
	public List<Departments> searchDepartment(String deptName)
	{
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		String query="select DEPT_ID,DEPT_NAME from departments where upper(DEPT_NAME) like '"+deptName.toUpperCase()+"%'";
		ResultSet rs=null;
		List<Departments> departmentList=new ArrayList<Departments>();

		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
				Departments department=new Departments(rs.getInt(1),rs.getString(2));
				departmentList.add(department);
			}
			
			return departmentList;
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		return departmentList;
		
		
		}

//	public Departments findDepartment(String deptName)
//	{
//		
//		GradeDaoImpl gradeDao=new GradeDaoImpl();
//		
//		
//		String query="select * from departments where dept_name= '"+deptName+"' ";
//		Grade grade=gradeDao.findGrade(GrdId);
//		ConnectionUtilImpl connection=new ConnectionUtilImpl();
//		Connection con=connection.dbConnect();
//		Departments depart=null;
//		GradeDaoImpl gradeDaoImpl=new GradeDaoImpl();
//
//		try {
//			Statement stmt=con.createStatement();
//			ResultSet rs=stmt.executeQuery(query);
//			if(rs.next()) {
//				
//				depart=new Departments(rs.getInt(1),rs.getString(2));
//				
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return depart;
//	}
	
	
	

}
