package com.mj.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mj.entity.Product;

public class SaveObjectTest {
	public static void main(String[] args) {
		//bootstrap or activate the hibernate
		Configuration cfg=new Configuration();
		//specify the hibernate cfg file name and location
		cfg.configure("com/mj/cfgs/hibernate.cfg.xml");
		//build session factory having all services specified in cfg file and mapping file
		SessionFactory factory=cfg.buildSessionFactory();
		System.out.println(factory.getClass());
		//create session object
		Session ses=factory.openSession();
		System.out.println(ses.getClass());
		Transaction tx=null;
		boolean flag=false;
		try {
			//begin transaction 
			tx=ses.beginTransaction();//internally calls con.setAutoCommit(false) to disable auto commit mode on db s/w
			//prepare entity object
			Product product=new Product();
			//product.setPid(1005);
			product.setPname("chair");
			product.setPrice(300);
			product.setQty(6);
			//save object
			Integer pidValue=(Integer) ses.save(product);//gives persistence instruction to hibernate to save object(insert object data as record)
			System.out.println("Generated Id :"+pidValue);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag)
			{
				tx.commit();
				System.out.println("Record inserted");
			}
			else
			{
				tx.rollback();//internally calls con.rollback() method to rollback the results of query execution
				System.out.println("record not inserted");
			}
		}
		//close session object
		if(ses!=null)
		{
			try {
				ses.close();
			} catch (HibernateException he) {
				he.printStackTrace();
			}
		}
		
		//close factory object
		if(factory!=null)
		{
			try {
				factory.close();
			} catch (HibernateException he) {
				he.printStackTrace();
			}
		}
		
	}//main
}//class
