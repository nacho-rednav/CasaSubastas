package Vista.Cliente.mostrarCliente;

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


public class IGUImostrarCliente extends JFrame implements IGUI{
	
	public IGUImostrarCliente(){
		JPanel main = new JPanel();
		this.setContentPane(main);
		this.setTitle("Mostrar Cliente");
		
		JLabel lid = new JLabel("ID: ");
		main.add(lid);
		JTextField tid = new JTextField(20);
		main.add(tid);

		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				try{
					setVisible(false);
					Integer id = Integer.parseInt(tid.getText());
					TCliente tc = new TCliente(id);
					Controlador.getInstancia().accion(Evento.MOSTRAR_CLIENTE, tc);
					dispose();
				}catch(NumberFormatException ex){
					setVisible(true);
					JOptionPane.showMessageDialog(null, "Introduzca valores válidos");
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
		
		pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
	
	public void actualizar(Object data){
		this.setVisible(true);
	}

}