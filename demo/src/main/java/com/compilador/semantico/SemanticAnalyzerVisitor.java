package com.compilador.semantico;

import com.compilador.MiLenguajeBaseVisitor;
import com.compilador.MiLenguajeParser;
import com.compilador.SymbolTable;
import java.util.ArrayList;
import java.util.List;

public class SemanticAnalyzerVisitor extends MiLenguajeBaseVisitor<Void> {

    private final SymbolTable symbolTable;
    private final List<SemanticError> errores = new ArrayList<>();
    private final List<SemanticWarning> warnings = new ArrayList<>();

    private int nivelBucles = 0;
    private int nivelFunciones = 0;

    public SemanticAnalyzerVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public List<SemanticError> getErrores() { return errores; }

    public List<SemanticWarning> getWarnings() { return warnings; }

    public boolean hayErrores() { return !errores.isEmpty(); }

    @Override
    public Void visitPrograma(MiLenguajeParser.ProgramaContext ctx) {
        for (MiLenguajeParser.ElementoContext elemento : ctx.elemento()) {
            if (elemento.funcion() != null) {
                declararFuncion(elemento.funcion());
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public Void visitDeclaracion(MiLenguajeParser.DeclaracionContext ctx) {
        String nombre = ctx.ID().getText();
        String tipo = ctx.tipo().getText();

        if (!symbolTable.declareVariable(nombre, tipo)) {
            errores.add(new SemanticError(
                    ctx.ID().getSymbol().getLine(),
                    ctx.ID().getSymbol().getCharPositionInLine(),
                    "Variable '" + nombre + "' ya declarada en este ambito."));
        }

        if (ctx.expresion() != null) {
            visit(ctx.expresion());
        }

        return null;
    }

    @Override
    public Void visitBloque(MiLenguajeParser.BloqueContext ctx) {
        symbolTable.enterScope();
        visitChildren(ctx);
        symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visitSentenciaWhile(MiLenguajeParser.SentenciaWhileContext ctx) {
        visit(ctx.expresion());
        nivelBucles++;
        visit(ctx.bloque());
        nivelBucles--;
        return null;
    }

    @Override
    public Void visitSentenciaFor(MiLenguajeParser.SentenciaForContext ctx) {
        nivelBucles++;
        symbolTable.enterScope();
        visit(ctx.inicializacionFor());
        visit(ctx.expresion());
        visit(ctx.actualizacionFor());
        visit(ctx.bloque());
        symbolTable.exitScope();
        nivelBucles--;
        return null;
    }

    @Override
    public Void visitInicializacionFor(MiLenguajeParser.InicializacionForContext ctx) {
        String nombre = ctx.ID().getText();

        if (ctx.tipo() != null) {
            String tipo = ctx.tipo().getText();

            if (!symbolTable.declareVariable(nombre, tipo)) {
                errores.add(new SemanticError(
                        ctx.ID().getSymbol().getLine(),
                        ctx.ID().getSymbol().getCharPositionInLine(),
                        "Variable '" + nombre + "' ya declarada en este ambito."));
            }
        } else if (symbolTable.resolveVariable(nombre) == null) {
            errores.add(new SemanticError(
                    ctx.ID().getSymbol().getLine(),
                    ctx.ID().getSymbol().getCharPositionInLine(),
                    "Variable '" + nombre + "' no declarada."));
        }

        visit(ctx.expresion());
        return null;
    }

    @Override
    public Void visitFuncion(MiLenguajeParser.FuncionContext ctx) {
        nivelFunciones++;
        symbolTable.enterScope();

        if (ctx.parametros() != null) {
            for (MiLenguajeParser.ParametroContext parametro : ctx.parametros().parametro()) {
                declararParametro(parametro);
            }
        }

        visit(ctx.bloque());
        symbolTable.exitScope();
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
                    "Uso de 'return' fuera de una funcion."));
        }

        if (ctx.expresion() != null) {
            visit(ctx.expresion());
        }

        return null;
    }

    @Override
    public Void visitAsignacion(MiLenguajeParser.AsignacionContext ctx) {
        String nombre = ctx.accesoVariable().ID().getText();

        if (symbolTable.resolveVariable(nombre) == null) {
            errores.add(new SemanticError(
                    ctx.accesoVariable().ID().getSymbol().getLine(),
                    ctx.accesoVariable().ID().getSymbol().getCharPositionInLine(),
                    "Variable '" + nombre + "' no declarada."));
        }

        visit(ctx.expresion());
        return null;
    }

    @Override
    public Void visitExprIdentificador(MiLenguajeParser.ExprIdentificadorContext ctx) {
        String nombre = ctx.accesoVariable().ID().getText();

        if (symbolTable.resolveVariable(nombre) == null) {
            errores.add(new SemanticError(
                    ctx.accesoVariable().ID().getSymbol().getLine(),
                    ctx.accesoVariable().ID().getSymbol().getCharPositionInLine(),
                    "Variable '" + nombre + "' no declarada."));
        }

        return null;
    }

    @Override
    public Void visitLlamadaFuncion(MiLenguajeParser.LlamadaFuncionContext ctx) {
        String nombre = ctx.ID().getText();

        if (symbolTable.resolveFunction(nombre) == null) {
            errores.add(new SemanticError(
                    ctx.ID().getSymbol().getLine(),
                    ctx.ID().getSymbol().getCharPositionInLine(),
                    "Funcion '" + nombre + "' no declarada."));
        }

        if (ctx.argumentos() != null) {
            visit(ctx.argumentos());
        }

        return null;
    }

    private void declararFuncion(MiLenguajeParser.FuncionContext ctx) {
        String nombre = ctx.ID().getText();
        String tipoRetorno = ctx.tipo().getText();

        if (!symbolTable.declareFunction(nombre, tipoRetorno)) {
            errores.add(new SemanticError(
                    ctx.ID().getSymbol().getLine(),
                    ctx.ID().getSymbol().getCharPositionInLine(),
                    "Funcion '" + nombre + "' ya declarada."));
        }
    }

    private void declararParametro(MiLenguajeParser.ParametroContext ctx) {
        String nombre = ctx.ID().getText();
        String tipo = ctx.tipo().getText();

        if (!symbolTable.declareVariable(nombre, tipo)) {
            errores.add(new SemanticError(
                    ctx.ID().getSymbol().getLine(),
                    ctx.ID().getSymbol().getCharPositionInLine(),
                    "Parametro '" + nombre + "' ya declarado en esta funcion."));
        }
    }
}
