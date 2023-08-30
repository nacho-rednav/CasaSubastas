/**
 * 
 */
package Integracion.Almacen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Negocio.Almacen.TAlmacen;


public class DAOAlmacenImp implements DAOAlmacen {
	
	public Integer crearAlmacen(TAlmacen tAlmacen) {
		Integer id = getNewId();
		tAlmacen.setID(id);
		escribir(tAlmacen);
		
		return tAlmacen.getID();
	}

	public Integer eliminarAlmacen(TAlmacen tAlmacen) {
		modificarAlmacen(tAlmacen);
		return tAlmacen.getID();
	}

	public Integer modificarAlmacen(TAlmacen tAlmacen) {
		escribir(tAlmacen);
		return tAlmacen.getID();
	}

	public TAlmacen mostrarAlmacen_Nombre(TAlmacen tAlmacen) {
		File almacenes = new File("almacenes");
		String [] listaDeAlmacenes = almacenes.list();
		
		TAlmacen ret = new TAlmacen(0);
		
		for (String path : listaDeAlmacenes) {
			ret = read("almacenes/" + path);
			if (ret.getNombre().equals(tAlmacen.getNombre()))
				return ret;
		}
		return new TAlmacen(0);
	}
	
	public TAlmacen mostrarAlmacen(TAlmacen tAlmacen) {
		String path = "almacenes/almacen" + tAlmacen.getID().toString() + ".txt";
		TAlmacen res = read(path);
		return res;
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
	
	private void escribir(TAlmacen ta){
		
		String file = "almacenes/almacen"+ ta.getID().toString() + ".txt";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
		    StringBuilder buff = new StringBuilder();
		    buff.append(ta.getID().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(ta.getNombre());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(ta.getMetrosCuadrados().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(ta.getAltura().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(ta.getTemperatura().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(ta.getActivo().toString());
		    buff.append(System.getProperty("line.separator"));
		    
		    bw.write(buff.toString());
		}
		catch(IOException ex) {
			throw new IllegalArgumentException("Error occured on writing");
		}
	}
	
	private TAlmacen read(String path) {
		TAlmacen ta = new TAlmacen(null);
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			ta.setID(Integer.parseInt(br.readLine()));
			ta.setNombre(br.readLine());
			ta.setMetrosCuadrados(Integer.parseInt(br.readLine()));
			ta.setAltura(Integer.parseInt(br.readLine()));
			ta.setTemperatura(Integer.parseInt(br.readLine()));
			ta.setActivo(br.readLine().equals("true"));
			
		} catch(IOException e){
			return new TAlmacen(0);
		}
		
		return ta;
	}

	@Override
	public ArrayList<TAlmacen> listarAlmacen() {
		ArrayList<TAlmacen> list = new ArrayList<TAlmacen>();
		
		File alms = new File("almacenes");
		String[] listOfAlms = alms.list();
		TAlmacen aux = new TAlmacen(0);
		for(String path : listOfAlms){
			aux = read("almacenes/"+path); 
			list.add(aux);
		}	
		return list;
	}
}