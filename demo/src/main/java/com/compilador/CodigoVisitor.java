package com.compilador;

public class CodigoVisitor extends MiLenguajeBaseVisitor<String> {

    private final GeneradorCodigo generador;

    public CodigoVisitor(GeneradorCodigo generador) {
        this.generador = generador;
    }

    // =========================================================
    // DECLARACIONES
    // Ejemplo:
    // int x = 5;
    // int y = a + b;
    // =========================================================
    @Override
    public String visitDeclaracion(MiLenguajeParser.DeclaracionContext ctx) {
        String nombreVariable = ctx.ID().getText();

        // Si la declaración tiene inicialización, generamos código.
        if (ctx.expresion() != null) {
            String valor = visit(ctx.expresion());
            generador.emitir(nombreVariable + " = " + valor);
        } else {
            // Para declaraciones sin valor inicial, dejamos una instrucción clara.
            generador.emitir("declare " + ctx.tipo().getText() + " " + nombreVariable);
        }

        return null;
    }

    // =========================================================
    // ASIGNACIONES
    // Ejemplo:
    // x = a + b * c;
    // =========================================================
    @Override
    public String visitAsignacion(MiLenguajeParser.AsignacionContext ctx) {
        String nombreVariable = ctx.ID().getText();
        String valor = visit(ctx.expresion());

        generador.emitir(nombreVariable + " = " + valor);

        return null;
    }

    // =========================================================
    // SENTENCIA IF / IF-ELSE
    // Ejemplos:
    // if (x > y) { ... }
    // if (x > y) { ... } else { ... }
    // =========================================================
    @Override
    public String visitSentenciaIf(MiLenguajeParser.SentenciaIfContext ctx) {
        String condicion = visit(ctx.expresion());

        boolean tieneElse = ctx.bloque().size() > 1;

        if (tieneElse) {
            String etiquetaElse = generador.nuevaEtiqueta();
            String etiquetaFin = generador.nuevaEtiqueta();

            generador.emitir("if !" + condicion + " goto " + etiquetaElse);

            // Bloque del IF
            visit(ctx.bloque(0));

            generador.emitir("goto " + etiquetaFin);

            // Bloque del ELSE
            generador.emitir(etiquetaElse + ":");
            visit(ctx.bloque(1));

            // Fin del IF-ELSE
            generador.emitir(etiquetaFin + ":");
        } else {
            String etiquetaFin = generador.nuevaEtiqueta();

            generador.emitir("if !" + condicion + " goto " + etiquetaFin);

            // Bloque del IF
            visit(ctx.bloque(0));

            // Fin del IF
            generador.emitir(etiquetaFin + ":");
        }

        return null;
    }

    // =========================================================
    // SENTENCIA WHILE
    // Ejemplo:
    // while (x < 10) { ... }
    // =========================================================
    @Override
    public String visitSentenciaWhile(MiLenguajeParser.SentenciaWhileContext ctx) {
        String etiquetaInicio = generador.nuevaEtiqueta();
        String etiquetaFin = generador.nuevaEtiqueta();
    
        // Inicio del bucle
        generador.emitir(etiquetaInicio + ":");
    
        // Evaluar condición
        String condicion = visit(ctx.expresion());
    
        // Si la condición es falsa, salir del bucle
        generador.emitir("if !" + condicion + " goto " + etiquetaFin);
    
        // Cuerpo del while
        visit(ctx.bloque());
    
        // Volver a evaluar la condición
        generador.emitir("goto " + etiquetaInicio);
    
        // Fin del bucle
        generador.emitir(etiquetaFin + ":");
    
        return null;
    }

    // =========================================================
    // EXPRESIONES LITERALES Y VARIABLES
    // Estos no generan instrucciones, solo devuelven su texto.
    // =========================================================

    @Override
    public String visitExprEntero(MiLenguajeParser.ExprEnteroContext ctx) {
        return ctx.INTEGER().getText();
    }

    @Override
    public String visitExprDecimal(MiLenguajeParser.ExprDecimalContext ctx) {
        return ctx.DECIMAL().getText();
    }

    @Override
    public String visitExprCaracter(MiLenguajeParser.ExprCaracterContext ctx) {
        return ctx.CHARACTER().getText();
    }

    @Override
    public String visitExprCadena(MiLenguajeParser.ExprCadenaContext ctx) {
        return ctx.CADENA().getText();
    }

    @Override
    public String visitExprVerdadero(MiLenguajeParser.ExprVerdaderoContext ctx) {
        return "true";
    }

    @Override
    public String visitExprFalso(MiLenguajeParser.ExprFalsoContext ctx) {
        return "false";
    }

    @Override
    public String visitExprIdentificador(MiLenguajeParser.ExprIdentificadorContext ctx) {
        return ctx.ID().getText();
    }

    @Override
    public String visitExprAgrupada(MiLenguajeParser.ExprAgrupadaContext ctx) {
        return visit(ctx.expresion());
    }

    // =========================================================
    // EXPRESIONES ARITMÉTICAS
    // Ejemplo:
    // a + b
    // a - b
    // =========================================================
    @Override
    public String visitExprAditiva(MiLenguajeParser.ExprAditivaContext ctx) {
        String izquierda = visit(ctx.expresion(0));
        String derecha = visit(ctx.expresion(1));
        String operador = ctx.getChild(1).getText();

        String temporal = generador.nuevaTemporal();
        generador.emitir(temporal + " = " + izquierda + " " + operador + " " + derecha);

        return temporal;
    }

    // =========================================================
    // EXPRESIONES MULTIPLICATIVAS
    // Ejemplo:
    // a * b
    // a / b
    // a % b
    // =========================================================
    @Override
    public String visitExprMultiplicativa(MiLenguajeParser.ExprMultiplicativaContext ctx) {
        String izquierda = visit(ctx.expresion(0));
        String derecha = visit(ctx.expresion(1));
        String operador = ctx.getChild(1).getText();

        String temporal = generador.nuevaTemporal();
        generador.emitir(temporal + " = " + izquierda + " " + operador + " " + derecha);

        return temporal;
    }

    // =========================================================
    // EXPRESIONES RELACIONALES
    // Ejemplo:
    // a > b
    // x <= 10
    // =========================================================
    @Override
    public String visitExprRelacional(MiLenguajeParser.ExprRelacionalContext ctx) {
        String izquierda = visit(ctx.expresion(0));
        String derecha = visit(ctx.expresion(1));
        String operador = ctx.getChild(1).getText();

        String temporal = generador.nuevaTemporal();
        generador.emitir(temporal + " = " + izquierda + " " + operador + " " + derecha);

        return temporal;
    }

    // =========================================================
    // EXPRESIONES DE IGUALDAD
    // Ejemplo:
    // a == b
    // x != 0
    // =========================================================
    @Override
    public String visitExprIgualdad(MiLenguajeParser.ExprIgualdadContext ctx) {
        String izquierda = visit(ctx.expresion(0));
        String derecha = visit(ctx.expresion(1));
        String operador = ctx.getChild(1).getText();

        String temporal = generador.nuevaTemporal();
        generador.emitir(temporal + " = " + izquierda + " " + operador + " " + derecha);

        return temporal;
    }

    // =========================================================
    // EXPRESIÓN AND
    // Ejemplo:
    // a > b && b > c
    // =========================================================
    @Override
    public String visitExprAnd(MiLenguajeParser.ExprAndContext ctx) {
        String izquierda = visit(ctx.expresion(0));
        String derecha = visit(ctx.expresion(1));

        String temporal = generador.nuevaTemporal();
        generador.emitir(temporal + " = " + izquierda + " && " + derecha);

        return temporal;
    }

    // =========================================================
    // EXPRESIÓN OR
    // Ejemplo:
    // a > b || c == 0
    // =========================================================
    @Override
    public String visitExprOr(MiLenguajeParser.ExprOrContext ctx) {
        String izquierda = visit(ctx.expresion(0));
        String derecha = visit(ctx.expresion(1));

        String temporal = generador.nuevaTemporal();
        generador.emitir(temporal + " = " + izquierda + " || " + derecha);

        return temporal;
    }

    // =========================================================
    // EXPRESIÓN NOT
    // Ejemplo:
    // !activo
    // !(a > b)
    // =========================================================
    @Override
    public String visitExprNot(MiLenguajeParser.ExprNotContext ctx) {
        String valor = visit(ctx.expresion());

        String temporal = generador.nuevaTemporal();
        generador.emitir(temporal + " = !" + valor);

        return temporal;
    }

        // =========================================================
        // EXPRESIÓN NEGATIVA
        // Ejemplo:
        // -x
        // -(a + b)
        // =========================================================
        @Override
        public String visitExprNegativo(MiLenguajeParser.ExprNegativoContext ctx) {
            String valor = visit(ctx.expresion());

            String temporal = generador.nuevaTemporal();
            generador.emitir(temporal + " = -" + valor);

            return temporal;
        }
    }