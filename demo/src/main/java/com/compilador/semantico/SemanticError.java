package com.compilador.semantico;

public class SemanticError {
    private final int line;
    private final int column;
    private final String message;

    public SemanticError(int line, int column, String message) {
        this.line = line;
        this.column = column;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[Línea " + line + ":" + column + "] " + message;
    }
}