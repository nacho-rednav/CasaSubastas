/**
 * 
 */
package Negocio;

import Negocio.Almacen.SAAlmacen;
import Negocio.Cliente.SACliente;
import Negocio.Empleado.SAEmpleado;
import Negocio.Especialidad.SAEspecialidad;
import Negocio.Lote.SALote;
import Negocio.Subasta.SASubasta;
import Negocio.Tipodeproducto.SATipo;
import Negocio.VinculacionesEmpAlm.SAVinculaciones;

public abstract class FactoriaNegocio {
	
	static FactoriaNegocio instance;
	
	public static FactoriaNegocio getInstancia() {
		if(instance == null){
			instance = new FactoriaNegocioImp();
		}
		return instance;
	}

	
	public abstract SAAlmacen createSAAlmacen();

	public abstract SACliente createSACliente();

	public abstract SAEmpleado  createSAEmpleado();

	public abstract SAEspecialidad createSAEspecialidad();

	public abstract SALote createSALote();

	public abstract SASubasta createSASubasta();

	public abstract SATipo createSATipoProducto();

	public abstract SAVinculaciones createSAVinculacionesEmpAlm();
}