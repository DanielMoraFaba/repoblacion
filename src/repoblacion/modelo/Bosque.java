package repoblacion.modelo;

import java.util.Arrays;
import java.util.Random;

public class Bosque {
    public static final int MAX_ALTURA = 500;
    public static final int MINIMO = 10;
    public static final int MAX_ANCHURA = 1000;
    public static final int MAX_ESPECIES = 4;
    private Arbol arbolMasAlejado;
    private Arbol arbolMasCentrado;
    private Random generador = new Random();
    private int ancho;
    private int alto;
    private Arbol[] arboles;

    // CONSTRUCTOR
    public Bosque(int ancho, int alto, int poblacion) {
        setAncho(ancho);
        setAlto(alto);
        checkPoblacion(poblacion);
        this.arboles = new Arbol[poblacion];
        repoblar();
        realizarCalculos();
    }

    // GETTERS
    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public Arbol getArbolMasAlejado() {
        return arbolMasAlejado;
    }

    public Arbol getArbolMasCentrado() {
        return arbolMasCentrado;
    }

    // SETTERS
    public void setAncho(int ancho) {
        if (ancho < MINIMO || ancho > MAX_ANCHURA) {
            throw new IllegalArgumentException("ERROR: Anchura no válida.");
        }
        this.ancho = ancho;
    }

    public void setAlto(int alto) {
        if (alto < MINIMO || alto > MAX_ALTURA) {
            throw new IllegalArgumentException("ERROR: Altura no válida.");
        }
        this.alto = alto;
    }

    // MÉTODO duplicarBosque
    public Arbol[] duplicaBosque() {
        return arboles.clone();
    }

    // MÉTODO checkPoblacion
    public void checkPoblacion(int poblacion) {
        int perimetro = 2 * (ancho + alto);
        if (poblacion <= 0) {
            throw new IllegalArgumentException("ERROR: La población debe ser mayor que cero.");
        }
        if (poblacion > perimetro) {
            throw new IllegalArgumentException("ERROR: La población no puede superar el perímetro del bosque.");
        }
    }

    // MÉTODO repoblar
    private void repoblar() {
        Especie especieAleatoria = null;
        for (int i = 0; i < arboles.length - 1; i++) {
            Posicion posicionAleatoria = new Posicion(generador.nextDouble(getAncho()) + 0, generador.nextDouble(getAlto()) + 0);
            int numRandom = generador.nextInt(7);
            if (numRandom == 0) {
                especieAleatoria = Especie.ALAMO;
            } else if (numRandom == 1) {
                especieAleatoria = Especie.CASTANO;
            } else if (numRandom == 2) {
                especieAleatoria = Especie.CIPRES;
            } else if (numRandom == 3) {
                especieAleatoria = Especie.ENCINA;
            } else if (numRandom == 4) {
                especieAleatoria = Especie.OLIVO;
            } else if (numRandom == 5) {
                especieAleatoria = Especie.PINO;
            } else if (numRandom == 6) {
                especieAleatoria = Especie.ROBLE;
            }
            if (especieAleatoria == Especie.ALAMO) {
                int seleccionarEspecie = generador.nextInt(MAX_ESPECIES);
                if (seleccionarEspecie == 0) {
                    especieAleatoria = Especie.ALAMO;
                } else if (seleccionarEspecie == 1) {
                    especieAleatoria = Especie.ENCINA;
                } else if (seleccionarEspecie == 2) {
                    especieAleatoria = Especie.PINO;
                } else if (seleccionarEspecie == 3) {
                    especieAleatoria = Especie.ROBLE;
                }
            } else if (especieAleatoria == Especie.OLIVO) {
                int seleccionarEspecie = generador.nextInt(MAX_ESPECIES);
                if (seleccionarEspecie == 0) {
                    especieAleatoria = Especie.OLIVO;
                } else if (seleccionarEspecie == 1) {
                    especieAleatoria = Especie.CIPRES;
                } else if (seleccionarEspecie == 2) {
                    especieAleatoria = Especie.PINO;
                } else if (seleccionarEspecie == 3) {
                    especieAleatoria = Especie.ROBLE;
                }
            }
            arboles[i] = new Arbol(especieAleatoria, posicionAleatoria);
        }
    }

    // MÉTODO realizarCalculos
    public void realizarCalculos() {
        Arbol masAlejado;
        Arbol masCentrado;
        masAlejado = masCentrado = arboles[0];
        for (int i = 1; i < arboles.length - 1; i++) {
            if (arboles[i].getPosicion().distancia(new Posicion(0, 0)) > masAlejado.getPosicion()
                    .distancia(new Posicion(0, 0))) {
                masAlejado = arboles[i];
            } else if (arboles[i].getPosicion().distancia(new Posicion(0, 0)) < masCentrado.getPosicion()
                    .distancia(new Posicion(0, 0))) {
                masCentrado = arboles[i];
            }
        }
        arbolMasCentrado = masCentrado;
        arbolMasAlejado = masAlejado;
    }

    // MÉTODO toString
    @Override
    public String toString() {
        return "Bosque [ancho=" + ancho + ", alto=" + alto + ", arboles=" + Arrays.toString(arboles) + "]";
    }
}
