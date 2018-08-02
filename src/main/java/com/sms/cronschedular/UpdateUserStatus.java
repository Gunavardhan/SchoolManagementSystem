package com.sms.cronschedular;


import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.scheduling.annotation.Scheduled;

import com.sms.dbutil.DBUtil;

public class UpdateUserStatus {
	
	@Scheduled(cron="*/200 * * * * ?") //for every 90 seconds triggered this method
	//@Scheduled(cron = "0 15 10 * * ? 2019") //Fires at 10:15 AM every day in the year 2019:
	//@Scheduled(cron="0 8 11 * * ?") //Fires at 11:08 AM every day
	public void testCronSchedular(){
		System.out.println("Method executed at every 200 seconds :: " + new Date());
		SessionFactory sessionFactory = DBUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query updateUserStatusQuery = session.createSQLQuery("UPDATE sms_admin SET user_status = false,count=0 WHERE admin_name='admin@gmail.com' AND role='ADMIN'; ");
		int updateCount = updateUserStatusQuery.executeUpdate();
		session.beginTransaction().commit();
		System.out.println("UPDTAE COUNT : " + updateCount);
		//System.out.println("Method executed at every 5 seconds :: " + new Date());
	}

}
