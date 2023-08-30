/**
 * 
 */
package Negocio.Cliente;

import java.util.ArrayList;

import Integracion.FactoriaIntegracion;
import Integracion.Cliente.DAOCliente;


public class SAClienteImp implements SACliente {
	
	public Integer altaCliente(TCliente tCliente) {
		int idVuelta = 0;
		if(tCliente.getDNI() == null || tCliente.getDNI().equals("") || tCliente.getCorreo().equals("")
				|| tCliente.getCuentaBancaria().equals("") || tCliente.getDomicilio().equals("") 
				|| tCliente.getNombre().equals("")){
			return 0;
		}
		
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().createDAOCliente();
		TCliente res = daoCliente.mostrarCliente_DNI(tCliente);
		if(res.getID() > 0 && res.getActivo()){ //cliente activo y existe
			return -1;
		}
		else if (res.getID() > 0 && !res.getActivo()){
			res.setActivo(true);
			daoCliente.modificarCliente(res);
			idVuelta = res.getID();
		}
		else if(res.getID() == 0){
			tCliente = daoCliente.altaCliente(tCliente);
			idVuelta = tCliente.getID();
		}
		
		return idVuelta;
	}

	
	public Integer bajaCliente(TCliente TCliente) {
		if(TCliente.getID() <= 0){
			return 0;
		}
		DAOCliente dao = FactoriaIntegracion.getInstance().createDAOCliente();
		TCliente res = dao.mostrarCliente(TCliente);
		
		if(res.getID() == 0){
			return 0;
		}
		else if(res.getID() > 0 && !res.getActivo()){
			return -1;
		}
		else if(res.getID() > 0 && res.getActivo()){
			res.setActivo(false);
			dao.bajaCliente(res);
		}
		
		return res.getID();
	}

	
	public Integer modificarCliente(TCliente tCliente) {
		if(tCliente.getDNI() == null || tCliente.getDNI().equals("") || tCliente.getCorreo().equals("")
				|| tCliente.getCuentaBancaria().equals("") || tCliente.getDomicilio().equals("") 
				|| tCliente.getNombre().equals("") || tCliente.getID() <= 0){
			return 0;
		}
		
		DAOCliente dao = FactoriaIntegracion.getInstance().createDAOCliente();
		tCliente = dao.modificarCliente(tCliente);
		return tCliente.getID();
	}

	
	public TCliente mostrarCliente(TCliente TCliente) {
		DAOCliente dao = FactoriaIntegracion.getInstance().createDAOCliente();
		TCliente = dao.mostrarCliente(TCliente);
		return TCliente;
	}
	
	public ArrayList<TCliente> listarCliente() {
		DAOCliente dao = FactoriaIntegracion.getInstance().createDAOCliente();
		ArrayList<TCliente> list = dao.listarCliente();

		return list;
	}

}