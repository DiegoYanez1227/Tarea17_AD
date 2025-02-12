package ejecutadores;

import model.AlumnoDAO;
import model.AlumnoBD;
import vista.IVista;
import vista.VistaConsola;
import controlador.Controlador;


public class EjecutadorBD {

	public static void main(String[] args) {
		AlumnoDAO modelo = new AlumnoBD();
		IVista vista = new VistaConsola();
		new Controlador().ejecutar(modelo, vista);

	}

}
