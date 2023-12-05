package com.mj.test;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mj.entity.Movie;
import com.mj.proxy.IMovie;
import com.mj.utility.HibernateUtil;

public class LoadObjectWithAnnoTest {

	public static void main(String[] args) {
		//get session factory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get session object
		Session session=HibernateUtil.getSession();
		try(session;factory) {
			//load entity object
			IMovie movie=session.load(IMovie.class, 101);
			System.out.println(movie.getClass()+"------"+movie.getClass().getSuperclass()+"------"+Arrays.toString(movie.getClass().getInterfaces()));
			System.out.println(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
