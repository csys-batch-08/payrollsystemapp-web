package service;

public class LoginService {

	public boolean validate(String name) {
		boolean flag=false;
		if(name.equals("mani")) {
			flag=true;
		}
		return flag;
		
	}
}
