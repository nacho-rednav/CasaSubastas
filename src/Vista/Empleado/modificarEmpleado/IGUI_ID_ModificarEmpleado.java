package Vista.Empleado.modificarEmpleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Empleado.TEmpleado;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;

public class IGUI_ID_ModificarEmpleado  extends JFrame implements IGUI{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public IGUI_ID_ModificarEmpleado(){
		JPanel main = new JPanel();
		this.setContentPane(main);
		
		JLabel e = new JLabel("ID Empleado a modificar: ");
		main.add(e);
		JTextField idtext = new JTextField(10);
		main.add(idtext);
		
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					setVisible(false);
					Integer id = Integer.parseInt(idtext.getText());
					TEmpleado te = new TEmpleado(id);
					Controlador.getInstancia().accion(Evento.MODIFICAR_EMPLEADO, te);
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
