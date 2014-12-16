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

	static SessionFactory sesion = SessionFactoryUtil.getSessionFactory();		
	static Session session = sesion.openSession();		
    static Transaction tx;
    static Query q;

	static Departamentos dep = new Departamentos();
	static Empleados emp = new Empleados();
	
	public static Departamentos[] listarDep(){
		q = session.createQuery("FROM Departamentos");
		List<Departamentos> listaDep = q.list();
		Iterator<?> iter = q.iterate();
		Departamentos[] D = new Departamentos[listaDep.size()];
		int i = 0;		
		
		while(iter.hasNext()){
			dep = (Departamentos) iter.next();
			D[i] = dep;
			i++;
		}
		return D;
	}
	
	public static Empleados[] listarEmp(){
		q = session.createQuery("FROM Empleados WHERE oficio IN ('DIRECTOR', 'PRESIDENTE', 'ANALISTA')");
		List<Empleados> listaEmp = q.list();
		Iterator<?> iter = q.iterate();
		Empleados[] E = new Empleados[listaEmp.size()];
		int i = 0;
		
		while(iter.hasNext()){
			emp = (Empleados) iter.next();
			E[i] = emp;
			i++;
		}
		return E;
	}
	
	public static void InsertarEmp(short nEmp, String apellido, String oficio, Float salario, Float comision, Departamentos dep, short Dir){
		java.util.Date hoy = new java.util.Date();
		java.sql.Date fhoy = new java.sql.Date(hoy.getTime());
		tx = session.beginTransaction();
		/*q = session.createQuery("INSERT INTO Empleados VALUES(?, ?, ?, ?, SYSDATE(), ?, ?, ?")
				.setByte(0, nEmp)
				.setString(1, apellido)
				.setString(2, oficio)
				.setDouble(3, salario)
				.setDouble(4, comision)
				.setInteger(5, nDep)
				.setInteger(6, Dir);*/
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
		emp = (Empleados) session.load(Empleados.class, nEmp);	
		return emp;		
	}
	
	public static Departamentos ConsultarDep(byte nDep){
		dep = (Departamentos) session.load(Departamentos.class, nDep);
		return dep;
	}
	
}
