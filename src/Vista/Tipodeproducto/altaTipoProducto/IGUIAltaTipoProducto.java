
package Vista.Tipodeproducto.altaTipoProducto;

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

public class IGUIAltaTipoProducto extends JFrame implements IGUI {
	
	public IGUIAltaTipoProducto(){
		
		setTitle("Crear Tipo de Producto");
		JPanel panel = new JPanel(); 
		this.setContentPane(panel);
		
		JLabel lTitulo = new JLabel("Titulo: ");
		JTextField tTitulo = new JTextField(20);
		panel.add(lTitulo);
		panel.add(tTitulo);
		
		JLabel lDesc = new JLabel("Descripcion: ");
		JTextField tDesc = new JTextField(100);
		panel.add(lDesc);
		panel.add(tDesc);
		
		JButton accept = new JButton("Aceptar");
		JButton cancel = new JButton("Cancel");
		panel.add(accept);
		panel.add(cancel);
		
		accept.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				try{
					
					setVisible(false);
					
					String titulo = tTitulo.getText();
					String desc = tDesc.getText();
					
					TTipo tt = new TTipo(titulo, desc);
					
					Controlador.getInstancia().accion(Evento.ALTA_TIPO, tt);
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