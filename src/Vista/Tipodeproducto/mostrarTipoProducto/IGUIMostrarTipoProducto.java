
package Vista.Tipodeproducto.mostrarTipoProducto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Tipodeproducto.TTipo;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;

public class IGUIMostrarTipoProducto extends JFrame implements IGUI{
	
	public IGUIMostrarTipoProducto(){
		
		setTitle("Mostrar tipo de producto");
		JPanel panel = new JPanel(); 
		this.setContentPane(panel);

		JLabel lId = new JLabel("Id: ");
		JTextField tId = new JTextField(20);
		panel.add(lId);
		panel.add(tId);
		
		JButton accept = new JButton("Aceptar");
		JButton cancel = new JButton("Cancel");
		panel.add(accept);
		panel.add(cancel);
		
		accept.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				try{
					
					setVisible(false);
					
					Integer id = Integer.parseInt(tId.getText());
					
					TTipo tt = new TTipo(id);
					
					Controlador.getInstancia().accion(Evento.MOSTRAR_TIPO, tt);
					dispose();
				}catch(NumberFormatException ex){
					
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
	public void actualizar(Object data) {
		this.setVisible(true);
		
	}
}