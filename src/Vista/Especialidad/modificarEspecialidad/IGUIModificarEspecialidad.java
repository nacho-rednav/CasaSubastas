/**
 * 
 */
package Vista.Especialidad.modificarEspecialidad;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Especialidad.TEspecialidad;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;


public class IGUIModificarEspecialidad extends JFrame implements IGUI{
	
	JPanel main;
	JTextField id, id_E, id_T, activo, nivel;
	
	public IGUIModificarEspecialidad(){
		this.setTitle("Modificar Especialidad");
		main = new JPanel(new GridLayout(6, 2));
		this.setContentPane(main);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		id = new JTextField();
		id_E= new JTextField();
		id_T = new JTextField();
		activo = new JTextField();
		nivel = new JTextField();
	}
	
	@Override
	public void actualizar(Object data) {
		setVisible(true);

		TEspecialidad te = (TEspecialidad) data;
		JLabel lid = new JLabel("Id: ");
		id.setText(te.getId().toString());
		id.setEditable(false);
		main.add(lid); main.add(id);
		
		JLabel lid_E = new JLabel("Id Empleado: ");
		id_E.setText(te.getId_Empleado().toString());
		id_E.setEditable(false);
		main.add(lid_E); main.add(id_E);
		
		JLabel lid_T = new JLabel("Id Tipo producto: ");
		id_T.setText(te.getId_Tipo().toString());
		id_T.setEditable(false);
		main.add(lid_T); main.add(id_T);
		
		JLabel lactivo = new JLabel("Activo: ");
		activo.setText(te.getActivo().toString());
		activo.setEditable(false);
		main.add(lactivo); main.add(activo);
		
		JLabel lnivel = new JLabel("Nivel: ");
		nivel.setText(te.getNivel().toString());
		main.add(lnivel); main.add(nivel);
		
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
					setVisible(false);
					TEspecialidad trans = new TEspecialidad();
					trans.setId(Integer.parseInt(id.getText()));
					trans.setActivo(activo.getText().equals("true"));
					trans.setId_Tipo(Integer.parseInt(id_T.getText()));
					trans.setId_Empleado(Integer.parseInt(id_E.getText()));
					trans.setNivel(Integer.parseInt(nivel.getText()));
					Controlador.getInstancia().accion(Evento.MODIFICAR_ESPECIALIDAD, trans);
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