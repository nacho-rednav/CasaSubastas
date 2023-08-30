package Integracion.Empleado;

import Negocio.Empleado.TEmpleado;
import Negocio.Empleado.TEmpleadoCompleta;
import Negocio.Empleado.TEmpleadoPartida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class DAOEmpleadoImp implements DAOEmpleado {
	private static final int ERROR_ID = -1;

	public TEmpleado bajaEmpleado(TEmpleado te) {
		modificarEmpleado(te);
		return te;
	}


	public TEmpleado altaEmpleado(TEmpleado te) {
		try{			
			Integer id = getNewId();
			te.setId(id);
		}catch(IllegalArgumentException ex){
			te.setId(ERROR_ID);
			return te;
		}
		if(te.getTipo() == 1){
			escribirCompleta((TEmpleadoCompleta)te);
		}
		else{
			escribirPartida((TEmpleadoPartida)te);
		}		
		return te;
	}


	public TEmpleado modificarEmpleado(TEmpleado te) {
		if(te.getTipo() == 1){
			escribirCompleta((TEmpleadoCompleta)te);
		}
		else{
			escribirPartida((TEmpleadoPartida)te);
		}
		return te;
	}


	public ArrayList<TEmpleado> listarEmpleados() {
		ArrayList<TEmpleado> empleadoslist = new ArrayList<TEmpleado>();
		File empleados = new File("empleadosCompleta");
		String[] empleadoslista = empleados.list();
		
		TEmpleado emp = new TEmpleado(0);
		
		for(String path : empleadoslista){
			emp = readCompleta(path);
			empleadoslist.add(emp);
		}
		
		File empleados2 = new File("empleadosPartida");
		empleadoslista = empleados2.list();
		
		for(String path : empleadoslista){
			emp = readPartida(path);
			empleadoslist.add(emp);
		}
		
		return empleadoslist;
	}
	
	
	public TEmpleado mostrarEmpleadoDNI(TEmpleado te){
		File empleados = new File("empleadosCompleta");
		String[] empleadoslist = empleados.list();
		
		TEmpleado emp = new TEmpleado(0);
		
		for(String path : empleadoslist){
			emp = readCompleta(path);
			
			if(emp.getDNI().equals(te.getDNI())){
				return emp;
			}
		}
		
		File empleados2 = new File("empleadosPartida");
		empleadoslist = empleados2.list();
		
		for(String path : empleadoslist){
			emp = readPartida(path);
			
			if(emp.getDNI().equals(te.getDNI())){
				return emp;
			}
		}
		
		return new TEmpleado(0);
		
	}


	public TEmpleado mostrarEmpleado(TEmpleado te) {
		String path = "empleado" + te.getId().toString() + ".txt";
		te = readCompleta(path);
		if(te.getId() == 0){
			te = readPartida(path);
		}
		return te;
	}
	
	
	private Integer getNewId() throws IllegalArgumentException{
		Integer res;
		try(BufferedReader br = new BufferedReader(new FileReader("id.txt"))) {
		    String line = br.readLine();
		    res = Integer.parseInt(line);
		}
		catch(IOException ex) {
			throw new IllegalArgumentException("Error occured on ID register");
		} catch(NumberFormatException nx){
			throw new IllegalArgumentException("Wrong data on ID register");
		}
		
		try(BufferedWriter out = new BufferedWriter(new FileWriter("id.txt"))) {
			Integer newId = res + 1;
			out.write(newId.toString());
		}
		catch(IOException ex) {
			throw new IllegalArgumentException("Error occured writing on ID register");
		}
		
		return res;
	}
	
	private void escribirCompleta(TEmpleadoCompleta te){
		
		String file = "empleadosCompleta/empleado"+ te.getId().toString() + ".txt";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
		    StringBuilder buff = new StringBuilder();
		    buff.append(te.getId().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(te.getActivo());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(te.getDNI());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(te.getNombre());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(te.getApellidos());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(te.getEdad().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(te.getSueldo().toString());
		    buff.append(System.getProperty("line.separator"));
			buff.append(te.gethorario().toString());
			buff.append(System.getProperty("line.separator"));
			buff.append(te.getbonus().toString());
			buff.append(System.getProperty("line.separator"));
		    bw.write(buff.toString());
		}
		catch(IOException ex) {
			throw new IllegalArgumentException("Error occured on writing");
		}
	}
	
	private void escribirPartida(TEmpleadoPartida te){
		
		String file = "empleadosPartida/empleado"+ te.getId().toString() + ".txt";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
		    StringBuilder buff = new StringBuilder();
		    buff.append(te.getId().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(te.getActivo());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(te.getDNI());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(te.getNombre());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(te.getApellidos());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(te.getEdad().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(te.getSueldo().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(te.getturno().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(te.gethorasFinSemana().toString());
		    buff.append(System.getProperty("line.separator"));
		    bw.write(buff.toString());
		}
		catch(IOException ex) {
			throw new IllegalArgumentException("Error occured on writing");
		}
	}
	
	private TEmpleado readCompleta(String path){
		TEmpleadoCompleta tc = new TEmpleadoCompleta();
		String camino;
		camino = "empleadosCompleta/" + path;
		try(BufferedReader br = new BufferedReader(new FileReader(camino))){
			
			tc.setId(Integer.parseInt(br.readLine()));
			tc.setActivo(br.readLine().equals("true"));
			tc.setDNI(br.readLine());
			tc.setNombre(br.readLine());
			tc.setApellidos(br.readLine());
			tc.setEdad(Integer.parseInt(br.readLine()));
			tc.setSueldo(Integer.parseInt(br.readLine()));
			tc.sethorario(br.readLine());
			tc.setbonus(Integer.parseInt(br.readLine()));

		}catch(IOException e){
			tc.setId(0);
			return tc;
		}
		
		return tc;
	}
	
	
	private TEmpleado readPartida(String path){
		TEmpleadoPartida tp = new TEmpleadoPartida();
		String camino;
		camino = "empleadosPartida/" + path;
		try(BufferedReader br = new BufferedReader(new FileReader(camino))){
							
			tp.setId(Integer.parseInt(br.readLine()));
			tp.setActivo(br.readLine().equals("true"));
			tp.setDNI(br.readLine());
			tp.setNombre(br.readLine());
			tp.setApellidos(br.readLine());
			tp.setEdad(Integer.parseInt(br.readLine()));
			tp.setSueldo(Integer.parseInt(br.readLine()));
			tp.setturno(br.readLine());
			tp.sethorasFinSemana(br.readLine());

		}catch(IOException o){
			tp.setId(0);
			return tp;
		}		
		return tp;
	}
	
}
