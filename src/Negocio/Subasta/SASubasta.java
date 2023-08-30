/**
 * 
 */
package Negocio.Subasta;

import java.util.ArrayList;

public interface SASubasta {

	public TSubasta crearSubasta(TSubasta TSubasta);

	public TSubasta eliminarSubasta(TSubasta TSubasta);

	public TSubasta mostrarSubasta(TSubasta TSubasta);

	public TSubasta modificarSubasta(TSubasta TSubasta);

	public ArrayList<TSubasta> listarSubastas();
}