package com.sms.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.model.StdIncharge;
import com.sms.service.IStdInChrageService;

@Controller
public class StudentInchargeController {
	@Autowired
	private IStdInChrageService stdInchargeService = null;
	private static final Logger logger = Logger.getLogger(StudentInchargeController.class);
	
	@RequestMapping(value="/gotoinchargeloginview")
	public String openInchargeLoginView(){
		logger.info("Incharge login view page opened :: StudentInchargeController");
		return "std-incharge-login";
	}
	
	@RequestMapping(value="/inchargelogin" , method=RequestMethod.POST)
	public String loginStdInchrage(StdIncharge stdIncharge,Model model){
		logger.info("Entered into Student Incharge login :: loginStdInchrage");
		String loginProfile = stdInchargeService.stdInchargeLogin(stdIncharge, model);
		return loginProfile;
	}
	
}
