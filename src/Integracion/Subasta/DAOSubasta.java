/**
 * 
 */
package Integracion.Subasta;

import Negocio.Subasta.TSubasta;
import java.util.ArrayList;

 public interface DAOSubasta {
	public TSubasta crearSubasta(TSubasta TSubasta);

	public TSubasta eliminarSubasta(TSubasta TSubasta);

	public TSubasta mostrarSubasta(TSubasta TSubasta);

	public TSubasta modificarSubasta(TSubasta TSubasta);

	public ArrayList<TSubasta> listarSubastas();

	public TSubasta mostrarSubasta_Nombre(TSubasta tSubasta);
}