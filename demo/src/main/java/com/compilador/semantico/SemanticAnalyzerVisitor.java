package com.compilador.semantico;

import com.compilador.MiLenguajeBaseVisitor;
import com.compilador.MiLenguajeParser;
import java.util.ArrayList;
import java.util.List;
import com.compilador.SymbolTable;

public class SemanticAnalyzerVisitor extends MiLenguajeBaseVisitor<Void> {

    private final SymbolTable symbolTable;

    private final List<SemanticError> errores = new ArrayList<>();
    private final List<SemanticWarning> warnings = new ArrayList<>();
    

    private int nivelBucles = 0;
    private int nivelFunciones = 0;

    
    public SemanticAnalyzerVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public List<SemanticError> getErrores() {
        return errores;
    }

    public List<SemanticWarning> getWarnings() {
        return warnings;
    }

    public boolean hayErrores() {
        return !errores.isEmpty();
    }

    @Override
    public Void visitSentenciaWhile(MiLenguajeParser.SentenciaWhileContext ctx) {
        nivelBucles++;
        visit(ctx.bloque());
        nivelBucles--;
        return null;
    }

    @Override
    public Void visitSentenciaFor(MiLenguajeParser.SentenciaForContext ctx) {
        nivelBucles++;
        visit(ctx.bloque());
        nivelBucles--;
        return null;
    }

    @Override
    public Void visitFuncion(MiLenguajeParser.FuncionContext ctx) {
        nivelFunciones++;
        visit(ctx.bloque());
        nivelFunciones--;
        return null;
    }

    @Override
    public Void visitSentenciaBreak(MiLenguajeParser.SentenciaBreakContext ctx) {
        if (nivelBucles == 0) {
            errores.add(new SemanticError(
                    ctx.BREAK().getSymbol().getLine(),
                    ctx.BREAK().getSymbol().getCharPositionInLine(),
                    "Uso de 'break' fuera de un bucle."));
        }
        return null;
    }

    @Override
    public Void visitSentenciaContinue(MiLenguajeParser.SentenciaContinueContext ctx) {
        if (nivelBucles == 0) {
            errores.add(new SemanticError(
                    ctx.CONTINUE().getSymbol().getLine(),
                    ctx.CONTINUE().getSymbol().getCharPositionInLine(),
                    "Uso de 'continue' fuera de un bucle."));
        }
        return null;
    }

    @Override
    public Void visitSentenciaReturn(MiLenguajeParser.SentenciaReturnContext ctx) {
        if (nivelFunciones == 0) {
            errores.add(new SemanticError(
                    ctx.RETURN().getSymbol().getLine(),
                    ctx.RETURN().getSymbol().getCharPositionInLine(),
                    "Uso de 'return' fuera de una función."));
        }

        if (ctx.expresion() != null) {
            visit(ctx.expresion());
        }

        return null;
    }
}