/**
 * 
 */
package Vista.Controlador;


public abstract class Controlador {
	
	static ControladorImp instance;
	
	//Devuelve ControladorImp para usarlo por la aplicaci�n
	public static ControladorImp getInstancia() {
		if(instance == null){
			instance = new ControladorImp();
		}
		return instance;
	}
}