public class Carta {

    private Palo palo;
    private int beneficio;
    private int valor;

    public Carta(Palo palo, int valor, int beneficio) {
        this.palo = palo;
        this.beneficio = beneficio;
        this.valor = valor;
    }

    public Carta() {
    }

    public int getGanancia() {
        return palo.getValor() + beneficio + valor;
    }

    public String infoCarta() {
        return infoCartaExpress() + " (Beneficio: " + this.beneficio + ") su Ganancia es: " + getGanancia();
    }

    public String infoCartaExpress() {
        return this.valor + " de " + this.palo.getNombre();
    }

    public void print(String string) {
        System.out.println(string);
    }

}
