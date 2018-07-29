package com.sms.dao;

import java.util.List;

import com.sms.model.StdIncharge;
import com.sms.model.Student;

public interface IStdIncharge {
	List<StdIncharge> loginStdIncharge(StdIncharge stdIncharge);
	void stdRegister(Student std);
}
