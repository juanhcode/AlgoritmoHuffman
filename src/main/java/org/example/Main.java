package org.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String cadena = "Holaa";

        HashMap<Character,Integer> mapaDeFrecuencia = new HashMap<>();
        for (char letra: cadena.toCharArray()) {
            if(mapaDeFrecuencia.containsKey(letra)){
                mapaDeFrecuencia.put(letra,mapaDeFrecuencia.get(letra)+1);
            }else{
                mapaDeFrecuencia.put(letra,1);
            }
        }

        for (char letra : mapaDeFrecuencia.keySet()) {
            int frequencia = mapaDeFrecuencia.get(letra);
            System.out.println("'" + letra + "' : " + frequencia);
        }

        ArbolHuffman arbolHuffman = new ArbolHuffman(mapaDeFrecuencia);
        arbolHuffman.imprimirArbol();

        //Codificador
        CodificadorHuffman codificadorHuffman = new CodificadorHuffman(arbolHuffman);

        // Codificar un texto
        String codificado = codificadorHuffman.codificar(cadena);
        System.out.println("Texto original: " + cadena);
        System.out.println("Texto codificado: " + codificado);

        codificadorHuffman.imprimirTablaCodigo();

        DecodificadorHuffman decodificadorHuffman = new DecodificadorHuffman(arbolHuffman);
        //Decodificar el texto
        String cadenaOriginal = decodificadorHuffman.decodificar(codificado);
        System.out.println("Texto codificado: " + codificado);
        System.out.println("Cadena decodificada original: " + cadenaOriginal);
    }
}