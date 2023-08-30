/**
 * 
 */
package Integracion;

import Integracion.Almacen.DAOAlmacen;
import Integracion.Cliente.DAOCliente;
import Integracion.Empleado.DAOEmpleado;
import Integracion.Especialidad.DAOEspecialidad;
import Integracion.Lote.DAOLote;
import Integracion.Subasta.DAOSubasta;
import Integracion.Tipodeproducto.DAOTipo;
import Integracion.VinculacionesEmpAlm.DAOVinculaciones;


public abstract class FactoriaIntegracion {
	
	static FactoriaIntegracion instance;
	
	public static FactoriaIntegracion getInstance() {
		if(instance == null){
			instance = new FactoriaIntegracionImp();
		}
		return instance;
	}

	
	public abstract DAOAlmacen createDAOAlmacen();

	public abstract DAOCliente createDAOCliente();

	public abstract DAOEmpleado createDAOEmpleado();

	public abstract DAOEspecialidad createDAOEspecialidad();

	public abstract DAOLote createDAOLote();

	public abstract DAOSubasta createDAOSubasta();

	public abstract DAOTipo createDAOTipoProducto();

	public abstract DAOVinculaciones createDAOVinculacionesEmpAlm();
}