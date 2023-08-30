/**
 * 
 */
package Vista.Almacen.modificarAlmacen;

import java.awt.GridLayout;
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


public class IGUImodificarAlmacen extends JFrame implements IGUI {
	
	private JPanel panel;
	private JTextField id, nombre, metrosCuadrados, altura, temperatura, activo;
	
	public IGUImodificarAlmacen() {
		setTitle("Modificar almacen");
		panel = new JPanel(new GridLayout(11, 2));
		this.setContentPane(panel);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		id = new JTextField();
		nombre = new JTextField();
		metrosCuadrados = new JTextField();
		altura = new JTextField();
		temperatura = new JTextField();
		activo = new JTextField();
	}

	@Override
	public void actualizar(Object data) {
		TAlmacen ta = (TAlmacen) data;
		setVisible(true);
		
		JLabel lId = new JLabel("Id: ");
		id.setText(ta.getID().toString());
		id.setEditable(false);
		panel.add(lId);
		panel.add(id);
		
		JLabel lNombre = new JLabel("Nombre: ");
		nombre.setText(ta.getNombre().toString());
		nombre.setEditable(false);
		panel.add(lNombre); 
		panel.add(nombre);
		
		JLabel lMetrosCuadrados = new JLabel("Metros cuadrados: ");
		metrosCuadrados.setText(ta.getMetrosCuadrados().toString());
		panel.add(lMetrosCuadrados); 
		panel.add(metrosCuadrados);
		
		JLabel lAltura = new JLabel("Altura: ");
		altura.setText(ta.getAltura().toString());
		panel.add(lAltura); 
		panel.add(altura);
		
		JLabel lTemperatura = new JLabel("Temperatura: ");
		temperatura.setText(ta.getAltura().toString());
		panel.add(lTemperatura); 
		panel.add(temperatura);
		
		JLabel lAct = new JLabel("Activo: ");
		activo.setText(ta.getActivo().toString());
		activo.setEditable(false);
		panel.add(lAct); 
		panel.add(activo);
		
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					setVisible(false);
					TAlmacen ta = new TAlmacen(null);
					ta.setID(Integer.parseInt(id.getText()));
					ta.setNombre(nombre.getText());
					ta.setMetrosCuadrados(Integer.parseInt(metrosCuadrados.getText()));
					ta.setAltura(Integer.parseInt(altura.getText()));
					ta.setTemperatura(Integer.parseInt(temperatura.getText()));
					ta.setActivo(activo.getText().equals("true"));
					Controlador.getInstancia().accion(Evento.MODIFICAR_ALMACEN, ta);
				} catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(panel, "Introduzca datos válidos");
					setVisible(true);
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
		this.pack();
	}
}