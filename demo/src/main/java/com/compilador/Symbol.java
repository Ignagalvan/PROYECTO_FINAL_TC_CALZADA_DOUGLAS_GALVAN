package com.compilador;

import java.util.Objects;

public class Symbol {

    public enum Kind {
        VARIABLE,
        FUNCTION
    }

    private final String name;
    private final String type;
    private final Kind kind;
    private final int scopeLevel;

    private Symbol(String name, String type, Kind kind, int scopeLevel) {
        this.name = Objects.requireNonNull(name, "name");
        this.type = Objects.requireNonNull(type, "type");
        this.kind = Objects.requireNonNull(kind, "kind");
        this.scopeLevel = scopeLevel;
    }

    public static Symbol variable(String name, String type, int scopeLevel) {
        return new Symbol(name, type, Kind.VARIABLE, scopeLevel);
    }

    public static Symbol function(String name, String returnType, int scopeLevel) {
        return new Symbol(name, returnType, Kind.FUNCTION, scopeLevel);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Kind getKind() {
        return kind;
    }

    public int getScopeLevel() {
        return scopeLevel;
    }

    public boolean isVariable() {
        return kind == Kind.VARIABLE;
    }

    public boolean isFunction() {
        return kind == Kind.FUNCTION;
    }
}
