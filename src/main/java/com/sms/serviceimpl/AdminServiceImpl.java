package com.sms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.sms.dao.IAdminLogin;
import com.sms.model.SchoolAdmin;
import com.sms.service.IAdmin;

public class AdminServiceImpl implements IAdmin{
	@Autowired
	IAdminLogin adminDao;
	public String adminLogin(SchoolAdmin admin,Model model) {
		List<SchoolAdmin> adminLogin = adminDao.adminLogin(admin);
		if(adminLogin.isEmpty()){
			model.addAttribute("errMsg", "Invalid Credentials, Please try again...!!!");
			return "admin-login";
		}/*else if(admin.getAdmin_name().equals("admin@gmail.com") && admin.getAdmin_pwd().equals("admin")){
			return "admin-profile";
		}else if(!admin.getAdmin_name().equals("admin@gmail.com") && !admin.getAdmin_pwd().equals("admin")){
			model.addAttribute("errMsg", "Invalid Credentials, Please try again...!!!");
			return "admin-login";
		}*/
		return "admin-profile";
	}

}
