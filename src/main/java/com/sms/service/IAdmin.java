package com.sms.service;

import org.springframework.ui.Model;

import com.sms.model.SchoolAdmin;

public interface IAdmin {

	String adminLogin(SchoolAdmin admin,Model model);
}
