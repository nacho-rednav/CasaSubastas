/**
 * 
 */
package Negocio.Almacen;

import java.util.ArrayList;

import Integracion.FactoriaIntegracion;
import Integracion.Almacen.DAOAlmacen;
import Negocio.Lote.TLote;


public class SAAlmacenImp implements SAAlmacen {
	
	public Integer crearAlmacen(TAlmacen tAlmacen) {
		int idVuelta = 0;
		if (tAlmacen.getNombre().equals("") ||
				tAlmacen.getAltura() <= 0 || tAlmacen.getMetrosCuadrados() <= 0)
			return 0;
		
		DAOAlmacen dao = FactoriaIntegracion.getInstance().createDAOAlmacen();
		TAlmacen ta = dao.mostrarAlmacen_Nombre(tAlmacen);
		
		if (ta.getID() == 0) {
			idVuelta = dao.crearAlmacen(tAlmacen);
		}
		else if (ta.getID() > 0){
			if(ta.getActivo())
				return -1;
			else if(!ta.getActivo()) {
				ta.setActivo(true);
				idVuelta = dao.modificarAlmacen(ta);
			}
		}
			
		return idVuelta;
	}

	public Integer eliminarAlmacen(TAlmacen tAlmacen) {
		int idVuelta = 0;
		if (tAlmacen.getID() <= 0) return 0;
		
		TLote tl = new TLote();
		tl.setId_Almacen(tAlmacen.getID());
		ArrayList<TLote> listLotes = FactoriaIntegracion.getInstance().createDAOLote().listarLote_almacen(tl);
		
		if(listLotes != null && listLotes.size() > 0)
			return -2;
		
		DAOAlmacen dao = FactoriaIntegracion.getInstance().createDAOAlmacen();
		TAlmacen ta = dao.mostrarAlmacen(tAlmacen);
		
		if (ta.getID() == 0) {
			return 0;
		}
		else if (ta.getID() > 0) {
			if (!ta.getActivo())
				return -1;
			else {
				ta.setActivo(false);
				idVuelta = dao.modificarAlmacen(ta);
			}
		}
		return idVuelta;
	}

	public Integer modificarAlmacen(TAlmacen tAlmacen) {
		if (tAlmacen.getNombre().equals("") || tAlmacen.getID() <= 0 ||
				tAlmacen.getAltura() <= 0 || tAlmacen.getMetrosCuadrados() <= 0)
			return 0;
		
		return FactoriaIntegracion.getInstance().createDAOAlmacen().modificarAlmacen(tAlmacen);
	}

	public TAlmacen mostrarAlmacen(TAlmacen tAlmacen) {
		return FactoriaIntegracion.getInstance().createDAOAlmacen().mostrarAlmacen(tAlmacen);
	}

	@Override
	public ArrayList<TAlmacen> listarAlmacen() {
		return FactoriaIntegracion.getInstance().createDAOAlmacen().listarAlmacen();
	}
}