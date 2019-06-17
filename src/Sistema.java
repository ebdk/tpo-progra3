import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private List<Carta> todasLasCartas;
    private int combinatoria;

    private Parseador parseador;
    private Combinador combinador;

    public Sistema(Parseador parseador, Combinador combinador) {
        combinatoria = 0;
        todasLasCartas = new ArrayList<>();
        setParseador(parseador);
        setCombinador(combinador);
    }

    public void ejecutar() throws IOException {
        parseador.procesarArchivo();
        printCartas();
        Palo.printPalos();
        //combinador.conseguirResultado();
    }

    public List<Carta> getTodasLasCartas() {
        return todasLasCartas;
    }

    public void agregarCarta(Carta carta) {
        todasLasCartas.add(carta);
    }

    private int getCombinatoria() {
        return combinatoria;
    }

    public void setCombinatoria(int combinatoria) {
        this.combinatoria = combinatoria;
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
    }

    public void printCartas() {
        for (Carta carta : todasLasCartas) {
            carta.printCarta();
        }
    }

}
