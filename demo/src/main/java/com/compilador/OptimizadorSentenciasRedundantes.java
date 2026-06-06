package com.compilador;

import java.util.ArrayList;
import java.util.List;

public class OptimizadorSentenciasRedundantes implements OptimizadorIntermedio {

    private final List<String> codigoOriginal;
    private List<String> codigoOptimizado;

    public OptimizadorSentenciasRedundantes(List<String> codigoOriginal) {
        this.codigoOriginal = new ArrayList<>(codigoOriginal);
        this.codigoOptimizado = new ArrayList<>(codigoOriginal);
    }

    @Override
    public List<String> optimizar() {
        List<String> resultado = new ArrayList<>();

        for (String linea : codigoOriginal) {
            Asignacion asignacion = parsearAsignacion(linea.trim());

            if (asignacion != null && asignacion.izquierda.equals(asignacion.derecha)) {
                continue;
            }

            resultado.add(linea);
        }

        codigoOptimizado = resultado;
        return new ArrayList<>(codigoOptimizado);
    }

    @Override
    public List<String> getCodigoOptimizado() {
        return new ArrayList<>(codigoOptimizado);
    }

    @Override
    public void imprimirResumen() {
        int originales = codigoOriginal.size();
        int optimizadas = codigoOptimizado.size();
        int eliminadas = originales - optimizadas;

        System.out.println("Optimizacion aplicada: Eliminacion de sentencias redundantes");
        System.out.println("   Instrucciones originales: " + originales);
        System.out.println("   Instrucciones optimizadas: " + optimizadas);
        System.out.println("   Instrucciones eliminadas: " + eliminadas);
    }

    @Override
    public void imprimirCodigoOptimizado() {
        System.out.println("\n=== CODIGO OPTIMIZADO ===\n");

        for (String linea : codigoOptimizado) {
            System.out.println(linea);
        }
    }

    private Asignacion parsearAsignacion(String linea) {
        int indiceIgual = linea.indexOf("=");

        if (indiceIgual == -1 || linea.startsWith("if ")) {
            return null;
        }

        String izquierda = linea.substring(0, indiceIgual).trim();
        String derecha = linea.substring(indiceIgual + 1).trim();

        if (izquierda.isEmpty() || derecha.isEmpty()) {
            return null;
        }

        return new Asignacion(izquierda, derecha);
    }

    private static class Asignacion {
        private final String izquierda;
        private final String derecha;

        private Asignacion(String izquierda, String derecha) {
            this.izquierda = izquierda;
            this.derecha = derecha;
        }
    }
}