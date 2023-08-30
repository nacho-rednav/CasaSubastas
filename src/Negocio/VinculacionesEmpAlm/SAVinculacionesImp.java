/**
 * 
 */
package Negocio.VinculacionesEmpAlm;

import java.util.ArrayList;

import Integracion.FactoriaIntegracion;
import Negocio.Almacen.TAlmacen;
import Negocio.Empleado.TEmpleado;

public class SAVinculacionesImp implements SAVinculaciones{

	@Override
	public TVinculacion crearVinculacion(TVinculacion tv) {
		
		if(tv.getIdAlmacen() <= 0 || tv.getIdEmpleado() <= 0)
			return new TVinculacion(0);
		
		TAlmacen ta = FactoriaIntegracion.getInstance().createDAOAlmacen().mostrarAlmacen(new TAlmacen(tv.getIdAlmacen()));
		TEmpleado te = FactoriaIntegracion.getInstance().createDAOEmpleado().mostrarEmpleado(new TEmpleado(tv.getIdEmpleado()));
		
		if(ta.getID() == 0 || te.getId() == 0 || !ta.getActivo() || !te.getActivo())
			return new TVinculacion(0);
		
		if(FactoriaIntegracion.getInstance().createDAOVinculacionesEmpAlm().existeVinculacion(tv))
			return new TVinculacion(-1);
		
		TVinculacion res = FactoriaIntegracion.getInstance().createDAOVinculacionesEmpAlm().crearVinculacion(tv);
				
		return res;
	}

	@Override
	public Integer eliminarVinculacion(TVinculacion tv) {
		if(tv.getIdAlmacen() <= 0 || tv.getIdEmpleado() <= 0 
				|| !FactoriaIntegracion.getInstance().createDAOVinculacionesEmpAlm().existeVinculacion(tv))
			return 0;
		
		return FactoriaIntegracion.getInstance().createDAOVinculacionesEmpAlm().eliminarVinculacion(tv);
	}

	@Override
	public ArrayList<TVinculacion> listar() {
		return FactoriaIntegracion.getInstance().createDAOVinculacionesEmpAlm().listar();
	}

	@Override
	public ArrayList<TVinculacion> listarPorAlmacen(TVinculacion tv) {
		return FactoriaIntegracion.getInstance().createDAOVinculacionesEmpAlm().listarPorAlmacen(tv);
	}

	@Override
	public ArrayList<TVinculacion> listarPorEmpleado(TVinculacion tv) {
		return FactoriaIntegracion.getInstance().createDAOVinculacionesEmpAlm().listarPorEmpleado(tv);
	}
}