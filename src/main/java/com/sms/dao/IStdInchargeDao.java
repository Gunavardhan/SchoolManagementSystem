package com.sms.dao;

import java.util.List;

import com.sms.model.StdIncharge;
import com.sms.model.Student;

public interface IStdInchargeDao {
	List<StdIncharge> stdInchargeLogin(StdIncharge stdIncharge);
	void stdRegister(Student std);
}
