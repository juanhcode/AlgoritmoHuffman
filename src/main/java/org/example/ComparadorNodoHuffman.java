package org.example;

import java.util.Comparator;

public class ComparadorNodoHuffman implements Comparator<NodoHuffman> {

    @Override
    public int compare(NodoHuffman nodo1, NodoHuffman nodo2) {
        return nodo1.getFrecuencia() - nodo2.getFrecuencia();
    }
}
