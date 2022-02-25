package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.payroll.dao.EmployeeDao;
import com.payroll.entity.EmployeeEntity;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDao employRepo;

	@RequestMapping("/ShowEmployee")
	@ResponseBody
	public ModelAndView showEmploy() {

		ModelAndView mv = new ModelAndView();

		List<EmployeeEntity> employList = employRepo.findAll();
		mv.addObject("empList", employList);
		mv.setViewName("employeeShow.jsp");

		return mv;

	}

}
