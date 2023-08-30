/**
 * 
 */
package Negocio.Lote;

import java.util.ArrayList;

import Integracion.FactoriaIntegracion;
import Integracion.Lote.DAOLote;
import Negocio.Almacen.TAlmacen;
import Negocio.Cliente.TCliente;
import Negocio.Subasta.TSubasta;
import Negocio.Tipodeproducto.TTipo;


public class SALoteImp implements SALote {
	
	public Integer bajaLote(TLote tLote) {
		
		if(tLote.getId() <= 0) return 0;
		
		
		DAOLote dao = FactoriaIntegracion.getInstance().createDAOLote();
		TLote res = dao.mostrarLote(tLote);
		
		if(res.getId() == 0) 
			return 0;
		
		else if(res.getId() > 0 && !res.getActivo()) 
			return -1;
		
		else if(res.getId() > 0 && res.getActivo()){
			res.setActivo(false);
			dao.bajaLote(res);
		}
		
		return res.getId();
	}

	
	public Integer crearLote(TLote tLote) {
		int idVuelta = 0;
		
		//Primero miro que los datos que ha metido están bien, si no devuelvo 0
		if(tLote.getNombre().equals("") || tLote.getDescripcion().equals("")
				|| tLote.getPrecioSalida() <= 0 || tLote.getId_Almacen() <= 0
				|| tLote.getId_Tipo() <= 0 || tLote.getId_Subasta() <= 0)
			return 0;
		
		//En mi caso tengo que mirar que almacén, subasta, y tipo de producto existan y estén activos
		//La función mostrar de todo módulo recibe un Transfer con un id y devuelve 0 si no existe elemento con ese id
		//y si no devuelve el id y en el transfer que recibe por parámetro ha metido los datos que haya leido
		TAlmacen ta = new TAlmacen(tLote.getId_Almacen());
		TTipo tt = new TTipo(tLote.getId_Tipo());
		TSubasta ts = new TSubasta(tLote.getId_Subasta());
		TLote tl;
		//Así accedo a FactoriaIntegracionImp para pedirle los DAOs que me hacen falta
		//Antes de dar de alta debemos comprobar que no se esté metiendo un objeto con atributo único (Nombre o DNI según el módulo)
		//ya existente, por eso hago mostrarLote_Nombre
		DAOLote daoLote = FactoriaIntegracion.getInstance().createDAOLote();
		tl = daoLote.mostrarLote_Nombre(tLote);
		ta = FactoriaIntegracion.getInstance().createDAOAlmacen().mostrarAlmacen(ta);
		tt = FactoriaIntegracion.getInstance().createDAOTipoProducto().mostrarTipoProducto(tt);
		ts = FactoriaIntegracion.getInstance().createDAOSubasta().mostrarSubasta(ts);
		
		//Para saber que almacén, subasta y tipo de producto están activos debo haber recibido
		//lotes con Id > 0 y su atributo activo debe ser = true
		//Se debe mirar antes el Id que el atributo activo para evitar errores
		if(ta.getID() == 0 || ts.getId() == 0 || tt.getId() == 0
				|| !ta.getActivo() || !ts.getActivo())
			return 0;
		
		//Si el id del lote > 0 es porque ya hay un lote con el mismo nombre
		else if(tl.getId() > 0 && tl.getActivo()) //Si ese lote ya está activo, no hay que darle de alta
			return -1; //Informar ya dado de alta
		else if(tl.getId() > 0 && !tl.getActivo()){//Si está inactivo, lo modificamos y lo ponemos activo
			//IMPORTANTE, si modificas se debe usar tl (el creado durante la función), no el recibido por parámetro
			tl.setActivo(true);
			idVuelta = daoLote.modificarLote(tl);
		}
		else if(tl.getId() == 0){//Si no existe lote con ese nombre, creamos uno nuevo
			//IMPORTANTE, debemos pasar tLote (el recibido por parámetro) porque es el que tiene los datos nuevos, no tl (el creado durante la funcion)
			idVuelta =  daoLote.crearLote(tLote);
		}
		
		return idVuelta;
	}

	
	public ArrayList<TLote> listarLote_almacen(TLote tl) {
		ArrayList<TLote> lotes = new ArrayList<TLote>();
		
		if(tl.getId_Almacen() == null || tl.getId_Almacen() <= 0)
			return null;
		TAlmacen ta = new TAlmacen(tl.getId_Almacen());
		ta = FactoriaIntegracion.getInstance().createDAOAlmacen().mostrarAlmacen(ta);
		
		if(ta.getID() == 0 || !ta.getActivo())
			return null;
		else if(ta.getID() > 0)
			lotes = FactoriaIntegracion.getInstance().createDAOLote().listarLote_almacen(tl);
		return lotes;
	}

	
	public ArrayList<TLote> listarLote_tipo(TLote tl) {
		ArrayList<TLote> lotes = new ArrayList<TLote>();
		
		if(tl.getId_Tipo() == null || tl.getId_Tipo() <= 0)
			return null;
		TTipo tt = new TTipo(tl.getId_Tipo());
		tt = FactoriaIntegracion.getInstance().createDAOTipoProducto().mostrarTipoProducto(tt);
		
		if(tt.getId() == 0)
			return null;
		else if(tt.getId() > 0)
			lotes = FactoriaIntegracion.getInstance().createDAOLote().listarLote_tipo(tl);
		return lotes;
	}
	
	//Los listar normales solamente devuelven una lista con todos los elementos
	//(lotes sería en este caso) que haya guardados
	//Los listar por subasta (y cualquier listar por otro módulo) devuelven
	//null si no existe la subasta(en este caso) con el id que se pregunta
	//En otro caso, devuelven la lista con todos los lotes asignados a esta
	//subasta, que podría ser una lista vacía
	public ArrayList<TLote> listarLote_subasta(TLote tl) {
		ArrayList<TLote> lotes = new ArrayList<TLote>();
		
		if(tl.getId_Subasta() == null || tl.getId_Subasta() <= 0)
			return null;
		TSubasta ts = new TSubasta(tl.getId_Subasta());
		ts = FactoriaIntegracion.getInstance().createDAOSubasta().mostrarSubasta(ts);
		
		if(ts.getId() == 0 || !ts.getActivo())
			return null;
		else if(ts.getId() > 0)
			lotes = FactoriaIntegracion.getInstance().createDAOLote().listarLote_subasta(tl);
		return lotes;
	}

	
	public Integer modificarLote(TLote tLote) {
		if(tLote.getNombre().equals("") || tLote.getDescripcion().equals("")
				|| tLote.getPrecioSalida() <= 0 || tLote.getId_Almacen() <= 0
				|| tLote.getId_Tipo() <= 0 || tLote.getId_Subasta() <= 0)
			return 0;
		if(tLote.getVendido() && (tLote.getPrecioVenta() <= 0 || tLote.getId_Comprador() <= 0))
			return 0;
		
		TAlmacen ta = new TAlmacen(tLote.getId_Almacen());
		TTipo tt = new TTipo(tLote.getId_Tipo());
		TSubasta ts = new TSubasta(tLote.getId_Subasta());
		TCliente tc = new TCliente(tLote.getId_Comprador());
		
		ta = FactoriaIntegracion.getInstance().createDAOAlmacen().mostrarAlmacen(ta);
		tt = FactoriaIntegracion.getInstance().createDAOTipoProducto().mostrarTipoProducto(tt);
		ts = FactoriaIntegracion.getInstance().createDAOSubasta().mostrarSubasta(ts);
		tc = FactoriaIntegracion.getInstance().createDAOCliente().mostrarCliente(tc);
		
		if(tLote.getVendido() && (tc.getID() == 0 || !tc.getActivo()))
			return 0;
		if(ta.getID() == 0 || ts.getId() == 0 || tt.getId() == 0
				|| !ta.getActivo() || !ts.getActivo())
			return 0;
		
		return FactoriaIntegracion.getInstance().createDAOLote().modificarLote(tLote);
	}

	
	public TLote mostrarLote(TLote tl) {	
		return FactoriaIntegracion.getInstance().createDAOLote().mostrarLote(tl);
	}


	@Override
	public Integer comprarLote(TLote tLote) {
		
		if(tLote.getId() <= 0 || tLote.getId_Comprador() <= 0 || tLote.getPrecioVenta() <= 0)
			return 0;
		
		TLote tl = FactoriaIntegracion.getInstance().createDAOLote().mostrarLote(tLote);
		TCliente tc = new TCliente(tLote.getId_Comprador());
		tc = FactoriaIntegracion.getInstance().createDAOCliente().mostrarCliente(tc);

		if(tl.getId() == 0 || tc.getID() == 0 || !tl.getActivo() || !tc.getActivo()) return 0;
		else if(tl.getId() > 0 && tl.getVendido()) return -1;
		
		tl.setId_Comprador(tLote.getId_Comprador());
		tl.setPrecioVenta(tLote.getPrecioVenta());
		tl.setVendido(true);
		return FactoriaIntegracion.getInstance().createDAOLote().modificarLote(tl);
	}
}