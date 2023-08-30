/**
 * 
 */
package Negocio.Lote;

import java.util.ArrayList;


public interface SALote {
	
	public Integer crearLote(TLote TLote);

	
	public Integer bajaLote(TLote TLote);

	
	public ArrayList<TLote> listarLote_almacen(TLote tl);

	
	public ArrayList<TLote> listarLote_tipo(TLote tl);

	
	public ArrayList<TLote> listarLote_subasta(TLote tl);

	public Integer modificarLote(TLote TLote);

	public TLote mostrarLote(TLote TLote);
	
	public Integer comprarLote(TLote tLote);
}