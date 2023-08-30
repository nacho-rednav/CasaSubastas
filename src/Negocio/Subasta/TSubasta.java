/**
 * 
 */
package Negocio.Subasta;

public class TSubasta {

	private Integer id;
	private String titulo;
	private String descripcion;
	private Boolean activo;
	
	public TSubasta() {}
	
	public TSubasta(Integer id) {
		this.id = id;
	}
	
	public TSubasta(String titulo, String desc){
		this.titulo = titulo;
		this.descripcion = desc;
		activo = true;
		id = 0;
	}
	
	public TSubasta(Integer id, boolean activo, String titulo, String desc){
		this.titulo = titulo;
		this.descripcion = desc;
		this.activo = activo;
		this.id = id;
	}
	
	@Override
	public String toString(){
		StringBuilder buff = new StringBuilder();
		buff.append("ID: " + id.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Activo: " + activo.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Titulo: " + titulo);
		buff.append(System.getProperty("line.separator"));
		buff.append("Descripcion: " + descripcion);
		return buff.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripción) {
		this.descripcion = descripción;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public void copy(TSubasta ts){
		this.id = ts.id;
		this.titulo = ts.titulo;
		this.activo = ts.activo;
		this.descripcion = ts.descripcion;
	}
}