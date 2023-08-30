package Vista.Especialidad.modificarEspecialidad;

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

public class IGUI_ID_ModificarEspecialidad extends JFrame implements IGUI{
	
	
	public IGUI_ID_ModificarEspecialidad(){
		JPanel main = new JPanel();
		this.setContentPane(main);
		
		JLabel lb = new JLabel("ID especialidad a modificar: ");
		main.add(lb);
		JTextField idtext = new JTextField(10);
		main.add(idtext);
		
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					setVisible(false);
					Integer id = Integer.parseInt(idtext.getText());
					TEspecialidad tl = new TEspecialidad(id);
					Controlador.getInstancia().accion(Evento.TRAER_MODIFICAR_ESPECIALIDAD, tl);
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