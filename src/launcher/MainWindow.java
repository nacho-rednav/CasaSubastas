package launcher;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Vista.Evento;
import Vista.IGUI;
import Vista.Controlador.Controlador;

public class MainWindow extends JFrame implements IGUI{
		
	public MainWindow(){
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		setTitle("Elige la opción que quieras realizar");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
	    JMenu menuAlmacen =new JMenu("Almacén");
        menuBar.add(menuAlmacen);
        JMenu menuEmpleado =new JMenu("Empleados");
        menuBar.add(menuEmpleado);
        JMenu menuLote =new JMenu("Lotes");
        menuBar.add(menuLote);
        JMenu menuClientes =new JMenu("Clientes");
        menuBar.add(menuClientes);
        JMenu menuSubasta =new JMenu("Subastas");
        menuBar.add(menuSubasta);
        JMenu menuTipoProducto =new JMenu("Tipo Producto");
        menuBar.add(menuTipoProducto);
        JMenu menuEspecialidad =new JMenu("Especialidades");
        menuBar.add(menuEspecialidad);
        JMenu menuVincs =new JMenu("Vinculaciones Emp-Alm");
        menuBar.add(menuVincs);
        
        JMenuItem crearLote = new JMenuItem("Crear lote");
        menuLote.add(crearLote);
        crearLote.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_CREAR_LOTE, null);

			}
		});
        
        JMenuItem eliminarLote = new JMenuItem("Baja lote");
        menuLote.add(eliminarLote);
        eliminarLote.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_BAJA_LOTE, null);

			}
		});
        
        
        JMenuItem mostrarLote = new JMenuItem("Mostrar lote");
        menuLote.add(mostrarLote);
        mostrarLote.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_MOSTRAR_LOTE, null);
				
			}
		});
        
        JMenuItem modificarLote = new JMenuItem("Modificar lote");
        menuLote.add(modificarLote);
        modificarLote.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_MODIFICAR_LOTE, null);

			}
		});
        
        
        JMenuItem listarLotesAl = new JMenuItem("Listar lotes por almacén");
        menuLote.add(listarLotesAl);
        listarLotesAl.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_LISTAR_LOTES_ALMACEN, null);
			}
		});
        
        
        JMenuItem listarLotesSu = new JMenuItem("Listar lotes por subasta");
        menuLote.add(listarLotesSu);
        listarLotesSu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_LISTAR_LOTES_SUBASTA, null);
			}
		});
        
        JMenuItem listarLotesTi = new JMenuItem("Listar lotes por tipo producto");
        menuLote.add(listarLotesTi);
        listarLotesTi.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_LISTAR_LOTES_TIPO, null);
			}
		});
        
        
        JMenuItem comprarLote = new JMenuItem("Comprar lote");
        menuLote.add(comprarLote);
        comprarLote.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_COMPRAR_LOTE, null);

			}
		});
        
        
        JMenuItem crearSubasta = new JMenuItem("Crear subasta");
        menuSubasta.add(crearSubasta);
        crearSubasta.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_CREAR_SUBASTA, null);

			}
		});
        
        JMenuItem eliminarSubasta = new JMenuItem("Baja subasta");
        menuSubasta.add(eliminarSubasta);
        eliminarSubasta.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_ELIMINAR_SUBASTA, null);

			}
		});
        
        JMenuItem mostrarSubasta = new JMenuItem("Mostrar subasta");
        menuSubasta.add(mostrarSubasta);
        mostrarSubasta.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_MOSTRAR_SUBASTA, null);
				
			}
		});
        
        JMenuItem modificarSubasta = new JMenuItem("Modificar subasta");
        menuSubasta.add(modificarSubasta);
        modificarSubasta.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_MODIFICAR_SUBASTA, null);

			}
		});
        
        JMenuItem listarSubastas = new JMenuItem("Listar subastas");
        menuSubasta.add(listarSubastas);
        listarSubastas.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.LISTAR_SUBASTAS, null);
			}
		});
        
        JMenuItem crearEmpleado = new JMenuItem("Crear empleado");
        menuEmpleado.add(crearEmpleado);
        crearEmpleado.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_ALTA_EMPLEADO, null);
			}
		});
        
        
        JMenuItem bajaEmpleado = new JMenuItem("Baja empleado");
        menuEmpleado.add(bajaEmpleado);
        bajaEmpleado.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_BAJA_EMPLEADO, null);
			}
		});
        
        JMenuItem listarEmpelado = new JMenuItem("Listar empleado");
        menuEmpleado.add(listarEmpelado);
        listarEmpelado.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.LISTAR_EMPLEADO, null);
			}
		});
        
        JMenuItem modificarEmpleado = new JMenuItem("Modificar empleado");
        menuEmpleado.add(modificarEmpleado);
        modificarEmpleado.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_MODIFICAR_EMPLEADO, null);
			}
		});
        
        JMenuItem mostrarEmpelado = new JMenuItem("Mostar empleado");
        menuEmpleado.add(mostrarEmpelado);
        mostrarEmpelado.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_MOSTRAR_EMPLEADO, null);
			}
		});
        
        JMenuItem crearAlmacen = new JMenuItem("Crear almacen");
        menuAlmacen.add(crearAlmacen);
        crearAlmacen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstancia().accion(Evento.INIT_CREAR_ALMACEN, null);
			}
		});
        
        JMenuItem eliminarAlmacen = new JMenuItem("Eliminar almacen");
        menuAlmacen.add(eliminarAlmacen);
        eliminarAlmacen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstancia().accion(Evento.INIT_ELIMINAR_ALMACEN, null);
			}
		});
        
        JMenuItem listarAlmacen = new JMenuItem("Listar almacen");
        menuAlmacen.add(listarAlmacen);
        listarAlmacen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstancia().accion(Evento.LISTAR_ALMACEN, null);
			}
		});
        
        JMenuItem modificarAlmacen = new JMenuItem("Modificar almacen");
        menuAlmacen.add(modificarAlmacen);
        modificarAlmacen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstancia().accion(Evento.INIT_MODIFICAR_ALMACEN, null);
			}
		});
        
        JMenuItem mostrarAlmacen = new JMenuItem("Mostrar almacen");
        menuAlmacen.add(mostrarAlmacen);
        mostrarAlmacen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstancia().accion(Evento.INIT_MOSTRAR_ALMACEN, null);
			}
		});
        
        JMenuItem altaTipo = new JMenuItem("Crear Tipo de producto");
        menuTipoProducto.add(altaTipo);
        altaTipo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstancia().accion(Evento.INIT_ALTA_TIPO, null);
			}
		});
        
        JMenuItem bajaTipo = new JMenuItem("Baja Tipo de producto");
        menuTipoProducto.add(bajaTipo);
        bajaTipo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstancia().accion(Evento.INIT_BAJA_TIPO, null);
			}
		});
        
        JMenuItem listarTipos = new JMenuItem("Listar Tipo de producto");
        menuTipoProducto.add(listarTipos);
        listarTipos.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstancia().accion(Evento.LISTAR_TIPOS, null);
			}
		});
        
        JMenuItem modTipo = new JMenuItem("Modificar Tipo de producto");
        menuTipoProducto.add(modTipo);
        modTipo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstancia().accion(Evento.INIT_MODIFICAR_TIPO, null);
			}
		});
        
        JMenuItem mostrarTipo = new JMenuItem("Mostrar Tipo de producto");
        menuTipoProducto.add(mostrarTipo);
        mostrarTipo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstancia().accion(Evento.INIT_MOSTRAR_TIPO, null);
			}
		});
        
        JMenuItem altaCliente = new JMenuItem("Alta cliente");
        menuClientes.add(altaCliente);
        altaCliente.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_ALTA_CLIENTE, null);

			}
		});
        
        JMenuItem bajaCliente = new JMenuItem("Baja cliente");
        menuClientes.add(bajaCliente);
        bajaCliente.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_BAJA_CLIENTE, null);

			}
		});
        
        JMenuItem listarCliente = new JMenuItem("Listar clientes");
        menuClientes.add(listarCliente);
        listarCliente.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.LISTAR_CLIENTE, null);

			}
		});
        
        JMenuItem modifCliente = new JMenuItem("Modificar cliente");
        menuClientes.add(modifCliente);
        modifCliente.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_MODIFICAR_CLIENTE, null);

			}
		});
        
        JMenuItem mostrarCliente = new JMenuItem("Mostrar cliente");
        menuClientes.add(mostrarCliente);
        mostrarCliente.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_MOSTRAR_CLIENTE, null);

			}
		});
        
        JMenuItem crearEspecialidad = new JMenuItem("Crear especialidad");
        menuEspecialidad.add(crearEspecialidad);
        crearEspecialidad.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_CREAR_ESPECIALIDAD, null);

			}
		});
        
        JMenuItem bajaEspecialidad = new JMenuItem("Baja especialidad");
        menuEspecialidad.add(bajaEspecialidad);
        bajaEspecialidad.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_BAJA_ESPECIALIDAD, null);

			}
		});
        
        JMenuItem listEmpEspecialidad = new JMenuItem("Listar por empleado");
        menuEspecialidad.add(listEmpEspecialidad);
        listEmpEspecialidad.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_LISTAR_ESPECIALIDAD_EMPLEADO, null);

			}
		});
        
        JMenuItem listTipoEspecialidad = new JMenuItem("Listar por tipo de producto");
        menuEspecialidad.add(listTipoEspecialidad);
        listTipoEspecialidad.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_LISTAR_ESPECIALIDAD_TIPO, null);

			}
		});
        
        JMenuItem modificarEspecialidad = new JMenuItem("Modificar especialidad");
        menuEspecialidad.add(modificarEspecialidad);
        modificarEspecialidad.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_MODIFICAR_ESPECIALIDAD, null);

			}
		});
        
        JMenuItem mostrarEspecialidad = new JMenuItem("Mostrar especialidad");
        menuEspecialidad.add(mostrarEspecialidad);
        mostrarEspecialidad.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_MOSTRAR_ESPECIALIDAD, null);

			}
		});
        
        JMenuItem crearVinculacion = new JMenuItem("Crear vinculacion");
        menuVincs.add(crearVinculacion);
        crearVinculacion.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_CREAR_VINCULACION, null);

			}
		});
        
        JMenuItem eliminarVinculacion = new JMenuItem("Eliminar vinculacion");
        menuVincs.add(eliminarVinculacion);
        eliminarVinculacion.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_ELIMINAR_VINCULACION, null);

			}
		});
        
        JMenuItem listVinculacion = new JMenuItem("Listar vinculaciones");
        menuVincs.add(listVinculacion);
        listVinculacion.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.LISTAR_VINCULACIONES, null);

			}
		});
        
        JMenuItem listVinculacionEmp = new JMenuItem("Listar vinculaciones por empleado");
        menuVincs.add(listVinculacionEmp);
        listVinculacionEmp.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_LISTAR_VINCULACIONES_EMPLEADO, null);

			}
		});
        
        JMenuItem listVinculacionAlm = new JMenuItem("Listar vinculaciones por almacén");
        menuVincs.add(listVinculacionAlm);
        listVinculacionAlm.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controlador.getInstancia().accion(Evento.INIT_LISTAR_VINCULACIONES_ALMACEN, null);

			}
		});
        
        
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	@Override
	public void actualizar(Object data) {
        setVisible(true);
		
	}
}
