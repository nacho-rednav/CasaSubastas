/**
 * 
 */
package Negocio.VinculacionesEmpAlm;

import java.util.ArrayList;

public interface SAVinculaciones {
	public TVinculacion crearVinculacion(TVinculacion tv);
	public Integer eliminarVinculacion(TVinculacion tv);
	public ArrayList<TVinculacion> listar();
	public ArrayList<TVinculacion> listarPorAlmacen(TVinculacion tv );
	public ArrayList<TVinculacion> listarPorEmpleado(TVinculacion tv);

}