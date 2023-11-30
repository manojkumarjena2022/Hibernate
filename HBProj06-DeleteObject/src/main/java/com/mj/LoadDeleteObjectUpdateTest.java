package com.mj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mj.entity.Product;

public class LoadDeleteObjectUpdateTest {

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
			Product product=session.get(Product.class, 1003);
			//System.out.println(product);
			if(product==null)
			{
				System.out.println("Record not found for delete");
				return;
			}
			else
			{
				//begin transaction
				tx=session.beginTransaction();
				//instruction to delete object
				session.delete(product);
				//commit transaction
				tx.commit();
				System.out.println("Object deleted");
			}

		}
		catch (Exception e) {
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null)
				tx.rollback();
			System.out.println("Object is not deleted");
			e.printStackTrace();
		}
	}

}
