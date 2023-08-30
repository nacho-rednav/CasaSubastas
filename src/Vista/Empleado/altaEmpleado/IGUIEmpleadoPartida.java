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

import Negocio.Empleado.TEmpleadoPartida;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;

public class IGUIEmpleadoPartida extends JFrame implements IGUI {

	
	public IGUIEmpleadoPartida(){
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
		
		JLabel lTurno = new JLabel("Turno: ");
		JTextField tTurno = new JTextField(10);
		panelPrincipal.add(lTurno);
		panelPrincipal.add(tTurno);

		JLabel lHorasFindeSemana = new JLabel("Horas fin de semana: ");
		JTextField tHorasFindeSemana = new JTextField(10);
		panelPrincipal.add(lHorasFindeSemana);
		panelPrincipal.add(tHorasFindeSemana);
		
		JButton accept = new JButton("Aceptar");
		
		accept.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
				String DNI = tDNI.getText();
				String nombre = tNombre.getText();
				String Apeliidos = tApellidos.getText();
				Integer Edad = Integer.parseInt(tEdad.getText());
				Integer Sueldo = Integer.parseInt(tSueldo.getText());
				String turno = tTurno.getText();
				String HorasFinSemana = tHorasFindeSemana.getText();
				TEmpleadoPartida tp = new TEmpleadoPartida(HorasFinSemana, turno, DNI, Sueldo, Edad, Apeliidos, nombre);
				Controlador.getInstancia().accion(Evento.ALTA_EMPLEADO_PARTIDA, tp);
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
