package com.mj.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mj.entity.CallerTune;

public class UpdateObjectTest {
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
			//load object
			CallerTune tune=ses.get(CallerTune.class, 22);
			if(tune==null)
			{
				System.out.println("Record not exist !");
				return;
			}
			//begin transaction 
			tx=ses.beginTransaction();//internally calls con.setAutoCommit(false) to disable auto commit mode on db s/w
			//prepare entity object
			tune.setTuneName("aye bittsas");
			//update object
			ses.update(tune);//gives persistence instruction to hibernate to update object(insert object data as record)
			tx.commit();//internally calls con.commit() to make insertion execution result permanent
			System.out.println("object is updated for.."+tune.getUpdationCount());
			System.out.println("Record updated");
		} catch (Exception e) {
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null)
			{
				tx.rollback();//internally calls con.rollback() method to rollback the results of query execution
				System.out.println("record not updated");
			}
			e.printStackTrace();
			
		}
	}//main	
}
