/**
 * 
 */
package Negocio.Empleado;

public class TEmpleado {
	
	private Integer id;
	private String nombre;
	private String DNI;
	private String apellidos;
	private Integer edad;
	private Integer sueldo;
	private boolean activo;
	
	public TEmpleado() {}
	
	public TEmpleado(Integer id){
		this.id = id;
	}
	
	public TEmpleado(String DNI, Integer sueldo, Integer edad, String apellidos, String nombre){
		this.sueldo = sueldo;
		this.edad = edad;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.DNI = DNI;
		activo = true;
	}

	public TEmpleado(String DNI, Integer sueldo, Integer edad, String apellidos, String nombre, Integer id){
		this.sueldo = sueldo;
		this.edad = edad;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.DNI = DNI;
		activo = true;
	}
	
	@Override
	public String toString(){
		StringBuilder buff = new StringBuilder();
		buff.append("ID: " + id.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("DNI: " + DNI);
		buff.append(System.getProperty("line.separator"));
		buff.append("Nombre: " + nombre);
		buff.append(System.getProperty("line.separator"));
		buff.append("Apellidos: " + apellidos);
		buff.append(System.getProperty("line.separator"));
		buff.append("Edad: " + edad.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Sueldo: " + sueldo.toString());
		buff.append(System.getProperty("line.separator"));
		return buff.toString();		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}
	
	public Integer getTipo(){
		return -1;
	};

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getSueldo() {
		return sueldo;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}
	
	public boolean getActivo(){
		return activo;
	}
	
	public void setActivo(boolean activo){
		this.activo = activo;
	}
	
	public void copy(TEmpleado te){
		this.sueldo = te.sueldo;
		this.edad = te.edad;
		this.apellidos = te.apellidos;
		this.nombre = te.nombre;
		this.DNI = te.DNI;
	}
	

}