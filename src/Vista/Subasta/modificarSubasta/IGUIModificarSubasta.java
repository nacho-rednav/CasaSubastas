package Vista.Subasta.modificarSubasta;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Subasta.TSubasta;
import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;

public class IGUIModificarSubasta extends JFrame implements IGUI{

	JPanel panelModi;
	JTextField id, activo, titulo, descripcion;
	
	public IGUIModificarSubasta(){

		this.setTitle("Modificar Subasta");
		panelModi = new JPanel(new BorderLayout());
		this.setContentPane(panelModi);
		this.setSize(800, 250);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		id = new JTextField();
		titulo = new JTextField();
		activo = new JTextField();
		descripcion = new JTextField();
	}

	@Override
	public void actualizar(Object data) {
		TSubasta ts = (TSubasta) data;
		
		JPanel main = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 5));
		JLabel lid = new JLabel("ID:");
		p.add(lid);
		JTextField tid = new JTextField(ts.getId() + "\n", 20);
		tid.setEnabled(false);
		p.add(tid);
		main.add(p);
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 48, 5));
		JLabel lActivo = new JLabel("Activo:");
		p1.add(lActivo);
		JTextField tActivo = new JTextField(ts.getActivo()+ "\n", 20);
		tActivo.setEnabled(false);
		p1.add(tActivo);
		main.add(p1);
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 5));
		JLabel lTitulo = new JLabel("Título:");
		p2.add(lTitulo);
		JTextField tTitulo = new JTextField(ts.getTitulo()+ "\n", 20);
		tTitulo.setEnabled(false);
		p2.add(tTitulo);
		main.add(p2);
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
		JLabel lDescri = new JLabel("Descripción: ");
		p3.add(lDescri);
		JTextField tDescripcion = new JTextField(ts.getDescripcion()+ "\n", 50);
		p3.add(tDescripcion);
		main.add(p3);
		panelModi.add(main);
		
		JPanel pButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
		JButton accept = new JButton("Aceptar");
		pButtons.add(accept);
		JButton cancel = new JButton("Cancel");
		pButtons.add(cancel);
		panelModi.add(pButtons, BorderLayout.PAGE_END);
		
		accept.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ts.setTitulo(tTitulo.getText());
				ts.setDescripcion(tDescripcion.getText());
				Controlador.getInstancia().accion(Evento.MODIFICAR_SUBASTA2, ts);
			}
		});

		cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});		
		setVisible(true);
	}
}
