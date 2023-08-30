package Vista.Empleado.altaEmpleado;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;

public class IGUIEmpleado extends JFrame implements IGUI {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;





	public IGUIEmpleado(){
		this.setLayout(new GridLayout(0, 1));
		setTitle("Alta Empleado(Selecionar jornada)");
		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.PAGE_START);
		
		JButton completa = new JButton("Completa");
		JButton partida = new JButton("Partida");
		
		
		completa.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				Controlador.getInstancia().accion(Evento.INIT_ALTA_EMPLEADO_COMPLETA, null);	
				dispose();
			}
			
		});
		
		partida.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				Controlador.getInstancia().accion(Evento.INIT_ALTA_EMPLEADO_PARTIDA, null);	
				dispose();

			}
			
		});
		
		panel.add(completa);
		panel.add(partida);
		pack();
	}

	
	@Override
	public void actualizar(Object data) {
		this.setVisible(true);
	}

}
