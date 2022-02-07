package com.payroll.bundle;

import java.util.ListResourceBundle;

public class InputLabel  extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		return contents;
	}
	static final Object[][] contents= {
			{"nav.Department","DEPARTMENT"},
			{"nav.Address","ADDRESS"},
			{"nav.City","CITY"},
			{"nav.Pincode","PINCODE"},
			{"nav.State","STATE"},
			{"nav.Dob","DOB"},
			{"nav.Doj","DOJ"},
			{"nav.Email","EMAIL"},
			{"nav.Status","STATUS"},
			{"nav.Active","ACTIVE"},
			{"nav.Payroll","PAYROLL"}
			
	};

}
