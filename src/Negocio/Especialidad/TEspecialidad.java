/**
 * 
 */
package Negocio.Especialidad;


public class TEspecialidad {
	
	private Integer id_Empleado;
	
	private Integer id_Tipo;
	
	private Integer id;
	
	private Integer nivel;
	
	private Boolean activo;
	
	
	public TEspecialidad() {
	}
	public TEspecialidad(int id) {
		this.id = id;
	}
	public TEspecialidad(int idE, int idT, int nivel) {
		id_Empleado = idE;
		id_Tipo = idT;
		this.nivel = nivel;
		activo = true;
	}

	public Integer getId_Empleado() {
		return id_Empleado;
	}

	public void setId_Empleado(Integer id_Empleado) {
		this.id_Empleado = id_Empleado;
	}

	public Integer getId_Tipo() {
		return id_Tipo;
	}

	public void setId_Tipo(Integer id_Tipo) {
		this.id_Tipo = id_Tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	public String toString(){
		StringBuilder buff = new StringBuilder();
		buff.append("ID: " + id.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("ID Empleado: " + id_Empleado.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("ID Tipo producto: " + id_Tipo.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Nivel: " + nivel.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Activo: " + activo.toString());
		buff.append(System.getProperty("line.separator"));
		
		return buff.toString();
	}
}