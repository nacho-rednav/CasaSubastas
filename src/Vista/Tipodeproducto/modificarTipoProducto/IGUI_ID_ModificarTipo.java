
package Vista.Tipodeproducto.modificarTipoProducto;

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

public class IGUI_ID_ModificarTipo extends JFrame implements IGUI {
	
	public IGUI_ID_ModificarTipo(){
		
		setTitle("Modificar Tipo de Producto");
		JPanel panel = new JPanel(); 
		this.setContentPane(panel);
		
		JLabel lid = new JLabel("ID tipo a modificar: ");
		JTextField tId = new JTextField(20);
		panel.add(lid);
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
					
					int id = Integer.parseInt(tId.getText());
					
					TTipo tt = new TTipo(id);
					
					Controlador.getInstancia().accion(Evento.MODIFICAR_TRAER_TIPO, tt);
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