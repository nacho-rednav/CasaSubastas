/**
 * 
 */
package Vista.Empleado.listarEmpleado;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Empleado.TEmpleado;
import Vista.IGUI;


public class IGUIListarEmpleado  extends JFrame implements IGUI{
	
	JPanel panel;

	public IGUIListarEmpleado() {
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		this.setTitle("Listar Empleados");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	@Override
	public void actualizar(Object data) {
		
		ArrayList<TEmpleado> list = (ArrayList<TEmpleado>) data;
		if(list.size() == 0){
			JLabel lb = new JLabel("No hay empleados");
			panel.add(lb);
		}
		else{
			for(int i = 0; i < list.size(); i++){
				JPanel lote = new JPanel();
				JTextField txt = new JTextField();
				txt.setText(list.get(i).toString());
				txt.setEditable(false);
				lote.add(txt);
				panel.add(lote);
			}
		}
		pack();
		setVisible(true);
	}
}