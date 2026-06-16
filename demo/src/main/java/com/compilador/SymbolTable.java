package com.compilador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;

public class SymbolTable {

    private final Scope globalScope;
    private final List<Scope> scopes = new ArrayList<>();
    private Scope currentScope;

    public SymbolTable() {
        this.globalScope = new Scope(null);
        this.currentScope = globalScope;
        scopes.add(globalScope);
    }

    public boolean declareVariable(String name, String type) {
        return declareVariable(name, type, -1, -1, null);
    }

    public boolean declareVariable(
            String name, String type, int line, int column, Integer arraySize) {
        Symbol symbol = Symbol.variable(name, type, currentScope.getLevel(),
                line, column, currentScope.getName(), arraySize);
        return currentScope.declare(symbol);
    }

    public boolean declareFunction(String name, String returnType) {
        return declareFunction(name, returnType, -1, -1, Collections.emptyList());
    }

    public boolean declareFunction(
            String name, String returnType, int line, int column,
            List<String> parameterTypes) {
        Symbol symbol = Symbol.function(name, returnType, globalScope.getLevel(),
                line, column, parameterTypes);
        return globalScope.declare(symbol);
    }

    public boolean declareParameter(String name, String type) {
        return declareParameter(name, type, -1, -1);
    }

    public boolean declareParameter(String name, String type, int line, int column) {
        Symbol symbol = Symbol.parameter(name, type, currentScope.getLevel(),
                line, column, currentScope.getName());
        return currentScope.declare(symbol);
    }

    public Symbol resolve(String name) {
        return currentScope.resolve(name);
    }

    public Symbol resolveVariable(String name) {
        Symbol symbol = resolve(name);
        return symbol != null && symbol.isVariable() ? symbol : null;
    }

    public Symbol resolveFunction(String name) {
        Symbol symbol = currentScope.resolve(name);
        return symbol != null && symbol.isFunction() ? symbol : null;
    }

    public void enterScope() {
        currentScope = new Scope(currentScope);
        scopes.add(currentScope);
    }

    public void enterScope(String name) {
        currentScope = new Scope(currentScope, name);
        scopes.add(currentScope);
    }

    public void exitScope() {
        if (currentScope == globalScope) {
            throw new IllegalStateException("No se puede salir del ambito global");
        }

        currentScope = currentScope.getParent();
    }

    public boolean isGlobalScope() {
        return currentScope == globalScope;
    }

    public Scope getGlobalScope() {
        return globalScope;
    }

    public Scope getCurrentScope() {
        return currentScope;
    }

    public List<Scope> getScopes() {
        return Collections.unmodifiableList(scopes);
    }

    public void imprimirTabla() {
        List<Symbol> symbols = new ArrayList<>();
        for (Scope scope : scopes) {
            symbols.addAll(scope.getSymbols());
        }
        symbols.sort(Comparator
                .comparingInt(Symbol::getLine)
                .thenComparingInt(Symbol::getColumn));

        System.out.println("\n=== TABLA DE SÍMBOLOS ===");
        System.out.printf("%-16s %-10s %-15s %-10s %-10s %-15s %s%n",
                "NOMBRE", "TIPO", "CATEGORÍA", "LÍNEA", "COLUMNA",
                "ÁMBITO", "DETALLES");
        System.out.println("--------------------------------------------------------------------------------------------");

        for (Symbol symbol : symbols) {
            System.out.printf("%-16s %-10s %-15s %-10d %-10d %-15s %s%n",
                    symbol.getName(),
                    symbol.getType(),
                    categoryName(symbol),
                    symbol.getLine(),
                    symbol.getColumn(),
                    symbol.getScopeName(),
                    details(symbol));
        }
    }

    private String categoryName(Symbol symbol) {
        switch (symbol.getKind()) {
            case FUNCTION:
                return "funcion";
            case PARAMETER:
                return "parametro";
            default:
                return "variable";
        }
    }

    private String details(Symbol symbol) {
        if (symbol.getKind() == Symbol.Kind.PARAMETER) {
            return "";
        }

        StringBuilder details = new StringBuilder();
        if (symbol.getArraySize() != null) {
            details.append("[arr:").append(symbol.getArraySize()).append("] ");
        }
        details.append("[private]");

        if (symbol.getKind() == Symbol.Kind.FUNCTION
                && !symbol.getParameterTypes().isEmpty()) {
            details.append(" [")
                    .append(String.join(", ", symbol.getParameterTypes()))
                    .append("]");
        }
        return details.toString();
    }
}
