package Princ;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.exception.ConstraintViolationException;

import primero.Departamentos;
import primero.Empleados;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class VentanaPrincipal {	
	
	
	private JFrame frame;
	JTabbedPane tabbedPane;
	private JTextField TfNEmpI;
	private JTextField TfComI;
	private JTextField TfApeI;
	private JTextField TfOfiI;
	private JTextField TfSalI;
	private JTextField TfComM;
	private JTextField TfSalM;
	private JTextField TfOfiM;
	private JTextField TfApeM;
	private JTextField TfNEmpM;
	private JComboBox CBDepI;
	private JComboBox CBDirI;
	private JComboBox CBDepM;
	private JComboBox CBDirM;	
	private int i;
	private List departamentos = Metodos.listarDep();
	//Empleados[] empleados = Metodos.listarEmp(2);
	
	Empleados emp = new Empleados();
	Departamentos dep = new Departamentos();
	private JTextField TfNDepI;
	private JTextField TfNomI;
	private JTextField TfLocI;
	private JTextField TfLocM;
	private JTextField TfNomM;
	private JTextField TfNDepM;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 614, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmInsertar = new JMenuItem("Insertar");
		mntmInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tabbedPane.setSelectedIndex(0);
				tabbedPane.setVisible(true);
				
			}
		});
		mnEmpleados.add(mntmInsertar);
		
		JSeparator separator = new JSeparator();
		mnEmpleados.add(separator);		
		
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(1);
				tabbedPane.setVisible(true);
				
			}
		});
		mnEmpleados.add(mntmModificar);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(1);
				tabbedPane.setVisible(true);
				
			}
		});
		mnEmpleados.add(mntmConsultar);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setMaximumSize(new Dimension(4, 32767));
		separator_3.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_3);
		
		JMenu mnDepartamentos = new JMenu("Departamentos");
		menuBar.add(mnDepartamentos);
		
		JMenuItem mntmInsertar_1 = new JMenuItem("Insertar");
		mntmInsertar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(2);
				tabbedPane.setVisible(true);
				
			}
		});
		mnDepartamentos.add(mntmInsertar_1);
		
		JSeparator separator_1 = new JSeparator();
		mnDepartamentos.add(separator_1);
		
		JMenuItem mntmModificar_1 = new JMenuItem("Modificar");
		mntmModificar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(3);
				tabbedPane.setVisible(true);
				
			}
		});
		mnDepartamentos.add(mntmModificar_1);
		
		JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");
		mntmConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(3);
				tabbedPane.setVisible(true);
				
			}
		});
		mnDepartamentos.add(mntmConsultar_1);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setMaximumSize(new Dimension(4, 32767));
		menuBar.add(separator_4);
		
		JMenu mnVarios = new JMenu("Varios");
		menuBar.add(mnVarios);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnVarios.add(mntmSalir);
		
		JSeparator separator_2 = new JSeparator();
		mnVarios.add(separator_2);
		
		JMenuItem mntmEstadisticas = new JMenuItem("Estadisticas");
		mntmEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(4);
				tabbedPane.setVisible(true);
				
			}
		});
		mnVarios.add(mntmEstadisticas);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setMaximumSize(new Dimension(4, 32767));
		menuBar.add(separator_5);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			
				if (tabbedPane.getSelectedIndex() == 1){
					/*System.out.println("Pesta�a Modificar Empleados");
					Departamentos[] D = Metodos.listarDep();
					for (int i = 0; i <= D.length - 1; i++){
						CBDepM.addItem((D[i].getDeptNo()));
						System.out.println(D[i].getDnombre());
					}
					
					Empleados[] directores = Metodos.listarEmp(1);
					for (int i = 0; i <= directores.length - 1; i++){
						CBDirM.addItem(directores[i].getEmpNo());
						System.out.println(directores[i].getEmpNo());
					}*/
					List depart = Metodos.listarDep();
					for (int i = 0; i <= depart.size() - 1; i++){
						CBDepM.addItem((((Departamentos) depart.get(i)).getDeptNo()));
						System.out.println(((Departamentos) depart.get(i)).getDnombre());
					}
					
					List directores = Metodos.listarEmp(1);
					for (int i = 0; i <= directores.size() - 1; i++){
						CBDirM.addItem(((Empleados) directores.get(i)).getEmpNo());
						System.out.println(((Empleados) directores.get(i)).getEmpNo());
					}
				}
				else if (tabbedPane.getSelectedIndex() == 2){
					System.out.println("Pesta�a Insertar Departamentos");
				}
				else if (tabbedPane.getSelectedIndex() == 3){
					System.out.println("Pesta�a Modificar Departamentos");
				}
				else if (tabbedPane.getSelectedIndex() == 4){
					System.out.println("Pesta�a Estadisticas");
				}		
			}
		});
		tabbedPane.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {	
				
				if (tabbedPane.getSelectedIndex() == 0){
					System.out.println("Pesta�a Insertar Empleados");
					//Departamentos[] D = Metodos.listarDep();
					List depart = Metodos.listarDep();
					for (int i = 0; i <= depart.size() - 1; i++){
						CBDepI.addItem((((Departamentos) depart.get(i)).getDeptNo()));
						System.out.println(((Departamentos) depart.get(i)).getDnombre());
					}
					
					List directores = Metodos.listarEmp(1);
					for (int i = 0; i <= directores.size() - 1; i++){
						CBDirI.addItem(((Empleados) directores.get(i)).getEmpNo());
						System.out.println(((Empleados) directores.get(i)).getEmpNo());
					}
				}				
			}
		});
		tabbedPane.setVisible(false);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(0, 27, 614, 334);
		frame.getContentPane().add(tabbedPane);
		
		JPanel InsEmp = new JPanel();
		tabbedPane.addTab("Insertar Empleado", null, InsEmp, null);
		InsEmp.setLayout(null);
		
		JLabel lblNumeroDeEmpleado = new JLabel("Numero de Empleado");
		lblNumeroDeEmpleado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumeroDeEmpleado.setBounds(28, 36, 132, 14);
		InsEmp.add(lblNumeroDeEmpleado);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellido.setBounds(28, 59, 132, 14);
		InsEmp.add(lblApellido);
		
		JLabel lblOficio = new JLabel("Oficio");
		lblOficio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOficio.setBounds(28, 84, 132, 14);
		InsEmp.add(lblOficio);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSalario.setBounds(28, 109, 132, 14);
		InsEmp.add(lblSalario);
		
		JLabel lblComision = new JLabel("Comision");
		lblComision.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblComision.setBounds(28, 134, 132, 14);
		InsEmp.add(lblComision);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDepartamento.setBounds(330, 57, 91, 14);
		InsEmp.add(lblDepartamento);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDirector.setBounds(330, 105, 91, 14);
		InsEmp.add(lblDirector);
		
		TfNEmpI = new JTextField();
		TfNEmpI.setBounds(170, 34, 86, 20);
		InsEmp.add(TfNEmpI);
		TfNEmpI.setColumns(10);
		
		TfComI = new JTextField();
		TfComI.setColumns(10);
		TfComI.setBounds(170, 132, 86, 20);
		InsEmp.add(TfComI);
		
		TfApeI = new JTextField();
		TfApeI.setColumns(10);
		TfApeI.setBounds(170, 57, 86, 20);
		InsEmp.add(TfApeI);
		
		TfOfiI = new JTextField();
		TfOfiI.setColumns(10);
		TfOfiI.setBounds(170, 82, 86, 20);
		InsEmp.add(TfOfiI);
		
		TfSalI = new JTextField();
		TfSalI.setColumns(10);
		TfSalI.setBounds(170, 107, 86, 20);
		InsEmp.add(TfSalI);
		
		CBDepI = new JComboBox();
		CBDepI.setBounds(449, 55, 70, 20);
		InsEmp.add(CBDepI);
		
		CBDirI = new JComboBox();
		CBDirI.setBounds(449, 103, 70, 20);
		InsEmp.add(CBDirI);
		
		JButton btnInsertarEmpleado = new JButton("Insertar Empleado");
		btnInsertarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				if(TfNEmpI.getText().equals("") || TfApeI.getText().equals("") || TfOfiI.getText().equals("") || TfSalI.getText().equals("") ||
				TfComI.getText().equals("")){
					
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
					
				} else{
					
						dep = Metodos.ConsultarDep((byte) CBDepI.getSelectedItem());
						Metodos.InsertarEmp(Short.parseShort(TfNEmpI.getText()), TfApeI.getText(), TfOfiI.getText(), Float.parseFloat(TfSalI.getText()), 
							Float.parseFloat(TfComI.getText()), dep, (short) CBDirI.getSelectedItem());							
				}
			}
		});
		btnInsertarEmpleado.setBounds(225, 188, 150, 50);
		InsEmp.add(btnInsertarEmpleado);
		
		JPanel ModEmp = new JPanel();
		tabbedPane.addTab("Modificar Empleado", null, ModEmp, null);
		ModEmp.setLayout(null);
		
		JLabel label = new JLabel("Numero de Empleado");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(26, 30, 132, 14);
		ModEmp.add(label);
		
		JLabel label_1 = new JLabel("Apellido");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(26, 53, 132, 14);
		ModEmp.add(label_1);
		
		JLabel label_2 = new JLabel("Oficio");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(26, 78, 132, 14);
		ModEmp.add(label_2);
		
		JLabel label_3 = new JLabel("Salario");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(26, 103, 132, 14);
		ModEmp.add(label_3);
		
		JLabel label_4 = new JLabel("Comision");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(26, 128, 132, 14);
		ModEmp.add(label_4);
		
		TfComM = new JTextField();
		TfComM.setColumns(10);
		TfComM.setBounds(168, 126, 86, 20);
		ModEmp.add(TfComM);
		
		TfSalM = new JTextField();
		
		TfSalM.setColumns(10);
		TfSalM.setBounds(168, 101, 86, 20);
		ModEmp.add(TfSalM);
		
		TfOfiM = new JTextField();
		TfOfiM.setColumns(10);
		TfOfiM.setBounds(168, 76, 86, 20);
		ModEmp.add(TfOfiM);
		
		TfApeM = new JTextField();
		TfApeM.setColumns(10);
		TfApeM.setBounds(168, 51, 86, 20);
		ModEmp.add(TfApeM);
		
		TfNEmpM = new JTextField();
		TfNEmpM.setColumns(10);
		TfNEmpM.setBounds(168, 28, 86, 20);
		ModEmp.add(TfNEmpM);
		
		JLabel label_5 = new JLabel("Departamento");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(328, 51, 91, 14);
		ModEmp.add(label_5);
		
		JLabel label_6 = new JLabel("Director");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(328, 99, 91, 14);
		ModEmp.add(label_6);
		
		CBDirM = new JComboBox();
		CBDirM.setBounds(447, 97, 110, 20);
		ModEmp.add(CBDirM);
		
		CBDepM = new JComboBox();
		CBDepM.setBounds(447, 49, 110, 20);
		ModEmp.add(CBDepM);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Metodos.ConsultarEmp(Short.parseShort(TfNEmpM.getText())) != null){
					
					emp = Metodos.ConsultarEmp(Short.parseShort(TfNEmpM.getText()));
					TfApeM.setText(emp.getApellido());
					TfOfiM.setText(emp.getOficio());
					TfSalM.setText(String.valueOf(emp.getSalario()));
					TfComM.setText(String.valueOf(emp.getComision()));
					CBDepM.setSelectedItem(emp.getDepartamentos().getDeptNo());
					CBDirM.setSelectedItem(emp.getDir());
					
					//empleados
					
				} else { JOptionPane.showMessageDialog(null, "El empleado no existe"); }		
				
			}
		});
		btnConsultar.setBounds(28, 182, 150, 50);
		ModEmp.add(btnConsultar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TfNEmpM.getText().equals("") || TfApeM.getText().equals("") || TfOfiM.getText().equals("") || TfSalM.getText().equals("") ||
						TfComM.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
						} else{
				dep = Metodos.ConsultarDep((byte) CBDepM.getSelectedItem());
				Metodos.ModificarEmp(Short.parseShort(TfNEmpM.getText()), TfApeM.getText(), TfOfiM.getText(), Float.parseFloat(TfSalM.getText()), 
						Float.parseFloat(TfComM.getText()), dep, (short) CBDirM.getSelectedItem());
			}
			}
		});
		btnModificar.setBounds(228, 182, 150, 50);
		ModEmp.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Metodos.EliminarEmp(Short.parseShort(TfNEmpM.getText()));		
			}
		});
		btnEliminar.setBounds(422, 182, 150, 50);
		ModEmp.add(btnEliminar);
		
		JButton btnPrimerRegistro = new JButton("Primer Registro");
		btnPrimerRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				/*Empleados[] empleados = Metodos.listarEmp(2);
				i = 0;
				emp = empleados[i];
				
				TfNEmpM.setText(String.valueOf(emp.getEmpNo()));
				TfApeM.setText(emp.getApellido());
				TfOfiM.setText(emp.getOficio());
				TfSalM.setText(String.valueOf(emp.getSalario()));
				TfComM.setText(String.valueOf(emp.getComision()));
				CBDepM.setSelectedItem(emp.getDepartamentos().getDeptNo());
				CBDirM.setSelectedItem(emp.getDir());*/
				
				
			}
		});
		btnPrimerRegistro.setBounds(28, 257, 110, 23);
		ModEmp.add(btnPrimerRegistro);
		
		JButton btnSiguienteRegistro = new JButton("Siguiente Registro");
		btnSiguienteRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				/*Empleados[] empleados = Metodos.listarEmp(2);
				i++;
				emp = empleados[i];
				
				TfNEmpM.setText(String.valueOf(emp.getEmpNo()));
				TfApeM.setText(emp.getApellido());
				TfOfiM.setText(emp.getOficio());
				TfSalM.setText(String.valueOf(emp.getSalario()));
				TfComM.setText(String.valueOf(emp.getComision()));
				CBDepM.setSelectedItem(emp.getDepartamentos().getDeptNo());
				CBDirM.setSelectedItem(emp.getDir());*/
				
			}
		});
		btnSiguienteRegistro.setBounds(168, 257, 132, 23);
		ModEmp.add(btnSiguienteRegistro);
		
		JButton btnAnteriorRegistro = new JButton("Anterior Registro");
		btnAnteriorRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				i--;
				emp = empleados[i];
				
				TfNEmpM.setText(String.valueOf(emp.getEmpNo()));
				TfApeM.setText(emp.getApellido());
				TfOfiM.setText(emp.getOficio());
				TfSalM.setText(String.valueOf(emp.getSalario()));
				TfComM.setText(String.valueOf(emp.getComision()));
				CBDepM.setSelectedItem(emp.getDepartamentos().getDeptNo());
				CBDirM.setSelectedItem(emp.getDir());
				*/
			}
		});
		btnAnteriorRegistro.setBounds(310, 257, 126, 23);
		ModEmp.add(btnAnteriorRegistro);
		
		JButton btnUltimoRegistros = new JButton("Ultimo Registro");
		btnUltimoRegistros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				/*Empleados[] empleados = Metodos.listarEmp(2);
				i = empleados.length - 1;
				emp = empleados[i];
				
				TfNEmpM.setText(String.valueOf(emp.getEmpNo()));
				TfApeM.setText(emp.getApellido());
				TfOfiM.setText(emp.getOficio());
				TfSalM.setText(String.valueOf(emp.getSalario()));
				TfComM.setText(String.valueOf(emp.getComision()));
				CBDepM.setSelectedItem(emp.getDepartamentos().getDeptNo());
				CBDirM.setSelectedItem(emp.getDir());*/
				
			}
		});
		btnUltimoRegistros.setBounds(462, 257, 110, 23);
		ModEmp.add(btnUltimoRegistros);
		
		JPanel InsDep = new JPanel();
		tabbedPane.addTab("Insertar Departamento", null, InsDep, null);
		InsDep.setLayout(null);
		
		JLabel lblNumeroDeDepartamento = new JLabel("Numero de Departamento");
		lblNumeroDeDepartamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumeroDeDepartamento.setBounds(177, 43, 132, 14);
		InsDep.add(lblNumeroDeDepartamento);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(177, 79, 132, 14);
		InsDep.add(lblNombre);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLocalidad.setBounds(177, 120, 132, 14);
		InsDep.add(lblLocalidad);
		
		TfNDepI = new JTextField();
		TfNDepI.setColumns(10);
		TfNDepI.setBounds(319, 41, 86, 20);
		InsDep.add(TfNDepI);
		
		TfNomI = new JTextField();
		TfNomI.setColumns(10);
		TfNomI.setBounds(319, 77, 86, 20);
		InsDep.add(TfNomI);
		
		TfLocI = new JTextField();
		TfLocI.setColumns(10);
		TfLocI.setBounds(319, 118, 86, 20);
		InsDep.add(TfLocI);
		
		JButton btnInsertarDepartamento = new JButton("Insertar Departamento");
		btnInsertarDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Metodos.InsertarDep(Byte.parseByte(TfNDepI.getText()), TfNomI.getText(), TfLocI.getText());
				
			}
		});
		btnInsertarDepartamento.setBounds(212, 167, 150, 50);
		InsDep.add(btnInsertarDepartamento);
		
		JPanel ModDep = new JPanel();
		tabbedPane.addTab("Modificar Departamento", null, ModDep, null);
		ModDep.setLayout(null);
		
		JButton ConsultarDep = new JButton("Consultar");
		ConsultarDep.setBounds(32, 158, 150, 50);
		ModDep.add(ConsultarDep);
		
		JButton ModificarDep = new JButton("Modificar");
		ModificarDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		ModificarDep.setBounds(232, 158, 150, 50);
		ModDep.add(ModificarDep);
		
		JButton EliminarDep = new JButton("Eliminar");
		EliminarDep.setBounds(426, 158, 150, 50);
		ModDep.add(EliminarDep);
		
		JButton URDep = new JButton("Ultimo Registro");
		URDep.setBounds(466, 233, 110, 23);
		ModDep.add(URDep);
		
		JButton ARDep = new JButton("Anterior Registro");
		ARDep.setBounds(314, 233, 126, 23);
		ModDep.add(ARDep);
		
		JButton SRDep = new JButton("Siguiente Registro");
		SRDep.setBounds(172, 233, 132, 23);
		ModDep.add(SRDep);
		
		JButton PRDep = new JButton("Primer Registro");
		PRDep.setBounds(32, 233, 110, 23);
		ModDep.add(PRDep);
		
		JLabel label_7 = new JLabel("Numero de Departamento");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(188, 33, 132, 14);
		ModDep.add(label_7);
		
		JLabel label_8 = new JLabel("Nombre");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(188, 69, 132, 14);
		ModDep.add(label_8);
		
		JLabel label_9 = new JLabel("Localidad");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(188, 110, 132, 14);
		ModDep.add(label_9);
		
		TfLocM = new JTextField();
		TfLocM.setColumns(10);
		TfLocM.setBounds(330, 108, 86, 20);
		ModDep.add(TfLocM);
		
		TfNomM = new JTextField();
		TfNomM.setColumns(10);
		TfNomM.setBounds(330, 67, 86, 20);
		ModDep.add(TfNomM);
		
		TfNDepM = new JTextField();
		TfNDepM.setColumns(10);
		TfNDepM.setBounds(330, 31, 86, 20);
		ModDep.add(TfNDepM);
		
		JPanel Estadisticas = new JPanel();
		tabbedPane.addTab("Estadisticas", null, Estadisticas, null);
		Estadisticas.setLayout(null);
		
		JLabel lblPracticaDeHibernate = new JLabel("Practica de Hibernate");
		lblPracticaDeHibernate.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPracticaDeHibernate.setHorizontalAlignment(SwingConstants.CENTER);
		lblPracticaDeHibernate.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPracticaDeHibernate.setBounds(150, 120, 298, 69);
		frame.getContentPane().add(lblPracticaDeHibernate);
		
		JLabel lblJorgeRealLozano = new JLabel("Jorge Real Lozano");
		lblJorgeRealLozano.setBounds(250, 300, 131, 14);
		frame.getContentPane().add(lblJorgeRealLozano);
		
		
		
		
	}
}
