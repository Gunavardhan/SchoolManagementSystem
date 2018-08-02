package com.sms.service;

import org.springframework.ui.Model;

import com.sms.model.StdIncharge;

public interface IStdInChrageService {
	String stdInchargeLogin(StdIncharge stdIncharge, Model model);
	String studentRegister(StdIncharge stdIncharge, Model model);
}
