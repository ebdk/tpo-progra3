package services;

import models.Carta;
import models.Palo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Combinador {

    private Sistema sistema;

    private Map<Palo, List<Carta> > mapaDePalos;

    public Combinador() {
    }

    public void setMapaDePalos(Map<Palo, List<Carta>> mapaDePalos) {
        this.mapaDePalos = mapaDePalos;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public void conseguirResultado() {
        listaAMapa(sistema.getTodasLasCartas());
        getMapaDePalos().forEach((key, val) -> recursiveCombinations(val, new ArrayList<>(), 0));
//        recortarMapa();
//        elegirMejorPalo();
    }

    private void listaAMapa(List<Carta> todasLasCartas) {
        Map< Palo, List<Carta> > mapaDePalos = new HashMap<>();
        Palo[] palos = Palo.values();
        for(Palo palo : palos) {
            List<Carta> cartaDelPalo = todasLasCartas
                    .stream()
                    .filter(carta -> carta.getPalo().equals(palo))
                    .collect(Collectors.toList());
            mapaDePalos.put(palo, cartaDelPalo);
        }
        setMapaDePalos(mapaDePalos);
    }

    private void recursiveCombinations(List<Carta> cartas, List<models.Carta> arrayHelper, int index) {

        if(index == cartas.size()) {
            if(arrayHelper.size() <= sistema.getCombinatoriaMaxima()) {
                int valorTotalDeLaCombinacion =
                        arrayHelper
                                .stream()
                                .map(x -> x.getGanancia())
                                .reduce(0, (acc, val) -> acc + val);
                if(valorTotalDeLaCombinacion > sistema.getMejorValor()) {
                    sistema.setMejorValor(valorTotalDeLaCombinacion);
                    sistema.setMejorCombinacion(new ArrayList<>(arrayHelper));
                }
            }
        } else {
            arrayHelper.add(cartas.get(index));
            recursiveCombinations(cartas, arrayHelper, index+1);
            arrayHelper.remove(cartas.get(index));
            recursiveCombinations(cartas, arrayHelper, index+1);
        }
    }

    private Map<Palo, List<Carta>> getMapaDePalos() {
        return mapaDePalos;
    }

/*
    int k = 3;
    int bestValor = 0;
    List<models.Carta> bestCombination = new ArrayList<>();

    public int getK() {
        return k;
    }
    public void setBestValor(int bestValor) {
        this.bestValor = bestValor;
    }

    public void setBestCombination(List<models.Carta> bestCombination) {
        this.bestCombination = bestCombination;
    }

    public void recursiveCombinationsStart(ArrayList<models.Carta> cartas) {
        List<models.Carta> arrayHelper = new ArrayList<>();
        recursiveCombinations(cartas, arrayHelper, 0);
    }

    public void display() {
        ArrayList<models.Carta> cartas = new ArrayList<>();
        cartas.add(new models.Carta(models.Carta.palos.Oro, 2, 4));
        cartas.add(new models.Carta(models.Carta.palos.Oro, 8, -3));
        cartas.add(new models.Carta(models.Carta.palos.Oro, 4, 2));
        cartas.add(new models.Carta(models.Carta.palos.Oro, 3, -5));

        recursiveCombinationsStart(cartas);
        System.out.println(this.bestValor);
        System.out.println(this.bestCombination);
    }
    */


}
