package Vista.VinculacionesEmpAlm.listarPorEmpleado;

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

public class IGUI_ID_ListarVinculacionesEmpleado extends JFrame implements IGUI{
	
	
	public IGUI_ID_ListarVinculacionesEmpleado(){
		JPanel main = new JPanel(new GridLayout(2, 2));
		this.setContentPane(main);
		this.setTitle("Listar Vinculaciones por Empleado");
		
		JLabel lb2 = new JLabel("ID Empleado: ");
		main.add(lb2);
		JTextField idemp = new JTextField(10);
		main.add(idemp);
		
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					setVisible(false);
					Integer idE = Integer.parseInt(idemp.getText());
					TVinculacion tv = new TVinculacion(0, idE);
					Controlador.getInstancia().accion(Evento.LISTAR_VINCULACIONES_EMPLEADO, tv);
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
