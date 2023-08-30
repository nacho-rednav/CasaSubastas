
package Integracion.Tipodeproducto;

import Negocio.Tipodeproducto.TTipo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DAOTipoImp implements DAOTipo {
	
	public Integer altaTipoProducto(TTipo TTipo) {
		Integer id = getNewId();
		TTipo.setId(id);
		escribir(TTipo);
		return id;
	}

	public Integer bajaTipoProducto(TTipo t) {
		String path = "tiposProducto/tipoProducto" + t.getId() + ".txt";
		File vinc = new File(path);
		if(vinc.delete())
			return t.getId();
		else
			return 0;
	}

	public ArrayList<TTipo> listarTiposProducto() {
		ArrayList<TTipo> tipos = new ArrayList<TTipo>();
		
		File datos = new File("tiposProducto"); 
		String[] listOfTipos = datos.list();
		
		TTipo ret = new TTipo();
		
		for(String path : listOfTipos){ 
			ret = read("tiposProducto/"+path);
			tipos.add(ret);
		}
		return tipos;
	}

	public Integer modificarTipoProducto(TTipo TTipo) {
		escribir(TTipo);
		return TTipo.getId();
	}

	public TTipo mostrarTipoProducto(TTipo TTipo) {
		String path = "tiposProducto/tipoProducto" + TTipo.getId().toString() + ".txt"; 
		TTipo res = read(path);
		return res;
	}
	
	public TTipo mostrarTipoProducto_Titulo(TTipo t){
		File tipos = new File("tiposProducto");
		String[] listOfTipos = tipos.list();
		
		TTipo ret = new TTipo(0);
		
		for(String path : listOfTipos){
			ret = read("tiposProducto/"+path); 
			
			if(ret.getTitulo().equals(t.getTitulo())){
				return ret;
			}
		}	
		return new TTipo(0);
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
	
	private void escribir(TTipo t){
		String file = "tiposProducto/tipoProducto"+ t.getId().toString() + ".txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
		    StringBuilder buff = new StringBuilder();
		    buff.append(t.getId().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(t.getTitulo());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(t.getDescripcion());
		    bw.write(buff.toString());
		}
		catch(IOException ex) {
			throw new IllegalArgumentException("Error occured on writing");
		}
	}
	
	private TTipo read(String path){
		TTipo tt = new TTipo();
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			tt.setId(Integer.parseInt(br.readLine()));
			tt.setTitulo(br.readLine());
			tt.setDescripcion(br.readLine());

		}catch(IOException e){
			return new TTipo(0);
		}
		
		return tt;
	}
}