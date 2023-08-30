/**
 * 
 */
package Integracion.Subasta;
import Negocio.Subasta.TSubasta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DAOSubastaImp implements DAOSubasta {

	public final static int ERROR = -1;
	public final static int NULL = 0;
	
	public TSubasta crearSubasta(TSubasta tSubasta) {
		try{
			Integer id = getNewId();
			tSubasta.setId(id);
		}catch(IllegalArgumentException ex){
			tSubasta.setId(ERROR);
			return tSubasta;
		}
		escribir(tSubasta);
		return tSubasta;
	}

	public TSubasta eliminarSubasta(TSubasta tSubasta) {
		modificarSubasta(tSubasta);
		return tSubasta;
	}
	
	public TSubasta mostrarSubasta(TSubasta tSubasta) {
		String path = "subastas/subasta" + tSubasta.getId().toString() + ".txt";
		tSubasta = read(path);
		if(tSubasta.getTitulo() == null){
			tSubasta.setId(NULL);
		}
		return tSubasta;
	}

	public TSubasta modificarSubasta(TSubasta tSubasta) {
		escribir(tSubasta);
		return tSubasta;
	}

	public ArrayList<TSubasta> listarSubastas() {
		ArrayList<TSubasta> list = new ArrayList<TSubasta>();
		
		File subastas = new File("subastas");
		String[] listOfSubastas = subastas.list();
		TSubasta aux = new TSubasta();
		for(String path : listOfSubastas){
			aux = read("subastas/"+path); 
			list.add(aux);
		}	
		return list;
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
	
	private void escribir(TSubasta ts){
		String file = "subastas/subasta"+ ts.getId().toString() + ".txt";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
		    StringBuilder buff = new StringBuilder();
		    buff.append(ts.getId().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(ts.getActivo().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(ts.getTitulo());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(ts.getDescripcion());
		    bw.write(buff.toString());
		}
		catch(IOException ex) {
			throw new IllegalArgumentException("Error occured on writing");
		}
	}
	
	private TSubasta read(String path){
		TSubasta ts = new TSubasta();
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			ts.setId(Integer.parseInt(br.readLine()));
			ts.setActivo(br.readLine().equals("true"));
			ts.setTitulo(br.readLine());
			ts.setDescripcion(br.readLine());
		}catch(IOException e){
			return ts;
		}
		return ts;
	}

	public TSubasta mostrarSubasta_Nombre(TSubasta tSubasta) {
		File subastas = new File("subastas");
		String[] listOfSubastas = subastas.list();
		TSubasta aux = new TSubasta();
		for(String path : listOfSubastas){
			aux = read("subastas/"+path); 
			if(aux.getTitulo().equals(tSubasta.getTitulo())){
				tSubasta.copy(aux);
				return tSubasta;
			}
		}	
		return tSubasta;
	}
}