package com.mj;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mj.entity.Product;
import com.mj.utility.HibernateUtil;

public class Approach2MergeObjectProblemTest {

	public static void main(String[] args) {
		//get session factory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get session object
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try{
			//begin transaction
			tx=session.beginTransaction();
			Product prod1=session.get(Product.class, 1009);
			if(prod1!=null)
				System.out.println(prod1);

			Product product=new Product();
			product.setPid(1009);
			product.setPname("mkkk");
			product.setPrice(10f);
			product.setQty(12f);

			session.update(product);
			System.out.println(product);
			flag=true;
		}

		catch (HibernateException e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag)
			{
				tx.commit();
			}
			else
			{
				tx.rollback();
			}
			session.close();
			factory.close();
		}
	}

}
