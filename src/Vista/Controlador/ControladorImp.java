/**
 * 
 */
package Vista.Controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Negocio.FactoriaNegocio;
import Negocio.Almacen.TAlmacen;
import Negocio.Cliente.TCliente;
import Negocio.Empleado.TEmpleado;
import Negocio.Empleado.TEmpleadoCompleta;
import Negocio.Empleado.TEmpleadoPartida;
import Negocio.Especialidad.TEspecialidad;
import Negocio.Lote.TLote;
import Negocio.Subasta.TSubasta;
import Negocio.Tipodeproducto.TTipo;
import Negocio.VinculacionesEmpAlm.TVinculacion;
import Vista.Evento;
import Vista.FactoriaVistas;

public class ControladorImp extends Controlador {
			
	
	public void accion(int evento, Object transfer) {
		try{
		switch(evento){
		//Cada caso de uso será un case
		//Todo caso de uso tendrá un init (excepto los listar) que es el evento al que se llamará desde el menú
		//Solo tiene que llamar a la vista desde la factoria y actualizarla
		case Evento.INIT_MENU:{
			FactoriaVistas.getInstance().createIGUIMenu().actualizar(null);
			break;
		}
		case Evento.INIT_CREAR_LOTE:{
			FactoriaVistas.getInstance().createIGUICrearLote().actualizar(null);
			break;
		}
		case Evento.CREAR_LOTE:{
			TLote tl = (TLote)transfer;//Hacemos casting de lo que haya recibido, en un caso de uso de Almacen por ejemplo haría (TAlmacen)transfer
			
			//Accedo a la FactoriaNegocioImp, después accedo a la función que devuelve un SALoteImp y después en ese SA 
			//realizo crear lote, pasándole el transfer
			int res = FactoriaNegocio.getInstancia().createSALote().crearLote(tl);
			//He hecho res = 0 si hay un fallo como datos incorrectos, res > 0 si todo va bien y luego los negativos
			//para otros casos. Aquí, por ejemplo, que ya estuviese dado de alta
			if(res == -1){
				JOptionPane.showMessageDialog(null, "Lote con ese Nombre ya dado de alta");
			}
			else if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Dado de alta lote con ID: "+res);
			}
			break;
		}
		case Evento.INIT_BAJA_LOTE:{
			FactoriaVistas.getInstance().createIGUIBajaLote().actualizar(null);
			break;
		}
		case Evento.BAJA_LOTE:{
			TLote tl = (TLote)transfer;
			int res = FactoriaNegocio.getInstancia().createSALote().bajaLote(tl);
			if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res == -1){
				JOptionPane.showMessageDialog(null, "Lote ya dado de baja");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Dado de baja lote con ID: "+res);
			}
			break;
		}
		case Evento.INIT_LISTAR_LOTES_SUBASTA: {
			FactoriaVistas.getInstance().createIGUI_ID_ListarLote_Subasta().actualizar(null);
			break;
		}
		case Evento.LISTAR_LOTES_SUBASTA: {
			TLote tl = (TLote)transfer;
			
			ArrayList<TLote> lista = FactoriaNegocio.getInstancia().createSALote().listarLote_subasta(tl);
			
			if(lista == null){
				JOptionPane.showMessageDialog(null, "Subasta inexistente o inactiva");
			}
			else{
				FactoriaVistas.getInstance().createIGUIListarLote_Subasta().actualizar(lista);
			}
			break;
		}
		case Evento.INIT_LISTAR_LOTES_ALMACEN:{
			FactoriaVistas.getInstance().createIGUI_ID_ListarLote_Almacen().actualizar(null);
			break;
		}
		case Evento.LISTAR_LOTES_ALMACEN: {
			TLote tl = (TLote)transfer;
			
			ArrayList<TLote> lista = FactoriaNegocio.getInstancia().createSALote().listarLote_almacen(tl);
			
			if(lista == null){
				JOptionPane.showMessageDialog(null, "Almacen inexistente o inactivo");
			}
			else{
				FactoriaVistas.getInstance().createIGUIListarLote_Almacen().actualizar(lista);
			}
			break;
		}
		case Evento.INIT_LISTAR_LOTES_TIPO:{
			FactoriaVistas.getInstance().createIGUI_ID_ListarLote_Tipo().actualizar(null);
			break;
		}
		case Evento.LISTAR_LOTES_TIPO: {
			TLote tl = (TLote)transfer;
			
			ArrayList<TLote> lista = FactoriaNegocio.getInstancia().createSALote().listarLote_tipo(tl);
			
			if(lista == null){
				JOptionPane.showMessageDialog(null, "Tipo de producto inexistente");
			}
			else{
				FactoriaVistas.getInstance().createIGUIListarLote_Tipo().actualizar(lista);
			}
			break;
		}
		case Evento.INIT_MODIFICAR_LOTE:{
			FactoriaVistas.getInstance().createIGUI_ID_ModificarLote().actualizar(null);
			break;
		}
		case Evento.TRAER_MODIFICAR_LOTE:{
			TLote tl = (TLote) transfer;
			
			tl = FactoriaNegocio.getInstancia().createSALote().mostrarLote(tl);
			
			if(tl.getId() == 0){
				JOptionPane.showMessageDialog(null, "Lote inexistente");
			}
			else{
				FactoriaVistas.getInstance().createIGUIModificarLote().actualizar(tl);
			}
			break;
		}
		case Evento.MODIFICAR_LOTE:{
			TLote tl = (TLote) transfer;
			 int res = FactoriaNegocio.getInstancia().createSALote().modificarLote(tl);
			 
			 if(res == 0){
					JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			 }
			 else if(res > 0){
					JOptionPane.showMessageDialog(null, "Modificado lote con Id: " + res);
			 }
			 break;
		}
		case Evento.INIT_MOSTRAR_LOTE:{
			FactoriaVistas.getInstance().createIGUIMostrarLote().actualizar(null);
			break;
		}
		case Evento.MOSTRAR_LOTE:{
			TLote tl = (TLote) transfer;
			tl = FactoriaNegocio.getInstancia().createSALote().mostrarLote(tl);
			if(tl.getId() == 0){
				JOptionPane.showMessageDialog(null, "Lote inexistente");
			}
			else if(tl.getId() > 0){
				JOptionPane.showMessageDialog(null, tl.toString());
			}
			break;
		}
		case Evento.INIT_COMPRAR_LOTE:{
			FactoriaVistas.getInstance().createIGUIComprarLote().actualizar(null);
			break;
		}
		case Evento.COMPRAR_LOTE:{
			TLote tl = (TLote)transfer;
			int res = FactoriaNegocio.getInstancia().createSALote().comprarLote(tl);
			if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res == -1){
				JOptionPane.showMessageDialog(null, "Lote ya comprado");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Comprado lote con ID: "+res);
			}
			break;
		}
		
		
		case Evento.INIT_CREAR_SUBASTA:{
			FactoriaVistas.getInstance().createIGUICrearSubasta().actualizar(null);
			break;
		}
		case Evento.CREAR_SUBASTA:{
			TSubasta ts = (TSubasta)transfer;
			
			ts = FactoriaNegocio.getInstancia().createSASubasta().crearSubasta(ts);
			if(ts.getId() == -1){
				JOptionPane.showMessageDialog(null, "Subasta con ese Titulo ya dado de alta");
			}
			else if(ts.getId() == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(ts.getId() > 0){
				JOptionPane.showMessageDialog(null, "Dada de alta subasta con ID: "+ts.getId().toString());
			}
			break;
		}
		case Evento.INIT_ELIMINAR_SUBASTA:{
			FactoriaVistas.getInstance().createIGUIEliminarSubasta().actualizar(null);
			break;
		}
		case Evento.ELIMINAR_SUBASTA:{
			TSubasta ts = (TSubasta)transfer;
			ts = FactoriaNegocio.getInstancia().createSASubasta().eliminarSubasta(ts);
			if(ts.getId() == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(ts.getId() == -1){
				JOptionPane.showMessageDialog(null, "Subasta ya dada de baja");
			}
			else if(ts.getId() == -2){
				JOptionPane.showMessageDialog(null, "No se pudo dar de baja debido a que la subasta seleccionada contiene lotes asignados");
			}
			else if(ts.getId() > 0){
				JOptionPane.showMessageDialog(null, "Dada de baja subasta con ID: "+ts.getId().toString());
			}
			break;
		}
		case Evento.INIT_MOSTRAR_SUBASTA:{
			FactoriaVistas.getInstance().createIGUIMostrarSubasta().actualizar(null);
			break;
		}
		case Evento.MOSTRAR_SUBASTA:{
			TSubasta ts = (TSubasta)transfer;
			ts = FactoriaNegocio.getInstancia().createSASubasta().mostrarSubasta(ts);
			if(ts.getId() == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(ts.getId() > 0){
				JOptionPane.showMessageDialog(null, ts);
			}
			break;
		}
		case Evento.INIT_MODIFICAR_SUBASTA:{
			FactoriaVistas.getInstance().createIGUI_ID_ModificarSubasta().actualizar(null);
			break;
		}
		case Evento.MODIFICAR_SUBASTA:{
			TSubasta ts = (TSubasta)transfer;
			ts = FactoriaNegocio.getInstancia().createSASubasta().mostrarSubasta(ts);
			if(ts.getId() == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else{
				FactoriaVistas.getInstance().createIGUIModificarSubasta().actualizar(ts);
			}
			break;
		}
		case Evento.MODIFICAR_SUBASTA2:{
			TSubasta ts = (TSubasta)transfer;
			ts = FactoriaNegocio.getInstancia().createSASubasta().modificarSubasta(ts);
			if(ts.getId() == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(ts.getId() > 0){
				JOptionPane.showMessageDialog(null, "Modificada correctamente subasta con ID: "+ts.getId().toString());
			}
			break;
		}
		case Evento.LISTAR_SUBASTAS:{
			ArrayList<TSubasta> list = FactoriaNegocio.getInstancia().createSASubasta().listarSubastas();
			if(list == null){
				JOptionPane.showMessageDialog(null, "No hay subastas en estos momentos");
			}
			else {
				FactoriaVistas.getInstance().createIGUIListarSubastas().actualizar(list);
			}
			break;
		}
		
		
		case Evento.INIT_CREAR_ESPECIALIDAD:{
			FactoriaVistas.getInstance().createIGUICrearEspecialidad().actualizar(null);
			break;
		}
		case Evento.CREAR_ESPECIALIDAD:{
			TEspecialidad tes = (TEspecialidad) transfer;
			int res = FactoriaNegocio.getInstancia().createSAEspecialidad().crearEspecialidad(tes);
			if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res == -1){
				JOptionPane.showMessageDialog(null, "Especialidad ya existente");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Creada Especialidad con ID: "+ res);
			}
			break;
		}
		case Evento.INIT_BAJA_ESPECIALIDAD:{
			FactoriaVistas.getInstance().createIGUIBajaEspecialidad().actualizar(null);
			break;
		}
		case Evento.BAJA_ESPECIALIDAD:{
			TEspecialidad tl = (TEspecialidad)transfer;
			int res = FactoriaNegocio.getInstancia().createSAEspecialidad().bajaEspecialidad(tl);
			if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res == -1){
				JOptionPane.showMessageDialog(null, "Especialidad ya dada de baja");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Dada de baja Especialidad con ID: "+ res);
			}
			break;
		}
		case Evento.INIT_MODIFICAR_ESPECIALIDAD:{
			FactoriaVistas.getInstance().createIGUI_ID_ModificarEspecialidad().actualizar(null);
			break;
		}
		case Evento.TRAER_MODIFICAR_ESPECIALIDAD:{
			TEspecialidad tl = (TEspecialidad) transfer;
			
			tl = FactoriaNegocio.getInstancia().createSAEspecialidad().mostrarEspecialidad(tl);
			
			if(tl.getId() == 0){
				JOptionPane.showMessageDialog(null, "Especialidad inexistente");
			}
			else{
				FactoriaVistas.getInstance().createIGUIModificarEspecialidad().actualizar(tl);
			}
			break;
		}
		case Evento.MODIFICAR_ESPECIALIDAD:{
			TEspecialidad tl = (TEspecialidad) transfer;
			int res = FactoriaNegocio.getInstancia().createSAEspecialidad().modificarEspecialidad(tl);
			if(res <= 0){
				JOptionPane.showMessageDialog(null, "Error al modificar");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Modificada especialidad con ID: "+res);
			}
			break;
		}
		case Evento.INIT_MOSTRAR_ESPECIALIDAD:{
			FactoriaVistas.getInstance().createIGUIMostrarEspecialidad().actualizar(null);
			break;
		}
		case Evento.MOSTRAR_ESPECIALIDAD:{
			TEspecialidad te = (TEspecialidad)transfer;
			
			te = FactoriaNegocio.getInstancia().createSAEspecialidad().mostrarEspecialidad(te);
			if(te.getId() == 0){
				JOptionPane.showMessageDialog(null, "Especialidad inexistente");
			}
			else if(te.getId() > 0){
				JOptionPane.showMessageDialog(null, te.toString());
			}
			break;
		}
		case Evento.INIT_LISTAR_ESPECIALIDAD_EMPLEADO:{
			FactoriaVistas.getInstance().createIGUI_ID_listarPorEmpleado().actualizar(null);
			break;
		}
		case Evento.LISTAR_ESPECIALIDAD_EMPLEADO:{
			TEspecialidad te = (TEspecialidad) transfer;
			ArrayList<TEspecialidad> lista = FactoriaNegocio.getInstancia().createSAEspecialidad().listarPorEmpleado(te);
			
			if(lista == null){
				JOptionPane.showMessageDialog(null, "Empleado inexistente");
			}
			else{
				FactoriaVistas.getInstance().createIGUIListarPorEmpleado().actualizar(lista);
			}
			break;
		}
		case Evento.INIT_LISTAR_ESPECIALIDAD_TIPO:{
			FactoriaVistas.getInstance().createIGUI_ID_listarPorTipo().actualizar(null);
			break;
		}
		case Evento.LISTAR_ESPECIALIDAD_TIPO:{
			TEspecialidad te = (TEspecialidad) transfer;
			ArrayList<TEspecialidad> lista = FactoriaNegocio.getInstancia().createSAEspecialidad().listarPorTipo(te);
			
			if(lista == null){
				JOptionPane.showMessageDialog(null, "Tipo de producto inexistente");
			}
			else{
				FactoriaVistas.getInstance().createIGUIListarPorTipo().actualizar(lista);
			}
			break;
		}
		
		
		case Evento.INIT_CREAR_VINCULACION:{
			FactoriaVistas.getInstance().createIGUICrearVinculacion().actualizar(null);
			break;
		}
		case Evento.CREAR_VINCULACION:{
			TVinculacion data = (TVinculacion) transfer;
			TVinculacion tv = FactoriaNegocio.getInstancia().createSAVinculacionesEmpAlm().crearVinculacion(data);
			
			if(tv.getIdAlmacen() == -1){
				JOptionPane.showMessageDialog(null, "Vinculacion ya existente");
			}
			else if(tv.getIdAlmacen() == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(tv.getIdAlmacen() > 0){
				JOptionPane.showMessageDialog(null, "Vinculacion creada entre Almacen-Empleado: " + tv.getIdAlmacen() +"-"+tv.getIdEmpleado());
			}
			break;
		}
		case Evento.INIT_ELIMINAR_VINCULACION:{
			FactoriaVistas.getInstance().createIGUIEliminarVinculacion().actualizar(null);
			break;
		}
		case Evento.ELIMINAR_VINCULACION:{
			TVinculacion data = (TVinculacion) transfer;
			int res = FactoriaNegocio.getInstancia().createSAVinculacionesEmpAlm().eliminarVinculacion(data);
			
			if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Vinculacion eliminada entre Almacen-Empleado: " + data.getIdAlmacen() +"-"+data.getIdEmpleado());
			}
			break;
		}
		case Evento.LISTAR_VINCULACIONES:{
			ArrayList<TVinculacion> lista = FactoriaNegocio.getInstancia().createSAVinculacionesEmpAlm().listar();
			
			if(lista == null){
				JOptionPane.showMessageDialog(null, "No se pudo realizar la operación");
			}
			else{
				FactoriaVistas.getInstance().createIGUIListarVinculaciones().actualizar(lista);
			}
			break;
		}
		case Evento.INIT_LISTAR_VINCULACIONES_ALMACEN:{
			FactoriaVistas.getInstance().createIGUI_ID_ListarVinculacionesAlmacen().actualizar(null);
			break;
		}
		case Evento.LISTAR_VINCULACIONES_ALMACEN:{
			TVinculacion tv = (TVinculacion) transfer;
			ArrayList<TVinculacion> lista = FactoriaNegocio.getInstancia().createSAVinculacionesEmpAlm().listarPorAlmacen(tv);
			
			if(lista == null){
				JOptionPane.showMessageDialog(null, "No se pudo realizar la operación");
			}
			else{
				FactoriaVistas.getInstance().createIGUIListarVinculaciones().actualizar(lista);
			}
			break;
		}
		case Evento.INIT_LISTAR_VINCULACIONES_EMPLEADO:{
			FactoriaVistas.getInstance().createIGUI_ID_ListarVinculacionesEmpleado().actualizar(null);
			break;
		}
		case Evento.LISTAR_VINCULACIONES_EMPLEADO:{
			TVinculacion tv = (TVinculacion) transfer;
			ArrayList<TVinculacion> lista = FactoriaNegocio.getInstancia().createSAVinculacionesEmpAlm().listarPorEmpleado(tv);
			
			if(lista == null){
				JOptionPane.showMessageDialog(null, "No se pudo realizar la operación");
			}
			else{
				FactoriaVistas.getInstance().createIGUIListarVinculaciones().actualizar(lista);
			}
			break;
		}
		
		
		case Evento.INIT_CREAR_ALMACEN:{
			FactoriaVistas.getInstance().createIGUICrearAlmacen().actualizar(null);
			break;
		}
		case Evento.CREAR_ALMACEN: {
			TAlmacen ta = (TAlmacen) transfer;
			int res = FactoriaNegocio.getInstancia().createSAAlmacen().crearAlmacen(ta);
			if(res == -1){
				JOptionPane.showMessageDialog(null, "Almacen ya dado de alta");
			}
			else if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Dado de alta almacen con ID: "+res);
			}
			break;
		}
		case Evento.INIT_ELIMINAR_ALMACEN:{
			FactoriaVistas.getInstance().createIGUIEliminarAlmacen().actualizar(null);
			break;
		}
		case Evento.ELIMINAR_ALMACEN: {
			TAlmacen ta = (TAlmacen) transfer;
			int res = FactoriaNegocio.getInstancia().createSAAlmacen().eliminarAlmacen(ta);
			if(res == -1){
				JOptionPane.showMessageDialog(null, "Almacen ya dado de baja");
			}
			else if(res == -2){
				JOptionPane.showMessageDialog(null, "Almacen asignado a lotes, no puede darse de baja");
			}
			else if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Dado de baja almacen con ID: "+res);
			}
			break;
		}
		case Evento.LISTAR_ALMACEN:{
			ArrayList<TAlmacen> list = FactoriaNegocio.getInstancia().createSAAlmacen().listarAlmacen();
			if(list == null){
				JOptionPane.showMessageDialog(null, "No hay almacenes dados de alta");
			}
			else{
				FactoriaVistas.getInstance().createIGUIListarAlmacen().actualizar(list);
			}
			break;
		}
		case Evento.INIT_MOSTRAR_ALMACEN:{
			FactoriaVistas.getInstance().createIGUIMostrarAlmacen().actualizar(null);
			break;
		}
		case Evento.MOSTRAR_ALMACEN:{
			TAlmacen data = (TAlmacen) transfer;
			TAlmacen res = FactoriaNegocio.getInstancia().createSAAlmacen().mostrarAlmacen(data);
			
			if(res.getID() == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res.getID() > 0){
				JOptionPane.showMessageDialog(null, res.toString());
			}
			break;
		}
		case Evento.INIT_MODIFICAR_ALMACEN: {
			FactoriaVistas.getInstance().createIGUI_ID_ModificarAlmacen().actualizar(null);
			break;
		}
		case Evento.MODIFICAR_ALMACEN_TRAER:{
			TAlmacen data = (TAlmacen) transfer;
			
			TAlmacen res = FactoriaNegocio.getInstancia().createSAAlmacen().mostrarAlmacen(data);
			
			if(res.getID() == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res.getID() > 0){
				FactoriaVistas.getInstance().createIGUIModificarAlmacen().actualizar(res);
			}
			break;
		}
		case Evento.MODIFICAR_ALMACEN: {
			TAlmacen data = (TAlmacen) transfer;
			
			int res = FactoriaNegocio.getInstancia().createSAAlmacen().modificarAlmacen(data);
			if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Modificado almacen con ID: "+res);
			}
			break;
		}

		
		case Evento.INIT_ALTA_CLIENTE:{
			FactoriaVistas.getInstance().createIGUIAltaCliente().actualizar(null);
			break;
		}
		case Evento.ALTA_CLIENTE:{
			TCliente tc = (TCliente)transfer;
			
			int res = FactoriaNegocio.getInstancia().createSACliente().altaCliente(tc);
			
			if(res == -1){
				JOptionPane.showMessageDialog(null, "Cliente con ese DNI ya dado de alta");
			}
			else if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Dado de alta cliente con ID: "+res);
			}
			break;
		}
		case Evento.INIT_BAJA_CLIENTE:{
			FactoriaVistas.getInstance().createIGUIBajaCliente().actualizar(null);
			break;
		}
		case Evento.BAJA_CLIENTE:{
			TCliente tc = (TCliente)transfer;
			
			int res = FactoriaNegocio.getInstancia().createSACliente().bajaCliente(tc);
			
			if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res == -1){
				JOptionPane.showMessageDialog(null, "Cliente ya dado de baja");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Dado de baja cliente con ID: "+res);
			}
			break;
		}	
		case Evento.LISTAR_CLIENTE:{			
			ArrayList<TCliente> lista = FactoriaNegocio.getInstancia().createSACliente().listarCliente();
			
			if(lista == null){
				JOptionPane.showMessageDialog(null, "No hay clientes en la base de datos");
			}
			else{
				FactoriaVistas.getInstance().createIGUIListarCliente().actualizar(lista);
			}
			break;
		}
		case Evento.INIT_MODIFICAR_CLIENTE:{
			FactoriaVistas.getInstance().createIGUI_ID_ModificarCliente().actualizar(null);
			break;
		}
		case Evento.MODIFICAR_CLIENTE_TRAER:{
			TCliente tc = (TCliente) transfer;
			
			TCliente res = FactoriaNegocio.getInstancia().createSACliente().mostrarCliente(tc);
			if(res.getID() == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res.getID() > 0){
				FactoriaVistas.getInstance().createIGUIModificarCliente().actualizar(res);
			}
			break;
		}
		case Evento.MODIFICAR_CLIENTE:{
			TCliente tc = (TCliente) transfer;
			 int res = FactoriaNegocio.getInstancia().createSACliente().modificarCliente(tc);
			 
			 if(res == 0){
					JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			 }
			 else if(res > 0){
					JOptionPane.showMessageDialog(null, "Modificado cliente con ID: " + res);
			 }
			 break;
		}
		case Evento.INIT_MOSTRAR_CLIENTE:{
			FactoriaVistas.getInstance().createIGUIMostrarCliente().actualizar(null);
			break;
		}
		case Evento.MOSTRAR_CLIENTE:{
			TCliente tc = (TCliente) transfer;
			tc = FactoriaNegocio.getInstancia().createSACliente().mostrarCliente(tc);
			if(tc.getID() == 0){
				JOptionPane.showMessageDialog(null, "Cliente inexistente");
			}
			else if(tc.getID() > 0){
				JOptionPane.showMessageDialog(null, tc.toString());
			}
			break;
		}

		
		case Evento.ALTA_TIPO:{
			TTipo tt = (TTipo)transfer;
			int res = FactoriaNegocio.getInstancia().createSATipoProducto().altaTipoProducto(tt);

			if(res == -1){
				JOptionPane.showMessageDialog(null, "Este tipo de producto ya existe");
			}
			else if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Dado de alta tipo de producto con ID: "+res);
			}
			break;
		}
		case Evento.INIT_ALTA_TIPO:{
			FactoriaVistas.getInstance().createIGUIAltaTipoProducto().actualizar(null);;
			break;
		}
		case Evento.BAJA_TIPO:{
			TTipo tt = (TTipo)transfer;
			int res = FactoriaNegocio.getInstancia().createSATipoProducto().bajaTipoProducto(tt);

			if(res == -1){
				JOptionPane.showMessageDialog(null, "Este tipo de producto está en una especialidad o lote");
			}
			else if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Dado de baja tipo de producto con ID: "+res);
			}
			break;
		}
		case Evento.INIT_BAJA_TIPO:{
			FactoriaVistas.getInstance().createIGUIBajaTipoProducto().actualizar(null);
			break;
		}
		case Evento.LISTAR_TIPOS:{
			ArrayList<TTipo> lista = FactoriaNegocio.getInstancia().createSATipoProducto().listarTiposProducto();
			if(lista == null){
				JOptionPane.showMessageDialog(null, "No hay ningun tipo de producto dado de alta");
			}
			else{
				FactoriaVistas.getInstance().createIGUIListarTiposProducto().actualizar(lista);
			}
			break;
		}
		case Evento.MODIFICAR_TIPO:{
			TTipo tt = (TTipo) transfer;
			int res = FactoriaNegocio.getInstancia().createSATipoProducto().modificarTipoProducto(tt);
			 
			if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Modificado tipo de producto con Id: " + res);
			}
			break;
		}
		case Evento.MODIFICAR_TRAER_TIPO:{
			TTipo info = (TTipo) transfer;
			TTipo tt = FactoriaNegocio.getInstancia().createSATipoProducto().mostrarTipoProducto(info);
			
			if(tt.getId() == 0){
				JOptionPane.showMessageDialog(null, "Tipo de producto inexistente");
			}
			else if( tt.getId() > 0){
				FactoriaVistas.getInstance().createIGUIModificarTipoProducto().actualizar(tt);
			}
			break;
		}
		case Evento.INIT_MODIFICAR_TIPO:{
			FactoriaVistas.getInstance().createIGUI_ID_ModificarTipoProducto().actualizar(null);
			break;
		}
		case Evento.MOSTRAR_TIPO:{
			TTipo tt = (TTipo) transfer;
			tt = FactoriaNegocio.getInstancia().createSATipoProducto().mostrarTipoProducto(tt);
			if(tt.getId() == 0){
				JOptionPane.showMessageDialog(null, "Tipo de producto inexistente");
			}
			else if(tt.getId() > 0){
				JOptionPane.showMessageDialog(null, tt.toString());
			}
			break;
		}
		case Evento.INIT_MOSTRAR_TIPO:{
			FactoriaVistas.getInstance().createIGUIMostrarTipoProducto().actualizar(null);
			break;
		}
		
		
		case Evento.INIT_ALTA_EMPLEADO:{
			FactoriaVistas.getInstance().createIGUIAltaEmpleado().actualizar(null);
			break;
		}
		case Evento.INIT_ALTA_EMPLEADO_COMPLETA:{
			FactoriaVistas.getInstance().createIGUIAltaEmpleadoCompleta().actualizar(null);
			break;
		}
		case Evento.ALTA_EMPLEADO_COMPLETA:{
			TEmpleado tc = (TEmpleadoCompleta) transfer;
			int res = FactoriaNegocio.getInstancia().createSAEmpleado().altaEmpleado(tc);
			if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos del empleado erroneos");
			}
			else if(res == -1){
				JOptionPane.showMessageDialog(null, "Estos datos ya corresponden a un empleado");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Dados introducidos del empleado con ID:" + res);
			}
			break;
		}
		case Evento.INIT_ALTA_EMPLEADO_PARTIDA:{
			FactoriaVistas.getInstance().createIGUIAltaEmpleadoPartida().actualizar(null);
			break;
		}
		case Evento.ALTA_EMPLEADO_PARTIDA:{
			TEmpleado tp = (TEmpleadoPartida) transfer;
			int res = FactoriaNegocio.getInstancia().createSAEmpleado().altaEmpleado(tp);
			if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos del empleado erroneos");
			}
			else if(res == -1){
				JOptionPane.showMessageDialog(null, "Estos datos ya corresponden a un empleado");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Dada de alta empleado con ID:" + res);
			}
			break;
		}
		case Evento.INIT_BAJA_EMPLEADO:{
			FactoriaVistas.getInstance().createIGUIBajaEmpleado().actualizar(null);
			break;
		}
		case Evento.BAJA_EMPLEADO:{
			TEmpleado t = (TEmpleado) transfer;
			int res = FactoriaNegocio.getInstancia().createSAEmpleado().bajaEmpleado(t);
			if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos del empleado erroneos");
			}
			else if(res == -1){
				JOptionPane.showMessageDialog(null, "Empleado ya dado de baja");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Dada de baja empleado con ID:" + res);
			}
			break;
		}
		case Evento.INIT_MOSTRAR_EMPLEADO:{
			FactoriaVistas.getInstance().createIGUIMostrarEmpleado().actualizar(null);
			break;
		}
		case Evento.MOSTRAR_EMPLEADO:{
			TEmpleado t = (TEmpleado) transfer;
			t = FactoriaNegocio.getInstancia().createSAEmpleado().mostrarEmpleado(t);
			if(t.getId() == 0){
				JOptionPane.showMessageDialog(null, "Datos del empleado erroneos");
			}
			else if(t.getId() > 0){
				JOptionPane.showMessageDialog(null, t.toString());
			}
			break;
		}
		case Evento.INIT_MODIFICAR_EMPLEADO:{
			FactoriaVistas.getInstance().createIGUIModificarEmpleadoCID().actualizar(null);
			break;
		}
		case Evento.MODIFICAR_EMPLEADO:{
			TEmpleado t = (TEmpleado) transfer;
			TEmpleado res = FactoriaNegocio.getInstancia().createSAEmpleado().mostrarEmpleado(t);
			if(res.getId() == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res.getId() > 0){
				if(res.getTipo() == 1){
					FactoriaVistas.getInstance().createIGUIModificarEmpleadoCompleta().actualizar(res);
				}
				else{
					FactoriaVistas.getInstance().createIGUIModificarEmpleadoPartida().actualizar(res);
				}
			}
			break;
		}
		case Evento.MODIFICAR_EMPLEADO_FINAL:{
			
			TEmpleado te = (TEmpleado) transfer;
			int res  = FactoriaNegocio.getInstancia().createSAEmpleado().modificarEmpleado(te);
			
			if(res == 0){
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
			}
			else if(res > 0){
				JOptionPane.showMessageDialog(null, "Modificado Empleado con Id: " + te.getId());
			}
			break;
		}
		case Evento.LISTAR_EMPLEADO:{
			ArrayList<TEmpleado> list = FactoriaNegocio.getInstancia().createSAEmpleado().listarEmpleados();
			if(list == null){
				JOptionPane.showMessageDialog(null, "Base de datos sin empleados");
			}
			else{
				FactoriaVistas.getInstance().createIGUIListarEmpleado().actualizar(list);
			}
			break;
		}
		}
		}catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Algo falló, checkea que los ficheros de la BBDD tenagn el fromato corecto");
		}
	}
}