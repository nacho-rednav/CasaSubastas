/**
 * 
 */
package Negocio.Cliente;

import java.util.ArrayList;

public interface SACliente {
	
	public Integer altaCliente(TCliente TCliente);

	public Integer bajaCliente(TCliente TCliente);

	public Integer modificarCliente(TCliente TCliente);

	public TCliente mostrarCliente(TCliente TCliente);
	
	public ArrayList<TCliente> listarCliente();
}