package com.compilador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class OptimizadorPropagacionConstantes implements OptimizadorIntermedio {

    private final List<String> codigoOriginal;
    private List<String> codigoOptimizado;

    public OptimizadorPropagacionConstantes(List<String> codigoOriginal) {
        this.codigoOriginal = new ArrayList<>(codigoOriginal);
        this.codigoOptimizado = new ArrayList<>(codigoOriginal);
    }

    @Override
    public List<String> optimizar() {
        Map<String, String> constantes = new HashMap<>();
        List<String> resultado = new ArrayList<>();

        for (String linea : codigoOriginal) {
            String lineaTrim = linea.trim();

            if (lineaTrim.isEmpty() || lineaTrim.startsWith("//")) {
                resultado.add(linea);
                continue;
            }

            if (esLimiteDeBloque(lineaTrim)) {
                constantes.clear();
                resultado.add(linea);
                continue;
            }

            if (lineaTrim.startsWith("goto ")
                    || lineaTrim.startsWith("if ")
                    || lineaTrim.startsWith("call ")
                    || lineaTrim.startsWith("print ")) {
                resultado.add(reemplazarConstantes(linea, constantes));
                continue;
            }

            Asignacion asignacion = parsearAsignacion(lineaTrim);

            if (asignacion != null) {
                String derechaOptimizada = reemplazarConstantes(asignacion.derecha, constantes);
                String nuevaLinea = asignacion.izquierda + " = " + derechaOptimizada;

                resultado.add(nuevaLinea);

                if (esVariableSimple(asignacion.izquierda) && esConstante(derechaOptimizada)) {
                    constantes.put(asignacion.izquierda, derechaOptimizada);
                } else if (esVariableSimple(asignacion.izquierda)) {
                    constantes.remove(asignacion.izquierda);
                }

                continue;
            }

            resultado.add(reemplazarConstantes(linea, constantes));
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

        System.out.println("Optimizacion aplicada: Propagacion de constantes");
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

    private boolean esLimiteDeBloque(String linea) {
        return esEtiqueta(linea)
                || linea.startsWith("func ")
                || linea.equals("endfunc");
    }

    private boolean esEtiqueta(String linea) {
        return linea.matches("[A-Za-z_][A-Za-z0-9_]*:");
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

    private String reemplazarConstantes(String texto, Map<String, String> constantes) {
        if (texto.contains("\"") || texto.contains("'")) {
            return texto;
        }

        String resultado = texto;

        for (Map.Entry<String, String> entrada : constantes.entrySet()) {
            resultado = resultado.replaceAll(
                    "\\b" + Pattern.quote(entrada.getKey()) + "\\b",
                    entrada.getValue()
            );
        }

        return resultado;
    }

    private boolean esConstante(String valor) {
        return valor.matches("-?\\d+(\\.\\d+)?")
                || valor.equals("true")
                || valor.equals("false")
                || valor.matches("'[^']'")
                || valor.matches("\".*\"");
    }

    private boolean esVariableSimple(String valor) {
        return valor.matches("[A-Za-z_][A-Za-z0-9_]*");
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