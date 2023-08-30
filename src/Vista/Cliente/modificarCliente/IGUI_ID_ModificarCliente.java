/**
 * 
 */
package Vista.Cliente.modificarCliente;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Cliente.TCliente;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;


public class IGUI_ID_ModificarCliente extends JFrame implements IGUI{
	
	public IGUI_ID_ModificarCliente(){
		
		setTitle("Modificar Cliente");
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		
		JLabel label = new JLabel("ID cliente a modificar: ");
		panel.add(label);
		JTextField idField = new JTextField(20);
		panel.add(idField);
		
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Integer id = Integer.parseInt(idField.getText());
					TCliente tc = new TCliente(id);
					Controlador.getInstancia().accion(Evento.MODIFICAR_CLIENTE_TRAER, tc);
					dispose();
				}catch(NumberFormatException ex){
					setVisible(true);
					JOptionPane.showMessageDialog(panel, "Introduzca valores válidos");
				}
			}
			
		});
		panel.add(ok);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		panel.add(cancelar);
		
		pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actualizar(Object data) {
		this.setVisible(true);		
	}
}