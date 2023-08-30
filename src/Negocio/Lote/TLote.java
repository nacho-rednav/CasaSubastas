/**
 * 
 */
package Negocio.Lote;


public class TLote {
	
	private Integer id;
	private Integer id_Almacen;
	private Integer id_Tipo;
	private Integer id_Subasta;
	private Integer id_Comprador;
	private Double precioSalida;
	private Double precioVenta;
	private String nombre;
	private String descripcion;
	private Boolean vendido;
	private Boolean activo;
	
	public TLote() {}
	
	public TLote(Integer id){
		this.id = id;
	}
	
	public TLote(String nombre, String desc, Integer id_Almacen,
			Integer id_Tipo, Integer id_Subasta, Double precio){
		this.nombre = nombre;
		this.descripcion = desc;
		this.id_Almacen = id_Almacen;
		this.id_Tipo = id_Tipo;
		this.id_Subasta = id_Subasta;
		id_Comprador = 0;
		precioSalida = precio;
		precioVenta = 0.0;
		vendido = false;
		activo = true;
	}

	@Override
	public String toString(){
		StringBuilder buff = new StringBuilder();
		buff.append("ID: " + id.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Nombre: " + nombre);
		buff.append(System.getProperty("line.separator"));
		buff.append("Almacen: " + id_Almacen.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Tipo producto: " + id_Tipo.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Subasta: " + id_Subasta.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Descripcion: " + descripcion);
		buff.append(System.getProperty("line.separator"));
		buff.append("Activo: " + activo.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Precio Salida: " + precioSalida.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Vendido: " + vendido.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Precio Venta: " + precioVenta.toString());
		buff.append(System.getProperty("line.separator"));
		buff.append("Comprador: " + id_Comprador.toString());
		return buff.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_Almacen() {
		return id_Almacen;
	}

	public void setId_Almacen(Integer id_Almacen) {
		this.id_Almacen = id_Almacen;
	}

	public Integer getId_Tipo() {
		return id_Tipo;
	}

	public void setId_Tipo(Integer id_Tipo) {
		this.id_Tipo = id_Tipo;
	}

	public Integer getId_Subasta() {
		return id_Subasta;
	}

	public void setId_Subasta(Integer id_Subasta) {
		this.id_Subasta = id_Subasta;
	}

	public Integer getId_Comprador() {
		return id_Comprador;
	}

	public void setId_Comprador(Integer id_Comprador) {
		this.id_Comprador = id_Comprador;
	}

	public Double getPrecioSalida() {
		return precioSalida;
	}

	public void setPrecioSalida(Double precioSalida) {
		this.precioSalida = precioSalida;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getVendido() {
		return vendido;
	}

	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}