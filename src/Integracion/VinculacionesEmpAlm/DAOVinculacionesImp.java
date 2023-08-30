/**
 * 
 */
package Integracion.VinculacionesEmpAlm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Negocio.VinculacionesEmpAlm.TVinculacion;

public class DAOVinculacionesImp implements DAOVinculaciones{

	@Override
	public TVinculacion crearVinculacion(TVinculacion tv) {
		escribir(tv);
		return tv;
	}

	@Override
	public Integer eliminarVinculacion(TVinculacion tv) {
		String path = "vinculaciones/vinculacion" + tv.getIdAlmacen() + tv.getIdEmpleado() + ".txt";
		File vinc = new File(path);
		if(vinc.delete())
			return 1;
		else
			return 0;
	}

	@Override
	public ArrayList<TVinculacion> listar() {
		ArrayList<TVinculacion>vincs = new ArrayList<TVinculacion>();
		
		File datos = new File("vinculaciones");
		String[] listOfVincs = datos.list();
		
		TVinculacion ret = new TVinculacion(0);
		
		for(String path : listOfVincs){
			ret = read("vinculaciones/"+path); 
			vincs.add(ret);
		}
		return vincs;
	}

	@Override
	public ArrayList<TVinculacion> listarPorAlmacen(TVinculacion tv) {
		ArrayList<TVinculacion>vincs = new ArrayList<TVinculacion>();
		
		File datos = new File("vinculaciones");
		String[] listOfVincs = datos.list();
		
		TVinculacion ret = new TVinculacion(0);
		
		for(String path : listOfVincs){
			ret = read("vinculaciones/"+path);
			if(ret.getIdAlmacen() == tv.getIdAlmacen())
				vincs.add(ret);
		}
		return vincs;
	}

	@Override
	public ArrayList<TVinculacion> listarPorEmpleado(TVinculacion tv) {
		ArrayList<TVinculacion>vincs = new ArrayList<TVinculacion>();
		
		File datos = new File("vinculaciones");
		String[] listOfVincs = datos.list();
		
		TVinculacion ret = new TVinculacion(0);
		
		for(String path : listOfVincs){
			ret = read("vinculaciones/"+path);
			if(ret.getIdEmpleado() == tv.getIdEmpleado())
				vincs.add(ret);
		}
		return vincs;
	}
	
	private void escribir(TVinculacion tv){
		String file = "vinculaciones/vinculacion"+ tv.getIdAlmacen() + tv.getIdEmpleado() + ".txt";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
		    StringBuilder buff = new StringBuilder();
		    buff.append(tv.getIdAlmacen());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tv.getIdEmpleado());
		    buff.append(System.getProperty("line.separator"));
		    bw.write(buff.toString());
		}
		catch(IOException ex) {
			throw new IllegalArgumentException("Error occured on writing");
		}
	}
	
	private TVinculacion read(String path){
		TVinculacion tv = new TVinculacion(0);
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			tv.setIdAlmacen(Integer.parseInt(br.readLine()));
			tv.setIdEmpleado(Integer.parseInt(br.readLine()));

		}catch(IOException e){
			return new TVinculacion(0);
		}
		
		return tv;
	}

	@Override
	public boolean existeVinculacion(TVinculacion tv) {
		String path = "vinculaciones/vinculacion" + tv.getIdAlmacen() + tv.getIdEmpleado() + ".txt";
		TVinculacion res = read(path);
		return res.getIdAlmacen() > 0;
	}
}