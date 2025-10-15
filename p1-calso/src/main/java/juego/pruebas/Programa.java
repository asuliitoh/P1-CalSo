package juego.pruebas;

import java.util.logging.Logger;

import juego.geometria.Punto;

public class Programa {

    public static void main(String[] args) {
      Logger logger = Logger.getLogger(Programa.class.getName());
      Punto punto1 = new Punto();

      Punto[] puntos = new Punto[2]; 
      puntos[0] = punto1;
      
      String info = ""; 

      for (Punto punto : puntos)
    	  info = info.concat(punto.toString());

     String mensaje = (info.equals("")) ? "no hay puntos" : info; 

     logger.info(mensaje);
    }
}
