/**
 * 
 */
package Vista;

//Todas las vistas deben implementarlo

public interface IGUI {
	//Esta funci�n solamente hace la vista visible, excepto en los listar
		//y en modificar que hace m�s cosas
	public void actualizar(Object data);
}