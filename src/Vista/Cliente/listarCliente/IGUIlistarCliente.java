/**
 * 
 */
package Vista.Cliente.listarCliente;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Cliente.TCliente;
import Vista.IGUI;


public class IGUIlistarCliente extends JFrame implements IGUI{
	
	JPanel main;
	
	public IGUIlistarCliente(){
		main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		this.setContentPane(main);
		this.setTitle("Listar Clientes");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actualizar(Object data) {
		ArrayList<TCliente> clientes = (ArrayList<TCliente>) data;
		
		if(clientes.size() == 0){
			JLabel lb = new JLabel("No hay clientes");
			main.add(lb);
		}
		else{
			for(int i = 0; i < clientes.size(); i++){
				JPanel cli = new JPanel();
				JTextField txt = new JTextField();
				txt.setText(clientes.get(i).toString());
				txt.setEditable(false);
				cli.add(txt);
				main.add(cli);
			}
		}
		pack();
		setVisible(true);
		
	}
}