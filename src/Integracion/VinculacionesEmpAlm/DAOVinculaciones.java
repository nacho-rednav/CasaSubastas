/**
 * 
 */
package Integracion.VinculacionesEmpAlm;

import java.util.ArrayList;

import Negocio.VinculacionesEmpAlm.TVinculacion;

public interface DAOVinculaciones {
	public TVinculacion crearVinculacion(TVinculacion tv);
	public Integer eliminarVinculacion(TVinculacion tv);
	public boolean existeVinculacion(TVinculacion tv);
	public ArrayList<TVinculacion> listar();
	public ArrayList<TVinculacion> listarPorAlmacen(TVinculacion tv );
	public ArrayList<TVinculacion> listarPorEmpleado(TVinculacion tv);
}