package com.mj.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mj.entity.Movie;
import com.mj.utility.HibernateUtil;

public class SaveObjectWithAnnoTest {

	public static void main(String[] args) {
		//get session factory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get session object
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try(session;factory) {
			//start transaction
			tx=session.beginTransaction();
			//create entity object
			Movie movie=new Movie(101,"Bahubali","Prabhas",50000f);
			session.save(movie);
			tx.commit();
			System.out.println("Movie inserted");
		} catch (Exception e) {
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null)
			{
				tx.rollback();
				System.out.println("Movie not inserted");
			}
			e.printStackTrace();
		}

	}

}
