package com.mj.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		System.out.println("HibernateUtil.static block");
		//create configuration videos
		Configuration cfg=new Configuration();
		//load and read hibernate cfg file
		cfg.configure("com/mj/cfgs/hibernate.cfg.xml");
		//create session factory object
		factory=cfg.buildSessionFactory();
	}
	//static factory method for sessionFactory object
	public static SessionFactory getSessionFactory(){
		return factory;
	}
	//static factory method for session object
	public static Session getSession()
	{
		Session ses=null;
		if(factory!=null)
		{
			ses=factory.openSession();
		}
		return ses;
	}
}
