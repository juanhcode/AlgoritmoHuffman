package org.example;

import java.util.HashMap;

public class CodificadorHuffman {
    private ArbolHuffman arbolHuffman;
    private HashMap<Character,String> mapaCodificado;

    public CodificadorHuffman(ArbolHuffman arbolHuffman){
        this.arbolHuffman = arbolHuffman;
        this.mapaCodificado = generarTablaCodigos();
    }

    private HashMap<Character,String> generarTablaCodigos(){
        HashMap<Character,String> tabla = new HashMap<>();
        generarTablaCodigosRecursivos(arbolHuffman.getPadre(),"",tabla);
        return tabla;
    }

    private void generarTablaCodigosRecursivos(NodoHuffman nodo,String codigoActual,HashMap<Character,String> tabla){
        if(nodo != null){
            if(nodo.getCaracter() != 'n'){
                tabla.put(nodo.getCaracter(),codigoActual);
            }else{
                generarTablaCodigosRecursivos(nodo.getIzquierdo(),codigoActual+"0",tabla);
                generarTablaCodigosRecursivos(nodo.getDerecho(),codigoActual+"1",tabla);
            }
        }
    }

    public void imprimirTablaCodigo(){
        for (char letra : mapaCodificado.keySet()) {
            String codigo = mapaCodificado.get(letra);
            System.out.println("'" + letra + "' : " + codigo);
        }
    }

    public String codificar(String texto){
        StringBuilder codificado = new StringBuilder();
        for (char letra:texto.toCharArray()) {
            String codigo = mapaCodificado.get(letra);
            if(codigo != null){
                codificado.append(codigo);
            }
        }
        return  codificado.toString();
    }
}
