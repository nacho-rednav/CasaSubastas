/**
 * 
 */
package Vista.Especialidad.crearEspecialidad;

import java.awt.Dimension;
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


public class IGUICrearEspecialidad extends JFrame implements IGUI{
	
	public IGUICrearEspecialidad(){
		JPanel main = new JPanel(new GridLayout(4, 2));
		this.setContentPane(main);
		this.setTitle("Crear Especialidad");
		
		JLabel idEmp = new JLabel("ID Empleado: ");
		JTextField tEmp = new JTextField(10);
		main.add(idEmp); main.add(tEmp);
		
		JLabel idT = new JLabel("ID Tipo de producto: ");
		JTextField tTipo = new JTextField(10);
		main.add(idT); main.add(tTipo);
		
		JLabel lNiv = new JLabel("Nivel de especialidad: ");
		JTextField tNivel = new JTextField(10);
		main.add(lNiv); main.add(tNivel);
		
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					setVisible(false);
					int idE = Integer.parseInt(tEmp.getText());
					int idT = Integer.parseInt(tTipo.getText());
					int nivel = Integer.parseInt(tNivel.getText());
					TEspecialidad te = new TEspecialidad(idE, idT, nivel);
					Controlador.getInstancia().accion(Evento.CREAR_ESPECIALIDAD, te);
					dispose();
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(main, "Introduce valores válidos");
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
		
		pack();
		this.setSize(new Dimension(700, 200));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actualizar(Object data) {
		setVisible(true);
	}
}