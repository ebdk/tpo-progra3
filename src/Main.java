import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Parseador parseador = new Parseador();
        Sistema sistema = new Sistema(parseador, null);
        sistema.ejecutar();
    }
}
