package Vista.VinculacionesEmpAlm.listar;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.VinculacionesEmpAlm.TVinculacion;
import Vista.IGUI;


public class IGUIListarVinculaciones extends JFrame implements IGUI{
	
	JPanel main;
	
	public IGUIListarVinculaciones(){
		main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		this.setContentPane(main);
		this.setTitle("Listar Vinculaciones");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actualizar(Object data) {
		ArrayList<TVinculacion> vincs = (ArrayList<TVinculacion>) data;
		
		if(vincs.size() == 0){
			JLabel lb = new JLabel("No hay vinculaciones empleado-almacen");
			main.add(lb);
		}
		else{
			for(int i = 0; i < vincs.size(); i++){
				JPanel vinc = new JPanel();
				JTextField txt = new JTextField();
				txt.setText(vincs.get(i).toString());
				txt.setEditable(false);
				vinc.add(txt);
				main.add(vinc);
			}
		}
		pack();
		setVisible(true);	
	}
}
