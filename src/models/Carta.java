package models;

public class Carta {

    private Palo palo;
    private int beneficio;
    private int posicion;

    public Carta(Palo palo, int posicion, int beneficio) {
        this.palo = palo;
        this.beneficio = beneficio;
        this.posicion = posicion;
    }

    public Carta() {
    }

    public int getGanancia() {
        return palo.getValor() + beneficio + posicion;
    }

    public Palo getPalo() {
        return palo;
    }

    public String infoCarta() {
        return infoCartaExpress() + " (Beneficio: " + this.beneficio + ") su Ganancia es: " + getGanancia();
    }

    public String infoCartaExpress() {
        return this.posicion + " de " + this.palo.getNombre();
    }

    public void print(String string) {
        System.out.println(string);
    }

    public String toString() {
        return "{ " + infoCartaExpress() + ", " + getGanancia() + " }";
    }
}
