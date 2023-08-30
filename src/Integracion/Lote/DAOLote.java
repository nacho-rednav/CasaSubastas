/**
 * 
 */
package Integracion.Lote;

import Negocio.Lote.TLote;
import java.util.ArrayList;


public interface DAOLote {
	
	public Integer crearLote(TLote TLote);

	
	public Integer bajaLote(TLote TLote);

	
	public Integer modificarLote(TLote TLote);

	
	public TLote mostrarLote(TLote TLote);
	public TLote mostrarLote_Nombre(TLote tLote);

	
	public ArrayList<TLote> listarLote_almacen(TLote tl);

	
	public ArrayList<TLote> listarLote_subasta(TLote tl);

	
	public ArrayList<TLote> listarLote_tipo(TLote tl);
}