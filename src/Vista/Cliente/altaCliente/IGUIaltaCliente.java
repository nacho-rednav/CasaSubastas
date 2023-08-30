/**
 * 
 */
package Vista.Cliente.altaCliente;

import javax.swing.JFrame;

import java.awt.Dimension;
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


public class IGUIaltaCliente extends JFrame implements IGUI{

	public IGUIaltaCliente(){
		//Crea el panel
		setTitle("Alta Cliente");
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		
		//Creamos los campos necesarios y los botones de aceptar y cancelar
		JLabel lDNI = new JLabel("DNI: ");
		JTextField tDNI = new JTextField(20);
		panel.add(lDNI);
		panel.add(tDNI);
		
		JLabel lNombre = new JLabel("Nombre: ");
		JTextField tNombre = new JTextField(20);
		panel.add(lNombre);
		panel.add(tNombre);
		
		JLabel lTelefono = new JLabel("Telefono: ");
		JTextField tTelefono = new JTextField(20);
		panel.add(lTelefono);
		panel.add(tTelefono);
		
		JLabel lDomicilio = new JLabel("Domicilio: ");
		JTextField tDomicilio = new JTextField(20);
		panel.add(lDomicilio);
		panel.add(tDomicilio);
		
		JLabel lCorreo = new JLabel("Correo: ");
		JTextField tCorreo = new JTextField(20);
		panel.add(lCorreo);
		panel.add(tCorreo);
		
		JLabel lCuentaBancaria = new JLabel("Cuenta Bancaria: ");
		JTextField tCuentaBancaria = new JTextField(20);
		panel.add(lCuentaBancaria);
		panel.add(tCuentaBancaria);
	
		
		JButton accept = new JButton("Aceptar");
		JButton cancel = new JButton("Cancel");
		panel.add(accept);
		panel.add(cancel);	
		
				accept.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						
						try{
							setVisible(false);
							String DNI = tDNI.getText();
							String Nombre = tNombre.getText();
							Integer Telefono = Integer.parseInt(tTelefono.getText());
							String Domicilio = tDomicilio.getText();
							String Correo = tCorreo.getText();
							String CuentaBancaria = tCuentaBancaria.getText();
							TCliente tc = new TCliente(DNI, Nombre, Telefono, Domicilio, Correo, CuentaBancaria);
							Controlador.getInstancia().accion(Evento.ALTA_CLIENTE, tc);
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
				this.setSize(new Dimension(700, 200));
				this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
			}
			
			public void actualizar(Object data) {
				this.setVisible(true);		
	
			}
}