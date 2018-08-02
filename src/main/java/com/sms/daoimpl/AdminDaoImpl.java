package com.sms.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.IAdminLogin;
import com.sms.dbutil.DBUtil;
import com.sms.model.SchoolAdmin;
import com.sms.model.StdIncharge;

public class AdminDaoImpl implements IAdminLogin {
	private static final Logger logger = Logger.getLogger(AdminDaoImpl.class);

	/*
	 * public List<SchoolAdmin> adminLogin(SchoolAdmin admin) {
	 * System.out.println("Admin Login DAOIMPL :: method"); SessionFactory
	 * sessionFactory = DBUtil.getSessionFactory(); Session session =
	 * sessionFactory.openSession(); Query adminLogin = session.createQuery(
	 * "from SchoolAdmin WHERE admin_name =:email AND admin_pwd =:pwd");
	 * adminLogin.setParameter("email", admin.getAdmin_name());
	 * adminLogin.setParameter("pwd", admin.getAdmin_pwd());
	 * //adminLogin.setParameter("role", "admin"); List<SchoolAdmin> list =
	 * adminLogin.list(); System.out.println(list); return list; }
	 */
	public List<SchoolAdmin> adminLogin(SchoolAdmin admin) {
		logger.info("Admin Login DAOIMPL :: method");
		SessionFactory sessionFactory = DBUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<SchoolAdmin> list = null;
		logger.info("Login User name :" +admin.getAdmin_name());
		Query adminLoginQuery = session
				.createQuery("from SchoolAdmin WHERE admin_name =:email");
		adminLoginQuery.setParameter("email", admin.getAdmin_name());
		logger.info("Login User name :" +admin.getAdmin_name());
		list = adminLoginQuery.list();
		return list;
	}
	
	public void updateSchoolAdmin(SchoolAdmin admin) {
		SessionFactory sessionFactory = DBUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.update(admin);
		session.beginTransaction().commit();
	}
	
	public void stdInchargeRegister(StdIncharge stdIncharge) {
		SessionFactory sessionFactory = DBUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		if(stdIncharge !=null){
			try{
				session.save(stdIncharge);
				session.beginTransaction().commit();
				logger.info("Student incharge successfullly registered :: stdInchargeRegister");
			}catch(Exception e){
				logger.error("Some thing went wrong while storing student incharge :: ", e);
			}
		}
	}

}
