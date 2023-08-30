/**
 * 
 */
package Vista.Empleado.mostrarEmpleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Empleado.TEmpleado;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;


public class IGUIMostrarEmpleado extends JFrame implements IGUI{


	public IGUIMostrarEmpleado(){
		this.setTitle("Mostrar Empleado");
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		JLabel lID = new JLabel("ID: ");
		panel.add(lID);
		JTextField tID = new JTextField(20);
		panel.add(tID);

		JButton accept = new JButton("Aceptar");
		panel.add(accept);
		JButton cancel = new JButton("Cancel");
		panel.add(cancel);
		
		accept.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					setVisible(false);
					Integer id = Integer.parseInt(tID.getText());
					TEmpleado te = new TEmpleado(id);
					Controlador.getInstancia().accion(Evento.MOSTRAR_EMPLEADO, te);
					dispose();
				}catch(NumberFormatException ex){
					setVisible(true);
					JOptionPane.showMessageDialog(panel, "Introduzca valores válidos");
				}
			}
		});

		cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

				
	}

	@Override
	public void actualizar(Object data){
		this.setVisible(true);
	}
	
}