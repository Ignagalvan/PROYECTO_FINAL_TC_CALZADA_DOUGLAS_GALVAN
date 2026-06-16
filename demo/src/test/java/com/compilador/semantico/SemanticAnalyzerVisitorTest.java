package com.compilador.semantico;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.compilador.MiLenguajeLexer;
import com.compilador.MiLenguajeParser;
import com.compilador.SymbolTable;
import java.util.List;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

public class SemanticAnalyzerVisitorTest {

    @Test
    public void acceptsDeclaredVariableUse() {
        List<SemanticError> errores = analizar("int x; x = 1;");

        assertTrue(errores.isEmpty());
    }

    @Test
    public void acceptsVariableDeclarationWithInitializer() {
        List<SemanticError> errores = analizar("int x = 1;");

        assertTrue(errores.isEmpty());
    }

    @Test
    public void reportsDuplicatedVariableInSameScope() {
        List<SemanticError> errores = analizar("int x; int x;");

        assertTrue(contieneError(errores, "Variable 'x' ya declarada"));
    }

    @Test
    public void allowsSameVariableNameInNestedScope() {
        List<SemanticError> errores = analizar("int x; if (true) { int x; x = 1; } x = 2;");

        assertFalse(contieneError(errores, "Variable 'x' ya declarada"));
    }

    @Test
    public void registersFunctionsBeforeValidatingCalls() {
        List<SemanticError> errores = analizar("saludar(); void saludar() { return; }");

        assertTrue(errores.isEmpty());
    }

    @Test
    public void reportsDuplicatedFunction() {
        List<SemanticError> errores = analizar("void saludar() {} void saludar() {}");

        assertTrue(contieneError(errores, "Funcion 'saludar' ya declarada"));
    }

    @Test
    public void registersFunctionParametersInFunctionScope() {
        List<SemanticError> errores = analizar("int identidad(int x) { return x; }");

        assertTrue(errores.isEmpty());
    }

    private List<SemanticError> analizar(String codigo) {
        MiLenguajeLexer lexer = new MiLenguajeLexer(CharStreams.fromString(codigo));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiLenguajeParser parser = new MiLenguajeParser(tokens);

        SymbolTable symbolTable = new SymbolTable();
        SemanticAnalyzerVisitor visitor = new SemanticAnalyzerVisitor(symbolTable);
        visitor.visit(parser.programa());

        return visitor.getErrores();
    }

    private boolean contieneError(List<SemanticError> errores, String texto) {
        for (SemanticError error : errores) {
            if (error.toString().contains(texto)) {
                return true;
            }
        }
        return false;
    }
}
