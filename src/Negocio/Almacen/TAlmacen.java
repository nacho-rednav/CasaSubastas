/**
 * 
 */
package Negocio.Almacen;


public class TAlmacen {
	
	private Integer id;
	
	private String nombre;
	
	private Integer metrosCuadrados;
	
	private Integer altura;
	
	private Integer temperatura;
	
	private Boolean activo;
	
	public TAlmacen(Integer id) {
		this.id = id;
	}
	
	public TAlmacen(String n, Integer mC, Integer a, Integer t) {
		nombre = n;
		metrosCuadrados = mC;
		altura = a;
		temperatura = t;
		activo = true;
	}

	public String toString(){
		StringBuilder buff = new StringBuilder();
		buff.append("ID: " + id.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Nombre: " + nombre);
		buff.append(System.getProperty("line.separator"));
		buff.append("Temperatura: " + temperatura.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Metros cuadrados: " + metrosCuadrados.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Alturta: " + altura.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Activo: " + activo.toString());
		return buff.toString();
	}
	
	public Integer getID() {
		return id;
	}

	public void setID(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(Integer metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Integer getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}