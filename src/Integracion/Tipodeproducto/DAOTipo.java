/**
 * 
 */
package Integracion.Tipodeproducto;

import Negocio.Tipodeproducto.TTipo;
import java.util.ArrayList;

public interface DAOTipo {
	
	public Integer altaTipoProducto(TTipo TTipo);

	public Integer bajaTipoProducto(TTipo TTipo);

	public ArrayList<TTipo> listarTiposProducto();

	public Integer modificarTipoProducto(TTipo TTipo);

	public TTipo mostrarTipoProducto(TTipo TTipo);
	
	public TTipo mostrarTipoProducto_Titulo(TTipo t);
}