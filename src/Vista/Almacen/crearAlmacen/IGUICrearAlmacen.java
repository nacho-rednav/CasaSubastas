/**
 * 
 */
package Vista.Almacen.crearAlmacen;

import java.awt.Dimension;
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

public class IGUICrearAlmacen extends JFrame implements IGUI {
	
	public IGUICrearAlmacen(){
		setTitle("Crear almacen");
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		JLabel lNombre = new JLabel("Nombre: ");
		JTextField tNombre = new JTextField(20);
		panel.add(lNombre);
		panel.add(tNombre);
		
		JLabel lM2 = new JLabel("Metros Cuadrados: ");
		JTextField tM2 = new JTextField(20);
		panel.add(lM2);
		panel.add(tM2);
		
		JLabel lAltura = new JLabel("Altura: ");
		JTextField tAltura = new JTextField(20);
		panel.add(lAltura);
		panel.add(tAltura);
		
		JLabel lTemperatura = new JLabel("Temperatura: ");
		JTextField tTemperatura = new JTextField(20);
		panel.add(lTemperatura);
		panel.add(tTemperatura);	
		
		JButton accept = new JButton("Aceptar");
		JButton cancel = new JButton("Cancel");
		panel.add(accept);
		panel.add(cancel);
		
		accept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					String nombre = tNombre.getText();
					Integer metrosCuadrados = Integer.parseInt(tM2.getText());
					Integer altura = Integer.parseInt(tAltura.getText());
					Integer temperatura = Integer.parseInt(tTemperatura.getText());
					TAlmacen ta = new TAlmacen(nombre, metrosCuadrados, altura, temperatura);
					Controlador.getInstancia().accion(Evento.CREAR_ALMACEN, ta);
					dispose();
				} catch (NumberFormatException ex) {
					setVisible(true);
					JOptionPane.showMessageDialog(panel, "Introduzca valores válidos");
				}
			}
		});
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();			
			}
		});
		
		pack();
		this.setSize(new Dimension(700, 200));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actualizar(Object data) {
		setVisible(true);
	}
}