/**
 * 
 */
package Vista.Especialidad.bajaEspecialidad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Especialidad.TEspecialidad;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;


public class IGUIBajaEspecialidad extends JFrame implements IGUI{
	
	public IGUIBajaEspecialidad(){
		this.setTitle("Baja Especialidad");
		JPanel mainPanel = new JPanel();
		this.setContentPane(mainPanel);
		
		JLabel label = new JLabel("ID especialidad a dar de baja: ");
		mainPanel.add(label);
		JTextField idField = new JTextField(20);
		mainPanel.add(idField);
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Integer id = Integer.parseInt(idField.getText());
					TEspecialidad tl = new TEspecialidad(id);
					Controlador.getInstancia().accion(Evento.BAJA_ESPECIALIDAD, tl);
				dispose();
				}catch(NumberFormatException ex){
					setVisible(true);
					JOptionPane.showMessageDialog(mainPanel, "Introduzca valores válidos");
				}
			}
			
		});
		mainPanel.add(ok);
		
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		mainPanel.add(cancelar);
		
		pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void actualizar(Object data) {
		this.setVisible(true);
	}
}