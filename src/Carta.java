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

    public void printCarta() {

        System.out.println(this.valor + " de " + this.palo.getNombre() + " (Beneficio: " + this.beneficio + ") su Ganancia es: " + getGanancia());

    }

}
