package Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class WordDaoUtil {
	private static SessionFactory factory;
	static{
		try{
		Configuration cfg=new Configuration().configure();
		factory=cfg.buildSessionFactory();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Session getSession(){
		return factory.openSession();
	}
	
	public static void closeSession(Session session){
		if(session!=null){
			if(session.isOpen())
				System.out.println("¹Ø±ÕSession");
				session.close();
		}
	}
	public static SessionFactory getSessionFactory(){
		return factory;
	}
	
}
