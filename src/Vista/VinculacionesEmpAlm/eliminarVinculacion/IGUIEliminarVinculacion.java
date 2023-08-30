package Vista.VinculacionesEmpAlm.eliminarVinculacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.VinculacionesEmpAlm.TVinculacion;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;

public class IGUIEliminarVinculacion extends JFrame implements IGUI{
	
	
	public IGUIEliminarVinculacion(){
		JPanel main = new JPanel(new GridLayout(3, 2));
		this.setContentPane(main);
		this.setTitle("Eliminar Vinculacion Empleado-Almacen");
		
		JLabel lb = new JLabel("ID Empleado: ");
		main.add(lb);
		JTextField idemp = new JTextField(10);
		main.add(idemp);
		JLabel lb2 = new JLabel("ID Almacen: ");
		main.add(lb2);
		JTextField idalm = new JTextField(10);
		main.add(idalm);
		
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					setVisible(false);
					Integer idE = Integer.parseInt(idemp.getText());
					Integer idA = Integer.parseInt(idalm.getText());
					TVinculacion tv = new TVinculacion(idA, idE);
					Controlador.getInstancia().accion(Evento.ELIMINAR_VINCULACION, tv);
					dispose();
				} catch(NumberFormatException ex){
					setVisible(true);
					JOptionPane.showMessageDialog(null, "Introduce valores válidos");
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
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actualizar(Object data) {
		this.setVisible(true);
	}
}
