package Vista.VinculacionesEmpAlm.listarPorAlmacen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Lote.TLote;
import Negocio.VinculacionesEmpAlm.TVinculacion;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;

public class IGUI_ID_ListarVinculacionesAlmacen extends JFrame implements IGUI{
	
	
	public IGUI_ID_ListarVinculacionesAlmacen(){
		JPanel main = new JPanel(new GridLayout(2, 2));
		this.setContentPane(main);
		this.setTitle("Listar Vinculaciones por Almacen");
		
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
					Integer idA = Integer.parseInt(idalm.getText());
					TVinculacion tv = new TVinculacion(idA);
					Controlador.getInstancia().accion(Evento.LISTAR_VINCULACIONES_ALMACEN, tv);
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
