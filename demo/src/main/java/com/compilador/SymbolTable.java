package com.compilador;

public class SymbolTable {

    private final Scope globalScope;
    private Scope currentScope;

    public SymbolTable() {
        this.globalScope = new Scope(null);
        this.currentScope = globalScope;
    }

    public boolean declareVariable(String name, String type) {
        Symbol symbol = Symbol.variable(name, type, currentScope.getLevel());
        return currentScope.declare(symbol);
    }

    public boolean declareFunction(String name, String returnType) {
        Symbol symbol = Symbol.function(name, returnType, globalScope.getLevel());
        return globalScope.declare(symbol);
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
}
