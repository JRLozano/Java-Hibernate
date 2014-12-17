package Princ;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Departamentos;
import primero.SessionFactoryUtil;

public class MetodosDep {

	public static List listarDep(){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();		
		Session session = sesion.openSession();
		Query q = session.createQuery("FROM Departamentos");
		
		List<Departamentos> listaDep = q.list();
		/*Iterator<?> iter = q.iterate();
		Departamentos[] D = new Departamentos[listaDep.size()];
		int i = 0;		
		Departamentos dep;
		
		while(iter.hasNext()){
			dep = (Departamentos) iter.next();
			D[i] = dep;
			i++;
		}*/
		return listaDep;
	}

	public static Departamentos ConsultarDep(byte nDep){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();		
		Session session = sesion.openSession();
		
		Departamentos dep = (Departamentos) session.get(Departamentos.class, nDep);
		return dep;
	}
	
	public static void InsertarDep(byte nDep, String nombre, String localidad){
		
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();		
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Departamentos dep = new Departamentos();
		
		if(ConsultarDep(nDep) == null){
			
			dep.setDeptNo(nDep);
			dep.setDnombre(nombre);
			dep.setLoc(localidad);
			
			session.save(dep);
			tx.commit();
		} else {
			JOptionPane.showMessageDialog(null, "El departamento ya existe");
		}
		
	}
	
	public static void ModificarDep(byte nDep, String nombre, String localidad){
		
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Departamentos dep = new Departamentos();
		
		if(ConsultarDep(nDep) == null){
			dep.setDeptNo(nDep);
			dep.setDnombre(nombre);
			dep.setLoc(localidad);
		} else { JOptionPane.showMessageDialog(null, "El departamento no existe"); }		
	}
	
	public static void EliminarDep(byte nDep){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();		
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		
		if(ConsultarDep(nDep) != null){
			Departamentos dep = (Departamentos) session.load(Departamentos.class, nDep);
			session.delete(dep);
			tx.commit();
			
		} else JOptionPane.showMessageDialog(null, "El departamento no existe");
	}
}
