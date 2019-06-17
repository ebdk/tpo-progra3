import java.io.IOException;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {

    private Parseador parseador;
    private Combinador combinador;

    private List<Carta> todasLasCartas;
    private List<Carta> mejorCombinacion;
    private int combinatoriaMaxima;


    public Sistema(Parseador parseador, Combinador combinador) {
        combinatoriaMaxima = 0;
        todasLasCartas = new ArrayList<>();
        mejorCombinacion = new ArrayList<>();
        setParseador(parseador);
        setCombinador(combinador);
    }

    public void ejecutar() throws IOException {
        parseador.procesarArchivo();
        printCartas();
        combinador.conseguirResultado();
        mostrarMejorCombinacion();
    }

    public List<Carta> getTodasLasCartas() {
        return todasLasCartas;
    }

    public void agregarCarta(Carta carta) {
        todasLasCartas.add(carta);
    }

    private int getCombinatoriaMaxima() {
        return combinatoriaMaxima;
    }

    public void setCombinatoriaMaxima(int combinatoriaMaxima) {
        this.combinatoriaMaxima = combinatoriaMaxima;
    }

    private Parseador getParseador() {
        return parseador;
    }

    private void setParseador(Parseador parseador) {
        this.parseador = parseador;
        parseador.setSistema(this);
    }

    private Combinador getCombinador() {
        return combinador;
    }

    private void setCombinador(Combinador combinador) {
        this.combinador = combinador;
        combinador.setSistema(this);
    }

    public void printCartas() {
        Palo.printPalos();
        System.out.println("Valor de K es: " + this.getCombinatoriaMaxima());
        for (Carta carta : todasLasCartas) {
            carta.print(carta.infoCarta());
        }
    }

    public void mostrarMejorCombinacion() {
        IntSummaryStatistics gananciaOBtenida= mejorCombinacion.stream().collect(Collectors.summarizingInt(i -> i.getGanancia() + i.getGanancia()));
        System.out.println("Ganancia del mayor conjunto es : " + gananciaOBtenida.getSum());
        for (Carta carta : mejorCombinacion) {
            carta.print(carta.infoCartaExpress());
        }

    }

}
