package com.compilador;

import java.util.ArrayList;
import java.util.List;

public class OptimizadorCodigoMuerto implements OptimizadorIntermedio {

    private final List<String> codigoOriginal;
    private List<String> codigoOptimizado;

    public OptimizadorCodigoMuerto(List<String> codigoOriginal) {
        this.codigoOriginal = new ArrayList<>(codigoOriginal);
        this.codigoOptimizado = new ArrayList<>(codigoOriginal);
    }

    @Override
    public List<String> optimizar() {
        List<String> resultado = new ArrayList<>();
        boolean inalcanzable = false;

        for (String linea : codigoOriginal) {
            String lineaTrim = linea.trim();

            if (lineaTrim.isEmpty() || lineaTrim.startsWith("//")) {
                if (!inalcanzable) {
                    resultado.add(linea);
                }
                continue;
            }

            if (esEtiqueta(lineaTrim) || lineaTrim.equals("endfunc") || lineaTrim.startsWith("func ")) {
                inalcanzable = false;
                resultado.add(linea);
                continue;
            }

            if (inalcanzable) {
                continue;
            }

            resultado.add(linea);

            if (esSaltoIncondicional(lineaTrim)) {
                inalcanzable = true;
            }
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

        System.out.println("Optimizacion aplicada: Eliminacion de codigo muerto");
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

    private boolean esSaltoIncondicional(String linea) {
        return linea.startsWith("goto ") || linea.startsWith("return");
    }

    private boolean esEtiqueta(String linea) {
        return linea.matches("[A-Za-z_][A-Za-z0-9_]*:");
    }
}