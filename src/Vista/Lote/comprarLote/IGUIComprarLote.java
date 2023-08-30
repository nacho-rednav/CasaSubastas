package Vista.Lote.comprarLote;

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
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;

public class IGUIComprarLote extends JFrame implements IGUI{
	
	
	public IGUIComprarLote(){
		JPanel main = new JPanel(new GridLayout(4, 2));
		this.setContentPane(main);
		
		JLabel lb = new JLabel("ID lote a comprar: ");
		main.add(lb);
		JTextField idtext = new JTextField(10);
		main.add(idtext);
		JLabel lb2 = new JLabel("ID Comprador: ");
		main.add(lb2);
		JTextField idcomp = new JTextField(10);
		main.add(idcomp);
		JLabel lb3 = new JLabel("Precio: ");
		main.add(lb3);
		JTextField tprecio = new JTextField(10);
		main.add(tprecio);
		
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					setVisible(false);
					Integer id = Integer.parseInt(idtext.getText());
					Integer idComp = Integer.parseInt(idcomp.getText());
					Double precio = Double.parseDouble(tprecio.getText());
					TLote tl = new TLote(id);
					tl.setId_Comprador(idComp);
					tl.setPrecioVenta(precio);
					Controlador.getInstancia().accion(Evento.COMPRAR_LOTE, tl);
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
		setVisible(true);
	}

}
