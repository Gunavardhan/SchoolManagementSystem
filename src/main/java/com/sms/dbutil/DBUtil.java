package com.sms.dbutil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DBUtil {

	private static SessionFactory sessionFactory = null;
	
	private DBUtil(){}
	
	public static SessionFactory getSessionFactory(){
		try {
			if(sessionFactory == null){
				Configuration configure = new Configuration().configure();
				StandardServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configure.getProperties())
						.build();
				sessionFactory = configure.buildSessionFactory(sr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
}
