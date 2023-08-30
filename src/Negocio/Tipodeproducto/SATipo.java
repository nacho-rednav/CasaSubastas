/**
 * 
 */
package Negocio.Tipodeproducto;

import java.util.ArrayList;

public interface SATipo {

	public Integer altaTipoProducto(TTipo TTipo);

	public Integer bajaTipoProducto(TTipo TTipo);

	public ArrayList<TTipo> listarTiposProducto();

	public Integer modificarTipoProducto(TTipo TTipo);

	public TTipo mostrarTipoProducto(TTipo TTipo);
}