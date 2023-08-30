/**
 * 
 */
package Integracion;

import Integracion.Almacen.DAOAlmacen;
import Integracion.Almacen.DAOAlmacenImp;
import Integracion.Cliente.DAOCliente;
import Integracion.Cliente.DAOClienteImp;
import Integracion.Empleado.DAOEmpleado;
import Integracion.Empleado.DAOEmpleadoImp;
import Integracion.Especialidad.DAOEspecialidad;
import Integracion.Especialidad.DAOEspecialidadImp;
import Integracion.Lote.DAOLote;
import Integracion.Lote.DAOLoteImp;
import Integracion.Subasta.DAOSubasta;
import Integracion.Subasta.DAOSubastaImp;
import Integracion.Tipodeproducto.DAOTipo;
import Integracion.Tipodeproducto.DAOTipoImp;
import Integracion.VinculacionesEmpAlm.DAOVinculaciones;
import Integracion.VinculacionesEmpAlm.DAOVinculacionesImp;

public class FactoriaIntegracionImp extends FactoriaIntegracion {
	
	public DAOEmpleado createDAOEmpleado() {
		return new DAOEmpleadoImp();
	}

	
	public DAOAlmacen createDAOAlmacen() {
		return new DAOAlmacenImp();
	}

	public DAOCliente createDAOCliente() {
		return new DAOClienteImp();
	}

	public DAOEspecialidad createDAOEspecialidad() {
		return new DAOEspecialidadImp();
	}
	
	public DAOLote createDAOLote() {
		return new DAOLoteImp();
	}

	
	public DAOSubasta createDAOSubasta() {
		return new DAOSubastaImp();
	}

	
	public DAOTipo createDAOTipoProducto() {
		return new DAOTipoImp();
	}

	public DAOVinculaciones createDAOVinculacionesEmpAlm() {
		return new DAOVinculacionesImp();
	}
}