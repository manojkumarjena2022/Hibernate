package com.mj.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mj.entity.Movie;
import com.mj.utility.HibernateUtil;

public class LoadObjectWithAnnoTest {

	public static void main(String[] args) {
		//get session factory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get session object
		Session session=HibernateUtil.getSession();
		try(session;factory) {
			//load entity object
			Movie movie=session.get(Movie.class, 101);
			if(movie!=null)
				System.out.println(movie);
			else
				System.out.println("Record not found");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
