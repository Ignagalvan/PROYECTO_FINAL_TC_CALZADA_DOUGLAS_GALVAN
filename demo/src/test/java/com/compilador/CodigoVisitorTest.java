package com.compilador;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

public class CodigoVisitorTest {

    @Test
    public void generatesAssignmentForInitializedDeclaration() {
        List<String> codigo = generar("int contadorGlobal = 19;");

        assertEquals(
                Arrays.asList(
                        "declare int contadorGlobal",
                        "contadorGlobal = 19"),
                codigo);
    }

    @Test
    public void generatesTemporariesForExpressionInitializer() {
        List<String> codigo = generar("int x = 1 + 2;");

        assertEquals(
                Arrays.asList(
                        "declare int x",
                        "t0 = 1 + 2",
                        "x = t0"),
                codigo);
    }

    private List<String> generar(String fuente) {
        MiLenguajeLexer lexer = new MiLenguajeLexer(CharStreams.fromString(fuente));
        MiLenguajeParser parser = new MiLenguajeParser(new CommonTokenStream(lexer));
        GeneradorCodigo generador = new GeneradorCodigo();

        new CodigoVisitor(generador).visit(parser.programa());

        return generador.getCodigo();
    }
}
