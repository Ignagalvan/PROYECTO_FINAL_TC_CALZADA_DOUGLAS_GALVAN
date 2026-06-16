package com.compilador;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Symbol {

    public enum Kind {
        VARIABLE,
        PARAMETER,
        FUNCTION
    }

    private final String name;
    private final String type;
    private final Kind kind;
    private final int scopeLevel;
    private final int line;
    private final int column;
    private final String scopeName;
    private final Integer arraySize;
    private final List<String> parameterTypes;

    private Symbol(
            String name,
            String type,
            Kind kind,
            int scopeLevel,
            int line,
            int column,
            String scopeName,
            Integer arraySize,
            List<String> parameterTypes) {
        this.name = Objects.requireNonNull(name, "name");
        this.type = Objects.requireNonNull(type, "type");
        this.kind = Objects.requireNonNull(kind, "kind");
        this.scopeLevel = scopeLevel;
        this.line = line;
        this.column = column;
        this.scopeName = Objects.requireNonNull(scopeName, "scopeName");
        this.arraySize = arraySize;
        this.parameterTypes = parameterTypes == null
                ? Collections.emptyList()
                : Collections.unmodifiableList(parameterTypes);
    }

    public static Symbol variable(String name, String type, int scopeLevel) {
        return variable(name, type, scopeLevel, -1, -1, "global", null);
    }

    public static Symbol variable(
            String name, String type, int scopeLevel, int line, int column,
            String scopeName, Integer arraySize) {
        return new Symbol(name, type, Kind.VARIABLE, scopeLevel, line, column,
                scopeName, arraySize, null);
    }

    public static Symbol function(String name, String returnType, int scopeLevel) {
        return function(name, returnType, scopeLevel, -1, -1,
                Collections.emptyList());
    }

    public static Symbol function(
            String name, String returnType, int scopeLevel, int line, int column,
            List<String> parameterTypes) {
        return new Symbol(name, returnType, Kind.FUNCTION, scopeLevel, line, column,
                "global", null, parameterTypes);
    }

    public static Symbol parameter(String name, String type, int scopeLevel) {
        return parameter(name, type, scopeLevel, -1, -1, "global");
    }

    public static Symbol parameter(
            String name, String type, int scopeLevel, int line, int column,
            String scopeName) {
        return new Symbol(name, type, Kind.PARAMETER, scopeLevel, line, column,
                scopeName, null, null);
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

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public String getScopeName() {
        return scopeName;
    }

    public Integer getArraySize() {
        return arraySize;
    }

    public List<String> getParameterTypes() {
        return parameterTypes;
    }

    public boolean isVariable() {
        return kind == Kind.VARIABLE || kind == Kind.PARAMETER;
    }

    public boolean isFunction() {
        return kind == Kind.FUNCTION;
    }
}
