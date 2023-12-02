package com.mj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mj.entity.Product;

public class SaveOrUpdateObjectTest {

	public static void main(String[] args) {
		//configuration object
		Configuration configuration=new Configuration();
		configuration.configure("com/mj/cfgs/hibernate.cfg.xml");
		//create session factory
		SessionFactory factory=configuration.buildSessionFactory();
		//create session object
		Session session=factory.openSession();
		Transaction tx=null;
		try(factory;session){
			//begin transaction
			tx=session.beginTransaction();
			//prepare object for entity class
			Product product=new Product();
			product.setPid(1008);
			product.setPname("tbpe");
			product.setPrice(30f);
			product.setQty(8f);
			//instruction to save/update object
			session.saveOrUpdate(product);
			//commit transaction
			tx.commit();
			System.out.println("Object is saved/updated");
		}
		catch (Exception e) {
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null)
				tx.rollback();
			System.out.println("Object is not saved/updated");
			e.printStackTrace();
		}
	}

}
