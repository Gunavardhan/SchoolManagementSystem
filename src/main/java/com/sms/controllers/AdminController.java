package com.sms.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.model.SchoolAdmin;
import com.sms.model.StdIncharge;
import com.sms.service.IAdmin;

@Controller
public class AdminController {
	private static final Logger logger = Logger.getLogger(AdminController.class);
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
	@RequestMapping(value="/stdinchargeregview")
	public String stdInchargeRegisterView(){
		return "std-incharge-reg";
	}
	@RequestMapping(value="stdinchrageregister" ,method=RequestMethod.POST)
	public String stdInchargeRegister(StdIncharge stdIncharge, Model model){
		logger.info("Entered into student incharge register method :: AdminController");
		String stdInchargeRegister = adminService.stdInchargeRegister(stdIncharge, model);
		if(stdInchargeRegister.equals(true)){
			model.addAttribute("succMsg", "Student Incharge Successfully Created");
		}
		return stdInchargeRegister;
	}
}
