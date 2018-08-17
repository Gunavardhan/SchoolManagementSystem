package com.sms.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.sms.model.SchoolAdmin;
import com.sms.model.StdIncharge;
import com.sms.securityforpwd.SecurePassword;
import com.sms.service.IAdmin;

/**
 * 
 * @author Dell
 *
 */

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
	public String stdInchargeRegister(StdIncharge stdIncharge, Model model) throws Exception{
		logger.info("Entered into student incharge register method :: AdminController");
		String stdInchargeRegister = adminService.stdInchargeRegister(stdIncharge, model);
		SecurePassword pwdDecrypt = new SecurePassword();
		String decryptPwd = pwdDecrypt.decrypt(stdIncharge.getInchargePwd());
		Gson gson = new Gson();
		String jsonReq = gson.toJson(stdIncharge, StdIncharge.class);
		RestTemplate template = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity reqBody = new HttpEntity(jsonReq, header);
		String message = "Hello, " + stdIncharge.getFirstname()  + " You are Successfully Registered " + " Username : " + stdIncharge.getEmail() + " Password : " + decryptPwd;
		String URL = "http://localhost:2017/messaging-restapi/api/generic/sendSms?mobileNum="+stdIncharge.getMobile()+"&message="+message+"";
		System.out.println(URL);
		ResponseEntity<String> responseBody = template.exchange(URL, HttpMethod.POST, reqBody, String.class);
		System.out.println("Response Data : " + responseBody.getBody());
		return stdInchargeRegister;
	}
}
