package repoblacion.modelo;

public class Arbol {
    private Especie especie;
    private Posicion posicion;

    // CONSTRUCTORES
    public Arbol(Especie especie, Posicion posicion) {
        setEspecie(especie);
        setPosicion(posicion);
    }

    public Arbol(Arbol a) {
        if (a == null) {
            throw new NullPointerException("ERROR: No se puede copiar un árbol nulo.");
        }
        setEspecie(a.getEspecie());
        setPosicion(a.getPosicion());
    }

    // GETTERS
    public Especie getEspecie() {
        return especie;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    // SETTERS
    private void setEspecie(Especie especie) {
        if (especie == null) {
            throw new NullPointerException("ERROR: La especie no puede ser nula.");
        }
        this.especie = especie;
    }

    private void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new NullPointerException("ERROR: La posición no puede ser nula.");
        }
        this.posicion = posicion;
    }

    // MÉTODO toString
    @Override
    public String toString() {
        return "especie=" + especie + ", posicion=(" + posicion + ")";
    }

}
