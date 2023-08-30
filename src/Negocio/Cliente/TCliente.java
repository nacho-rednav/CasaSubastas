/**
 * 
 */
package Negocio.Cliente;


public class TCliente {
	
	private String DNI;
	private String Nombre;
	private Integer Telefono;
	private String Domicilio;
	private String Correo;
	private String CuentaBancaria;
	private Boolean Activo;
	private Integer ID;
	
	public TCliente() {}
	
	public TCliente(Integer ID){
		this.ID = ID;
	}

	public TCliente(String DNI, String Nombre, Integer Telefono, String Domicilio, String Correo, String CuentaBancaria){
		this.DNI = DNI;
		this.Nombre = Nombre;
		this.Telefono = Telefono;
		this.Domicilio = Domicilio;
		this.Correo = Correo;
		this.CuentaBancaria = CuentaBancaria;
		
		Activo = true;
		
	}
	
	public String toString(){
		StringBuilder buff = new StringBuilder();
		buff.append("ID: " + ID.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Activo: " + Activo.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("DNI: " + DNI);
		buff.append(System.getProperty("line.separator"));
		buff.append("Nombre: " + Nombre);
		buff.append(System.getProperty("line.separator"));
		buff.append("Telefono: " + Telefono);
		buff.append(System.getProperty("line.separator"));
		buff.append("Domicilio: " + Domicilio);
		buff.append(System.getProperty("line.separator"));
		buff.append("Correo: " + Correo);
		buff.append(System.getProperty("line.separator"));
		buff.append("Cuenta Bancaria: " + CuentaBancaria);
		buff.append(System.getProperty("line.separator"));
		return buff.toString();		
	}
	
	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}

	public Integer getTelefono() {
		return Telefono;
	}

	public void setTelefono(Integer Telefono) {
		this.Telefono = Telefono;
	}

	public String getDomicilio() {
		return Domicilio;
	}

	public void setDomicilio(String Domicilio) {
		this.Domicilio = Domicilio;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String Correo) {
		this.Correo = Correo;
	}

	public String getCuentaBancaria(){
		return CuentaBancaria;
	}
	
	public void setCuentaBancaria(String CuentaBancaria) {
		this.CuentaBancaria = CuentaBancaria;
	}
	
	public Boolean getActivo(){
		return Activo;
	}
	
	public void setActivo(boolean activo){
		this.Activo = activo;
	}
}