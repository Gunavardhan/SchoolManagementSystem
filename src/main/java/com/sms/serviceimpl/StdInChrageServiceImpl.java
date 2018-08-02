package com.sms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.sms.dao.IStdInchargeDao;
import com.sms.model.StdIncharge;
import com.sms.service.IStdInChrageService;

public class StdInChrageServiceImpl implements IStdInChrageService{
	@Autowired
	private IStdInchargeDao inchargeDao;
	private static final Logger logger = Logger.getLogger(StdInChrageServiceImpl.class);
	public String stdInchargeLogin(StdIncharge stdIncharge, Model model) {
		logger.info("Entered Into Student Incharge Login :: StdInChrageServiceImpl");
		List<StdIncharge> stdInchargeLogin = inchargeDao.stdInchargeLogin(stdIncharge);
		if(stdInchargeLogin.isEmpty()){
			model.addAttribute("errMsg", "Please enter valid credentials");
			return "std-incharge-login";
		}
		return "incharge-profile";
	}

	public String studentRegister(StdIncharge stdIncharge, Model model) {
		return null;
	}

}
