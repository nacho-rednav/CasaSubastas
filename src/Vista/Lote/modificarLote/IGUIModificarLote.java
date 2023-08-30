/**
 * 
 */
package Vista.Lote.modificarLote;

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


public class IGUIModificarLote extends JFrame implements IGUI{
	
	JPanel main;
	JTextField id, nombre, activo, id_a, id_s, id_t, precSal, desc, id_f, precV;
	
	public IGUIModificarLote(){
		this.setTitle("Modificar lote");
		main = new JPanel(new GridLayout(11, 2));
		this.setContentPane(main);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		id = new JTextField();
		nombre = new JTextField();
		activo = new JTextField();
		id_a = new JTextField();
		id_s= new JTextField();
		id_t= new JTextField();
		precSal= new JTextField();
		desc= new JTextField();
		id_f= new JTextField();
		precV= new JTextField();
	}

	@Override
	public void actualizar(Object data) {
		TLote tl = (TLote) data;
		setVisible(true);
		
		JLabel lid = new JLabel("Id: ");
		id.setText(tl.getId().toString());
		id.setEditable(false);
		main.add(lid); main.add(id);
		
		JLabel lnom = new JLabel("Nombre: ");
		nombre.setText(tl.getNombre());
		nombre.setEditable(false);
		main.add(lnom); main.add(nombre);
		
		JLabel lact = new JLabel("Activo: ");
		activo.setText(tl.getActivo().toString());
		activo.setEditable(false);
		main.add(lact); main.add(activo);
		
		JLabel lid_a = new JLabel("Almacen: ");
		id_a.setText(tl.getId_Almacen().toString());
		main.add(lid_a); main.add(id_a);
		
		JLabel lid_s = new JLabel("Subasta: ");
		id_s.setText(tl.getId_Subasta().toString());
		main.add(lid_s); main.add(id_s);
		
		JLabel lid_t = new JLabel("Tipo de producto: ");
		id_t.setText(tl.getId_Tipo().toString());
		main.add(lid_t); main.add(id_t);
		
		JLabel lprecS = new JLabel("Precio de salida: ");
		precSal.setText(tl.getPrecioSalida().toString());
		main.add(lprecS); main.add(precSal);
		
		JLabel ldesc = new JLabel("Descripcion: ");
		desc.setText(tl.getDescripcion());
		main.add(ldesc); main.add(desc);
		
		precV.setText(tl.getPrecioVenta().toString());
		id_f.setText(tl.getId_Comprador().toString());
		if(tl.getVendido()){
			JLabel lprecV = new JLabel("Precio venta: ");
			main.add(lprecV); main.add(precV);
			
			JLabel lid_f = new JLabel("Comprador: ");
			main.add(lid_f); main.add(id_f);
		}
		
		JButton ok = new JButton("Aceptar");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
					setVisible(false);
					TLote trans = new TLote();
					trans.setId(Integer.parseInt(id.getText()));
					trans.setNombre(nombre.getText());
					trans.setActivo(activo.getText().equals("true"));
					trans.setId_Almacen(Integer.parseInt(id_a.getText()));
					trans.setId_Subasta(Integer.parseInt(id_s.getText()));
					trans.setId_Tipo(Integer.parseInt(id_t.getText()));
					trans.setId_Comprador(Integer.parseInt(id_f.getText()));
					trans.setPrecioSalida(Double.parseDouble(precSal.getText()));
					trans.setPrecioVenta(Double.parseDouble(precV.getText()));
					trans.setDescripcion(desc.getText());
					trans.setVendido(tl.getVendido());
					Controlador.getInstancia().accion(Evento.MODIFICAR_LOTE, trans);
					dispose();
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(main, "Introduzca datos válidos");
					setVisible(true);
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
		this.pack();
	}
}