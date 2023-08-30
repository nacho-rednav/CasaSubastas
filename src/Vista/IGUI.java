/**
 * 
 */
package Vista;

//Todas las vistas deben implementarlo

public interface IGUI {
	//Esta función solamente hace la vista visible, excepto en los listar
		//y en modificar que hace más cosas
	public void actualizar(Object data);
}