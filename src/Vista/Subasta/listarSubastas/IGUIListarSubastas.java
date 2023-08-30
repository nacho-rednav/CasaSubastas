/**
 * 
 */
package Vista.Subasta.listarSubastas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import Negocio.Subasta.TSubasta;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class IGUIListarSubastas extends JFrame implements IGUI{

	JPanel panel;
	
	public IGUIListarSubastas() {
		this.setLayout(new BorderLayout());
		this.setTitle("Listar Subastas");
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actualizar(Object data) {
		
		ArrayList<TSubasta> list = (ArrayList<TSubasta>) data;
		if(list.size() == 0){
			JLabel lb = new JLabel("No hay ninguna subasta");
			panel.add(lb);
		}
		else{
			for(int i = 0; i < list.size(); i++){
				JPanel subasta = new JPanel();
				JTextField txt = new JTextField();
				txt.setText(list.get(i).toString());
				txt.setEditable(false);
				subasta.add(txt);
				panel.add(subasta);
			}
		}
		pack();
		setVisible(true);
	}
}