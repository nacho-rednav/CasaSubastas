/**
 * 
 */
package Negocio.Especialidad;

import java.util.ArrayList;

import Integracion.FactoriaIntegracion;
import Integracion.Especialidad.DAOEspecialidad;
import Negocio.Empleado.TEmpleado;
import Negocio.Tipodeproducto.TTipo;


public class SAEspecialidadImp implements SAEspecialidad {
	
	public Integer crearEspecialidad(TEspecialidad tEspecialidad) {
		int resId = 0;
		
		if(tEspecialidad.getId_Empleado() <= 0 || tEspecialidad.getId_Tipo() <= 0
				|| tEspecialidad.getNivel() <= 0)
			return 0;
		
		TEmpleado te = new TEmpleado(tEspecialidad.getId_Empleado());
		te = FactoriaIntegracion.getInstance().createDAOEmpleado().mostrarEmpleado(te);
		TTipo tt = new TTipo(tEspecialidad.getId_Tipo());
		tt = FactoriaIntegracion.getInstance().createDAOTipoProducto().mostrarTipoProducto(tt);
		
		if(tt.getId() == 0 || te.getId() == 0 || !te.getActivo())
			return 0;
		
		DAOEspecialidad dao = FactoriaIntegracion.getInstance().createDAOEspecialidad();
		TEspecialidad tes = dao.mostrarEspecialidad_EmpleadoTipo(tEspecialidad);
		
		if(tes.getId() > 0){
			if(tes.getActivo()) return -1;
			
			else if(!tes.getActivo()){
				tes.setActivo(true);
				resId = dao.modificarEspecialidad(tes);
			}
		}
		else if(tes.getId() == 0){
			resId = dao.crearEspecialidad(tEspecialidad);
		}
		
		return resId;
	}

	
	public Integer bajaEspecialidad(TEspecialidad tEspecialidad) {
		
		if(tEspecialidad.getId() <= 0) return 0;
		
		DAOEspecialidad dao = FactoriaIntegracion.getInstance().createDAOEspecialidad();
		TEspecialidad res = dao.mostrarEspecialidad(tEspecialidad);
		
		if(res.getId() == 0) 
			return 0;
		
		else if(res.getId() > 0 && !res.getActivo()) 
			return -1;
		
		else if(res.getId() > 0 && res.getActivo()){
			res.setActivo(false);
			dao.bajaEspecialidad(res);
		}
		
		return res.getId();
	}

	
	public Integer modificarEspecialidad(TEspecialidad tEspecialidad) {
		if(tEspecialidad.getId() <= 0 || tEspecialidad.getNivel() <= 0){
			return 0;
		}
		
		return FactoriaIntegracion.getInstance().createDAOEspecialidad().modificarEspecialidad(tEspecialidad);
	}

	
	public TEspecialidad mostrarEspecialidad(TEspecialidad tEspecialidad) {
		
		return FactoriaIntegracion.getInstance().createDAOEspecialidad().mostrarEspecialidad(tEspecialidad);
	}

	
	public ArrayList<TEspecialidad> listarPorEmpleado(TEspecialidad tEspecialidad) {
		ArrayList<TEspecialidad> list = new ArrayList<TEspecialidad>();
		
		if(tEspecialidad.getId_Empleado() == null || tEspecialidad.getId_Empleado() <= 0)
			return null;
		
		TEmpleado temp = FactoriaIntegracion.getInstance().createDAOEmpleado().mostrarEmpleado(new TEmpleado(tEspecialidad.getId_Empleado()));
		if(temp.getId() == 0)
			return null;
		else if(temp.getId() > 0){
			list = FactoriaIntegracion.getInstance().createDAOEspecialidad().listarPorEmpleado(tEspecialidad);
		}
		
		return list;
	}

	public ArrayList<TEspecialidad> listarPorTipo(TEspecialidad tEspecialidad) {
		ArrayList<TEspecialidad> list = new ArrayList<TEspecialidad>();
		
		if(tEspecialidad.getId_Tipo() == null || tEspecialidad.getId_Tipo() <= 0)
			return null;
		
		TTipo temp = FactoriaIntegracion.getInstance().createDAOTipoProducto().mostrarTipoProducto(new TTipo(tEspecialidad.getId_Tipo()));
		if(temp.getId() == 0)
			return null;
		else if(temp.getId() > 0){
			list = FactoriaIntegracion.getInstance().createDAOEspecialidad().listarPorTipo(tEspecialidad);
		}
		
		return list;
	}
}