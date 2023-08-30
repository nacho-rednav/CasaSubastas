/**
 * 
 */
package Negocio.Tipodeproducto;

import java.util.ArrayList;

import Integracion.FactoriaIntegracion;
import Negocio.Especialidad.TEspecialidad;
import Negocio.Lote.TLote;

public class SATipoImp implements SATipo {

	public Integer altaTipoProducto(TTipo TTipo) {
		int idVuelta = 0;
		
		if(TTipo.getDescripcion() == null || TTipo.getTitulo() == null ||
				TTipo.getDescripcion().equals("") || TTipo.getTitulo().equals(""))
			return 0;
		
		TTipo tt = FactoriaIntegracion.getInstance().createDAOTipoProducto().mostrarTipoProducto_Titulo(TTipo);
		
		if(tt.getId() == 0){
			idVuelta = FactoriaIntegracion.getInstance().createDAOTipoProducto().altaTipoProducto(TTipo);
		}
		else if(tt.getId() > 0)
			return -1;
		
		return idVuelta;
		
	}

	public Integer bajaTipoProducto(TTipo TTipo) {
		int idV = 0;
		
		if(TTipo.getId() <= 0){
			return 0;
		}
		
		TTipo tt = FactoriaIntegracion.getInstance().createDAOTipoProducto().mostrarTipoProducto(TTipo);
		if(tt.getId() == 0)
			return 0;
		
		TEspecialidad te = new TEspecialidad();
		TLote tl = new TLote();
		tl.setId_Tipo(TTipo.getId());
		te.setId_Tipo(TTipo.getId());
		ArrayList<TEspecialidad> re = FactoriaIntegracion.getInstance().createDAOEspecialidad().listarPorTipo(te);
		ArrayList<TLote> rl = FactoriaIntegracion.getInstance().createDAOLote().listarLote_tipo(tl);
		
		if((re == null || re.size() == 0) && (rl == null || rl.size() == 0)){
			idV = FactoriaIntegracion.getInstance().createDAOTipoProducto().bajaTipoProducto(TTipo);
		}
		else if(re.size() > 0 || rl.size() > 0){
			return -1;
		}
		
		return idV;
	}

	public ArrayList<TTipo> listarTiposProducto() {
		ArrayList<TTipo> tipos = new ArrayList<TTipo>();
		
		tipos = FactoriaIntegracion.getInstance().createDAOTipoProducto().listarTiposProducto();
		return tipos;
	}

	public Integer modificarTipoProducto(TTipo TTipo) {
		if(TTipo.getId() <= 0 || TTipo.getDescripcion().equals("") || TTipo.getTitulo().equals(""))
			return 0;
		
		return FactoriaIntegracion.getInstance().createDAOTipoProducto().modificarTipoProducto(TTipo);
	}

	public TTipo mostrarTipoProducto(TTipo TTipo) {
		return FactoriaIntegracion.getInstance().createDAOTipoProducto().mostrarTipoProducto(TTipo);
	}

}