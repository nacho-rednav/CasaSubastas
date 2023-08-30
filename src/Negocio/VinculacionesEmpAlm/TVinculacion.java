/**
 * 
 */
package Negocio.VinculacionesEmpAlm;

public class TVinculacion {
	private int idAlmacen;
	private int idEmpleado;
	
	public TVinculacion(int msg){
		idAlmacen = msg;
	}
	
	public TVinculacion(int idA, int idE){
		idAlmacen = idA;
		idEmpleado = idE;
	}

	public int getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	@Override
	public String toString(){
		StringBuilder buff = new StringBuilder();
		buff.append("Almacen: " + idAlmacen);
		buff.append(System.getProperty("line.separator"));
		buff.append("Empleado: " + idEmpleado);
		return buff.toString();
	}
}