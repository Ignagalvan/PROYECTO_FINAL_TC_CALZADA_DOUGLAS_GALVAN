package com.compilador;

import java.util.List;

public interface OptimizadorIntermedio {

    List<String> optimizar();

    List<String> getCodigoOptimizado();

    void imprimirResumen();

    void imprimirCodigoOptimizado();
}