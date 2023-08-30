	
package Negocio.Empleado;

public class TEmpleadoPartida extends TEmpleado {
	
	private String turno;
	private String horasFinSemana;
	
	public TEmpleadoPartida(String horasFinSemana, String turno, String DNI, Integer sueldo, Integer edad, String apellidos, String nombre, Integer id){
		super(DNI, sueldo, edad, apellidos, nombre, id);
		this.horasFinSemana = horasFinSemana;
		this.turno = turno;
	}
	
	public TEmpleadoPartida(String horasFinSemana, String turno, String DNI, Integer sueldo, Integer edad, String apellidos, String nombre){
		super(DNI, sueldo, edad, apellidos, nombre);
		this.horasFinSemana = horasFinSemana;
		this.turno = turno;
	}
	
	public TEmpleadoPartida(){
		
	}
	
	@Override
	public String toString(){
		StringBuilder buff = new StringBuilder();
		buff.append(super.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Horas Finde Semana: " + horasFinSemana);
		buff.append(System.getProperty("line.separator"));
		buff.append("Turno: " + turno);
		buff.append(System.getProperty("line.separator"));
		return buff.toString();		
	}
	
	@Override
	public Integer getTipo(){
		return 0;
	}
	
	public String getturno() {
		return turno;
	}

	public void setturno(String turn0) {
		turno = turn0;
	}
	
	public String gethorasFinSemana() {
		return horasFinSemana;
	}

	public void sethorasFinSemana(String h0rasFinSemana) {
		this.horasFinSemana = h0rasFinSemana;
	}
	
	public void copy(TEmpleadoPartida tp){
		super.copy(tp);
		this.horasFinSemana = tp.horasFinSemana;
		this.turno = tp.turno;
	}
}