/**
 * 
 */
package Vista.Subasta.crearSubasta;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Subasta.TSubasta;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;

public class IGUICrearSubasta extends JFrame implements IGUI {
	
	public IGUICrearSubasta(){
		this.setLayout(new GridLayout(0, 1));
		setTitle("Crear Subasta");
		JPanel panel = new JPanel();
		this.add(panel);
		JLabel lTitulo = new JLabel("Titulo: ");
		panel.add(lTitulo);
		JTextField tTitulo = new JTextField(20);
		panel.add(tTitulo);
		
		JPanel panel2 = new JPanel();
		JLabel lDesc = new JLabel("Descripcion: ");
		panel2.add(lDesc);
		JTextField tDesc = new JTextField(50);
		panel2.add(tDesc);
		this.add(panel2);

		JPanel panel3 = new JPanel();
		JButton accept = new JButton("Aceptar");
		panel3.add(accept);
		JButton cancel = new JButton("Cancel");
		panel3.add(cancel);
		this.add(panel3);
		
		accept.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				String titulo = tTitulo.getText();
				String desc = tDesc.getText();
				TSubasta ts = new TSubasta(titulo, desc);
				Controlador.getInstancia().accion(Evento.CREAR_SUBASTA, ts);
				dispose();

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
		this.setVisible(true);
		this.setSize(new Dimension(700, 200));		
	}

	@Override
	public void actualizar(Object data) {
		this.setVisible(true);			
	}
}