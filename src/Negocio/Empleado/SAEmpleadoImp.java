/**
 * 
 */
package Negocio.Empleado;

import java.util.ArrayList;

import Integracion.FactoriaIntegracion;
import Integracion.Empleado.DAOEmpleado;


public class SAEmpleadoImp implements SAEmpleado {

	public final static int NULL = 0;
	
	
	public Integer bajaEmpleado(TEmpleado te) {

		
		if(te.getId() <= 0){
			return 0;
		}
		DAOEmpleado dao = FactoriaIntegracion.getInstance().createDAOEmpleado();
		TEmpleado res = dao.mostrarEmpleado(te);
		
		if(res.getId() == 0){
			return 0;
		}
		else if(res.getId() > 0 && !res.getActivo()){
			return -1;
		}
		else if(res.getId() > 0 && res.getActivo()){
			res.setActivo(false);
			dao.bajaEmpleado(res);
		}
		
		return res.getId();
	}


	public Integer altaEmpleado(TEmpleado te) {
		int idVuelta = 0;
		if(te.getDNI() == null || te.getDNI().equals("") || te.getNombre().equals("") || te.getApellidos().equals("")
				|| te.getSueldo() <= 0 || te.getEdad() <= 0){
			return 0;
		}
		if(te.getTipo() == 1){
			if(((TEmpleadoCompleta)te).gethorario().equals("") || ((TEmpleadoCompleta)te).getbonus() < 0){
				return 0;
			}
		}
		else if(te.getTipo() == 0){
			if(((TEmpleadoPartida)te).getturno().equals("") || ((TEmpleadoPartida)te).gethorasFinSemana().equals("")){
				return 0;
			}
		}
		
		DAOEmpleado daoEmpleado = FactoriaIntegracion.getInstance().createDAOEmpleado();
		TEmpleado res = daoEmpleado.mostrarEmpleadoDNI(te);
		if(res.getId() > 0 && res.getActivo()){ //empelado activo y existe
			return -1;
		}
		else if (res.getId() > 0 && !res.getActivo()){
			res.setActivo(true);
			daoEmpleado.modificarEmpleado(res);
			idVuelta = res.getId();
		}
		else if(res.getId() == 0){
			daoEmpleado.altaEmpleado(te);
			idVuelta = te.getId();
		}
		
		return idVuelta;
		
	}


	public Integer modificarEmpleado(TEmpleado te) {
		if(te.getDNI() == null || te.getDNI().equals("") || te.getNombre().equals("") || te.getApellidos().equals("")
				|| te.getSueldo() <= 0 || te.getEdad() <= 0 || te.getId() <= 0){
			return 0;
		}
		if(te.getTipo() == 1){
			if(((TEmpleadoCompleta)te).gethorario().equals("") || ((TEmpleadoCompleta)te).getbonus() < 0){
				return 0;
			}
		}
		else if(te.getTipo() == 0){
			if(((TEmpleadoPartida)te).getturno().equals("") || ((TEmpleadoPartida)te).gethorasFinSemana().equals("")){
				return 0;
			}
		}	
		DAOEmpleado dao = FactoriaIntegracion.getInstance().createDAOEmpleado();
		te = dao.modificarEmpleado(te);
		return te.getId();		
	}
	
	public ArrayList<TEmpleado> listarEmpleados() {
		DAOEmpleado dao = FactoriaIntegracion.getInstance().createDAOEmpleado();
		ArrayList<TEmpleado> list = dao.listarEmpleados();

		return list;
	}


	public TEmpleado mostrarEmpleado(TEmpleado te) {
		DAOEmpleado dao = FactoriaIntegracion.getInstance().createDAOEmpleado();
		te = dao.mostrarEmpleado(te);
		return te;
	}
}