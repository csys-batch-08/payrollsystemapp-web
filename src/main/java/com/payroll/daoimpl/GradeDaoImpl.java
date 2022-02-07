package com.payroll.daoimpl;
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
	static final String GRADEID="GRADE_ID";
	static final String GRADENAME="GRADE_NAME";
	static final String GRADEBASIC="GRADE_BASIC";
	static final String GRADEBONUS="GRADE_BONUS";
	static final String GRADEPF="GRADE_PF";
	static final String GRADEPT="GRADE_PT";
	static final String DEPTID="DEPT_ID";
	static final String GROSS="gross";
	static final String PERDAYSALARY="perDaySalary";
	public boolean insertGrade(Grade grade) 
	{	boolean result=false;
		String insertQuery="insert into Grades (grade_name,grade_basic,grade_bonus,grade_pf,grade_pt,"
				+ "DEPT_ID) values (?,?,?,?,?,?)";
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
		String findId="select grade_id from grades where grade_name= ? and DEPT_ID=?";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement=null;
		int id = 0;
		ResultSet resultSet=null;
		try {
			preparedStatement=connection.prepareStatement(findId);
			preparedStatement.setString(1, grade.getGradeName());
			preparedStatement.setInt(2, grade.getDepartment().getDeptId());
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				id=resultSet.getInt(GRADEID);
			}return id;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		
		return id;
	}
	
	
	public boolean updateGrade(Grade grade)
	{
		String updateQuery = "update  grades set grade_basic=?,grade_bonus=?,grade_pf=?,"
				+ "grade_pt=? where GRADE_ID=?";
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
		List<Grade> gradeList=new ArrayList();
		
		String showQuery="select GRADE_ID,GRADE_NAME,GRADE_BASIC,GRADE_BONUS,GRADE_PF,"
				+ "GRADE_PT,DEPT_ID from grades";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(showQuery);
			while(resultSet.next())
			{	DepartmentsDaoImpl departmentDao=new DepartmentsDaoImpl();
				Departments department=departmentDao.findDepartment(resultSet.getInt(DEPTID));
				Grade grade=new Grade( resultSet.getInt(GRADEID),department,resultSet.getString(GRADENAME), 
						resultSet.getLong(GRADEBASIC), resultSet.getLong(GRADEBONUS),resultSet.getLong(GRADEPF),
						resultSet.getLong(GRADEPT));
				gradeList.add(grade);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closeStatement(statement, connection, resultSet);
			
		}
		
		return gradeList;
	}
	public  Long grossSalary(String grdName,int deptId) 
	{	
		
		
		String qry="select (grade_basic + grade_pf) as gross from grades where grade_name = ? and DEPT_ID=?";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		Long grossSalary=null;
		ResultSet resultSet=null;
			PreparedStatement preparedStatement=null;
			try {
				preparedStatement = connection.prepareStatement(qry);
				preparedStatement.setString(1, grdName);
				preparedStatement.setInt(2, deptId);
				
				resultSet=preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					
					grossSalary=resultSet.getLong(GROSS);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
			}
			
		return grossSalary;


	}
	
	public  Grade findGrade(int gradeId) 
	{	
		String qry="select GRADE_ID,GRADE_NAME,GRADE_BASIC,GRADE_BONUS,GRADE_PF,"
				+ "GRADE_PT,DEPT_ID  from grades where GRADE_ID=?";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		Grade grd=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(qry);
			preparedStatement.setInt(1, gradeId);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				DepartmentsDaoImpl departmentDao=new DepartmentsDaoImpl();

				Departments depart=departmentDao.findDepartment(resultSet.getInt(DEPTID));
				 grd=new Grade(resultSet.getInt(GRADEID),depart,resultSet.getString(GRADENAME),
						 resultSet.getLong(GRADEBASIC),resultSet.getLong(GRADEBONUS),
						 resultSet.getLong(GRADEPF),resultSet.getLong(GRADEPT));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return grd;
		
	}
	
	public  long perDaySalary(String gradeName,int deptId) 
	{
		String query="select (grade_basic/30) as perDaySalary from grades where grade_name = ?"
				+ " and DEPT_ID=?";
		long perDaySalary=0;
		ResultSet resultSet=null;
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, gradeName);
			preparedStatement.setInt(2, deptId);
			
			resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				perDaySalary=resultSet.getLong(PERDAYSALARY);
			}
			return perDaySalary ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
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
		ResultSet resultSet=null;
		try {
			
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, gradeName);
			preparedStatement.setInt(2, deptId);
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				basicSalary=resultSet.getLong(GRADEBASIC);
			}
			return basicSalary ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		
		return basicSalary ;
	}
	public  long bonus(String gradeName,int deptId) {
		String query="select grade_bonus from grades where grade_name = ? and DEPT_ID=?";
		long gradeBonus=0;
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, gradeName);
			preparedStatement.setInt(2, deptId);
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				gradeBonus=resultSet.getLong(GRADEBONUS);
			}
			return gradeBonus ;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
			
		}
		
		return gradeBonus ;
	}
	public  long providentFund(String gradeName,int deptId) {
		String query="select grade_pf from grades where grade_name = ? and DEPT_ID=?";
		long providentFund=0;
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, gradeName);
			preparedStatement.setInt(2, deptId);
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				providentFund=resultSet.getLong(GRADEPF);
			}
			return providentFund ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return providentFund ;
	}
	public  long professionalTax(String gradeName ,int deptId) {
		String query="select grade_pt from grades where grade_name = ? and DEPT_ID=?";
		long professionalTax=0;
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, gradeName);
			preparedStatement.setInt(2, deptId);
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				professionalTax=resultSet.getLong(GRADEPT);
			}
			return professionalTax ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		
		return professionalTax ;
	}
	public List<Grade> searchGrade(String grdName)
	{
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		String query="select GRADE_ID,GRADE_NAME,GRADE_BASIC,GRADE_BONUS,GRADE_PF,"
				+ "GRADE_PT,DEPT_ID  from grades where upper(GRADE_NAME) like ?";
		ResultSet resultSet=null;
		List<Grade> gradeList=new ArrayList();
		PreparedStatement preparedStatement=null;
		

		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, grdName.toUpperCase() +"%");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				DepartmentsDaoImpl departmentDao=new DepartmentsDaoImpl();
				Departments depart=departmentDao.findDepartment(resultSet.getInt(DEPTID));
				Grade grade=new Grade(resultSet.getInt(GRADEID),depart,resultSet.getString(GRADENAME),
						resultSet.getLong(GRADEBASIC),resultSet.getLong(GRADEBONUS),
						resultSet.getLong(GRADEPF),resultSet.getLong(GRADEPT));
				gradeList.add(grade);
			}
			
			
			return gradeList;
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return gradeList;
		
		
		}
	public  Grade findGrade(String gradeName,int deptId) 
	{
		
		String qry="select GRADE_ID,GRADE_NAME,GRADE_BASIC,GRADE_BONUS,GRADE_PF,GRADE_PT,"
				+ "DEPT_ID  from grades where grade_name = ?  and DEPT_ID=?";
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		Grade grd=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(qry);
			preparedStatement.setString(1, gradeName);
			preparedStatement.setInt(2, deptId);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				DepartmentsDaoImpl departDao= new DepartmentsDaoImpl();
				Departments depart=departDao.findDepartment(resultSet.getInt(DEPTID));
				 grd=new Grade(resultSet.getInt(GRADEID),depart,resultSet.getString(GRADENAME),
						 resultSet.getLong(GRADEBASIC),resultSet.getLong(GRADEBONUS),resultSet.getLong(GRADEPF),
						 resultSet.getLong(GRADEPT));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		
		return grd;
		
	}
	public boolean validateGradeName(Grade grade) {
		boolean flag = true;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Connection connection =null;
		try {
			ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
			connection = connectionUtilImpl.dbConnect();
			String query = "select GRADE_NAME from grades where GRADE_NAME=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, grade.getGradeName());
		    resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				
				flag = false;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return flag;
	}

	
	
}
