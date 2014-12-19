package Princ;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import primero.Departamentos;
import primero.Empleados;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class VentanaPrincipal {	
	
	
	private JFrame frame;
	JTabbedPane tabbedPane;
	private static JTextField TfNEmpI;
	private static JTextField TfComI;
	private static JTextField TfApeI;
	private static JTextField TfOfiI;
	private static JTextField TfSalI;
	private static JTextField TfComM;
	private static JTextField TfSalM;
	private static JTextField TfOfiM;
	private static JTextField TfApeM;
	private static JTextField TfNEmpM;
	private static JComboBox CBDepI;
	private static JComboBox CBDirI;
	private static JComboBox CBDepM;
	private static JComboBox CBDirM;	
	private int i;
	private List departamentos = MetodosDep.listarDep();
	//Empleados[] empleados = Metodos.listarEmp(2);
	
	Empleados emp = new Empleados();
	Departamentos dep = new Departamentos();
	private static JTextField TfNDepI;
	private static JTextField TfNomI;
	private static JTextField TfLocI;
	private static JTextField TfLocM;
	private static JTextField TfNomM;
	private static JTextField TfNDepM;
	private static JTextField TfNumEmps;
	private static JTextField TfMidSal;
	private static JTextField TfMaxSal;
	private static JTextField TfMinSal;
	private static JTextField TfNumDeps;
	private static JTextField TfMaxEmps;
	private static JTextField TfMinEmps;
	private static JLabel lblMens1, lblMens2, lblMens3, lblMens4;
	
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
		frame.setBounds(100, 100, 630, 450);
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
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
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
				switch(tabbedPane.getSelectedIndex()){
				case 1:
					//System.out.println("Pestaña Modificar Empleados");
					LimpiarEmp(1);
					CBDepM.removeAllItems();
					CBDirM.removeAllItems();
					
					List depart = MetodosDep.listarDep();
					for (int i = 0; i <= depart.size() - 1; i++){
						CBDepM.addItem((((Departamentos) depart.get(i)).getDeptNo()));
					}
					
					List directores = MetodosEmp.listarEmp(1);
					for (int i = 0; i <= directores.size() - 1; i++){
						CBDirM.addItem(((Empleados) directores.get(i)).getEmpNo());
					}
					break;
				case 2:
					//System.out.println("Pestaña Insertar Departamentos");
					LimpiarDep(2);
					break;
				case 3:
					//System.out.println("Pestaña Modificar Departamentos");
					LimpiarDep(1);
					break;
				case 4:
					//System.out.println("Pestaña Estadisticas");
					
					TfNumEmps.setText(String.valueOf(Estadisticas.NumEmps()));
					TfMidSal.setText(String.valueOf(Estadisticas.MidSalar()));
					TfMaxSal.setText(Estadisticas.MaxSalar());
					TfMinSal.setText(Estadisticas.MinSalar());
					TfNumDeps.setText(String.valueOf(Estadisticas.NumDeps()));
					TfMaxEmps.setText(Estadisticas.MaxEmps());
					TfMinEmps.setText(Estadisticas.MinEmps());
					break;
				}
			}
		});
		tabbedPane.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {	
				
				if (tabbedPane.getSelectedIndex() == 0){
					//System.out.println("Pestaña Insertar Empleados");
					LimpiarEmp(2);
					List depart = MetodosDep.listarDep();
					for (int i = 0; i <= depart.size() - 1; i++){
						CBDepI.addItem((((Departamentos) depart.get(i)).getDeptNo()));
					}
					
					List directores = MetodosEmp.listarEmp(1);
					for (int i = 0; i <= directores.size() - 1; i++){
						CBDirI.addItem(((Empleados) directores.get(i)).getEmpNo());
					}
					
					}				
			}
		});
		tabbedPane.setVisible(false);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(0, 27, 614, 352);
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
		TfNEmpI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				/*if(Integer.parseInt(TfNEmpI.getText()) > 32767){
					TfNEmpI.setText("");
					TfNEmpI.requestFocus();
					lblMens1.setText("El numero de empleado debe estar comprendido entre 0 y 32767");
				}*/
				if(TfNEmpI.getText().length() > 4){
					TfNEmpI.setText("");
					//TfNEmpI.requestFocus();
					lblMens1.setText("El numero de empleado debe estar comprendido entre 0 y 9999");
				}
			}
		});
		TfNEmpI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
					String s1 = String.valueOf(e.getKeyChar());
					if(!(s1.matches("[0-9]")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE)){
						e.consume();
						//TfNEmpI.requestFocus();		
						TfNEmpI.setText("");
						lblMens1.setText("Solo puede contener números"); 
					}			
			}
		});
		TfNEmpI.setBounds(170, 34, 86, 20);
		InsEmp.add(TfNEmpI);
		TfNEmpI.setColumns(10);
		
		
		TfComI = new JTextField();
		TfComI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try{
					if (Double.parseDouble(TfComI.getText()) <= 0 || Double.parseDouble(TfComI.getText()) > 9999.99){
						lblMens1.setText("La comision debe estar entre los rangos permitidos(1 - 9999.99)");
						//TfComI.requestFocus();
						TfComI.setText("");
					}
				} catch (NumberFormatException nfe){
					TfComI.setText("");
					lblMens1.setText("Solo puede contener numeros");
				}	
					
			}
		});
		TfComI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {				
				String s1 = String.valueOf(e.getKeyChar());
				if(!(s1.matches("[0-9]")) && !(s1.matches(".")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE)){
					e.consume();
					//TfComI.requestFocus();		
					TfComI.setText("");
					lblMens1.setText("Solo puede contener números"); 
				}
				
			}
		});
		TfComI.setColumns(10);
		TfComI.setBounds(170, 132, 86, 20);
		InsEmp.add(TfComI);
		
		TfApeI = new JTextField();
		TfApeI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {				
					if(TfApeI.getText().length() > 10){
						TfApeI.setText("");
						TfApeI.requestFocus();
						lblMens1.setText("El apellido debe tener 10 caracteres como mucho");
					}							
			}
		});
		TfApeI.addKeyListener(new KeyAdapter() {			
				public void keyTyped(KeyEvent e) {
					String s1 = String.valueOf(e.getKeyChar());
					if(!(s1.matches("[a-zA-Z]")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE) ){
						e.consume();
						//TfApeI.requestFocus();		
						TfApeI.setText("");
						lblMens1.setText("No puede contener números"); 						
					}
				}
			
		});
		TfApeI.setColumns(10);
		TfApeI.setBounds(170, 57, 86, 20);
		InsEmp.add(TfApeI);
		
		TfOfiI = new JTextField();
		TfOfiI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(TfOfiI.getText().length() > 10){
					TfOfiI.setText("");
					//TfOfiI.requestFocus();
					lblMens1.setText("El oficio debe tener 10 caracteres como mucho");
				}
			}
		});
		TfOfiI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String s1 = String.valueOf(e.getKeyChar());
				if(!(s1.matches("[a-zA-Z]")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE) ){
					e.consume();
					//TfOfiI.requestFocus();		
					TfOfiI.setText("");
					lblMens1.setText("No puede contener números"); 
			}
			}
		});
		TfOfiI.setColumns(10);
		TfOfiI.setBounds(170, 82, 86, 20);
		InsEmp.add(TfOfiI);
		
		TfSalI = new JTextField();
		TfSalI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try{
					if (Double.parseDouble(TfSalI.getText()) <= 0 || Double.parseDouble(TfSalI.getText()) > 9999.99){
						lblMens1.setText("El salario debe estar entre los rangos permitidos(1 - 9999.99)");
						//TfSalI.requestFocus();
						TfSalI.setText("");
					}	
				} catch (NumberFormatException nfe){ 
					lblMens1.setText("Solo puede contener números"); 
					TfSalI.setText(""); 
					}
			}
		});
		TfSalI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {				
				String s1 = String.valueOf(e.getKeyChar());
				if(!(s1.matches("[0-9]")) &&!(s1.matches(".")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE)){
					e.consume();
					//TfSalI.requestFocus();		
					TfSalI.setText("");
					lblMens1.setText("Solo puede contener números"); 
				}			
			}
		});
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
					
					lblMens1.setText("Debe rellenar todos los campos");
					
				} else{
					
						dep = MetodosDep.ConsultarDep((byte) CBDepI.getSelectedItem());
						MetodosEmp.InsertarEmp(Short.parseShort(TfNEmpI.getText()), TfApeI.getText(), TfOfiI.getText(), Float.parseFloat(TfSalI.getText()), 
							Float.parseFloat(TfComI.getText()), dep, (short) CBDirI.getSelectedItem(), lblMens1);								
				}
			}
		});
		btnInsertarEmpleado.setBounds(225, 188, 150, 50);
		InsEmp.add(btnInsertarEmpleado);
		
		lblMens1 = new JLabel("");
		lblMens1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMens1.setBounds(60, 266, 491, 14);
		InsEmp.add(lblMens1);
		
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
		TfComM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String s1 = String.valueOf(e.getKeyChar());
				if(!(s1.matches("[0-9]")) &&!(s1.matches(".")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE)){
					e.consume();
					//TfSalI.requestFocus();		
					TfComM.setText("");
					lblMens2.setText("Solo puede contener números"); 
				}	
			}
		});
		TfComM.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try{
					if (Double.parseDouble(TfComM.getText()) <= 0 || Double.parseDouble(TfComM.getText()) > 9999.99){
						lblMens2.setText("La comision debe estar entre los rangos permitidos(1 - 9999.99)");
						//TfSalI.requestFocus();
						TfComM.setText("");
					}	
				} catch (NumberFormatException nfe){
					TfComM.setText("");
					lblMens2.setText("Solo puede contener numeros");					
				}
			}
		});
		TfComM.setColumns(10);
		TfComM.setBounds(168, 126, 86, 20);
		ModEmp.add(TfComM);
		
		TfSalM = new JTextField();
		TfSalM.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try{
					if (Double.parseDouble(TfSalM.getText()) <= 0 || Double.parseDouble(TfSalM.getText()) > 9999.99){
						lblMens2.setText("El salario debe estar entre los rangos permitidos(1 - 9999.99)");
						//TfSalI.requestFocus();
						TfSalM.setText("");
					}	
				} catch (NumberFormatException nfe){
					TfSalM.setText("");
					lblMens2.setText("Solo puede contener numeros");
				}
			}
		});
		TfSalM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String s1 = String.valueOf(e.getKeyChar());
				if(!(s1.matches("[0-9]")) &&!(s1.matches(".")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE)){
					e.consume();
					//TfSalI.requestFocus();		
					TfSalM.setText("");
					lblMens2.setText("Solo puede contener números"); 
				}	
			}
		});
		
		TfSalM.setColumns(10);
		TfSalM.setBounds(168, 101, 86, 20);
		ModEmp.add(TfSalM);
		
		TfOfiM = new JTextField();
		TfOfiM.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(TfOfiM.getText().length() > 10){
					TfOfiM.setText("");
					TfOfiM.requestFocus();
					lblMens2.setText("El oficio debe tener 10 caracteres como mucho");
				}	
			}
		});
		TfOfiM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String s1 = String.valueOf(e.getKeyChar());
				if(!(s1.matches("[a-zA-Z]")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE) ){
					e.consume();
					//TfOfiI.requestFocus();		
					TfOfiM.setText("");
					lblMens2.setText("No puede contener números"); 
			}
			}
		});
		TfOfiM.setColumns(10);
		TfOfiM.setBounds(168, 76, 86, 20);
		ModEmp.add(TfOfiM);
		
		TfApeM = new JTextField();
		TfApeM.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(TfApeM.getText().length() > 10){
					TfApeM.setText("");
					TfApeM.requestFocus();
					lblMens2.setText("El apellido debe tener 10 caracteres como mucho");
				}	
			}
		});
		TfApeM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String s1 = String.valueOf(e.getKeyChar());
				if(!(s1.matches("[a-zA-Z]")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE) ){
					e.consume();
					//TfOfiI.requestFocus();		
					TfApeM.setText("");
					lblMens2.setText("No puede contener números"); 
			}
			}
		});
		TfApeM.setColumns(10);
		TfApeM.setBounds(168, 51, 86, 20);
		ModEmp.add(TfApeM);
		
		TfNEmpM = new JTextField();
		TfNEmpM.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				/*if(Integer.parseInt(TfNEmpI.getText()) > 32767){
				TfNEmpI.setText("");
				TfNEmpI.requestFocus();
				lblMens1.setText("El numero de empleado debe estar comprendido entre 0 y 32767");
			}*/
			if(TfNEmpM.getText().length() > 4){
				TfNEmpM.setText("");
				//TfNEmpI.requestFocus();
				lblMens2.setText("El numero de empleado debe estar comprendido entre 0 y 9999");
			}
			}
		});
		TfNEmpM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
					String s1 = String.valueOf(e.getKeyChar());
					if(!(s1.matches("[0-9]")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE)){
						e.consume();
						//TfNEmpI.requestFocus();		
						TfNEmpM.setText("");
						lblMens2.setText("Solo puede contener números"); 
					}			
			}
		});
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
				
				if(MetodosEmp.ConsultarEmp(Short.parseShort(TfNEmpM.getText())) != null){			
					
					emp = MetodosEmp.ConsultarEmp(Short.parseShort(TfNEmpM.getText()));
					ImprimirEmp(emp);
					
					List<Empleados> empleados = MetodosEmp.listarEmp(2);
					i = empleados.indexOf(emp);
					System.out.println(i);
									
				} else { 
					lblMens2.setText("El empleado no existe");
					LimpiarDep(1);
				}		
				
			}
		});
		btnConsultar.setBounds(28, 182, 150, 50);
		ModEmp.add(btnConsultar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TfNEmpM.getText().equals("") || TfApeM.getText().equals("") || TfOfiM.getText().equals("") || TfSalM.getText().equals("") ||
						TfComM.getText().equals("")){
							lblMens2.setText("Debe rellenar todos los campos");
						} else{
				dep = MetodosDep.ConsultarDep((byte) CBDepM.getSelectedItem());
				MetodosEmp.ModificarEmp(Short.parseShort(TfNEmpM.getText()), TfApeM.getText(), TfOfiM.getText(), Float.parseFloat(TfSalM.getText()), 
						Float.parseFloat(TfComM.getText()), dep, (short) CBDirM.getSelectedItem(), lblMens2);
				//LimpiarDep(2);
				//lblMens2.setText("El empleado ha sido modificado");
			}
			}
		});
		btnModificar.setBounds(228, 182, 150, 50);
		ModEmp.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MetodosEmp.EliminarEmp(Short.parseShort(TfNEmpM.getText()), lblMens2);	
				
			}
		});
		btnEliminar.setBounds(422, 182, 150, 50);
		ModEmp.add(btnEliminar);
		
		JButton btnPrimerRegistro = new JButton("Primer Registro");
		btnPrimerRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				List<Empleados> empleados = MetodosEmp.listarEmp(2);
				i = 0;
				emp = empleados.get(i);				
				ImprimirEmp(emp);
				
				
			}
		});
		btnPrimerRegistro.setBounds(28, 257, 110, 23);
		ModEmp.add(btnPrimerRegistro);
		
		JButton btnSiguienteRegistro = new JButton("Siguiente Registro");
		btnSiguienteRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					List<Empleados> empleados = MetodosEmp.listarEmp(2);
					i++;
					emp = empleados.get(i);				
					ImprimirEmp(emp);
					
				} catch (IndexOutOfBoundsException boe) {
					lblMens2.setText("Este es el ultimo empleado, no puedes avanzar mas");
					i--;
				}
				
			}
		});
		btnSiguienteRegistro.setBounds(168, 257, 132, 23);
		ModEmp.add(btnSiguienteRegistro);
		
		JButton btnAnteriorRegistro = new JButton("Anterior Registro");
		btnAnteriorRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					List<Empleados> empleados = MetodosEmp.listarEmp(2);
					i--;
					emp = empleados.get(i);				
					ImprimirEmp(emp);
				} catch (IndexOutOfBoundsException boe) { 
					lblMens2.setText("Este es el primer empleado, no puedes retroceder mas");
					i++;
					}				
			}
		});
		btnAnteriorRegistro.setBounds(310, 257, 126, 23);
		ModEmp.add(btnAnteriorRegistro);
		
		JButton btnUltimoRegistros = new JButton("Ultimo Registro");
		btnUltimoRegistros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try{	
				List<Empleados> empleados = MetodosEmp.listarEmp(2);
				i = empleados.size() - 1;
				emp = empleados.get(i);
				ImprimirEmp(emp);
			} catch (IndexOutOfBoundsException boe) { 
				lblMens2.setText("Este es el ultimo empleado, no puedes avanzar mas");
				}
				
			}
		});
		btnUltimoRegistros.setBounds(462, 257, 110, 23);
		ModEmp.add(btnUltimoRegistros);
		
		lblMens2 = new JLabel("");
		lblMens2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMens2.setBounds(61, 291, 491, 14);
		ModEmp.add(lblMens2);
		
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
		TfNDepI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(TfNDepI.getText().length() > 2){
					TfNDepI.setText("");
					//TfNEmpI.requestFocus();
					lblMens3.setText("El numero de departamento debe estar comprendido entre 1 y 99");
				}
			}
		});
		TfNDepI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String s1 = String.valueOf(e.getKeyChar());
				if(!(s1.matches("[0-9]")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE)){
					e.consume();
					TfNDepI.requestFocus();		
					TfNDepI.setText("");
					lblMens3.setText("Solo puede contener números"); 
				}
			}
		});
		TfNDepI.setColumns(10);
		TfNDepI.setBounds(319, 41, 86, 20);
		InsDep.add(TfNDepI);
		
		TfNomI = new JTextField();
		TfNomI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String s1 = String.valueOf(e.getKeyChar());
				if(!(s1.matches("[a-zA-Z]")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE) ){
					e.consume();
					//TfApeI.requestFocus();		
					TfNomI.setText("");
					lblMens3.setText("No puede contener números"); 						
				}
			}
		});
		TfNomI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {				
				if(TfNomI.getText().length() > 10){
					TfNomI.setText("");
					TfNomI.requestFocus();
					lblMens3.setText("El nombre debe tener 10 caracteres como mucho");
				}
				
			}
		});
		TfNomI.setColumns(10);
		TfNomI.setBounds(319, 77, 86, 20);
		InsDep.add(TfNomI);
		
		TfLocI = new JTextField();
		TfLocI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String s1 = String.valueOf(e.getKeyChar());
				if(!(s1.matches("[a-zA-Z]")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE) ){
					e.consume();
					//TfApeI.requestFocus();		
					TfLocI.setText("");
					lblMens3.setText("No puede contener números"); 						
				}
			}
		});
		TfLocI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(TfLocI.getText().length() > 10){
					TfLocI.setText("");
					TfLocI.requestFocus();
					lblMens3.setText("La localidad debe tener 10 caracteres como mucho");
				}
			}
		});
		TfLocI.setColumns(10);
		TfLocI.setBounds(319, 118, 86, 20);
		InsDep.add(TfLocI);
		
		JButton btnInsertarDepartamento = new JButton("Insertar Departamento");
		btnInsertarDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (TfNDepI.getText().equals("") || TfNomI.getText().equals("") || TfLocI.getText().equals("")){
					lblMens3.setText("Debe rellenar todos los campos");
				} else{
					MetodosDep.InsertarDep(Byte.parseByte(TfNDepI.getText()), TfNomI.getText(), TfLocI.getText(), lblMens3);
					LimpiarDep(1);
					lblMens3.setText("Departamento insertado");
				}				
			}
		});
		btnInsertarDepartamento.setBounds(230, 167, 150, 50);
		InsDep.add(btnInsertarDepartamento);
		
		lblMens3 = new JLabel("");
		lblMens3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMens3.setBounds(60, 259, 491, 14);
		InsDep.add(lblMens3);
		
		JPanel ModDep = new JPanel();
		tabbedPane.addTab("Modificar Departamento", null, ModDep, null);
		ModDep.setLayout(null);
		
		JButton ConsultarDep = new JButton("Consultar");
		ConsultarDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(MetodosDep.ConsultarDep(Byte.parseByte(TfNDepM.getText())) != null){			
					
					dep = MetodosDep.ConsultarDep(Byte.parseByte(TfNDepM.getText()));
					ImprimirDep(dep);
					
					List<Departamentos> departamentos = MetodosDep.listarDep();
					i = departamentos.indexOf(dep);
					System.out.println(i);
									
				} else { 
					LimpiarDep(1);
					lblMens4.setText("El departamento no existe"); 
					}		
				
				
			}
		});
		ConsultarDep.setBounds(32, 158, 150, 50);
		ModDep.add(ConsultarDep);
		
		JButton ModificarDep = new JButton("Modificar");
		ModificarDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (TfNDepI.getText().equals("") || TfNomI.getText().equals("") || TfLocI.getText().equals("")){
					lblMens4.setText("Debe rellenar todos los campos");
				} else{
					MetodosDep.ModificarDep(Byte.parseByte(TfNDepI.getText()),TfNomI.getText(), TfLocI.getText(), lblMens4);
					LimpiarDep(1);
					lblMens4.setText("Departamento modificado");
				  }
			}
		});
		ModificarDep.setBounds(232, 158, 150, 50);
		ModDep.add(ModificarDep);
		
		JButton EliminarDep = new JButton("Eliminar");
		EliminarDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(TfNDepM.getText().equals("")){
					lblMens4.setText("Debe rellenar el numero de departamento");
				} else{
					MetodosDep.EliminarDep(Byte.parseByte(TfNDepM.getText()));
					LimpiarDep(1);
					lblMens4.setText("Empleado eliminado");
				}
				
			}
		});
		EliminarDep.setBounds(426, 158, 150, 50);
		ModDep.add(EliminarDep);
		
		JButton URDep = new JButton("Ultimo Registro");
		URDep.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
	
					List<Departamentos> departamentos = MetodosDep.listarDep();
					i = departamentos.size() - 1;
					dep = departamentos.get(i);
					ImprimirDep(dep);		
				
			}
		});
		URDep.setBounds(466, 233, 110, 23);
		ModDep.add(URDep);
		
		JButton ARDep = new JButton("Anterior Registro");
		ARDep.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					List<Departamentos> departamentos = MetodosDep.listarDep();
					i--;
					dep = departamentos.get(i);
					ImprimirDep(dep);
				} catch (IndexOutOfBoundsException boe) { 
					lblMens4.setText("Este es el primer departamento, no puedes retroceder mas");
					i++;
					}
				
			}
		});
		ARDep.setBounds(314, 233, 126, 23);
		ModDep.add(ARDep);
		
		JButton SRDep = new JButton("Siguiente Registro");
		SRDep.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
			try{	
				List<Departamentos> departamentos = MetodosDep.listarDep();
				i++;
				dep = departamentos.get(i);
				ImprimirDep(dep);
			} catch (IndexOutOfBoundsException boe) { 
				lblMens4.setText("Este es el ultimo departamento, no puedes avanzar mas");
				i--;
				}
			}
		});
		SRDep.setBounds(172, 233, 132, 23);
		ModDep.add(SRDep);
		
		JButton PRDep = new JButton("Primer Registro");
		PRDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Departamentos> departamentos = MetodosDep.listarDep();
				i = 0;
				dep = departamentos.get(i);
				ImprimirDep(dep);
			}
		});
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
		TfLocM.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(TfLocM.getText().length() > 10){
					TfLocM.setText("");
					TfLocM.requestFocus();
					lblMens4.setText("La localidad debe tener 10 caracteres como mucho");
				}
			}
		});
		TfLocM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String s1 = String.valueOf(e.getKeyChar());
				if(!(s1.matches("[a-zA-Z]")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE) ){
					e.consume();
					//TfApeI.requestFocus();		
					TfLocM.setText("");
					lblMens4.setText("No puede contener números"); 						
				}
			}
		});
		TfLocM.setColumns(10);
		TfLocM.setBounds(330, 108, 86, 20);
		ModDep.add(TfLocM);
		
		TfNomM = new JTextField();
		TfNomM.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(TfNomM.getText().length() > 10){
					TfNomM.setText("");
					TfNomM.requestFocus();
					lblMens4.setText("El nombre debe tener 10 caracteres como mucho");
				}
			}
		});
		TfNomM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String s1 = String.valueOf(e.getKeyChar());
				if(!(s1.matches("[a-zA-Z]")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE) ){
					e.consume();
					//TfApeI.requestFocus();		
					TfNomM.setText("");
					lblMens4.setText("No puede contener números"); 						
				}
			}
		});
		TfNomM.setColumns(10);
		TfNomM.setBounds(330, 67, 86, 20);
		ModDep.add(TfNomM);
		
		TfNDepM = new JTextField();
		TfNDepM.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(TfNDepM.getText().length() > 2){
					TfNDepM.setText("");
					//TfNEmpI.requestFocus();
					lblMens4.setText("El numero de departamento debe estar comprendido entre 1 y 99");
				}
			}
		});
		TfNDepM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String s1 = String.valueOf(e.getKeyChar());
				if(!(s1.matches("[0-9]")) && (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE)){
					e.consume();
					TfNDepM.requestFocus();		
					TfNDepM.setText("");
					lblMens4.setText("Solo puede contener números"); 
				}
			}
		});
		TfNDepM.setColumns(10);
		TfNDepM.setBounds(330, 31, 86, 20);
		ModDep.add(TfNDepM);

		lblMens4 = new JLabel("");
		lblMens4.setHorizontalAlignment(SwingConstants.CENTER);
		lblMens4.setBounds(60, 287, 491, 14);
		ModDep.add(lblMens4);
		
		JPanel Estadisticas = new JPanel();
		tabbedPane.addTab("Estadisticas", null, Estadisticas, null);
		Estadisticas.setLayout(null);
		
		JLabel lblNumeroDeEmpleados = new JLabel("Numero de Empleados");
		lblNumeroDeEmpleados.setBounds(34, 32, 106, 14);
		Estadisticas.add(lblNumeroDeEmpleados);
		
		TfNumEmps = new JTextField();
		TfNumEmps.setEditable(false);
		TfNumEmps.setBounds(182, 29, 86, 20);
		Estadisticas.add(TfNumEmps);
		TfNumEmps.setColumns(10);
		
		JLabel lblSalarioMedio = new JLabel("Salario Medio");
		lblSalarioMedio.setBounds(317, 32, 86, 14);
		Estadisticas.add(lblSalarioMedio);
		
		TfMidSal = new JTextField();
		TfMidSal.setEditable(false);
		TfMidSal.setBounds(428, 29, 86, 20);
		Estadisticas.add(TfMidSal);
		TfMidSal.setColumns(10);
		
		JLabel lblApellidoDelEmpleados = new JLabel("Apellido del empleado con salario maximo y salario maximo");
		lblApellidoDelEmpleados.setBounds(34, 57, 480, 14);
		Estadisticas.add(lblApellidoDelEmpleados);
		
		TfMaxSal = new JTextField();
		TfMaxSal.setEditable(false);
		TfMaxSal.setBounds(34, 82, 480, 20);
		Estadisticas.add(TfMaxSal);
		TfMaxSal.setColumns(10);
		
		JLabel lblApellidoDelEmpleados_1 = new JLabel("Apellido del empleado con salario minimo y salario minimo");
		lblApellidoDelEmpleados_1.setBounds(34, 113, 480, 14);
		Estadisticas.add(lblApellidoDelEmpleados_1);
		
		TfMinSal = new JTextField();
		TfMinSal.setEditable(false);
		TfMinSal.setBounds(34, 138, 480, 20);
		Estadisticas.add(TfMinSal);
		TfMinSal.setColumns(10);
		
		JLabel lblNumeroDeDepartamentos = new JLabel("Numero de departamentos");
		lblNumeroDeDepartamentos.setBounds(34, 172, 179, 14);
		Estadisticas.add(lblNumeroDeDepartamentos);
		
		TfNumDeps = new JTextField();
		TfNumDeps.setEditable(false);
		TfNumDeps.setBounds(234, 169, 86, 20);
		Estadisticas.add(TfNumDeps);
		TfNumDeps.setColumns(10);
		
		JLabel lblNombreDeDepartamento = new JLabel("Nombre de departamento con mas empleados y numero de empleados");
		lblNombreDeDepartamento.setBounds(38, 197, 476, 14);
		Estadisticas.add(lblNombreDeDepartamento);
		
		TfMaxEmps = new JTextField();
		TfMaxEmps.setEditable(false);
		TfMaxEmps.setBounds(34, 222, 480, 20);
		Estadisticas.add(TfMaxEmps);
		TfMaxEmps.setColumns(10);
		
		JLabel lblNombreDeDepartamento_1 = new JLabel("Nombre de departamento con menos empleados y numero de empleados");
		lblNombreDeDepartamento_1.setBounds(34, 252, 480, 14);
		Estadisticas.add(lblNombreDeDepartamento_1);
		
		TfMinEmps = new JTextField();
		TfMinEmps.setEditable(false);
		TfMinEmps.setBounds(34, 275, 480, 20);
		Estadisticas.add(TfMinEmps);
		TfMinEmps.setColumns(10);
		
		JLabel lblPracticaDeHibernate = new JLabel("Practica de Hibernate");
		lblPracticaDeHibernate.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPracticaDeHibernate.setHorizontalAlignment(SwingConstants.CENTER);
		lblPracticaDeHibernate.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPracticaDeHibernate.setBounds(150, 120, 298, 69);
		frame.getContentPane().add(lblPracticaDeHibernate);
		
		JLabel lblJorgeRealLozano = new JLabel("Jorge Real Lozano");
		lblJorgeRealLozano.setHorizontalAlignment(SwingConstants.CENTER);
		lblJorgeRealLozano.setBounds(240, 390, 131, 14);
		frame.getContentPane().add(lblJorgeRealLozano);
		
		
		
		
	}
	
	public void ImprimirEmp(Empleados emp){
		
		TfNEmpM.setText(String.valueOf(emp.getEmpNo()));
		TfApeM.setText(emp.getApellido());
		TfOfiM.setText(emp.getOficio());
		TfSalM.setText(String.valueOf(emp.getSalario()));
		TfComM.setText(String.valueOf(emp.getComision()));
		CBDepM.setSelectedItem(emp.getDepartamentos().getDeptNo());
		CBDirM.setSelectedItem(emp.getDir());		
	}
	
public static void LimpiarEmp(int op){
		switch(op){
		case 1:
			TfNEmpM.setText("");
			TfApeM.setText("");
			TfOfiM.setText("");
			TfSalM.setText("");
			TfComM.setText("");
			break;
		case 2:
			TfNEmpI.setText("");
			TfApeI.setText("");
			TfOfiI.setText("");
			TfSalI.setText("");
			TfComI.setText("");
			break;
		}
		
	}
	
	public void ImprimirDep(Departamentos dep){
		
		TfNDepM.setText(String.valueOf(dep.getDeptNo()));
		TfNomM.setText(dep.getDnombre());
		TfLocM.setText(dep.getLoc());
	}
	
	public static void LimpiarDep(int op){
		switch(op){
		case 1:
			TfNDepM.setText("");
			TfNomM.setText("");
			TfLocM.setText("");
			break;
		case 2:
			TfNDepI.setText("");
			TfNomI.setText("");
			TfLocI.setText("");
			break;
		}
	}
}
