/**
 * 
 */
package Integracion.Cliente;

import Negocio.Cliente.TCliente;
import java.util.ArrayList;


public interface DAOCliente {
	
	public TCliente altaCliente(TCliente TCliente);

	public TCliente bajaCliente(TCliente TCliente);

	public TCliente modificarCliente(TCliente TCliente);

	public TCliente mostrarCliente(TCliente TCliente);
	
	public ArrayList<TCliente> listarCliente();
	
	public TCliente mostrarCliente_DNI(TCliente tc);
	
}