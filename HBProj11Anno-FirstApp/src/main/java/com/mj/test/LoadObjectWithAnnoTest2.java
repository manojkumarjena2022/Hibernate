package com.mj.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mj.entity.Movie;
import com.mj.utility.HibernateUtil;

public class LoadObjectWithAnnoTest2 {

	public static void main(String[] args) {
		//get session factory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get session object
		Session session=HibernateUtil.getSession();
		try(session;factory) {
			//load entity object
			Movie movie=session.load(Movie.class, 101);
			//System.out.println(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
