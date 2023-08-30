/**
 * 
 */
package Integracion.Empleado;

import Negocio.Empleado.TEmpleado;
import java.util.ArrayList;


public interface DAOEmpleado {

	public TEmpleado bajaEmpleado(TEmpleado TEmpleado);


	public TEmpleado altaEmpleado(TEmpleado TEmpleado);


	public TEmpleado modificarEmpleado(TEmpleado TEmpleado);


	public ArrayList<TEmpleado> listarEmpleados();


	public TEmpleado mostrarEmpleado(TEmpleado TEmpleado);
	
	public TEmpleado mostrarEmpleadoDNI(TEmpleado te);
}