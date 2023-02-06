package repoblacion;

import repoblacion.modelo.Bosque;
import repoblacion.utilidades.Consola;

public class MainApp {

    public static void main(String[] args) {
        int ancho, alto, poblacion;
        try {
            ancho = Consola.leerAnchura();
            alto = Consola.leerAltura();
            int perimetro = 2 * (ancho + alto);
            do {
                poblacion = Consola.leerPoblacion();
            } while (poblacion <= 0 || poblacion > perimetro);
            Bosque bosque = new Bosque(ancho, alto, poblacion);
            System.out.println("Árbol más cercano: " + bosque.getArbolMasCentrado());
            System.out.println("Árbol más alejado: " + bosque.getArbolMasAlejado());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
