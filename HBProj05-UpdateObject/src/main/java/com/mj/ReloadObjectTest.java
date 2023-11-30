package com.mj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mj.entity.Product;

public class ReloadObjectTest {

	public static void main(String[] args) {
		//configuration object
		Configuration configuration=new Configuration();
		configuration.configure("com/mj/cfgs/hibernate.cfg.xml");
		//create session fatory
		SessionFactory factory=configuration.buildSessionFactory();
		//create session object
		Session session=factory.openSession();
		try(factory;session){
			//load object
			Product product=session.get(Product.class, 1001);
			if(product==null)
			{
				System.out.println("record not found");
				return;
			}
			//display record before sync
			System.out.println(product);
			System.out.println("Application is going to sleep.....");
			Thread.sleep(30000);//sleep app for 30 secs
			session.refresh(product);//reloads the object data from db table
			//display record after sync
			System.out.println(product);
			System.out.println("Object synced");
		}
		catch (Exception e) {
			System.out.println("Object is not synced");
			e.printStackTrace();
		}
	}

}
