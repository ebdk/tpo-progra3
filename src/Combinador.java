import java.util.ArrayList;
import java.util.List;

public class Combinador {
/*
    int k = 3;
    int bestValor = 0;
    List<Carta> bestCombination = new ArrayList<>();

    public int getK() {
        return k;
    }
    public void setBestValor(int bestValor) {
        this.bestValor = bestValor;
    }

    public void setBestCombination(List<Carta> bestCombination) {
        this.bestCombination = bestCombination;
    }

    private void recursiveCombinations(ArrayList<Carta> cartas, List<Carta> arrayHelper, int index) {

        if(index == cartas.size()) {
            if(arrayHelper.size() <= getK()) {
                int valorTotalDeLaCombinacion =
                        arrayHelper
                                .stream()
                                .map(x -> x.getValor())
                                .reduce(0, (acc, val) -> acc + val);
                if(valorTotalDeLaCombinacion > this.bestValor) {
                    this.setBestValor(valorTotalDeLaCombinacion);
                    this.setBestCombination(new ArrayList<>(arrayHelper));
                }
            }
        } else {
            arrayHelper.add(cartas.get(index));
            recursiveCombinations(cartas, arrayHelper, index+1);
            arrayHelper.remove(cartas.get(index));
            recursiveCombinations(cartas, arrayHelper, index+1);
        }
    }

    public void recursiveCombinationsStart(ArrayList<Carta> cartas) {
        List<Carta> arrayHelper = new ArrayList<>();
        recursiveCombinations(cartas, arrayHelper, 0);
    }

    public void display() {
        ArrayList<Carta> cartas = new ArrayList<>();
        cartas.add(new Carta(Carta.palos.Oro, 2, 4));
        cartas.add(new Carta(Carta.palos.Oro, 8, -3));
        cartas.add(new Carta(Carta.palos.Oro, 4, 2));
        cartas.add(new Carta(Carta.palos.Oro, 3, -5));

        recursiveCombinationsStart(cartas);
        System.out.println(this.bestValor);
        System.out.println(this.bestCombination);
    }



*/
}
