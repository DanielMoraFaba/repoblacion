package repoblacion.utilidades;

import org.iesalandalus.programacion.utilidades.Entrada;
import repoblacion.modelo.Bosque;

public class Consola {

    private Consola() {

    }

    // MÉTODO leerAnchura
    public static int leerAnchura() {
        int ancho;
        do {
            System.out.print("Introduce la anchura del bosque: ");
            ancho = Entrada.entero();
        } while (ancho < Bosque.MINIMO || ancho > Bosque.MAX_ANCHURA);
        return ancho;
    }

    // MÉTODO leerAltura
    public static int leerAltura() {
        int alto;
        do {
            System.out.print("Introduce la altura del bosque: ");
            alto = Entrada.entero();
        } while (alto < Bosque.MINIMO || alto > Bosque.MAX_ALTURA);
        return alto;
    }

    // MÉTODO leerPoblacion
    public static int leerPoblacion() {
        int poblacion;
        System.out.print("Introduce la población de especies: ");
        poblacion = Entrada.entero();
        return poblacion;
    }

}
