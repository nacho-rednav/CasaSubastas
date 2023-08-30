
package Vista.Tipodeproducto.modificarTipoProducto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Tipodeproducto.TTipo;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;

public class IGUIModificarTipoProducto extends JFrame implements IGUI{
	
	JPanel main;
	JTextField id, tit, desc;
	
	public IGUIModificarTipoProducto(){
		this.setTitle("Modificar Tipo de producto");
		main = new JPanel(new GridLayout(11, 2));
		this.setContentPane(main);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		id = new JTextField();
		tit = new JTextField();
		desc = new JTextField();
	}

	@Override
	public void actualizar(Object data) {
		TTipo tl = (TTipo) data;
		setVisible(true);
		
		JLabel lid = new JLabel("Id: ");
		id.setText(tl.getId().toString());
		id.setEditable(false);
		main.add(lid); main.add(id);
		
		JLabel ltit = new JLabel("Titulo: ");
		tit.setText(tl.getTitulo());
		tit.setEditable(false);
		main.add(ltit); main.add(tit);
		
		JLabel ldesc = new JLabel("Descripcion: ");
		desc.setText(tl.getDescripcion());
		main.add(ldesc); main.add(desc);
		
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				tl.setDescripcion(desc.getText());
				Controlador.getInstancia().accion(Evento.MODIFICAR_TIPO, tl);
				dispose();
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
	}
}