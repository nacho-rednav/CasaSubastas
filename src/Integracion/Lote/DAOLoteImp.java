/**
 * 
 */
package Integracion.Lote;

import Negocio.Lote.TLote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class DAOLoteImp implements DAOLote {
	
	
	public Integer bajaLote(TLote tLote) {
		modificarLote(tLote);
		return tLote.getId(); 
	}

	public Integer crearLote(TLote tLote) {
		//Es igual que modificar, sólo escribe, lo único que antes de escribir debemos
		//generar un id único y asignarselo al lote
		Integer id = getNewId();
		//Esta función la usaremos para obtener IDs únicos, debe estar en todos los DAOs y usarla siemrope antes de crear
		//Haced copia y pega si queréis
		tLote.setId(id);
		
		//Escibimos los datos del lote que recibimos
		escribir(tLote);
		
		return id;
	}

	
	public ArrayList<TLote> listarLote_almacen(TLote tl) {
		ArrayList<TLote>lotes = new ArrayList<TLote>();
		
		File datos = new File("lotes");
		String[] listOfLotes = datos.list();
		
		TLote ret = new TLote();
		
		for(String path : listOfLotes){
			ret = read("lotes/"+path); 
			
			if(ret.getId_Almacen() == tl.getId_Almacen())
				lotes.add(ret);
		}
		return lotes;
	}

	
	public ArrayList<TLote> listarLote_tipo(TLote tl) {
		ArrayList<TLote>lotes = new ArrayList<TLote>();
		
		File datos = new File("lotes");
		String[] listOfLotes = datos.list();
		
		TLote ret = new TLote();
		
		for(String path : listOfLotes){
			ret = read("lotes/"+path); 
			
			if(ret.getId_Tipo() == tl.getId_Tipo())
				lotes.add(ret);
		}
		return lotes;
	}

	
	public ArrayList<TLote> listarLote_subasta(TLote tl) {
		
		ArrayList<TLote>lotes = new ArrayList<TLote>();
		
		File datos = new File("lotes");
		String[] listOfLotes = datos.list();
		
		TLote ret = new TLote();
		
		for(String path : listOfLotes){
			ret = read("lotes/"+path); 
			
			if(ret.getId_Subasta() == tl.getId_Subasta())
				lotes.add(ret);
		}
		return lotes;
	}

	
	public Integer modificarLote(TLote tLote) {
		//Modificar es solamente escribir
		escribir(tLote);
		return tLote.getId();
	}

	public TLote mostrarLote(TLote tLote) {
		//Los mostrar deben devolver un lote que tendrá los datos del lote leido
		//si existe un lote con el id que nos preguntan y si no existe deben devolver
		//un lote con id = 0 
		String path = "lotes/lote" + tLote.getId().toString() + ".txt";
		//La función read hace exactamente eso, devuelve el lote que le hemos preguntado y
		//si no lo encuentra un lote con id = 0
		TLote  res = read(path);
		
		return res;
	}
	
	public TLote mostrarLote_Nombre(TLote tLote){
		//Debe devolver el lote con los datos que te preguntan y si no lo encuentra un lote con id = 0
		
		//Así es una forma de recorrer todos los ficheros de una carpeta
		File lotes = new File("lotes");
		String[] listOfLotes = lotes.list();
		
		//Debemos incializarlo antes con ID = 0 por si no hay ningún lote guardado
		//todavía
		TLote ret = new TLote(0);
		
		for(String path : listOfLotes){
			ret = read("lotes/"+path); 
			//Leemos sobre ret cada fichero
			
			if(ret.getNombre().equals(tLote.getNombre())){
				//Si encuentro un lote con el nombre que buscaba lo devuelvo
				return ret;
			}
		}	
		//Si no he encontrado ningún lote con ese nombre, devuelvo lote con id = 0
		return new TLote(0);
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
	
	private void escribir(TLote tl){
		//He creado el directorio lotes, que es donde irán los lotes. Hay que hacer lo mismo con
		//cada módulo
		//El formato de nombre de los módulos he pensado que sea lote+id+.txt, así puedes buscarlos por id
		//Construyop el camino hasta el nuevo fichero lote
		String file = "lotes/lote"+ tl.getId().toString() + ".txt";
		//Lo abro, aunque en este caso lo creará nuevo
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
		    StringBuilder buff = new StringBuilder();
		    buff.append(tl.getId().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tl.getActivo().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tl.getNombre());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tl.getId_Almacen().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tl.getId_Tipo().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tl.getId_Subasta().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tl.getId_Comprador().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tl.getDescripcion());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tl.getVendido().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tl.getPrecioSalida().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tl.getPrecioVenta().toString());
		    //Tras meter todos los datos en el StringBuilder, lo meto al fichero
		    bw.write(buff.toString());
		}
		catch(IOException ex) {
			throw new IllegalArgumentException("Error occured on writing");
		}
	}
	
	private TLote read(String path){
		//Recibe un path en el que se supone debe estar el fichero que va a leer con formato lotes/loteID.txt
		TLote tl = new TLote();
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			//Voy leyendo linea por linea y lo guardo
			//Cuidado con leer en orden distinto de como los guardas
			tl.setId(Integer.parseInt(br.readLine()));
			tl.setActivo(br.readLine().equals("true"));//Los booleanos se me ha ocurrido copiarlos así
			tl.setNombre(br.readLine());
			tl.setId_Almacen(Integer.parseInt(br.readLine()));
			tl.setId_Tipo(Integer.parseInt(br.readLine()));
			tl.setId_Subasta(Integer.parseInt(br.readLine()));
			tl.setId_Comprador(Integer.parseInt(br.readLine()));
			tl.setDescripcion(br.readLine());
			tl.setVendido(br.readLine().equals("true"));
			tl.setPrecioSalida(Double.parseDouble(br.readLine()));
			tl.setPrecioVenta(Double.parseDouble(br.readLine()));

		}catch(IOException e){
			//Aquí llega si no lo ha podido abrir, lo cual significa que no existe
			//lote con el ID que nos han preguntado y por eso devuelve un lote con ID = 0
			return new TLote(0);
		}
		
		return tl;
	}
}