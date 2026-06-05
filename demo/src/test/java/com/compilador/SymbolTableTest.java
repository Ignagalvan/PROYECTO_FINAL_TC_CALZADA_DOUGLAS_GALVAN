package com.compilador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SymbolTableTest {

    @Test
    public void registersVariableInCurrentScope() {
        SymbolTable table = new SymbolTable();

        assertTrue(table.declareVariable("x", "int"));

        Symbol symbol = table.resolveVariable("x");
        assertNotNull(symbol);
        assertEquals("x", symbol.getName());
        assertEquals("int", symbol.getType());
        assertTrue(symbol.isVariable());
    }

    @Test
    public void rejectsDuplicatedVariableInSameScope() {
        SymbolTable table = new SymbolTable();

        assertTrue(table.declareVariable("x", "int"));
        assertFalse(table.declareVariable("x", "float"));
    }

    @Test
    public void allowsVariableWithSameNameInNestedScope() {
        SymbolTable table = new SymbolTable();
        table.declareVariable("x", "int");

        table.enterScope();

        assertTrue(table.declareVariable("x", "float"));
        assertEquals("float", table.resolveVariable("x").getType());

        table.exitScope();

        assertEquals("int", table.resolveVariable("x").getType());
    }

    @Test
    public void registersFunctionsInGlobalScopeAndRejectsDuplicates() {
        SymbolTable table = new SymbolTable();

        assertTrue(table.declareFunction("suma", "int"));
        assertFalse(table.declareFunction("suma", "int"));

        Symbol function = table.resolveFunction("suma");
        assertNotNull(function);
        assertEquals("int", function.getType());
        assertTrue(function.isFunction());
    }

    @Test
    public void resolvesGlobalFunctionFromNestedScope() {
        SymbolTable table = new SymbolTable();
        table.declareFunction("saludar", "void");

        table.enterScope();

        assertNotNull(table.resolveFunction("saludar"));
    }

    @Test
    public void returnsNullWhenSymbolDoesNotExist() {
        SymbolTable table = new SymbolTable();

        assertNull(table.resolve("x"));
        assertNull(table.resolveVariable("x"));
        assertNull(table.resolveFunction("suma"));
    }

    @Test(expected = IllegalStateException.class)
    public void doesNotExitGlobalScope() {
        SymbolTable table = new SymbolTable();

        table.exitScope();
    }
}
