package com.sms.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.IStdInchargeDao;
import com.sms.dbutil.DBUtil;
import com.sms.model.StdIncharge;
import com.sms.model.Student;

public class StdInChrageDaoImpl implements IStdInchargeDao {
	private static final Logger logger = Logger.getLogger(StdInChrageDaoImpl.class);
	private SessionFactory sessionFactory = DBUtil.getSessionFactory();
	private Session session = null;

	@SuppressWarnings("unchecked")
	public List<StdIncharge> stdInchargeLogin(StdIncharge stdIncharge) {
		logger.info("Entered into Student Incharge login");
		session = sessionFactory.openSession();
		Query inchargeLoginQuery = session.createQuery("from StdIncharge WHERE email =:email AND inchargePwd =:pwd");
		inchargeLoginQuery.setParameter("email", stdIncharge.getEmail());
		inchargeLoginQuery.setParameter("pwd", stdIncharge.getInchargePwd());
		List<StdIncharge> list = inchargeLoginQuery.list();
		return list;
	}

	public void stdRegister(Student std) {
		// TODO Auto-generated method stub
		
	}
}
