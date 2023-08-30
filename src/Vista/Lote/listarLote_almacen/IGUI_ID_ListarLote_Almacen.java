package Vista.Lote.listarLote_almacen;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Lote.TLote;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;


public class IGUI_ID_ListarLote_Almacen extends JFrame implements IGUI{
	
	public IGUI_ID_ListarLote_Almacen(){
		this.setTitle("Listar Lotes por Almacen");
		JPanel mainPanel = new JPanel();
		this.setContentPane(mainPanel);
		
		JLabel label = new JLabel("ID Almacen: ");
		mainPanel.add(label);
		JTextField almField = new JTextField(20);
		mainPanel.add(almField);
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Integer alm = Integer.parseInt(almField.getText());
					TLote tl = new TLote();
					tl.setId_Almacen(alm);
					Controlador.getInstancia().accion(Evento.LISTAR_LOTES_ALMACEN, tl);
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

