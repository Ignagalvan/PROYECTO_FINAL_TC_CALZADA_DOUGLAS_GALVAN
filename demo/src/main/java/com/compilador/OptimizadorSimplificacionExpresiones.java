package com.compilador;

import java.util.ArrayList;
import java.util.List;

public class OptimizadorSimplificacionExpresiones implements OptimizadorIntermedio {

    private final List<String> codigoOriginal;
    private List<String> codigoOptimizado;

    public OptimizadorSimplificacionExpresiones(List<String> codigoOriginal) {
        this.codigoOriginal = new ArrayList<>(codigoOriginal);
        this.codigoOptimizado = new ArrayList<>(codigoOriginal);
    }

    @Override
    public List<String> optimizar() {
        List<String> resultado = new ArrayList<>();

        for (String linea : codigoOriginal) {
            Asignacion asignacion = parsearAsignacion(linea.trim());

            if (asignacion == null) {
                resultado.add(linea);
                continue;
            }

            String plegada = plegarOperacionConstante(asignacion.derecha);

            if (plegada != null) {
                resultado.add(asignacion.izquierda + " = " + plegada);
                continue;
            }

            String simplificada = simplificarIdentidadAlgebraica(asignacion.derecha);

            if (simplificada != null) {
                resultado.add(asignacion.izquierda + " = " + simplificada);
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

        System.out.println("Optimizacion aplicada: Simplificacion de expresiones");
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

    private String plegarOperacionConstante(String expresion) {
        String[] partes = expresion.split("\\s+");

        if (partes.length != 3) {
            return null;
        }

        String izquierda = partes[0];
        String operador = partes[1];
        String derecha = partes[2];

        if (!esNumero(izquierda) || !esNumero(derecha)) {
            return null;
        }

        double a = Double.parseDouble(izquierda);
        double b = Double.parseDouble(derecha);

        if ((operador.equals("/") || operador.equals("%")) && b == 0) {
            return null;
        }

        double resultado;

        switch (operador) {
            case "+":
                resultado = a + b;
                break;
            case "-":
                resultado = a - b;
                break;
            case "*":
                resultado = a * b;
                break;
            case "/":
                resultado = a / b;
                break;
            case "%":
                resultado = a % b;
                break;
            default:
                return null;
        }

        return formatearNumero(resultado);
    }

    private String simplificarIdentidadAlgebraica(String expresion) {
        String[] partes = expresion.split("\\s+");

        if (partes.length != 3) {
            return null;
        }

        String izquierda = partes[0];
        String operador = partes[1];
        String derecha = partes[2];

        if (operador.equals("+")) {
            if (esCero(derecha)) {
                return izquierda;
            }

            if (esCero(izquierda)) {
                return derecha;
            }
        }

        if (operador.equals("-")) {
            if (esCero(derecha)) {
                return izquierda;
            }
        }

        if (operador.equals("*")) {
            if (esUno(derecha)) {
                return izquierda;
            }

            if (esUno(izquierda)) {
                return derecha;
            }

            if (esCero(izquierda) || esCero(derecha)) {
                return "0";
            }
        }

        if (operador.equals("/")) {
            if (esUno(derecha)) {
                return izquierda;
            }
        }

        return null;
    }

    private boolean esNumero(String valor) {
        return valor.matches("-?\\d+(\\.\\d+)?");
    }

    private boolean esCero(String valor) {
        return valor.equals("0") || valor.equals("0.0");
    }

    private boolean esUno(String valor) {
        return valor.equals("1") || valor.equals("1.0");
    }

    private String formatearNumero(double numero) {
        if (numero == Math.rint(numero)) {
            return String.valueOf((long) numero);
        }

        return String.valueOf(numero);
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