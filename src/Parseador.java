import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Parseador {

    private Sistema sistema;

    public Parseador() {
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public void procesarArchivo() throws IOException {
        String archivoEntero = new String(Files.readAllBytes(Paths.get("cartas.txt")));

        System.out.println(archivoEntero);

        String[] separadoPorEspacios = archivoEntero.split("\\s+"); //separa entre linea 1 y 2

        analizarPrimerLinea(separadoPorEspacios[0]);
        analizarSegundaLinea(separadoPorEspacios[1]);

    }

    private void analizarPrimerLinea(String separadoPorEspacio) {

        String[] separadoPorPuntoComa = separadoPorEspacio.split(";");
        sistema.setCombinatoria(Integer.parseInt(separadoPorPuntoComa[1])); //setea el K

        String[] separadoPorMenos = separadoPorPuntoComa[0].split("-"); //separa cada palo

        for(int i = 0; i < separadoPorMenos.length; i++) {

            String[] separadoPorComa = separadoPorMenos[i].split(","); //consigo cada atributo del palo

            int valor = Integer.parseInt(separadoPorComa[0]);

            String palo = separadoPorComa[1];
            Palo paloEnum = Palo.buscarPorInicial(palo);
            paloEnum.setValor(valor);
        }

    }

    private void analizarSegundaLinea(String separadoPorEspacio) {

        String[] separadoPorPuntoComa = separadoPorEspacio.split(";"); //consigo cada carta
        for (int i = 0; i < separadoPorPuntoComa.length; i++) {
            String[] separadoPorComa = separadoPorPuntoComa[i].split(","); //consigo cada attributo de la carta
            Carta carta = new Carta(
                    Palo.buscarPorInicial(separadoPorComa[0]),
                    Integer.parseInt(separadoPorComa[1]),
                    Integer.parseInt(separadoPorComa[2]));
            sistema.agregarCarta(carta);
        }
    }

}
