import services.Combinador;
import services.Parseador;
import services.Sistema;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ejecutar();
    }

    private static void ejecutar() throws IOException {
        Parseador parseador = new Parseador();
        Combinador combinador = new Combinador();
        Sistema sistema = new Sistema(parseador, combinador);

        sistema.ejecutar();

        System.out.println(sistema.getMejorValor());
        System.out.println(sistema.getMejorCombinacion());
    }

}
