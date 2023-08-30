/**
 * 
 */
package Vista;

import Vista.Almacen.crearAlmacen.IGUICrearAlmacen;
import Vista.Almacen.eliminarAlmacen.IGUIeliminarAlmacen;
import Vista.Almacen.listarAlmacenes.IGUIListarAlmacenes;
import Vista.Almacen.modificarAlmacen.IGUI_ID_ModificarAlmacen;
import Vista.Almacen.modificarAlmacen.IGUImodificarAlmacen;
import Vista.Almacen.mostrarAlmacen.IGUImostrarAlmacen;
import Vista.Cliente.altaCliente.IGUIaltaCliente;
import Vista.Cliente.bajaCliente.IGUIbajaCliente;
import Vista.Cliente.listarCliente.IGUIlistarCliente;
import Vista.Cliente.modificarCliente.IGUI_ID_ModificarCliente;
import Vista.Cliente.modificarCliente.IGUImodificarCliente;
import Vista.Cliente.mostrarCliente.IGUImostrarCliente;
import Vista.Empleado.altaEmpleado.IGUIEmpleado;
import Vista.Empleado.altaEmpleado.IGUIEmpleadoCompleta;
import Vista.Empleado.altaEmpleado.IGUIEmpleadoPartida;
import Vista.Empleado.bajaEmpleado.IGUIBajaEmpleado;
import Vista.Empleado.listarEmpleado.IGUIListarEmpleado;
import Vista.Empleado.modificarEmpleado.IGUIModificarEmpleadoCompleta;
import Vista.Empleado.modificarEmpleado.IGUIModificarEmpleadoPartida;
import Vista.Empleado.modificarEmpleado.IGUI_ID_ModificarEmpleado;
import Vista.Empleado.mostrarEmpleado.IGUIMostrarEmpleado;
import Vista.Especialidad.bajaEspecialidad.IGUIBajaEspecialidad;
import Vista.Especialidad.crearEspecialidad.IGUICrearEspecialidad;
import Vista.Especialidad.listarPorEmpleado.IGUIListarPorEmpleado;
import Vista.Especialidad.listarPorEmpleado.IGUI_ID_listarPorEmpleado;
import Vista.Especialidad.listarPorTipo.IGUIListarPorTipo;
import Vista.Especialidad.listarPorTipo.IGUI_ID_listarPorTipo;
import Vista.Especialidad.modificarEspecialidad.IGUIModificarEspecialidad;
import Vista.Especialidad.modificarEspecialidad.IGUI_ID_ModificarEspecialidad;
import Vista.Especialidad.mostrarEspecialidad.IGUIMostrarEspecialidad;
import Vista.Lote.bajaLote.IGUIBajaLote;
import Vista.Lote.comprarLote.IGUIComprarLote;
import Vista.Lote.crearLote.IGUICrearLote;
import Vista.Lote.listarLote_almacen.IGUIListarLote_Almacen;
import Vista.Lote.listarLote_almacen.IGUI_ID_ListarLote_Almacen;
import Vista.Lote.listarLote_subasta.IGUIListarLote_Subasta;
import Vista.Lote.listarLote_subasta.IGUI_ID_ListarLote_Subasta;
import Vista.Lote.listarLote_tipo.IGUIListarLote_Tipo;
import Vista.Lote.listarLote_tipo.IGUI_ID_ListarLote_Tipo;
import Vista.Lote.modificarLote.IGUIModificarLote;
import Vista.Lote.modificarLote.IGUI_ID_ModificarLote;
import Vista.Lote.mostrarLote.IGUIMostrarLote;
import Vista.Subasta.crearSubasta.IGUICrearSubasta;
import Vista.Subasta.eliminarSubasta.IGUIEliminarSubasta;
import Vista.Subasta.listarSubastas.IGUIListarSubastas;
import Vista.Subasta.modificarSubasta.IGUIModificarSubasta;
import Vista.Subasta.modificarSubasta.IGUI_ID_ModificarSubasta;
import Vista.Subasta.mostrarSubasta.IGUIMostrarSubasta;
import Vista.Tipodeproducto.altaTipoProducto.IGUIAltaTipoProducto;
import Vista.Tipodeproducto.bajaTipoProducto.IGUIBajaTipoProducto;
import Vista.Tipodeproducto.listarTiposProducto.IGUIListarTiposProducto;
import Vista.Tipodeproducto.modificarTipoProducto.IGUIModificarTipoProducto;
import Vista.Tipodeproducto.modificarTipoProducto.IGUI_ID_ModificarTipo;
import Vista.Tipodeproducto.mostrarTipoProducto.IGUIMostrarTipoProducto;
import Vista.VinculacionesEmpAlm.crearVinculacion.IGUICrearVinculacion;
import Vista.VinculacionesEmpAlm.eliminarVinculacion.IGUIEliminarVinculacion;
import Vista.VinculacionesEmpAlm.listar.IGUIListarVinculaciones;
import Vista.VinculacionesEmpAlm.listarPorAlmacen.IGUI_ID_ListarVinculacionesAlmacen;
import Vista.VinculacionesEmpAlm.listarPorEmpleado.IGUI_ID_ListarVinculacionesEmpleado;
import launcher.MainWindow;

public class FactoriaVistasImp extends FactoriaVistas {
	
	public IGUI createIGUIMenu() {
		return new MainWindow();
	}
	
	//Lote
	@Override
	public IGUI createIGUIBajaLote() {
		return new IGUIBajaLote();
	}

	@Override
	public IGUI createIGUICrearLote() {
		return new IGUICrearLote();
	}
	
	@Override
	public IGUI createIGUIComprarLote() {
		return new IGUIComprarLote();
	}

	@Override
	public IGUI createIGUI_ID_ListarLote_Subasta() {
		return new IGUI_ID_ListarLote_Subasta();
	}

	@Override
	public IGUI createIGUIListarLote_Subasta() {
		return new IGUIListarLote_Subasta();
	}

	@Override
	public IGUI createIGUI_ID_ListarLote_Almacen() {
		return new IGUI_ID_ListarLote_Almacen();
	}
	
	@Override
	public IGUI createIGUIListarLote_Almacen() {
		return new IGUIListarLote_Almacen();
	}
	
	@Override
	public IGUI createIGUI_ID_ListarLote_Tipo() {
		return new IGUI_ID_ListarLote_Tipo();
	}
	
	@Override
	public IGUI createIGUIListarLote_Tipo() {
		return new IGUIListarLote_Tipo();
	}
	
	@Override
	public IGUI createIGUI_ID_ModificarLote() {
		return new IGUI_ID_ModificarLote();
	}
	
	@Override
	public IGUI createIGUIModificarLote() {
		return new IGUIModificarLote();
	}
	
	@Override
	public IGUI createIGUIMostrarLote() {
		return new IGUIMostrarLote();
	}
	//Fin vistas Lote
	
	//Subasta
	@Override
	public IGUI createIGUICrearSubasta() {
		return new IGUICrearSubasta();
	}

	@Override
	public IGUI createIGUIEliminarSubasta() {
		return new IGUIEliminarSubasta();
	}

	@Override
	public IGUI createIGUIListarSubastas() {
		return new IGUIListarSubastas();
	}

	@Override
	public IGUI createIGUIModificarSubasta() {
		return new IGUIModificarSubasta();
	}
	
	@Override
	public IGUI createIGUIMostrarSubasta() {
		return new IGUIMostrarSubasta();
	}

	@Override
	public IGUI createIGUI_ID_ModificarSubasta() {
		return new IGUI_ID_ModificarSubasta();
	}
	//Fin vistas subasta
	
	//Especialidad
	@Override
	public IGUI createIGUICrearEspecialidad() {
		return new IGUICrearEspecialidad();
	}
	
	@Override
	public IGUI createIGUIBajaEspecialidad() {
		return new IGUIBajaEspecialidad();
	}
	
	@Override
	public IGUI createIGUI_ID_ModificarEspecialidad() {
		return new IGUI_ID_ModificarEspecialidad();
	}
	
	@Override
	public IGUI createIGUIModificarEspecialidad() {
		return new IGUIModificarEspecialidad();
	}
	
	@Override
	public IGUI createIGUIMostrarEspecialidad() {
		return new IGUIMostrarEspecialidad();
	}
	
	@Override
	public IGUI createIGUI_ID_listarPorEmpleado() {
		return new IGUI_ID_listarPorEmpleado();
	}
	
	@Override
	public IGUI createIGUIListarPorEmpleado() {
		return new IGUIListarPorEmpleado();
	}
	
	@Override
	public IGUI createIGUI_ID_listarPorTipo() {
		return new IGUI_ID_listarPorTipo();
	}
	
	@Override
	public IGUI createIGUIListarPorTipo() {
		return new IGUIListarPorTipo();
	}
	//Fin vistas especialidad
	
	//Empleado
	@Override
	public IGUI createIGUIAltaEmpleado() {
		return new IGUIEmpleado();
	}

	@Override
	public IGUI createIGUIAltaEmpleadoCompleta() {
		return new IGUIEmpleadoCompleta();
	}

	@Override
	public IGUI createIGUIAltaEmpleadoPartida() {
		return new IGUIEmpleadoPartida();
	}

	@Override
	public IGUI createIGUIBajaEmpleado() {
		return new IGUIBajaEmpleado();
	}

	@Override
	public IGUI createIGUIMostrarEmpleado() {
		return new IGUIMostrarEmpleado();
	}

	@Override
	public IGUI createIGUIModificarEmpleadoCID() {
		return new IGUI_ID_ModificarEmpleado();
	}
	
	@Override
	public IGUI createIGUIModificarEmpleadoCompleta() {
		return new IGUIModificarEmpleadoCompleta();
	}
	
	public IGUI createIGUIListarEmpleado() {
		return new IGUIListarEmpleado();
	}
	
	@Override
	public IGUI createIGUIModificarEmpleadoPartida() {
		return new IGUIModificarEmpleadoPartida();
	}
	//Fin vistas Empleado
	
	//Tipo de producto
	@Override
	public IGUI createIGUIAltaTipoProducto() {
		return new IGUIAltaTipoProducto();
	}

	@Override
	public IGUI createIGUIBajaTipoProducto() {
		return new IGUIBajaTipoProducto();
	}

	@Override
	public IGUI createIGUIListarTiposProducto() {
		return new IGUIListarTiposProducto();
	}

	@Override
	public IGUI createIGUIModificarTipoProducto() {
		return new IGUIModificarTipoProducto();
	}
	
	@Override
	public IGUI createIGUI_ID_ModificarTipoProducto() {
		return new IGUI_ID_ModificarTipo();
	}

	@Override
	public IGUI createIGUIMostrarTipoProducto() {
		return new IGUIMostrarTipoProducto();
	}
	//fin vistas tipo producto
	
	//Vinculaciones
	@Override
	public IGUI createIGUICrearVinculacion() {
		return new IGUICrearVinculacion();
	}
	
	@Override
	public IGUI createIGUIEliminarVinculacion() {
		return new IGUIEliminarVinculacion();
	}
	
	@Override
	public IGUI createIGUIListarVinculaciones() {
		return new IGUIListarVinculaciones();
	}
	
	@Override
	public IGUI createIGUI_ID_ListarVinculacionesAlmacen() {
		return new IGUI_ID_ListarVinculacionesAlmacen();
	}
	
	@Override
	public IGUI createIGUI_ID_ListarVinculacionesEmpleado() {
		return new IGUI_ID_ListarVinculacionesEmpleado();
	}
	//Fin vistas vinculaciones
	
	//Cliente
	@Override
	public IGUI createIGUIAltaCliente() {
		return new IGUIaltaCliente();
	}

	@Override
	public IGUI createIGUIBajaCliente() {
		return new IGUIbajaCliente();
	}

	@Override
	public IGUI createIGUIModificarCliente() {
		return new IGUImodificarCliente();
	}
	
	public IGUI createIGUI_ID_ModificarCliente() {
		return new IGUI_ID_ModificarCliente();
	}

	@Override
	public IGUI createIGUIMostrarCliente() {
		return new IGUImostrarCliente();
	}

	@Override
	public IGUI createIGUIListarCliente() {
		return new IGUIlistarCliente();
	}
	//Fin vistas cliente
	
	//Almacen
	public IGUI createIGUICrearAlmacen() {
		return new IGUICrearAlmacen();
	}
	
	public IGUI createIGUIListarAlmacen() {
		return new IGUIListarAlmacenes();
	}
	
	public IGUI createIGUIEliminarAlmacen() {
		return new IGUIeliminarAlmacen();
	}
	
	public IGUI createIGUIMostrarAlmacen() {
		return new IGUImostrarAlmacen();
	}
	
	public IGUI createIGUIModificarAlmacen() {
		return new IGUImodificarAlmacen();
	}
	
	public IGUI createIGUI_ID_ModificarAlmacen() {
		return new IGUI_ID_ModificarAlmacen();
	}
	//Fin vistas almacen
	
}