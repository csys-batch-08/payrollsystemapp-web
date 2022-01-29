package com.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.payroll.model.Departments;
import com.payroll.model.Grade;

public class GradeDaoImpl {
	public boolean insertGrade(Grade grade) 
	{	boolean result=false;
		String insertQuery="insert into Grades (grade_name,grade_basic,grade_bonus,grade_pf,grade_pt,DEPT_ID) values (?,?,?,?,?,?)";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(insertQuery);
			
			preparedStatement.setString(1, grade.getGradeName());
			preparedStatement.setLong(2, grade.getGradeBasic());
			preparedStatement.setLong(3, grade.getGradeBonus());
			preparedStatement.setLong(4, grade.getGradePf());
			preparedStatement.setLong(5, grade.getGradePt());
			preparedStatement.setInt(6, grade.getDepartment().getDeptId());
			
			preparedStatement.executeQuery();
			result=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
			
		}
		
		return result;
		
		
		}
	public  int findGradeID(Grade grade)
	{
		String findId="select grade_id from grades where grade_name= '"+grade.getGradeName()+"' and DEPT_ID="+grade.getDepartment().getDeptId();
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		Statement statement=null;
		int id = 0;
		try {
			statement = connection.createStatement();
			
			ResultSet resultSet=statement.executeQuery(findId);
			if(resultSet.next()) {
				id=resultSet.getInt(1);
			}return id;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closeStatement(statement, connection);
		}
		
		return id;
	}
	
	
	public boolean updateGrade(Grade grade)
	{
		String updateQuery = "update  grades set grade_basic=?,grade_bonus=?,grade_pf=?,grade_pt=? where GRADE_ID=?";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		boolean result=false;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setLong(1,grade.getGradeBasic());
			preparedStatement.setLong(2, grade.getGradeBonus());
			preparedStatement.setLong(3, grade.getGradePf());
			preparedStatement.setLong(4, grade.getGradePt());
			preparedStatement.setInt(5, grade.getGradeId());

			preparedStatement.executeUpdate();
			result=true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return result;
	}
	public boolean deleteGrade(int  gradeId)
	{
		String deleteQuery = "delete from Grades where grade_id=?";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		boolean result=false;
		PreparedStatement preparedStatement = null;
		try {
			

			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, gradeId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return result;
	}
	public List<Grade> showGrade()
	{
		List<Grade> gradeList=new ArrayList<Grade>();
		
		String showQuery="select GRADE_ID,GRADE_NAME,GRADE_BASIC,GRADE_BONUS,GRADE_PF,GRADE_PT,DEPT_ID from grades";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		Statement statement=null;
		try {
			statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(showQuery);
			while(resultSet.next())
			{	DepartmentsDaoImpl departmentDao=new DepartmentsDaoImpl();
				Departments department=departmentDao.findDepartment(resultSet.getInt(7));
				Grade grade=new Grade( resultSet.getInt(1),department,resultSet.getString(2), resultSet.getLong(3), resultSet.getLong(4),resultSet.getLong(5),resultSet.getLong(6));
				gradeList.add(grade);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closeStatement(statement, connection);
			
		}
		
		return gradeList;
	}
	public  Long grossSalary(String grdName,int deptId) 
	{	
		
		
		String qry="select (grade_basic + grade_pf) gross from grades where grade_name = ? and DEPT_ID=?";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		Long grossSalary=null;
		
			PreparedStatement preparedStatement=null;
			try {
				preparedStatement = connection.prepareStatement(qry);
				preparedStatement.setString(1, grdName);
				preparedStatement.setInt(2, deptId);
				
				ResultSet rs=preparedStatement.executeQuery();
				
				while(rs.next()) {
					
					grossSalary=rs.getLong(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
			}
			
			
			return grossSalary;


		
		
		
	}
	
	public  Grade findGrade(int gradeId) 
	{	
		String qry="select GRADE_ID,GRADE_NAME,GRADE_BASIC,GRADE_BONUS,GRADE_PF,GRADE_PT,DEPT_ID  from grades where GRADE_ID=?";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		Grade grd=null;
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(qry);
			preparedStatement.setInt(1, gradeId);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				DepartmentsDaoImpl departmentDao=new DepartmentsDaoImpl();

				Departments depart=departmentDao.findDepartment(resultSet.getInt(7));
				 grd=new Grade(resultSet.getInt(1),depart,resultSet.getString(2),resultSet.getLong(3),resultSet.getLong(4),resultSet.getLong(5),resultSet.getLong(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return grd;
		
	}
	
	public  long perDaySalary(String gradeName,int deptId) 
	{
		String query="select (grade_basic/30)perDaySalary from grades where grade_name = ? and DEPT_ID=?";
		long perDaySalary=0;
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, gradeName);
			preparedStatement.setInt(2, deptId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				perDaySalary=resultSet.getLong(1);
			}
			return perDaySalary ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		
		return perDaySalary ;
	}
	public  long basicSalary(String gradeName,int deptId) 
	{
		String query="select grade_basic from grades where grade_name =? and DEPT_ID=?";
		long basicSalary=0;
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement=null;
		try {
			
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, gradeName);
			preparedStatement.setInt(2, deptId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				basicSalary=resultSet.getLong(1);
			}
			return basicSalary ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		
		return basicSalary ;
	}
	public  long bonus(String gradeName,int deptId) {
		String query="select grade_bonus from grades where grade_name = ? and DEPT_ID=?";
		long gradeBonus=0;
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement=null;
		try {
			
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, gradeName);
			preparedStatement.setInt(2, deptId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				gradeBonus=resultSet.getLong(1);
			}
			return gradeBonus ;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
			
		}
		
		return gradeBonus ;
	}
	public  long providentFund(String gradeName,int deptId) {
		String query="select grade_pf from grades where grade_name = ? and DEPT_ID=?";
		long providentFund=0;
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement=null;
		try {
			
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, gradeName);
			preparedStatement.setInt(2, deptId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				providentFund=resultSet.getLong(1);
			}
			return providentFund ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		
		
		return providentFund ;
	}
	public  long professionalTax(String gradeName ,int deptId) {
		String query="select grade_pt from grades where grade_name = ? and DEPT_ID=?";
		long professionalTax=0;
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement=null;
		try {
			
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, gradeName);
			preparedStatement.setInt(2, deptId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				professionalTax=resultSet.getLong(1);
			}
			return professionalTax ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		
		return professionalTax ;
	}
	public List<Grade> searchGrade(String grdName)
	{
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		String query="select GRADE_ID,GRADE_NAME,GRADE_BASIC,GRADE_BONUS,GRADE_PF,GRADE_PT,DEPT_ID  from grades where upper(GRADE_NAME) like ?";
		ResultSet resultSet=null;
		List<Grade> gradeList=new ArrayList<Grade>();
		PreparedStatement preparedStatement=null;
		

		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, grdName.toUpperCase() +"%");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				DepartmentsDaoImpl departmentDao=new DepartmentsDaoImpl();
				Departments depart=departmentDao.findDepartment(resultSet.getInt(7));
				Grade grade=new Grade(resultSet.getInt(1),depart,resultSet.getString(2),resultSet.getLong(3),resultSet.getLong(4),resultSet.getLong(5),resultSet.getLong(6));
				gradeList.add(grade);
			}
			
			
			return gradeList;
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return gradeList;
		
		
		}
	public  Grade findGrade(String gradeName,int deptId) 
	{
		
		String qry="select GRADE_ID,GRADE_NAME,GRADE_BASIC,GRADE_BONUS,GRADE_PF,GRADE_PT,DEPT_ID  from grades where grade_name = ?  and DEPT_ID=?";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		Grade grd=null;
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(qry);
			preparedStatement.setString(1, gradeName);
			preparedStatement.setInt(2, deptId);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				DepartmentsDaoImpl departDao= new DepartmentsDaoImpl();
				Departments depart=departDao.findDepartment(resultSet.getInt(7));
				 grd=new Grade(resultSet.getInt(1),depart,resultSet.getString(2),resultSet.getLong(3),resultSet.getLong(4),resultSet.getLong(5),resultSet.getLong(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		
		return grd;
		
	}
	
	
}
