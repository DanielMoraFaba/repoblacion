package repoblacion.modelo;

public enum Especie {
    ALAMO("álamo"), ENCINA("encina"), CASTANO("castaño"), CIPRES("ciprés"), PINO("pino piñonero"), ROBLE("roble mediterráneo"), OLIVO("olivo");
    final private String cadenaAMostrar;

    Especie(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    @Override
    public String toString() {
        return "[" + cadenaAMostrar + "]";
    }
}
