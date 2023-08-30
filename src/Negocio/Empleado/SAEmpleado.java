/**
 * 
 */
package Negocio.Empleado;

import java.util.ArrayList;


public interface SAEmpleado {

	public Integer bajaEmpleado(TEmpleado TEmpleado);


	public Integer altaEmpleado(TEmpleado TEmpleado);


	public Integer modificarEmpleado(TEmpleado TEmpleado);


	public ArrayList<TEmpleado> listarEmpleados();


	public TEmpleado mostrarEmpleado(TEmpleado TEmpleado);
}