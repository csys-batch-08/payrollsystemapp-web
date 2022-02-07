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
			{"nav.Submit","SUBMIT"}
			
	};

}
