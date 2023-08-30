
package Negocio.Tipodeproducto;

public class TTipo {
	
	private Integer id;

	private String titulo;

	private String descripcion;
	
	public TTipo(String titulo, String descripcion) {
		this.titulo = titulo;
		this.descripcion = descripcion;
	}

	public TTipo(Integer id) {
		this.id = id;
	}
	
	public TTipo() {};

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

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String toString(){
		StringBuilder buff = new StringBuilder();
		buff.append("ID: " + id.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Titulo: " + titulo);
		buff.append(System.getProperty("line.separator"));
		buff.append("Descripcion: " + descripcion);
		return buff.toString();
	}
}