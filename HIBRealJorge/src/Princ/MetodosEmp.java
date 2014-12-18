package Princ;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Departamentos;
import primero.Empleados;
import primero.SessionFactoryUtil;


public class MetodosEmp {

	
	
	
	public static List listarEmp(int op){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();		
		Session session = sesion.openSession();
		Query q = null;
		switch(op){
		case 1:
			q = session.createQuery("FROM Empleados WHERE oficio IN ('DIRECTOR', 'PRESIDENTE', 'ANALISTA')");
			break;
		case 2:
			q = session.createQuery("FROM Empleados order by empNo");
			break;
		}		
		
		List<Empleados> listaEmp = q.list();
		return listaEmp;
	}
	
	public static Empleados ConsultarEmp(short nEmp){	
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();		
		Session session = sesion.openSession();
		
		Empleados emp = (Empleados) session.get(Empleados.class, nEmp);	
		return emp;		
	}

	public static void InsertarEmp(short nEmp, String apellido, String oficio, Float salario, Float comision, Departamentos dep, short Dir, JLabel lbl){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();		
		Session session = sesion.openSession();
		java.util.Date hoy = new java.util.Date();
		java.sql.Date fhoy = new java.sql.Date(hoy.getTime());
		Transaction tx = session.beginTransaction();
		
		if(ConsultarEmp(nEmp) == null){
			
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
			
			lbl.setText("Empleado insertado");
			VentanaPrincipal.LimpiarEmp(2);
		} else {
			lbl.setText("El empleado ya existe");
			//System.out.println(ConsultarEmp(nEmp).getApellido() + " - " + ConsultarEmp(nEmp).getSalario());
		}
		
		
		
	}
	
	public static void EliminarEmp(short nEmp, JLabel lbl){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();		
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		
		if(ConsultarEmp(nEmp) != null){
			Empleados emp = (Empleados) session.load(Empleados.class, nEmp);
			session.delete(emp);
			tx.commit();
			VentanaPrincipal.LimpiarEmp(1);
			lbl.setText("Empleado eliminado");
		} else lbl.setText("El empleado no existe");
		
	}
	
	public static void ModificarEmp(short nEmp, String apellido, String oficio, Float salario, Float comision, Departamentos dep, short Dir, JLabel lbl){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		java.util.Date hoy = new java.util.Date();
		java.sql.Date fhoy = new java.sql.Date(hoy.getTime());
		
		if(ConsultarEmp(nEmp) != null){
			
			Empleados emp = new Empleados();
			emp.setEmpNo(nEmp);
			emp.setApellido(apellido);
			emp.setOficio(oficio);
			emp.setSalario(salario);
			emp.setFechaAlt(fhoy);
			emp.setComision(comision);
			emp.setDepartamentos(dep);
			emp.setDir(Dir);			
		
			session.update(emp);
			tx.commit();
			
			VentanaPrincipal.LimpiarDep(1);
			lbl.setText("El empleado ha sido modificado");
		} else JOptionPane.showMessageDialog(null, "El empleado no existe");		
	}
	
	
}