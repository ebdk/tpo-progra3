import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sistema {

    private static Map sets;
    private static List<Carta> todasLasCartas = new ArrayList<>();
    private static int combinatoria;

    public static void ejecutar() throws IOException {
        procesarArchivo();
        printCartas();
        Palo.printPalos();

        //ordenarEnPalos();
    }

    public static void procesarArchivo() throws IOException {
        String archivoEntero = new String(Files.readAllBytes(Paths.get("cartas.txt")));

        System.out.println(archivoEntero);

        String[] separadoPorEspacios = archivoEntero.split("\\s+"); //separa entre linea 1 y 2

        analizarPrimerLinea(separadoPorEspacios[0]);
        analizarSegundaLinea(separadoPorEspacios[1]);

    }

    public static void procesarArchivo3() throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        List<String> archivoEntero = Files.readAllLines(Paths.get("cartas.txt"), charset);

    }

    private static void analizarPrimerLinea(String separadoPorEspacio) {

        String[] separadoPorPuntoComa = separadoPorEspacio.split(";");
        combinatoria = Integer.parseInt(separadoPorPuntoComa[1]); //setea el K

        String[] separadoPorMenos = separadoPorPuntoComa[0].split("-"); //separa cada palo

        for(int i = 0; i < separadoPorMenos.length; i++) {

            String[] separadoPorComa = separadoPorMenos[i].split(","); //consigo cada atributo del palo

            int valor = Integer.parseInt(separadoPorComa[0]);

            String palo = separadoPorComa[1];
            Palo paloEnum = Palo.buscarPorInicial(palo);
            paloEnum.setValor(valor);
        }

    }

    private static void analizarSegundaLinea(String separadoPorEspacio) {

        String[] separadoPorPuntoComa = separadoPorEspacio.split(";"); //consigo cada carta
        for (int i = 0; i < separadoPorPuntoComa.length; i++) {
            String[] separadoPorComa = separadoPorPuntoComa[i].split(","); //consigo cada attributo de la carta
            Carta carta = new Carta(
                    Palo.buscarPorInicial(separadoPorComa[0]),
                    Integer.parseInt(separadoPorComa[1]),
                    Integer.parseInt(separadoPorComa[2]));
            todasLasCartas.add(carta);
        }
    }

    public static void printCartas() {

        for (Carta carta : todasLasCartas) {
            carta.printCarta();
        }

    }

}
