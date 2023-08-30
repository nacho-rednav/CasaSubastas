/**
 * 
 */
package Integracion.Cliente;

import Negocio.Cliente.TCliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DAOClienteImp implements DAOCliente {
	
	public TCliente altaCliente(TCliente tc) {
		Integer id = getNewId();
		tc.setID(id);
		escribir(tc);
		return tc;
	}

	
	public TCliente bajaCliente(TCliente tc) {
		modificarCliente(tc);
		return tc;
	}
	
	public ArrayList<TCliente> listarCliente() {
		ArrayList<TCliente> clientelist = new ArrayList<TCliente>();
		File cliente = new File("clientes");
		String[] lsclientes = cliente.list();
		TCliente client = new TCliente();
		
		for(String path: lsclientes){
			client = read("clientes/" + path);
			clientelist.add(client);
		}
		return clientelist;
	}

	
	public TCliente modificarCliente(TCliente tc) {
		escribir(tc);
		return tc;
	}

	
	public TCliente mostrarCliente(TCliente tc) {
		String path = "clientes/cliente" + tc.getID().toString() + ".txt";
		
		tc = read(path);
		
		return tc;
	}
	
	public TCliente mostrarCliente_DNI(TCliente tc){
		File cliente = new File("clientes");
		String[] lsclientes = cliente.list();
		TCliente client = new TCliente();
		
		for(String path: lsclientes){
			client = read("clientes/" + path);
			if(client.getDNI().equals(tc.getDNI())){
				return client;
			}
		}
		return new TCliente(0);
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
	
private void escribir(TCliente tc){
		
		String file = "clientes/cliente"+ tc.getID().toString() + ".txt";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
		    StringBuilder buff = new StringBuilder();
		    buff.append(tc.getID().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tc.getActivo());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tc.getDNI().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tc.getNombre().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tc.getTelefono().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tc.getDomicilio().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tc.getCorreo().toString());
		    buff.append(System.getProperty("line.separator"));
		    buff.append(tc.getCuentaBancaria().toString());
		    buff.append(System.getProperty("line.separator"));
		    bw.write(buff.toString());

		}
		catch(IOException ex) {
			throw new IllegalArgumentException("Error occured on writing");
		}
	}
	
	private TCliente read(String path){
		TCliente tc = new TCliente();
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			tc.setID(Integer.parseInt(br.readLine()));
			tc.setActivo(br.readLine().equals("true"));
			tc.setDNI(br.readLine());
			tc.setNombre(br.readLine());
			tc.setTelefono(Integer.parseInt(br.readLine()));
			tc.setDomicilio(br.readLine());
			tc.setCorreo(br.readLine());
			tc.setCuentaBancaria(br.readLine());

		}catch(IOException e){
			return new TCliente(0);
		}
		
		return tc;
	}

}