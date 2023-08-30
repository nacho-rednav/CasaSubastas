/**
 * 
 */
package Vista.Subasta.mostrarSubasta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Subasta.TSubasta;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;

public class IGUIMostrarSubasta extends JFrame implements IGUI {
	
	public IGUIMostrarSubasta(){
		setTitle("Mostrar Subasta");
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		JLabel lID = new JLabel("ID: ");
		panel.add(lID);
		JTextField tID = new JTextField(20);
		panel.add(tID);

		JButton accept = new JButton("Aceptar");
		panel.add(accept);
		JButton cancel = new JButton("Cancel");
		panel.add(cancel);
		
		JDialog panelModi = new JDialog();
		panelModi.setVisible(false);
		panelModi.setSize(new Dimension(800, 200));
		panelModi.setTitle("Mostrar Subasta");
		panelModi.setLayout(new BorderLayout());
		
		accept.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					setVisible(false);
					Integer id = Integer.parseInt(tID.getText());
					TSubasta ts = new TSubasta(id);
					Controlador.getInstancia().accion(Evento.MOSTRAR_SUBASTA, ts);

					dispose();
				}catch(NumberFormatException ex){
					setVisible(true);
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
		setVisible(true);		
	}
}