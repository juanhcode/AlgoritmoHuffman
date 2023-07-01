package org.example;

public class DecodificadorHuffman {
    private ArbolHuffman arbolHuffman;

    public DecodificadorHuffman(ArbolHuffman arbolHuffman){
        this.arbolHuffman = arbolHuffman;
    }

    public String decodificar(String textoCodificado){
        StringBuilder cadenaOriginal = new StringBuilder();
        NodoHuffman nodoActual = arbolHuffman.getPadre();

        for (char bit: textoCodificado.toCharArray()) {
            if(bit == '0'){
                nodoActual = nodoActual.getIzquierdo();
            }else if(bit == '1'){
                nodoActual = nodoActual.getDerecho();
            }

            if(nodoActual.getCaracter() != 'n'){
                cadenaOriginal.append(nodoActual.getCaracter());
                nodoActual = arbolHuffman.getPadre();
            }
        }
        return cadenaOriginal.toString();
    }
}
