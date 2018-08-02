package com.sms.service;

import org.springframework.ui.Model;

import com.sms.model.SchoolAdmin;
import com.sms.model.StdIncharge;

public interface IAdmin {

	String adminLogin(SchoolAdmin admin,Model model);
	String stdInchargeRegister(StdIncharge stdIncharge, Model model);
}
