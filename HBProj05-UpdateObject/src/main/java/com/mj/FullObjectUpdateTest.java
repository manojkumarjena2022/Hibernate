package com.mj;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mj.entity.Product;

public class FullObjectUpdateTest {

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
			//begin transaction
			tx=session.beginTransaction();
			//prepare object for entity class
			Product product=new Product();
			product.setPid(111001);
			product.setPname("tblee");//new value
			product.setPrice(370f);//new value
			product.setQty(88f);//new value
			//instruction to update object
			session.update(product);
			//commit transaction
			tx.commit();
			System.out.println("Object updated");
		}
		catch (Exception e) {
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null)
				tx.rollback();
			System.out.println("Object is not updated");
			e.printStackTrace();
		}
	}

}
