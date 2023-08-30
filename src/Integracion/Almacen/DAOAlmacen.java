/**
 * 
 */
package Integracion.Almacen;

import java.util.ArrayList;

import Negocio.Almacen.TAlmacen;


public interface DAOAlmacen {
	
	public Integer crearAlmacen(TAlmacen TAlmacen);

	public Integer eliminarAlmacen(TAlmacen TAlmacen);

	public Integer modificarAlmacen(TAlmacen TAlmacen);

	public TAlmacen mostrarAlmacen(TAlmacen TAlmacen);
	public TAlmacen mostrarAlmacen_Nombre(TAlmacen tAlmacen);
	
	public ArrayList<TAlmacen> listarAlmacen();
}