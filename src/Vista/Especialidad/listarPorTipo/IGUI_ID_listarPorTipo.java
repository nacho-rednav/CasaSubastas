package Vista.Especialidad.listarPorTipo;


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


public class IGUI_ID_listarPorTipo extends JFrame implements IGUI{
	
	public IGUI_ID_listarPorTipo(){
		this.setTitle("Listar Especialidades por Tipo producto");
		JPanel mainPanel = new JPanel();
		this.setContentPane(mainPanel);
		
		JLabel label = new JLabel("ID Tipo producto: ");
		mainPanel.add(label);
		JTextField tipoField = new JTextField(20);
		mainPanel.add(tipoField);
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Integer emp = Integer.parseInt(tipoField.getText());
					TEspecialidad tt = new TEspecialidad();
					tt.setId_Tipo(emp);
					Controlador.getInstancia().accion(Evento.LISTAR_ESPECIALIDAD_TIPO, tt);
					dispose();
				}catch(NumberFormatException ex){
					setVisible(true);
					JOptionPane.showMessageDialog(mainPanel, "Introduzca valores válidos");
				}
			}
			
		});
		mainPanel.add(ok);
		
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		mainPanel.add(cancelar);
		
		pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void actualizar(Object data) {
		this.setVisible(true);
	}
}

