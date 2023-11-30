package com.mj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mj.entity.Product;

public class PartialObjectUpdateTest {

	public static void main(String[] args) {
		//configuration object
		Configuration configuration=new Configuration();
		configuration.configure("com/mj/cfgs/hibernate.cfg.xml");
		//create session fatory
		SessionFactory factory=configuration.buildSessionFactory();
		//create session object
		Session session=factory.openSession();
		Transaction tx=null;
		try(factory;session){
			//load object
			Product product=session.get(Product.class, 1001);
			if(product==null)
			{
				System.out.println("record not found");
				return;
			}
			//begin transaction
			tx=session.beginTransaction();
			//prepare object for entity class
			product.setPrice(30f);//new value
			product.setQty(8f);//new value
			//instruction to update object
			session.update(product);
			//commit transaction
			tx.commit();
			System.out.println("Partial Object updated");
		}
		catch (Exception e) {
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null)
				tx.rollback();
			System.out.println("Object is not updated");
			e.printStackTrace();
		}
	}

}
