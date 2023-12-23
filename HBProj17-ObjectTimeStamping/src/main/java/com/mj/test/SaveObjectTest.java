package com.mj.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mj.entity.Stock;


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
		try(ses;factory) {
			//begin transaction 
			tx=ses.beginTransaction();//internally calls con.setAutoCommit(false) to disable auto commit mode on db s/w
			//prepare entity object
			Stock stock=new Stock();
			stock.setStockName("TCS");
			stock.setPrice(200f);
			stock.setExchange("BSE");
			//save object
			Integer pidValue=(Integer) ses.save(stock);//gives persistence instruction to hibernate to save object(insert object data as record)
			tx.commit();//internally calls con.commit() to make insertion execution result permanent
			System.out.println("Generated Id :"+pidValue);
			System.out.println("Record inserted");
		} catch (Exception e) {
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null)
			{
				tx.rollback();//internally calls con.rollback() method to rollback the results of query execution
				System.out.println("record not inserted");
			}
			e.printStackTrace();
			
		}
	}//main
}//class
