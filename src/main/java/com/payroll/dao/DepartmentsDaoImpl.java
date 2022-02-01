package com.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.payroll.daoimpl.DepartmentDao;
import com.payroll.model.Departments;


public class DepartmentsDaoImpl implements DepartmentDao{
	public int insertDep(Departments dprt) 
	
	{	
		String insertQuery="insert into departments (DEPT_NAME) values (?)";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		int i=0;
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, dprt.getDeptName());
			
			i=preparedStatement.executeUpdate();
			
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return i;
		
	}
	
	
	public int findDepartmentID(Departments dept)
	{

		String findId="select dept_id from departments where dept_name = ?";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		PreparedStatement  preparedStatement=null;
		int id = 0;
		try {
			
			preparedStatement=connection.prepareStatement(findId);
			preparedStatement.setString(1, dept.getDeptName());
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				id=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		
	
		return id;
	}
	public int updateDept(Departments depart)
	{
		String insertQuery = "update departments set dept_name=? where dept_id=?";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement = null;
		int i=0;
		try {

			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1,depart.getDeptName());
			preparedStatement.setLong(2, depart.getDeptId());
			i=preparedStatement.executeUpdate();

		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return i;
		
	}
	public boolean deleteDept(int  deptId)
	{
		String deleteQuery = "delete from departments where dept_id=?";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		boolean result=false;
		PreparedStatement preparedStatement = null;
		try {
			

			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, deptId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return result;
	}
	public List<Departments> showDepartments()
	{
		List<Departments> departmentList=new ArrayList<Departments>();
		
		String showQuery="select DEPT_ID,DEPT_NAME from Departments";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		Statement statement=null;
		try {
			statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(showQuery);
			while(resultSet.next())
			{
				Departments department=new Departments(resultSet.getInt(1),resultSet.getString(2));
				departmentList.add(department);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closeStatement(statement, connection);
			
		}
		
		return departmentList;
	}
	public  Departments	findDepartment(int id)
	{
		String query="select DEPT_ID,DEPT_NAME from departments where dept_id=?";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();		
		Departments departments=null;
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				departments=new Departments(resultSet.getInt(1),resultSet.getString(2));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return departments;
		
	}
	public  Departments	findDepartment(String deptName)
	{
		String query="select DEPT_ID,DEPT_NAME from departments where dept_name= ?";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		Departments departments=null;
		PreparedStatement preparedStatement=null;

		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,deptName);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				
				departments=new Departments(resultSet.getInt(1),resultSet.getString(2));
				
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		
		return departments;
		
	}
	public List<Departments> searchDepartment(String deptName)
	{
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		String query="select DEPT_ID,DEPT_NAME from departments where upper(DEPT_NAME) like ?";
		ResultSet resultSet=null;
		List<Departments> departmentList=new ArrayList<Departments>();
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, deptName.toUpperCase() +"%");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				Departments department=new Departments(resultSet.getInt(1),resultSet.getString(2));
				departmentList.add(department);
			}
			
			return departmentList;
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return departmentList;
		
		
		}
	
	
	

}
