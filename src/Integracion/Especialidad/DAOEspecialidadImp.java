/**
 * 
 */
package Integracion.Especialidad;

import Negocio.Especialidad.TEspecialidad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class DAOEspecialidadImp implements DAOEspecialidad {
	
	public Integer crearEspecialidad(TEspecialidad tEspecialidad) {
		Integer id = getNewId();
		
		tEspecialidad.setId(id);
		
		escribir(tEspecialidad);
		
		return id;
	}

	
	public Integer bajaEspecialidad(TEspecialidad tEspecialidad) {
		modificarEspecialidad(tEspecialidad);
		return tEspecialidad.getId();
	}

	
	public Integer modificarEspecialidad(TEspecialidad tEspecialidad) {
		escribir(tEspecialidad);
		return tEspecialidad.getId();
	}

	public TEspecialidad mostrarEspecialidad_EmpleadoTipo(TEspecialidad tEspecialidad){
		File especialidades = new File("especialidades");
		String[] listOfEspecialidades = especialidades.list();
		
		TEspecialidad ret = new TEspecialidad(0);
		
		for(String path : listOfEspecialidades){
			ret = read("especialidades/"+path); 
			
			if(ret.getId_Empleado() == tEspecialidad.getId_Empleado() &&
					ret.getId_Tipo() == tEspecialidad.getId_Tipo()){
				return ret;
			}
		}	
		return new TEspecialidad(0);
	}
	
	public TEspecialidad mostrarEspecialidad(TEspecialidad tEspecialidad) {
		String path = "especialidades/especialidad" + tEspecialidad.getId().toString() + ".txt";
		
		TEspecialidad res = read(path);
		
		return res;
	}

	
	public ArrayList<TEspecialidad> listarPorEmpleado(TEspecialidad tEspecialidad) {
		ArrayList<TEspecialidad> esps = new ArrayList<TEspecialidad>();
		
		File especialidades = new File("especialidades");
		String[] listOfEspecialidades = especialidades.list();
		
		TEspecialidad ret = new TEspecialidad();
		
		for(String path : listOfEspecialidades){
			ret = read("especialidades/"+path); 
			
			if(ret.getId_Empleado() == tEspecialidad.getId_Empleado()){
				esps.add(ret);
			}
		}
		
		return esps;
	}

	public ArrayList<TEspecialidad> listarPorTipo(TEspecialidad tEspecialidad) {
		ArrayList<TEspecialidad> esps = new ArrayList<TEspecialidad>();
		
		File especialidades = new File("especialidades");
		String[] listOfEspecialidades = especialidades.list();
		
		TEspecialidad ret = new TEspecialidad();
		
		for(String path : listOfEspecialidades){
			ret = read("especialidades/"+path); 
			
			if(ret.getId_Tipo() == tEspecialidad.getId_Tipo()){
				esps.add(ret);
			}
		}
		
		return esps;
	}
	
	private void escribir(TEspecialidad tl){
		String file = "especialidades/especialidad"+ tl.getId().toString() + ".txt";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
		    StringBuilder buff = new StringBuilder();
		    buff.append(tl.getId().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tl.getActivo().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tl.getId_Tipo().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tl.getId_Empleado().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tl.getNivel().toString());
		    bw.write(buff.toString());
		}
		catch(IOException ex) {
			throw new IllegalArgumentException("Error occured on writing");
		}
	}
	
	private TEspecialidad read(String path){
		TEspecialidad tl = new TEspecialidad();
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			tl.setId(Integer.parseInt(br.readLine()));
			tl.setActivo(br.readLine().equals("true"));
			tl.setId_Tipo(Integer.parseInt(br.readLine()));
			tl.setId_Empleado(Integer.parseInt(br.readLine()));
			tl.setNivel(Integer.parseInt(br.readLine()));

		}catch(IOException e){
			return new TEspecialidad(0);
		}
		
		return tl;
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
}