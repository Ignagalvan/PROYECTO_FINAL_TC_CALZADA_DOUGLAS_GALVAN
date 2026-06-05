package com.compilador.semantico;

public class SemanticWarning {
    private final int line;
    private final int column;
    private final String message;

    public SemanticWarning(int line, int column, String message) {
        this.line = line;
        this.column = column;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[Línea " + line + ":" + column + "] " + message;
    }
}