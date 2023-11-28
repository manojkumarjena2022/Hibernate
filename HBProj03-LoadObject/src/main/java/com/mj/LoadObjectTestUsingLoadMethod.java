package com.mj;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mj.entity.Product;

public class LoadObjectTestUsingLoadMethod {

	public static void main(String[] args) {
		//configuration object
		Configuration configuration=new Configuration();
		configuration.configure("com/mj/cfgs/hibernate.cfg.xml");
		//create session fatory
		SessionFactory factory=configuration.buildSessionFactory();
		//create session object
		Session session=factory.openSession();
		try(factory;session){
			Product product=session.load(Product.class, 1001);
			if(product!=null)
			{
				System.out.println(product);
				System.out.println(product.getClass()+" "+product.getClass().getSuperclass());
			}
			
		}
		catch (HibernateException e) {
			System.out.println("Product not found !");
			e.printStackTrace();
		}
	}

}
