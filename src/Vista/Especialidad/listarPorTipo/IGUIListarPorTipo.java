package Vista.Especialidad.listarPorTipo;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Especialidad.TEspecialidad;
import Vista.IGUI;


public class IGUIListarPorTipo extends JFrame implements IGUI{
	
	JPanel main;
	
	public IGUIListarPorTipo(){
		main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		this.setContentPane(main);
		this.setTitle("Listar Especialidades por Tipo");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actualizar(Object data) {
		ArrayList<TEspecialidad> esps = (ArrayList<TEspecialidad>) data;
		
		if(esps.size() == 0){
			JLabel lb = new JLabel("No hay especialidades con ese tipo de producto");
			main.add(lb);
		}
		else{
			for(int i = 0; i < esps.size(); i++){
				JPanel esp = new JPanel();
				JTextField txt = new JTextField();
				txt.setText(esps.get(i).toString());
				txt.setEditable(false);
				esp.add(txt);
				main.add(esp);
			}
		}
		pack();
		setVisible(true);
		
	}
}
