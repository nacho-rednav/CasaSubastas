/**
 * 
 */
package Vista.Cliente.modificarCliente;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Cliente.TCliente;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;

public class IGUImodificarCliente extends JFrame implements IGUI{
	
	JPanel main;
	JTextField DNI, Nombre, Telefono, Domicilio, Correo, CuentaBancaria, Activo, ID;

	public IGUImodificarCliente(){
		this.setTitle("Modificar cliente");
		main = new JPanel(new GridLayout(11, 2));
		this.setContentPane(main);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		ID = new JTextField();
		Nombre = new JTextField();
		Activo = new JTextField();
		DNI = new JTextField();
		Telefono = new JTextField();
		Domicilio = new JTextField();
		Correo = new JTextField();
		CuentaBancaria = new JTextField();
	}

	@Override
	public void actualizar(Object data) {
		
		TCliente tc = (TCliente) data;
		setVisible(true);
		
		JLabel cid = new JLabel("ID: ");
		ID.setText(tc.getID().toString());
		ID.setEditable(false);
		main.add(cid); 
		main.add(ID);
		
		JLabel lact = new JLabel("Activo: ");
		Activo.setText(tc.getActivo().toString());
		Activo.setEditable(false);
		main.add(lact); 
		main.add(Activo);
		
		JLabel cnom = new JLabel("Nombre: ");
		Nombre.setText(tc.getNombre());
		main.add(cnom); 
		main.add(Nombre);
		
		JLabel cdni = new JLabel("DNI: ");
		DNI.setText(tc.getDNI());
		DNI.setEditable(false);
		main.add(cdni); 
		main.add(DNI);
		
		JLabel ctlf = new JLabel("Telefono: ");
		Telefono.setText(tc.getTelefono().toString());
		main.add(ctlf); 
		main.add(Telefono);
		
		JLabel cdom = new JLabel("Domicilio: ");
		Domicilio.setText(tc.getDomicilio());
		main.add(cdom); 
		main.add(Domicilio);
		
		JLabel ccor = new JLabel("Correo: ");
		Correo.setText(tc.getCorreo());
		main.add(ccor); 
		main.add(Correo);
		
		JLabel ccb = new JLabel("Cuenta Bancaria: ");
		CuentaBancaria.setText(tc.getCuentaBancaria());
		main.add(ccb); 
		main.add(CuentaBancaria);
		
		
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
					setVisible(false);
					TCliente trans = new TCliente();
					trans.setID(Integer.parseInt(ID.getText()));
					trans.setNombre(Nombre.getText());
					trans.setActivo(Activo.getText().equals("true"));
					trans.setDNI(DNI.getText());
					trans.setTelefono(Integer.parseInt(Telefono.getText()));
					trans.setDomicilio(Domicilio.getText());
					trans.setCorreo(Correo.getText());
					trans.setCuentaBancaria(CuentaBancaria.getText());
					Controlador.getInstancia().accion(Evento.MODIFICAR_CLIENTE, trans);
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
	
