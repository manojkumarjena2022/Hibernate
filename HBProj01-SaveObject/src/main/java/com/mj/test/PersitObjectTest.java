package com.mj.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mj.entity.Product;

public class PersitObjectTest {
	public static void main(String[] args) {
		//bootstrap or activate the hibernate
		Configuration cfg=new Configuration();
		//specify the hibernate cfg file name and location
		cfg.configure("com/mj/cfgs/hibernate.cfg.xml");
		//build session factory having all services specified in cfg file and mapping file
		SessionFactory factory=cfg.buildSessionFactory();
		//create session object
		Session ses=factory.openSession();
		Transaction tx=null;
		try {
			//begin transaction 
			tx=ses.beginTransaction();//internally calls con.setAutoCommit(false) to disable auto commit mode on db s/w
			//prepare entity object
			Product product=new Product();
			//product.setPid(55);// exception saying : detached entity passed to persist: com.mj.entity.Product
			product.setPname("chair");
			product.setPrice(300);
			product.setQty(6);
			//save object
			ses.persist(product);//gives persistence instruction to hibernate
			tx.commit();//internally calls con.commit() to make insertion execution result permanent
			System.out.println("Record inserted");
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();//internally calls con.rollback() method to rollback the results of query execution
			System.out.println("record not inserted");
		}
		//close session object
		ses.close();
		//close factory object
		factory.close();
	}//main
}//class
