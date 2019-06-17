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
        mapaDePalos.forEach((key, val) -> recursiveCombinations(val, new ArrayList<>(), 0));
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

    private void recursiveCombinations(List<Carta> cartas, List<Carta> arrayHelper, int index) {

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

}
