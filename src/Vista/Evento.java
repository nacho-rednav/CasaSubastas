/**
 * 
 */
package Vista;


public class Evento {
	/*
	 * La numeración que he usado es según el orden en el que vienen los módulos en la SRS en el punto 2.2 de la SRS,
	 * de eso depende que sea 100 o 200 o 300. En este caso como lote es el primero por eso es 100.
	 * Después, los casos de usos según el orden en el que están en la SRS. Como Crear Lote es el primero
	 * de Lote, por eso es el 101.
	 * Todo evento tiene un evento antecesor, que es el que saca la vista esos son el mismo número poero con un cero al final
	 * */
	
	public static final int INIT_MENU = 0;
	
	public static final int CREAR_LOTE = 101;
	public static final int INIT_CREAR_LOTE = 1010;
	public static final int BAJA_LOTE = 102;
	public static final int INIT_BAJA_LOTE = 1020;
	public static final int MODIFICAR_LOTE = 103;
	public static final int INIT_MODIFICAR_LOTE = 1030;
	public static final int TRAER_MODIFICAR_LOTE = 1031;	
	public static final int LISTAR_LOTES_SUBASTA = 104;
	public static final int INIT_LISTAR_LOTES_SUBASTA = 1040;
	public static final int LISTAR_LOTES_ALMACEN = 105;
	public static final int INIT_LISTAR_LOTES_ALMACEN = 1050;
	public static final int LISTAR_LOTES_TIPO = 106;
	public static final int INIT_LISTAR_LOTES_TIPO = 1060;
	public static final int INIT_MOSTRAR_LOTE = 1070;
	public static final int MOSTRAR_LOTE = 107;
	public static final int INIT_COMPRAR_LOTE = 1080;
	public static final int COMPRAR_LOTE = 108;
	
	public static final int CREAR_ALMACEN = 201;
	public static final int INIT_CREAR_ALMACEN = 2010;
	public static final int ELIMINAR_ALMACEN = 202;
	public static final int INIT_ELIMINAR_ALMACEN = 2020;
	public static final int MODIFICAR_ALMACEN = 203;
	public static final int MODIFICAR_ALMACEN_TRAER = 20301;
	public static final int INIT_MODIFICAR_ALMACEN = 2030;
	public static final int MOSTRAR_ALMACEN = 204;
	public static final int INIT_MOSTRAR_ALMACEN = 2040;
	public static final int LISTAR_ALMACEN = 205;
	
	public static final int ALTA_CLIENTE = 501;
	public static final int INIT_ALTA_CLIENTE = 5010;
	public static final int MOSTRAR_CLIENTE = 502;
	public static final int INIT_MOSTRAR_CLIENTE = 5020;
	public static final int BAJA_CLIENTE = 503;
	public static final int INIT_BAJA_CLIENTE = 5030;
	public static final int MODIFICAR_CLIENTE = 504;
	public static final int MODIFICAR_CLIENTE_TRAER = 50401;
	public static final int INIT_MODIFICAR_CLIENTE = 5040;
	public static final int LISTAR_CLIENTE = 505;
	
	public static final int CREAR_SUBASTA = 401;
	public static final int INIT_CREAR_SUBASTA = 4010;
	public static final int ELIMINAR_SUBASTA = 402;
	public static final int INIT_ELIMINAR_SUBASTA = 4020;
	public static final int MODIFICAR_SUBASTA = 403;
	public static final int MODIFICAR_SUBASTA2 = 4031;
	public static final int INIT_MODIFICAR_SUBASTA = 4030;
	public static final int LISTAR_SUBASTAS = 404;
	public static final int MOSTRAR_SUBASTA = 405;
	public static final int INIT_MOSTRAR_SUBASTA = 4050;
	
	
	public static final int INIT_ALTA_EMPLEADO = 3010;
	public static final int INIT_ALTA_EMPLEADO_COMPLETA = 301001;
	public static final int ALTA_EMPLEADO_COMPLETA = 30101;
	public static final int INIT_ALTA_EMPLEADO_PARTIDA = 301002;
	public static final int ALTA_EMPLEADO_PARTIDA = 30102;
	public static final int INIT_BAJA_EMPLEADO = 3021;
	public static final int BAJA_EMPLEADO = 302;
	public static final int INIT_MODIFICAR_EMPLEADO = 3031;
	public static final int MODIFICAR_EMPLEADO = 30300;
	public static final int MODIFICAR_EMPLEADO_ID = 30301;
	public static final int MODIFICAR_EMPLEADO_FINAL = 30302;
	public static final int INIT_MOSTRAR_EMPLEADO = 3041;
	public static final int MOSTRAR_EMPLEADO = 304;
	public static final int LISTAR_EMPLEADO = 305;
	
	public static final int ALTA_TIPO = 701;
	public static final int INIT_ALTA_TIPO = 7010;
	public static final int BAJA_TIPO = 702;
	public static final int INIT_BAJA_TIPO = 7020;
	public static final int LISTAR_TIPOS = 703;
	public static final int MODIFICAR_TIPO = 704;
	public static final int MODIFICAR_TRAER_TIPO = 70401;
	public static final int INIT_MODIFICAR_TIPO = 7040;
	public static final int MOSTRAR_TIPO = 705;
	public static final int INIT_MOSTRAR_TIPO = 7050;
	
	public static final int INIT_CREAR_VINCULACION = 8010;
	public static final int CREAR_VINCULACION = 801;
	public static final int INIT_ELIMINAR_VINCULACION = 8020;
	public static final int ELIMINAR_VINCULACION = 802;
	public static final int LISTAR_VINCULACIONES = 803;
	public static final int INIT_LISTAR_VINCULACIONES_ALMACEN = 8040;
	public static final int LISTAR_VINCULACIONES_ALMACEN = 804;
	public static final int INIT_LISTAR_VINCULACIONES_EMPLEADO = 8050;
	public static final int LISTAR_VINCULACIONES_EMPLEADO = 805;
	
	public static final int INIT_CREAR_ESPECIALIDAD = 9010;
	public static final int CREAR_ESPECIALIDAD = 901;
	public static final int INIT_BAJA_ESPECIALIDAD = 9020;
	public static final int BAJA_ESPECIALIDAD = 902;
	public static final int MODIFICAR_ESPECIALIDAD = 903;
	public static final int INIT_MODIFICAR_ESPECIALIDAD = 9030;
	public static final int TRAER_MODIFICAR_ESPECIALIDAD = 9031;
	public static final int INIT_MOSTRAR_ESPECIALIDAD = 9040;
	public static final int MOSTRAR_ESPECIALIDAD = 904;
	public static final int INIT_LISTAR_ESPECIALIDAD_EMPLEADO = 9050;
	public static final int LISTAR_ESPECIALIDAD_EMPLEADO = 905;
	public static final int INIT_LISTAR_ESPECIALIDAD_TIPO = 9060;
	public static final int LISTAR_ESPECIALIDAD_TIPO = 906;
	
}