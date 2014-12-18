package Princ;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Hbiemps;
import primero.HbiempsId;
import primero.SessionFactoryUtil;

public class Estadisticas {

	
	public static long NumEmps(){
		
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("SELECT count(empNo) FROM Empleados");
	
		long emps = (long) q.uniqueResult();
		return emps;
	}
	
	public static double MidSalar(){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("SELECT avg(salario) FROM Empleados");
		
		double msal = (double) q.uniqueResult();
		return msal;
	}
	
	public static String MaxSalar(){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("SELECT apellido, max(salario) FROM Empleados where salario = (SELECT max(salario) FROM Empleados)");
		
		Object[] o = (Object[]) q.iterate().next();
		String ap = (String) o[0];
		float ms = (float) o[1];
		
		String text = ap + " | " + ms;
		return text;
		
	}
	
	public static String MinSalar(){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("SELECT apellido, min(salario) FROM Empleados where salario = (SELECT min(salario) FROM Empleados)");
		
		Object[] o = (Object[]) q.iterate().next();
		String ap = (String) o[0];
		float ms = (float) o[1];
		
		String text = ap + " | " + ms;
		return text;
		
	}
	
	public static long NumDeps(){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("SELECT count(dept_no) FROM Departamentos");
		
		long deps = (long) q.uniqueResult();
		return deps;
	}
	
	public static String MaxEmps(){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("from Hbiemps");		
		
			Hbiemps res = (Hbiemps) q.iterate().next();
			HbiempsId id = res.getId();		
			
			String dnom = id.getDep();
			long emps = id.getEmps();
			
			return dnom + " | " + emps;
	}
	
	public static String MinEmps(){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("from Hbiemps");	
		Iterator iter = q.iterate();
		
		String dnom = null;
		long emps = 0;
		
		while(iter.hasNext()){
			Hbiemps res = (Hbiemps) iter.next();
			HbiempsId id = res.getId();	
			
			dnom = id.getDep();
			emps = id.getEmps();
		}
		return dnom + " | " + emps;
	}
	
	
}
