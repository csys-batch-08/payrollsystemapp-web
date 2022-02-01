package com.payroll.daoimpl;


import java.util.Date;
import java.util.List;

import com.payroll.model.Leave;

public interface LeaveDao {

	public boolean insertLeave(Leave leave) ;
	public List<Leave> showLeaveDetail();
	public  int findLeaveID(Leave leave);
	public  Leave findLeave(Date leaveDt,int empId);
	public  int leaveDays(int empID);
	public  Leave findLeave(int leaveId);
}
