package com.sms.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.sms.dao.IAdminLogin;
import com.sms.model.SchoolAdmin;
import com.sms.model.StdIncharge;
import com.sms.service.IAdmin;

public class AdminServiceImpl implements IAdmin{
	private static final Logger logger = Logger.getLogger(AdminServiceImpl.class);
	@Autowired
	IAdminLogin adminDao;
	public String adminLogin(SchoolAdmin admin,Model model) {
		logger.info("ENTERED INTO ADMIN LOGIN SERVICE :: AdminServiceImpl");
		List<SchoolAdmin> list = adminDao.adminLogin(admin);
		
		if (!list.isEmpty()) {
			SchoolAdmin schoolAdminDao = list.get(0);
			System.out.println("ADMIN PASSWORD :: " +schoolAdminDao.getAdmin_pwd());
			if(schoolAdminDao.getAdmin_pwd().equals(admin.getAdmin_pwd()) && !schoolAdminDao.getUser_status().equals(true) && schoolAdminDao.getCount() != 3) {
				return "admin-profile";
			} else {
				int attempts = schoolAdminDao.getCount();
				if(attempts < 3) {
					schoolAdminDao.setCount(++attempts);	
					model.addAttribute("message", "Entered password is incorrect!! Attempts : " + attempts);
					adminDao.updateSchoolAdmin(schoolAdminDao);
					return "admin-login";
				} else {
					model.addAttribute("message", "User attempts are exceeded 3 times!! Account has been locked!!");
					schoolAdminDao.setUser_status(true);
					adminDao.updateSchoolAdmin(schoolAdminDao);
					return "admin-login";
				}
			}
		} 
		else {
			model.addAttribute("message", "User name is not exist!!");
			return "admin-login";
		}
	}
	public String stdInchargeRegister(StdIncharge stdIncharge, Model model) {
		logger.info("Entered into Student Incharge Register :: stdInchargeRegister method");
		adminDao.stdInchargeRegister(stdIncharge);
		return "admin-profile";
	}

}
