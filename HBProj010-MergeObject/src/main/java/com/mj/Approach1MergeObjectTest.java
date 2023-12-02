package com.mj;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mj.entity.Product;
import com.mj.utility.HibernateUtil;

public class Approach1MergeObjectTest {

	public static void main(String[] args) {
		//get session factory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get session object
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;session){
			//begin transaction
			tx=session.beginTransaction();
			Product product=new Product();
			product.setPid(1002);
			product.setPname("mkkk");
			product.setPrice(10f);
			product.setQty(12f);
			
			Product prod1=(Product) session.merge(product);
			tx.commit();
			System.out.println(product);
			System.out.println(prod1);
			System.out.println("Object saved or updated");
		}
		
		catch (HibernateException e) {
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
			{
				tx.rollback();
				System.out.println("Object saved or updated");
			}
			
			e.printStackTrace();
		}
	}

}
