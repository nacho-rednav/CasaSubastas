/**
 * 
 */
package Negocio;

import Negocio.Almacen.SAAlmacen;
import Negocio.Almacen.SAAlmacenImp;
import Negocio.Cliente.SACliente;
import Negocio.Cliente.SAClienteImp;
import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.SAEmpleadoImp;
import Negocio.Especialidad.SAEspecialidad;
import Negocio.Especialidad.SAEspecialidadImp;
import Negocio.Lote.SALote;
import Negocio.Lote.SALoteImp;
import Negocio.Subasta.SASubasta;
import Negocio.Subasta.SASubastaImp;
import Negocio.Tipodeproducto.SATipo;
import Negocio.Tipodeproducto.SATipoImp;
import Negocio.VinculacionesEmpAlm.SAVinculaciones;
import Negocio.VinculacionesEmpAlm.SAVinculacionesImp;

public class FactoriaNegocioImp extends FactoriaNegocio {
	
	public SAEmpleado createSAEmpleado() {
		return new SAEmpleadoImp();
	}

	public SAAlmacen createSAAlmacen() {
		return new SAAlmacenImp();
	}

	public SACliente createSACliente() {
		return new SAClienteImp();
	}

	public SAEspecialidad createSAEspecialidad() {
		return new SAEspecialidadImp();
	}

	
	public SALote createSALote() {
		return new SALoteImp();
	}

	public SASubasta createSASubasta() {
		return new SASubastaImp();
	}

	public SATipo createSATipoProducto() {
		return new SATipoImp();
	}

	public SAVinculaciones createSAVinculacionesEmpAlm() {	
		return new SAVinculacionesImp();
	}
}