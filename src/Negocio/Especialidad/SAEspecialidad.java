/**
 * 
 */
package Negocio.Especialidad;

import java.util.ArrayList;


public interface SAEspecialidad {
	
	public Integer crearEspecialidad(TEspecialidad tEspecialidad);

	
	public Integer bajaEspecialidad(TEspecialidad tEspecialidad);

	
	public Integer modificarEspecialidad(TEspecialidad tEspecialidad);

	public TEspecialidad mostrarEspecialidad(TEspecialidad tEspecialidad);

	public ArrayList<TEspecialidad> listarPorEmpleado(TEspecialidad tEspecialidad);

	public ArrayList<TEspecialidad> listarPorTipo(TEspecialidad tEspecialidad);
}