package com.compilador;

import java.util.ArrayList;
import java.util.List;

public class GeneradorCodigo {

    private final List<String> codigo = new ArrayList<>();

    private int contadorTemporales = 0;
    private int contadorEtiquetas = 0;

    public String nuevaTemporal() {
        return "t" + contadorTemporales++;
    }

    public String nuevaEtiqueta() {
        return "L" + contadorEtiquetas++;
    }

    public void emitir(String instruccion) {
        codigo.add(instruccion);
    }

    public List<String> getCodigo() {
        return codigo;
    }

    public void imprimirCodigo() {
        System.out.println("\n=== CODIGO INTERMEDIO ===\n");

        for (String linea : codigo) {
            System.out.println(linea);
        }
    }
}