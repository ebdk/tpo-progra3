import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Parseador parseador = new Parseador();
        Combinador combinador = new Combinador();
        Sistema sistema = new Sistema(parseador, combinador);
        sistema.ejecutar();
    }
}
