package Vista.Lote.listarLote_tipo;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Lote.TLote;
import Vista.IGUI;


public class IGUIListarLote_Tipo extends JFrame implements IGUI{
	
	JPanel main;
	
	public IGUIListarLote_Tipo(){
		main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		this.setContentPane(main);
		this.setTitle("Listar Lotes Tipo");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actualizar(Object data) {
		ArrayList<TLote> lotes = (ArrayList<TLote>) data;
		
		if(lotes.size() == 0){
			JLabel lb = new JLabel("No hay lotes con ese tipo de producto");
			main.add(lb);
		}
		else{
			for(int i = 0; i < lotes.size(); i++){
				JPanel lote = new JPanel();
				JTextField txt = new JTextField();
				txt.setText(lotes.get(i).toString());
				txt.setEditable(false);
				lote.add(txt);
				main.add(lote);
			}
		}
		pack();
		setVisible(true);
		
	}
}
