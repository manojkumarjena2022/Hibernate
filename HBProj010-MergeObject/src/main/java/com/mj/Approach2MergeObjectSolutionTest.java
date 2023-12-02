package com.mj;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mj.entity.Product;
import com.mj.utility.HibernateUtil;

public class Approach2MergeObjectSolutionTest {

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
			product.setPname("mk");
			product.setPrice(100f);
			product.setQty(12f);
			System.out.println(prod1.hashCode()+" "+product.hashCode());
			//session.update(product);
			Product prod2=(Product)session.merge(product);
			System.out.println(prod1.hashCode()+" "+product.hashCode()+" "+prod2.hashCode());
			System.out.println(prod1);
			System.out.println(product);
			System.out.println(prod2);

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
