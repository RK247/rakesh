package com.jlcindia.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab17A {
	public static void main(String[] args) {
		Transaction tx=null;
		try {
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session session=sf.openSession();
		    tx=session.beginTransaction();
		    
		    Student s1=new Student("Sri", "sri@jlc", 9999);
		    Student s2=new Student("Sm", "sr@jlc", 9889);
		    Student s3=new Student("Sn", "sq@jlc", 7788);
		    session.save(s1);
		    session.save(s2);
		    session.save(s3);
		  Course c1=new Course("java", new Integer(9), new Double(999));  
		  Course c2=new Course("jsp", new Integer(8), new Double(888));  
		  Course c3=new Course("ejb", new Integer(7), new Double(777));  
		    session.save(c1);
		    session.save(c2);
		    session.save(c3);
		Set<Course> cs1=new HashSet<Course>();
		cs1.add(c1);
		cs1.add(c2);
		cs1.add(c3);
		s1.setCourses(cs1);
		
		Set<Course> cs2=new HashSet<Course>();
		cs2.add(c1);
		cs2.add(c2);
		cs2.add(c3);
		s2.setCourses(cs2);
		tx.commit();
		session.close();

		System.out.println("Record Inserted");
		}catch(Exception e)
		{
		e.printStackTrace();
		if(tx !=null)
		tx.rollback();
		
		}
	}

}
		