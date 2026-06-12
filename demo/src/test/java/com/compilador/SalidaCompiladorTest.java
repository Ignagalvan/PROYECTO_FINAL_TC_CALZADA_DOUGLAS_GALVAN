package com.compilador;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class SalidaCompiladorTest {

    @Test
    public void usaVerdeParaExitos() throws Exception {
        String salida = capturar("exito");

        assertTrue(salida.contains(SalidaCompilador.VERDE + "[EXITO]"));
        assertTrue(salida.contains(SalidaCompilador.RESET));
    }

    @Test
    public void usaAmarilloParaWarnings() throws Exception {
        String salida = capturar("warning");

        assertTrue(salida.contains(SalidaCompilador.AMARILLO + "[WARNING]"));
        assertTrue(salida.contains(SalidaCompilador.RESET));
    }

    @Test
    public void usaRojoParaErrores() throws Exception {
        String salida = capturar("error");

        assertTrue(salida.contains(SalidaCompilador.ROJO + "[ERROR]"));
        assertTrue(salida.contains(SalidaCompilador.RESET));
    }

    private String capturar(String tipo) throws Exception {
        ByteArrayOutputStream contenido = new ByteArrayOutputStream();
        SalidaCompilador reporte = new SalidaCompilador(new PrintStream(contenido));

        if ("exito".equals(tipo)) {
            reporte.exito("correcto");
        } else if ("warning".equals(tipo)) {
            reporte.warning("advertencia");
        } else {
            reporte.error("fallo");
        }

        return contenido.toString("UTF-8");
    }
}
