public enum Palo {
    BASTO ("B", "BASTO", 0),
    ESPADA ("E", "ESPADA", 0),
    COPA ("C", "COPA", 0),
    ORO ("O", "ORO", 0);
    private String inicial;
    private String nombre;
    private int valor;

    Palo(String inicial, String nombre, int valor) {
        this.inicial = inicial;
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getInicial() {
        return inicial;
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public static Palo buscarPorInicial(String inicial) {
        Palo[] palos = Palo.values();
        Palo solucion = null;
        for(Palo palo : palos){
            if(palo.getInicial().equals(inicial)){
                solucion = palo;
            }
        }
        return solucion;
    }

    public void printPalo() {

        System.out.println(this.getNombre() + " tiene valor: " + this.getValor());

    }

    public static void printPalos() {

        Palo[] palos = Palo.values();
        for (Palo palo : palos) {
            palo.printPalo();
        }

    }

}
