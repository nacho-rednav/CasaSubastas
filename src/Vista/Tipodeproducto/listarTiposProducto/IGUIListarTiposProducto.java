
package Vista.Tipodeproducto.listarTiposProducto;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Tipodeproducto.TTipo;
import Vista.IGUI;

public class IGUIListarTiposProducto extends JFrame implements IGUI{
	
	JPanel main;
	
	public IGUIListarTiposProducto(){
		main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		this.setContentPane(main);
		this.setTitle("Listar Tipos de producto");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actualizar(Object data) {
		ArrayList<TTipo> tipos = (ArrayList<TTipo>) data;
		
		if(tipos.size() == 0){
			JLabel lb = new JLabel("No hay tipos de producto dados de alta");
			main.add(lb);
		}
		else{
			for(int i = 0; i < tipos.size(); i++){
				JPanel tipo = new JPanel();
				JTextField txt = new JTextField();
				txt.setText(tipos.get(i).toString());
				txt.setEditable(false);
				tipo.add(txt);
				main.add(tipo);
			}
		}
		pack();
		setVisible(true);		
	}
}