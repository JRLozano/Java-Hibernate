package Princ;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Departamentos;
import primero.Empleados;
import primero.SessionFactoryUtil;


public class Metodos {

	
	public static Departamentos[] listarDep(){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();		
		Session session = sesion.openSession();
		Query q = session.createQuery("FROM Departamentos");
		
		List<Departamentos> listaDep = q.list();
		Iterator<?> iter = q.iterate();
		Departamentos[] D = new Departamentos[listaDep.size()];
		int i = 0;		
		Departamentos dep;
		
		while(iter.hasNext()){
			dep = (Departamentos) iter.next();
			D[i] = dep;
			i++;
		}
		return D;
	}
	
	public static Empleados[] listarEmp(){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();		
		Session session = sesion.openSession();
		Query q = session.createQuery("FROM Empleados WHERE oficio IN ('DIRECTOR', 'PRESIDENTE', 'ANALISTA')");
		
		List<Empleados> listaEmp = q.list();
		Iterator<?> iter = q.iterate();
		Empleados[] E = new Empleados[listaEmp.size()];
		int i = 0;
		Empleados emp;
		
		while(iter.hasNext()){
			emp = (Empleados) iter.next();
			E[i] = emp;
			i++;
		}
		return E;
	}
	
	public static void InsertarEmp(short nEmp, String apellido, String oficio, Float salario, Float comision, Departamentos dep, short Dir){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();		
		Session session = sesion.openSession();
		java.util.Date hoy = new java.util.Date();
		java.sql.Date fhoy = new java.sql.Date(hoy.getTime());
		Transaction tx = session.beginTransaction();
		
		Empleados emp = new Empleados();
		emp.setEmpNo(nEmp);
		emp.setApellido(apellido);
		emp.setOficio(oficio);
		emp.setSalario(salario);
		emp.setFechaAlt(fhoy);
		emp.setComision(comision);
		emp.setDepartamentos(dep);
		emp.setDir(Dir);
		
		
		session.save(emp);
		tx.commit();
		
	}
	
	public static Empleados ConsultarEmp(short nEmp){	
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();		
		Session session = sesion.openSession();
		
		Empleados emp = (Empleados) session.load(Empleados.class, nEmp);	
		return emp;		
	}
	
	public static Departamentos ConsultarDep(byte nDep){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();		
		Session session = sesion.openSession();
		
		Departamentos dep = (Departamentos) session.load(Departamentos.class, nDep);
		return dep;
	}
	
}
