package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.payroll.service.AdminService;

@RestController
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView loginValidate(@RequestParam("email") String email, @RequestParam("pass") String password,
			HttpServletRequest req, HttpServletResponse res) {

		AdminService adminService = new AdminService();

		boolean adminFlag = adminService.validate(email, password);
		ModelAndView mv = new ModelAndView("adminControl");

		if (adminFlag) {
			System.out.println("login successfully");

		} else {
			System.out.println("login terminated");
		}
		return mv;

	}

}
