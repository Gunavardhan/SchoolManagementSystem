package com.sms.dao;

import java.util.List;
import com.sms.model.SchoolAdmin;
import com.sms.model.StdIncharge;

public interface IAdminLogin {
	List<SchoolAdmin> adminLogin(SchoolAdmin admin);
	void stdInchargeRegister(StdIncharge stdIncharge);
}
