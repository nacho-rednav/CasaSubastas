/**
 * 
 */
package Vista.Empleado.modificarEmpleado;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Empleado.TEmpleadoPartida;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;


public class IGUIModificarEmpleadoPartida extends JFrame implements IGUI{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel main;
	JTextField id, nombre, apellidos, DNI, Edad, Activo, Sueldo, HorarioFinSemana, Turno;
	
	
	public IGUIModificarEmpleadoPartida(){
		this.setTitle("Modificar Empleado");
		main = new JPanel(new GridLayout(10, 2));
		this.setContentPane(main);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		id = new JTextField();
		nombre = new JTextField();
		apellidos = new JTextField();
		DNI = new JTextField();
		Edad= new JTextField();
		Activo = new JTextField();
		Sueldo= new JTextField();
		HorarioFinSemana= new JTextField();
		Turno= new JTextField();
	}

	@Override
	public void actualizar(Object data) {
		TEmpleadoPartida te = (TEmpleadoPartida) data;
		setVisible(true);
		
		JLabel lid = new JLabel("Id: ");
		id.setText(te.getId().toString());
		id.setEditable(false);
		main.add(lid); main.add(id);
		
		JLabel lnom = new JLabel("Nombre: ");
		nombre.setText(te.getNombre());
		main.add(lnom); main.add(nombre);
		
		JLabel lap = new JLabel("Apellidos: ");
		apellidos.setText(te.getApellidos());
		main.add(lap); main.add(apellidos);
		
		JLabel lDNI = new JLabel("DNI: ");
		DNI.setText(te.getDNI());
		DNI.setEditable(false);
		main.add(lDNI); main.add(DNI);
		
		JLabel ledad = new JLabel("Edad: ");
		Edad.setText(te.getEdad().toString());
		main.add(ledad); main.add(Edad);
		
		JLabel lactivo = new JLabel("Activo: ");
		Activo.setText(String.valueOf(te.getActivo()));
		Activo.setEditable(false);
		main.add(lactivo); main.add(Activo);
		
		JLabel lsueldo = new JLabel("Sueldo: ");
		Sueldo.setText(te.getSueldo().toString());
		main.add(lsueldo); main.add(Sueldo);
		
		JLabel lturno = new JLabel("Turno: ");
		Turno.setText(te.getturno());
		main.add(lturno); main.add(Turno);
		
		JLabel lhorario = new JLabel("Horario: ");
		HorarioFinSemana.setText(te.gethorasFinSemana());
		main.add(lhorario); main.add(HorarioFinSemana);
		
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
					setVisible(false);
					TEmpleadoPartida emp = new TEmpleadoPartida();
					emp.setId(Integer.parseInt(id.getText()));
					emp.setNombre(nombre.getText());
					emp.setApellidos(apellidos.getText());
					emp.setActivo(Activo.getText().equals("true"));
					emp.setDNI(DNI.getText());
					emp.setEdad(Integer.parseInt(Edad.getText()));
					emp.setSueldo(Integer.parseInt(Sueldo.getText()));
					emp.setturno(Turno.getText());
					emp.sethorasFinSemana(HorarioFinSemana.getText());
					Controlador.getInstancia().accion(Evento.MODIFICAR_EMPLEADO_FINAL, emp);
					dispose();
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(main, "Introduzca datos válidos");
					setVisible(true);
				}
			}
			
		});
		
		main.add(ok);
		
		JButton cancel = new JButton("Cancelar");
		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		main.add(cancel);
		this.pack();
	}
}
