/**
 * 
 */
package Negocio.Almacen;

import java.util.ArrayList;

public interface SAAlmacen {
	
	public Integer crearAlmacen(TAlmacen TAlmacen);

	public Integer eliminarAlmacen(TAlmacen TAlmacen);

	public Integer modificarAlmacen(TAlmacen TAlmacen);

	public TAlmacen mostrarAlmacen(TAlmacen TAlmacen);
	
	public ArrayList<TAlmacen> listarAlmacen();
}