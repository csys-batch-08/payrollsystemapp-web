package com.payroll.bundle;

import java.util.ListResourceBundle;

public class Label  extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		return contents;
	}
	
	static final Object[][] contents= {
			{"nav.Home","HOME"},
			{"nav.EDIT","EDIT"},
			{"nav.Delete","DELETE"},
			{"nav.Submit","SUBMIT"},
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
