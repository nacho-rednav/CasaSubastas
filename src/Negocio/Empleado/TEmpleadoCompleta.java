/**
 * 
 */
package Negocio.Empleado;

public class TEmpleadoCompleta extends TEmpleado {
	
	private Integer bonus;
	private String horario;
	
	public TEmpleadoCompleta(Integer bonus, String horario, String DNI, Integer sueldo, Integer edad, String apellidos, String nombre){
		super(DNI, sueldo, edad, apellidos, nombre);
		this.bonus = bonus;
		this.horario = horario;
	}
	
	public TEmpleadoCompleta(Integer bonus, String horario, String DNI, Integer sueldo, Integer edad, String apellidos, String nombre, Integer id){
		super(DNI, sueldo, edad, apellidos, nombre, id);
		this.bonus = bonus;
		this.horario = horario;
	}
	
	public TEmpleadoCompleta(){
		
	}
	
	@Override
	public String toString(){
		StringBuilder buff = new StringBuilder();
		buff.append(super.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Bonus: " + bonus.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Horario: " + horario);
		buff.append(System.getProperty("line.separator"));
		return buff.toString();		
	}
	
	public String gethorario() {
		return horario;
	}
	
	@Override
	public Integer getTipo(){
		return 1;
	}

	public void sethorario(String h0rario) {
		horario = h0rario;
	}
	
	public Integer getbonus() {
		return bonus;
	}

	public void setbonus(Integer bonus) {
		this.bonus = bonus;
	}
	
	public void copy(TEmpleadoCompleta te){
		super.copy(te);
		this.bonus = te.bonus;
		this.horario = te.horario;
	}
}