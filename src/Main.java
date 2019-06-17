import services.Combinador;
import services.Parseador;
import services.Sistema;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ejecutar();
    }

    private static void ejecutar() throws IOException {
        Sistema sistema = new Sistema(new Parseador(), new Combinador());

        sistema.ejecutar();
    }

}
