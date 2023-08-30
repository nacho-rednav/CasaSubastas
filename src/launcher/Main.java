package launcher;

import Vista.Evento;
import Vista.Controlador.Controlador;

public class Main {

	public static void main(String[] args) {
		Controlador.getInstancia().accion(Evento.INIT_MENU, null);
	}

}
