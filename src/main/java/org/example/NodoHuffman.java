package org.example;

public class NodoHuffman {
    char caracter;
    int frecuencia;
    NodoHuffman izquierdo;
    NodoHuffman derecho;

    public NodoHuffman(char caracter, int frecuencia){
        this.caracter = caracter;
        this.frecuencia = frecuencia;
        izquierdo = null;
        derecho = null;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public NodoHuffman getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoHuffman izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoHuffman getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoHuffman derecho) {
        this.derecho = derecho;
    }
}
