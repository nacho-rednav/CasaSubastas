/**
 * 
 */
package Vista.Almacen.mostrarAlmacen;

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

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Nacho Redondo
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class IGUImostrarAlmacen extends JFrame implements IGUI {
	
	public IGUImostrarAlmacen() {
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		this.setTitle("Mostrar almacen");
		
		JLabel lId = new JLabel("ID almacen: ");
		JTextField tId = new JTextField(10);
		panel.add(lId);
		panel.add(tId);
		
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					Integer id = Integer.parseInt(tId.getText());
					TAlmacen ta = new TAlmacen(id);
					Controlador.getInstancia().accion(Evento.MOSTRAR_ALMACEN, ta);
					dispose();
				}
				catch(NumberFormatException ex) {
					setVisible(true);
					JOptionPane.showMessageDialog(null, "Introduce valores validos");
				}
			} 
		});
		panel.add(ok);
		
		JButton cancel = new JButton("Cancelar");
		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(cancel);
		
		pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actualizar(Object data) {
		this.setVisible(true);
		
	}
}