/**
 * 
 */
package Vista.Almacen.modificarAlmacen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Almacen.TAlmacen;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;


public class IGUI_ID_ModificarAlmacen extends JFrame implements IGUI {

	public IGUI_ID_ModificarAlmacen() {
		setTitle("Modificar almacen");
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		
		JLabel label = new JLabel("ID almacen a modificar: ");
		panel.add(label);
		JTextField idField = new JTextField(20);
		panel.add(idField);
		
		JButton okButton = new JButton("Aceptar");
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					Integer id = Integer.parseInt(idField.getText());
					TAlmacen tAlmacen = new TAlmacen(id);
					Controlador.getInstancia().accion(Evento.MODIFICAR_ALMACEN_TRAER, tAlmacen);
					dispose();
				} catch(NumberFormatException ex) {
					setVisible(true);
					JOptionPane.showMessageDialog(panel, "Introduzca valores validos");
				}
				
			}
		});
		panel.add(okButton);
		
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		panel.add(cancelButton);
		
		pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
 	
	@Override
	public void actualizar(Object data) {
		setVisible(true);
		
	}
}