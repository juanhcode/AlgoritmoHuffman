package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ArbolHuffman {
    private static NodoHuffman padre;

    public ArbolHuffman(HashMap<Character,Integer> mapaDeFrecuencia){
        construirArbol(mapaDeFrecuencia);
    }

    private void construirArbol(HashMap<Character,Integer> mapaDeFrecuencia){
        PriorityQueue<NodoHuffman> heap = new PriorityQueue<>(new ComparadorNodoHuffman());

        for (Map.Entry<Character,Integer> mapa: mapaDeFrecuencia.entrySet()) {
            char letra = mapa.getKey();
            int frecuencia = mapa.getValue();
            //Creo un nodo de Huffman
            NodoHuffman nodo = new NodoHuffman(letra,frecuencia);
            heap.offer(nodo);
        }

        //Acomodar el heap

        while (heap.size() > 1){
            NodoHuffman izquierdo = heap.poll();
            NodoHuffman derecho = heap.poll();
            int sumarFrecuencia = izquierdo.getFrecuencia() + derecho.getFrecuencia();
            NodoHuffman nodoPadre = new NodoHuffman('n',sumarFrecuencia);
            nodoPadre.setIzquierdo(izquierdo);
            nodoPadre.setDerecho(derecho);
            heap.offer(nodoPadre);
        }

        this.padre = heap.poll();

    }

    public NodoHuffman getPadre() {
        return padre;
    }

    public void imprimirArbol(){
        imprimirArbolRecursivo(padre," ");
    }

    public static void imprimirArbolRecursivo(NodoHuffman nodo, String prefijo) {
        if (nodo == null) {
            System.out.println(prefijo + "null");
            return;
        }

        if (nodo.getCaracter() != 'n') {
            System.out.println(prefijo + "Character: " + nodo.getCaracter() + ", Frequency: " + nodo.getFrecuencia());
        } else {
            System.out.println(prefijo + "Internal Node, Frequency: " + nodo.getFrecuencia());
        }

        imprimirArbolRecursivo(nodo.getIzquierdo(), prefijo + "  |---Left: ");
        imprimirArbolRecursivo(nodo.getDerecho(), prefijo + "  |---Right: ");
    }

}
