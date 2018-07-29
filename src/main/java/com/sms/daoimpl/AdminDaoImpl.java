package com.sms.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.sms.dao.IAdminLogin;
import com.sms.dbutil.DBUtil;
import com.sms.model.SchoolAdmin;
import com.sms.model.StdIncharge;

public class AdminDaoImpl implements IAdminLogin{
	public List<SchoolAdmin> adminLogin(SchoolAdmin admin) {
		System.out.println("Admin Login DAOIMPL :: method");
		SessionFactory sessionFactory = DBUtil.getSessionFactory();		
		Session session = sessionFactory.openSession();
			Query adminLogin = session.createQuery("from SchoolAdmin WHERE admin_name =:email AND admin_pwd =:pwd");
			adminLogin.setParameter("email", admin.getAdmin_name());
			adminLogin.setParameter("pwd", admin.getAdmin_pwd());
			//adminLogin.setParameter("role", "admin");
			List<SchoolAdmin> list = adminLogin.list();
			System.out.println(list);
		return list;
	}

	public void stdInchargeRegister(StdIncharge stdIncharge) {
		
	}

}
