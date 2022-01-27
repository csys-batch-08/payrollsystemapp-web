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
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(insertQuery);
			
			pstmt.setString(1, grade.getGradeName());
			pstmt.setLong(2, grade.getGradeBasic());
			pstmt.setLong(3, grade.getGradeBonus());
			pstmt.setLong(4, grade.getGradePf());
			pstmt.setLong(5, grade.getGradePt());
			pstmt.setInt(6, grade.getDepartment().getDeptId());
			
			pstmt.executeQuery();
			result=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
			
		}
		
		return result;
		
		
		}
	public  int findGradeID(Grade grade)
	{
		String findId="select grade_id from grades where grade_name= '"+grade.getGradeName()+"' and DEPT_ID="+grade.getDepartment().getDeptId();
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		Statement stmt=null;
		int id = 0;
		try {
			stmt = con.createStatement();
			
			ResultSet rs=stmt.executeQuery(findId);
			if(rs.next()) {
				id=rs.getInt(1);
			}return id;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closeStatement(stmt, con);
		}
		
		return id;
	}
	
	
	public boolean updateGrade(Grade grade)
	{
		String updateQuery = "update  grades set grade_basic=?,grade_bonus=?,grade_pf=?,grade_pt=? where GRADE_ID=?";
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		boolean result=false;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setLong(1,grade.getGradeBasic());
			pstmt.setLong(2, grade.getGradeBonus());
			pstmt.setLong(3, grade.getGradePf());
			pstmt.setLong(4, grade.getGradePt());
			pstmt.setInt(5, grade.getGradeId());

			pstmt.executeUpdate();
			result=true;

		} catch (SQLException e) {
			//catch the exception and get that message
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		return result;
	}
	public boolean deleteGrade(int  gradeId)
	{
		String deleteQuery = "delete from Grades where grade_id=?";
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		boolean result=false;
		PreparedStatement pstmt = null;
		try {
			

			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, gradeId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			//catch the exception and get that message
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		return result;
	}
	public List<Grade> showGrade()
	{
		List<Grade> gradeList=new ArrayList<Grade>();
		
		String showQuery="select GRADE_ID,GRADE_NAME,GRADE_BASIC,GRADE_BONUS,GRADE_PF,GRADE_PT,DEPT_ID from grades";
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		Statement stmt=null;
		try {
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(showQuery);
			while(rs.next())
			{	DepartmentsDaoImpl departmentDao=new DepartmentsDaoImpl();
				Departments department=departmentDao.findDepartment(rs.getInt(7));
				Grade grade=new Grade( rs.getInt(1),department,rs.getString(2), rs.getLong(3), rs.getLong(4),rs.getLong(5),rs.getLong(6));
				gradeList.add(grade);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closeStatement(stmt, con);
			
		}
		
		return gradeList;
	}
	public  Long grossSalary(String grdName,int deptId) 
	{	
		
		
		String qry="select (grade_basic + grade_pf) gross from grades where grade_name = ? and DEPT_ID=?";
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		Long grossSalary=null;
		
			PreparedStatement pstmt=null;
			try {
				pstmt = con.prepareStatement(qry);
				pstmt.setString(1, grdName);
				pstmt.setInt(2, deptId);
				
				ResultSet rs=pstmt.executeQuery();
				
				while(rs.next()) {
					
					grossSalary=rs.getLong(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				ConnectionUtilImpl.closePreparedStatement(pstmt, con);
			}
			
			
			return grossSalary;


		
		
		
	}
	
	public  Grade findGrade(int gradeId) 
	{	
		String qry="select GRADE_ID,GRADE_NAME,GRADE_BASIC,GRADE_BONUS,GRADE_PF,GRADE_PT,DEPT_ID  from grades where GRADE_ID=?";
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		Grade grd=null;
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=con.prepareStatement(qry);
			preparedStatement.setInt(1, gradeId);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				DepartmentsDaoImpl departmentDao=new DepartmentsDaoImpl();

				Departments depart=departmentDao.findDepartment(rs.getInt(7));
				 grd=new Grade(rs.getInt(1),depart,rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getLong(5),rs.getLong(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, con);
		}
		return grd;
		
	}
	
	public  long perDaySalary(String gradeName,int deptId) 
	{
		String query="select (grade_basic/30)perDaySalary from grades where grade_name = ? and DEPT_ID=?";
		long perDaySalary=0;
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, gradeName);
			pstmt.setInt(2, deptId);
			
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				perDaySalary=rs.getLong(1);
			}
			return perDaySalary ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		
		return perDaySalary ;
	}
	public  long basicSalary(String gradeName,int deptId) 
	{
		String query="select grade_basic from grades where grade_name =? and DEPT_ID=?";
		long basicSalary=0;
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		PreparedStatement pstmt=null;
		try {
			
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, gradeName);
			pstmt.setInt(2, deptId);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				basicSalary=rs.getLong(1);
			}
			return basicSalary ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		
		return basicSalary ;
	}
	public  long bonus(String gradeName,int deptId) {
		String query="select grade_bonus from grades where grade_name = ? and DEPT_ID=?";
		long gradeBonus=0;
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		PreparedStatement pstmt=null;
		try {
			
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, gradeName);
			pstmt.setInt(2, deptId);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				gradeBonus=rs.getLong(1);
			}
			return gradeBonus ;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
			
		}
		
		return gradeBonus ;
	}
	public  long providentFund(String gradeName,int deptId) {
		String query="select grade_pf from grades where grade_name = ? and DEPT_ID=?";
		long providentFund=0;
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		PreparedStatement pstmt=null;
		try {
			
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, gradeName);
			pstmt.setInt(2, deptId);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				providentFund=rs.getLong(1);
			}
			return providentFund ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		
		
		return providentFund ;
	}
	public  long professionalTax(String gradeName ,int deptId) {
		String query="select grade_pt from grades where grade_name = ? and DEPT_ID=?";
		long professionalTax=0;
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		PreparedStatement pstmt=null;
		try {
			
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, gradeName);
			pstmt.setInt(2, deptId);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				professionalTax=rs.getLong(1);
			}
			return professionalTax ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		
		return professionalTax ;
	}
	public List<Grade> searchGrade(String grdName)
	{
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		String query="select GRADE_ID,GRADE_NAME,GRADE_BASIC,GRADE_BONUS,GRADE_PF,GRADE_PT,DEPT_ID  from grades where upper(GRADE_NAME) like ?";
		ResultSet rs=null;
		List<Grade> gradeList=new ArrayList<Grade>();
		PreparedStatement pstmt=null;
		

		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, grdName.toUpperCase() +"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				DepartmentsDaoImpl departmentDao=new DepartmentsDaoImpl();
				Departments depart=departmentDao.findDepartment(rs.getInt(7));
				Grade grade=new Grade(rs.getInt(1),depart,rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getLong(5),rs.getLong(6));
				gradeList.add(grade);
			}
			
			
			return gradeList;
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		return gradeList;
		
		
		}
	public  Grade findGrade(String gradeName,int deptId) 
	{
		
		String qry="select GRADE_ID,GRADE_NAME,GRADE_BASIC,GRADE_BONUS,GRADE_PF,GRADE_PT,DEPT_ID  from grades where grade_name = ?  and DEPT_ID=?";
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		Grade grd=null;
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(qry);
			pstmt.setString(1, gradeName);
			pstmt.setInt(2, deptId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				DepartmentsDaoImpl departDao= new DepartmentsDaoImpl();
				Departments depart=departDao.findDepartment(rs.getInt(7));
				 grd=new Grade(rs.getInt(1),depart,rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getLong(5),rs.getLong(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		
		return grd;
		
	}
	
	
}
