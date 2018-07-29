package com.sms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.model.SchoolAdmin;
import com.sms.service.IAdmin;

@Controller
public class AdminController {
	@Autowired
	IAdmin adminService;
	@RequestMapping(value="/adminlogin", method=RequestMethod.POST)
	public String adminLogin(SchoolAdmin admin,Model model){
		System.out.println("Admin Login Controller :: adminLogin method");
		String adminLogin = adminService.adminLogin(admin, model);
		return adminLogin;
	}
	@RequestMapping(value="/gotoadminlogin")
	public String openAdminLogin(){
		return "admin-login";
	}
	@RequestMapping(value="/stdinchargereg")
	public String stdInchargeRegister(){
		return "std-incharge-reg";
	}
	
}
