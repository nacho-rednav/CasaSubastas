/**
 * 
 */
package Vista.Lote.crearLote;

import java.awt.Dimension;
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

public class IGUICrearLote extends JFrame implements IGUI{ //Implementa IGUI para que la use el controlador
	
	public IGUICrearLote(){
		//Añadimos campos y botones de aceptar y cancelar
		setTitle("Crear Lote");
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		JLabel lNombre = new JLabel("Nombre: ");
		JTextField tNombre = new JTextField(20);
		panel.add(lNombre);
		panel.add(tNombre);
		
		JLabel lDesc = new JLabel("Descripcion: ");
		JTextField tDesc = new JTextField(50);
		panel.add(lDesc);
		panel.add(tDesc);

		JLabel lAlmacen = new JLabel("Almacen: ");
		JTextField tAlmacen = new JTextField(20);
		panel.add(lAlmacen);
		panel.add(tAlmacen);

		JLabel lSubasta = new JLabel("Subasta: ");
		JTextField tSubasta = new JTextField(20);
		panel.add(lSubasta);
		panel.add(tSubasta);

		JLabel lTipo = new JLabel("Tipo Producto: ");
		JTextField tTipo = new JTextField(20);
		panel.add(lTipo);
		panel.add(tTipo);

		JLabel lPrecio = new JLabel("Precio: ");
		JTextField tPrecio = new JTextField(20);
		panel.add(lPrecio);
		panel.add(tPrecio);

		JButton accept = new JButton("Aceptar");
		JButton cancel = new JButton("Cancel");
		panel.add(accept);
		panel.add(cancel);
		
		//Acciones cuando le da a aceptar
		accept.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Está en un try por si ha metido letras en los campos numéricos
				try{
					//Ocultamos la vista
					setVisible(false);
					//Vamos recogiendo cada campo
					String nombre = tNombre.getText();
					String desc = tDesc.getText();
					Integer id_Alm = Integer.parseInt(tAlmacen.getText());
					Integer id_Tipo = Integer.parseInt(tTipo.getText());
					Integer id_Subasta = Integer.parseInt(tSubasta.getText());
					Double precioSalida = Double.parseDouble(tPrecio.getText());
					//Si todos lo datos introducidos son correctos, creamos el transfer con los datos recogidos
					TLote tl = new TLote(nombre, desc, id_Alm, id_Tipo, id_Subasta, precioSalida);
					//Así accedemos a ControladorImp, le mandamos el transfer recién creado y le decimos que le toca hacer un Crear Lote
					//Cada caso de uso tendrá su número en Evento (más explicación en clse Evento)
					Controlador.getInstancia().accion(Evento.CREAR_LOTE, tl);
					dispose();
				}catch(NumberFormatException ex){
					//Si ha metido letras dond iban números se le informa
					setVisible(true);//Con esto volvemos a hacer visible la vista para que pueda volver a meter los datos
					JOptionPane.showMessageDialog(panel, "Introduzca valores válidos");//Mensajito en la pantalla
				}
			}
		});
		//Si le da a cancelar deshacemos la vista
		cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		//Estos tres hay que ponerlos para que se vea y se pueda cerrar la vista
		pack();
		this.setSize(new Dimension(700, 200));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
	}
	
	//Cuando lo llaman hace visible la vista
	@Override
	public void actualizar(Object data) {
		this.setVisible(true);		
	}
}