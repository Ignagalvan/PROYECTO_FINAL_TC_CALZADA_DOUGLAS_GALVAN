package com.compilador;

import java.io.PrintStream;

/**
 * Centraliza los mensajes importantes del compilador y sus colores ANSI.
 */
public class SalidaCompilador {

    static final String VERDE = "\u001B[32m";
    static final String AMARILLO = "\u001B[33m";
    static final String ROJO = "\u001B[31m";
    static final String RESET = "\u001B[0m";

    private final PrintStream salida;

    public SalidaCompilador() {
        this(System.out);
    }

    SalidaCompilador(PrintStream salida) {
        this.salida = salida;
    }

    public void exito(String mensaje) {
        imprimir(VERDE, "[EXITO] " + mensaje);
    }

    public void warning(String mensaje) {
        imprimir(AMARILLO, "[WARNING] " + mensaje);
    }

    public void error(String mensaje) {
        imprimir(ROJO, "[ERROR] " + mensaje);
    }

    private void imprimir(String color, String mensaje) {
        salida.println(color + mensaje + RESET);
    }
}
