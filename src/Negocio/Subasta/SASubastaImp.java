/**
 * 
 */
package Negocio.Subasta;

import java.util.ArrayList;

import Integracion.FactoriaIntegracion;
import Integracion.Lote.DAOLote;
import Integracion.Subasta.DAOSubasta;
import Negocio.Lote.TLote;

public class SASubastaImp implements SASubasta {
	
	public final static int EXIST_LOTES = -2;
	public final static int ERROR = -1;
	public final static int NULL = 0;

public TSubasta crearSubasta(TSubasta ts) {
		
		if(ts.getTitulo().equals("") || ts.getDescripcion().equals("")){
			return ts;
		}
		
		DAOSubasta daoSubasta = FactoriaIntegracion.getInstance().createDAOSubasta();
		TSubasta tSubasta = daoSubasta.mostrarSubasta_Nombre(ts);
		
		if(tSubasta.getId() > 0 && tSubasta.getActivo())
	    	tSubasta.setId(ERROR);
		else if(tSubasta.getId() > 0 && !tSubasta.getActivo()){
			tSubasta.setActivo(true);
			tSubasta = daoSubasta.modificarSubasta(tSubasta);
		}
		else if(tSubasta.getId() == 0){
			tSubasta = daoSubasta.crearSubasta(ts);
		}
		return tSubasta;
	}

    public TSubasta eliminarSubasta(TSubasta tSubasta) {
	
	    DAOSubasta daoSubasta = FactoriaIntegracion.getInstance().createDAOSubasta();
	    tSubasta = daoSubasta.mostrarSubasta(tSubasta);

	    if (tSubasta.getId() > 0 && !tSubasta.getActivo())
	    	tSubasta.setId(ERROR);
	    else if(tSubasta.getId() > 0 && tSubasta.getActivo()){
	    	DAOLote daoLote = FactoriaIntegracion.getInstance().createDAOLote();
	    	TLote lote = new TLote();
	    	lote.setId_Subasta(tSubasta.getId());
	    	ArrayList<TLote> list = daoLote.listarLote_subasta(lote);
	    	if(list.isEmpty()){
	    		tSubasta.setActivo(false);
	    		tSubasta = daoSubasta.modificarSubasta(tSubasta);
	    	}
	    	else{
	    		tSubasta.setId(EXIST_LOTES);
	    	}
	    }
	    return tSubasta;
    }

    public TSubasta mostrarSubasta(TSubasta tSubasta) {
		
    	if(tSubasta.getId().equals("")){
    		tSubasta.setId(NULL);
    		return tSubasta;
    	}
    	else{
    		DAOSubasta daoSubasta = FactoriaIntegracion.getInstance().createDAOSubasta();
    		tSubasta = daoSubasta.mostrarSubasta(tSubasta);
    	}

		return tSubasta;
	}

    public TSubasta modificarSubasta(TSubasta tSubasta) {
		
		DAOSubasta daoSubasta = FactoriaIntegracion.getInstance().createDAOSubasta();
		tSubasta = daoSubasta.modificarSubasta(tSubasta);
		return tSubasta;
	}

	public ArrayList<TSubasta> listarSubastas() {
		
    	DAOSubasta daoSubasta = FactoriaIntegracion.getInstance().createDAOSubasta();
    	ArrayList<TSubasta> list = daoSubasta.listarSubastas();
    	
		return list;
	}
}