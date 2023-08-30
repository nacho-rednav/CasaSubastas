/**
 * 
 */
package Vista;

public abstract class FactoriaVistas {
	
	private static FactoriaVistas instance;
	
	public static FactoriaVistas getInstance(){
		if(instance == null){
			instance = new FactoriaVistasImp();
		}
		return instance;
	}
	
	public abstract IGUI createIGUIMenu();

	public abstract IGUI createIGUIBajaLote();
	public abstract IGUI createIGUICrearLote();
	public abstract IGUI createIGUI_ID_ListarLote_Subasta();
	public abstract IGUI createIGUIListarLote_Subasta();
	public abstract IGUI createIGUI_ID_ListarLote_Almacen();
	public abstract IGUI createIGUIListarLote_Almacen();
	public abstract IGUI createIGUI_ID_ListarLote_Tipo();
	public abstract IGUI createIGUIListarLote_Tipo();
	public abstract IGUI createIGUI_ID_ModificarLote();
	public abstract IGUI createIGUIModificarLote();
	public abstract IGUI createIGUIMostrarLote();
	public abstract IGUI createIGUIComprarLote();
	
	public abstract IGUI createIGUICrearSubasta();
	public abstract IGUI createIGUIEliminarSubasta();
	public abstract IGUI createIGUIListarSubastas();
	public abstract IGUI createIGUI_ID_ModificarSubasta();
	public abstract IGUI createIGUIModificarSubasta();
	public abstract IGUI createIGUIMostrarSubasta();
	
	public abstract IGUI createIGUICrearVinculacion();
	public abstract IGUI createIGUIEliminarVinculacion();
	public abstract IGUI createIGUIListarVinculaciones();
	public abstract IGUI createIGUI_ID_ListarVinculacionesAlmacen();
	public abstract IGUI createIGUI_ID_ListarVinculacionesEmpleado();
	
	public abstract IGUI createIGUICrearEspecialidad();
	public abstract IGUI createIGUIBajaEspecialidad();
	public abstract IGUI createIGUI_ID_ModificarEspecialidad();
	public abstract IGUI createIGUIModificarEspecialidad();
	public abstract IGUI createIGUIMostrarEspecialidad();
	public abstract IGUI createIGUI_ID_listarPorEmpleado();
	public abstract IGUI createIGUIListarPorEmpleado();
	public abstract IGUI createIGUI_ID_listarPorTipo();
	public abstract IGUI createIGUIListarPorTipo();

	
	public abstract IGUI createIGUIAltaCliente();
	public abstract IGUI createIGUIBajaCliente();
	public abstract IGUI createIGUIModificarCliente();
	public abstract IGUI createIGUIMostrarCliente();
	public abstract IGUI createIGUIListarCliente();
	public abstract IGUI createIGUI_ID_ModificarCliente();
	
	public abstract IGUI createIGUIAltaTipoProducto();
	public abstract IGUI createIGUIBajaTipoProducto();
	public abstract IGUI createIGUIListarTiposProducto();
	public abstract IGUI createIGUIModificarTipoProducto();
	public abstract IGUI createIGUIMostrarTipoProducto();
	public abstract IGUI createIGUI_ID_ModificarTipoProducto();

	public abstract IGUI createIGUIAltaEmpleado(); 
	public abstract IGUI createIGUIAltaEmpleadoCompleta();
	public abstract IGUI createIGUIAltaEmpleadoPartida(); 
	public abstract IGUI createIGUIBajaEmpleado(); 
	public abstract IGUI createIGUIMostrarEmpleado(); 
	public abstract IGUI createIGUIModificarEmpleadoCID(); 
	public abstract IGUI createIGUIModificarEmpleadoCompleta();
	public abstract IGUI createIGUIModificarEmpleadoPartida();
	public abstract IGUI createIGUIListarEmpleado();

	public abstract IGUI createIGUICrearAlmacen();
	public abstract IGUI createIGUIEliminarAlmacen();
	public abstract IGUI createIGUIMostrarAlmacen();
	public abstract IGUI createIGUIModificarAlmacen();
	public abstract IGUI createIGUI_ID_ModificarAlmacen();
	public abstract IGUI createIGUIListarAlmacen();



}