package com.mj.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mj.entity.ProgrammerProjId;
import com.mj.entity.ProgrammerProjectInfo;

public class LoadObjectTest {
	public static void main(String[] args) {
		//bootstrap or activate the hibernate
		Configuration cfg=new Configuration();
		//specify the hibernate cfg file name and location
		cfg.configure("com/mj/cfgs/hibernate.cfg.xml");
		//build session factory having all services specified in cfg file and mapping file
		SessionFactory factory=cfg.buildSessionFactory();
		System.out.println(factory.getClass());
		//create session object
		Session ses=factory.openSession();
		System.out.println(ses.getClass());
		try(ses;factory) {
			//prepare proj id
			ProgrammerProjId projId=new ProgrammerProjId(101, 1001);
			//load object
			ProgrammerProjectInfo projectInfo=(ProgrammerProjectInfo)ses.get(ProgrammerProjectInfo.class, projId);
			if(projectInfo!=null)
				System.out.println(projectInfo);
			else
				System.out.println("No record found");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}//main
}//class
