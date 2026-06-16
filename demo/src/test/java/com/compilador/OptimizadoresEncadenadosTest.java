package com.compilador;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class OptimizadoresEncadenadosTest {

    @Test
    public void appliesAllOptimizationsSequentially() {
        List<String> codigo = Arrays.asList(
                "x = 2",
                "t0 = x + 3",
                "y = y",
                "return t0",
                "muerto = 1");

        codigo = new OptimizadorCodigoMuerto(codigo).optimizar();
        codigo = new OptimizadorSentenciasRedundantes(codigo).optimizar();
        codigo = new OptimizadorPropagacionConstantes(codigo).optimizar();
        codigo = new OptimizadorSimplificacionExpresiones(codigo).optimizar();

        assertEquals(
                Arrays.asList(
                        "x = 2",
                        "t0 = 5",
                        "return t0"),
                codigo);
    }
}
