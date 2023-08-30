package Vista.Empleado.altaEmpleado;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Empleado.TEmpleadoCompleta;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;

public class IGUIEmpleadoCompleta extends JFrame implements IGUI {

	public IGUIEmpleadoCompleta(){
		this.setLayout(new GridLayout(0, 1));
		setTitle("Alta Empleado");
		
		JPanel panelPrincipal = new JPanel();
		this.setContentPane(panelPrincipal);
		this.setSize(new Dimension(800, 250));
		
		JLabel lDNI = new JLabel("DNI: ");
		JTextField tDNI = new JTextField(10);
		panelPrincipal.add(lDNI);
		panelPrincipal.add(tDNI);
		
		JLabel lNombre = new JLabel("Nombre: ");
		JTextField tNombre = new JTextField(10);
		panelPrincipal.add(lNombre);
		panelPrincipal.add(tNombre);
		
		JLabel lApellidos = new JLabel("Apellidos: ");
		JTextField tApellidos = new JTextField(10);
		panelPrincipal.add(lApellidos);
		panelPrincipal.add(tApellidos);

		JLabel lEdad = new JLabel("Edad: ");
		JTextField tEdad = new JTextField(10);
		panelPrincipal.add(lEdad);
		panelPrincipal.add(tEdad);

		JLabel lSueldo = new JLabel("Sueldo: ");
		JTextField tSueldo = new JTextField(10);
		panelPrincipal.add(lSueldo);
		panelPrincipal.add(tSueldo);
		
		JLabel lBonus = new JLabel("Bonus: ");
		JTextField tBonus = new JTextField(10);
		panelPrincipal.add(lBonus);
		panelPrincipal.add(tBonus);

		JLabel lHorario = new JLabel("Horario: ");
		JTextField tHorario = new JTextField(10);
		panelPrincipal.add(lHorario);
		panelPrincipal.add(tHorario);
		
		JButton accept = new JButton("Aceptar");
		
		accept.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
				setVisible(false);
				String DNI = tDNI.getText();
				String nombre = tNombre.getText();
				String Apeliidos = tApellidos.getText();
				Integer Edad = Integer.parseInt(tEdad.getText());
				Integer Sueldo = Integer.parseInt(tSueldo.getText());
				Integer Bonus = Integer.parseInt(tBonus.getText());
				String Horario = tHorario.getText();
				TEmpleadoCompleta tc = new TEmpleadoCompleta(Bonus, Horario, DNI, Sueldo, Edad, Apeliidos, nombre);
				Controlador.getInstancia().accion(Evento.ALTA_EMPLEADO_COMPLETA, tc);
				dispose();
				}catch(NumberFormatException ex){
					setVisible(true);
					JOptionPane.showMessageDialog(null, "Introduzca datos válidos");
				}

			}
			
		});
		
		JButton cancel = new JButton("Cancel");
		
		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		panelPrincipal.add(accept);
		panelPrincipal.add(cancel);
		
		
	}
	
	
	@Override
	public void actualizar(Object data) {
		this.setVisible(true);
	}
	
}
