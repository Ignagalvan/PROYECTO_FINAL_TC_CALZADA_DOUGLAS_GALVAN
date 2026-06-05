package com.compilador;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {

    private final Scope parent;
    private final Map<String, Symbol> symbols = new LinkedHashMap<>();
    private final int level;

    public Scope(Scope parent) {
        this.parent = parent;
        this.level = parent == null ? 0 : parent.getLevel() + 1;
    }

    public boolean declare(Symbol symbol) {
        if (symbols.containsKey(symbol.getName())) {
            return false;
        }

        symbols.put(symbol.getName(), symbol);
        return true;
    }

    public Symbol resolveLocal(String name) {
        return symbols.get(name);
    }

    public Symbol resolve(String name) {
        Symbol symbol = resolveLocal(name);
        if (symbol != null) {
            return symbol;
        }

        return parent == null ? null : parent.resolve(name);
    }

    public boolean containsLocal(String name) {
        return symbols.containsKey(name);
    }

    public Scope getParent() {
        return parent;
    }

    public int getLevel() {
        return level;
    }

    public Collection<Symbol> getSymbols() {
        return symbols.values();
    }
}
