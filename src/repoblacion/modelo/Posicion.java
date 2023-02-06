package repoblacion.modelo;

public class Posicion {
    private double x, y;

    // CONSTRUCTORES
    public Posicion(double x, double y) {
        setX(x);
        setY(y);
    }

    public Posicion(Posicion p) {
        if (p == null) {
            throw new NullPointerException("ERROR: No se puede copiar una posición nula.");
        }
        setX(p.getX());
        setY(p.getY());
    }

    // GETTERS
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // SETTERS
    private void setX(double x) {
        this.x = x;
    }

    private void setY(double y) {
        this.y = y;
    }

    // MÉTODO distancia
    public double distancia(Posicion posicion) {
        if (posicion == null) {
            throw new NullPointerException("ERROR: No se puede calcular la distancia a una posición nula.");
        }
        double x2 = posicion.getX();
        double y2 = posicion.getY();
        double distancia = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
        return distancia;
    }

    // MÉTODO toString
    @Override
    public String toString() {
        return "x=" + String.format("%.3f", x) + ", y=" + String.format("%.3f", y);
    }
}


