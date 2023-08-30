/**
 * 
 */
package Integracion.Especialidad;

import Negocio.Especialidad.TEspecialidad;
import java.util.ArrayList;


public interface DAOEspecialidad {
	
	public Integer crearEspecialidad(TEspecialidad tEspecialidad);

	public Integer bajaEspecialidad(TEspecialidad tEspecialidad);

	public Integer modificarEspecialidad(TEspecialidad tEspecialidad);
	
	public TEspecialidad mostrarEspecialidad_EmpleadoTipo(TEspecialidad tEspecialidad);
	public TEspecialidad mostrarEspecialidad(TEspecialidad tEspecialidad);

	public ArrayList<TEspecialidad> listarPorEmpleado(TEspecialidad tEspecialidad);

	public ArrayList<TEspecialidad> listarPorTipo(TEspecialidad tEspecialidad);
}