package com.mj;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mj.entity.Product;
import com.mj.utility.HibernateUtil;

public class LoadObjectTestUsingHibernateUtilClass {

	public static void main(String[] args) {
		//get session factory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get session object
		Session session=HibernateUtil.getSession();
		try(factory;session){
			Product product=session.load(Product.class, 1009);
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
