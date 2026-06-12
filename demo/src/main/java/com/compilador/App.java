package com.compilador;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.TreeViewer;
import javax.swing.*;
import java.util.Arrays;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.compilador.SymbolTable;
import com.compilador.semantico.SemanticAnalyzerVisitor;
import com.compilador.semantico.SemanticError;
import com.compilador.semantico.SemanticWarning;

/**
 * Punto de entrada del compilador educativo.
 *
 * Este programa realiza DOS fases del análisis:
 * 1. ANÁLISIS LÉXICO — convierte el texto en tokens
 * 2. ANÁLISIS SINTÁCTICO — verifica que los tokens forman
 * estructuras válidas según la gramática
 *
 * Para ejecutar:
 * java -jar demo-1.0-jar-with-dependencies.jar <archivo.txt>
 */
public class App {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java -jar demo-1.0-jar-with-dependencies.jar <archivo.txt>");
            System.exit(1);
        }

        try {
            // Cargar el archivo de texto como un stream de caracteres
            CharStream input = CharStreams.fromFileName(args[0]);
            System.out.println("🚀 Iniciando compilación de: " + args[0]);
            System.out.println("=".repeat(65));

            // =========================================================
            // FASE 1: ANÁLISIS LÉXICO
            //
            // El Lexer lee los caracteres del archivo y los agrupa
            // en unidades con significado llamadas TOKENS.
            //
            // Ejemplo:
            // "int x = 5 + 3 ;" → [INT] [ID:x] [IGUAL] [INTEGER:5]
            // [SUM] [INTEGER:3] [PYC]
            // =========================================================

            MiLenguajeLexer lexer = new MiLenguajeLexer(input);

            // Reemplazamos el manejador de errores por defecto del lexer.
            // Por defecto ANTLR imprime errores en System.err; aquí los
            // capturamos para mostrarlos de forma más clara.
            List<String> erroresLexicos = new ArrayList<>();
            lexer.removeErrorListeners();
            lexer.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer,
                        Object offendingSymbol,
                        int line, int charPositionInLine,
                        String msg, RecognitionException e) {
                    erroresLexicos.add(
                            "  [Linea " + line + ":" + charPositionInLine + "] " + msg);
                }
            });

            // fill() ejecuta el lexer y almacena TODOS los tokens en memoria.
            // Esto nos permite mostrarlos y luego reutilizarlos para el parser.
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            tokens.fill();

            // Mostrar tabla de tokens
            System.out.println("\n=== 1. ANÁLISIS LÉXICO ===\n");
            System.out.printf("  %-20s %-25s %-8s %-8s%n",
                    "TIPO DE TOKEN", "LEXEMA", "LINEA", "COLUMNA");
            System.out.println("  " + "-".repeat(63));

            for (Token token : tokens.getTokens()) {
                if (token.getType() == Token.EOF)
                    continue;

                String tipo = MiLenguajeLexer.VOCABULARY.getSymbolicName(token.getType());
                // Si el tipo es null, probablemente es OTRO (char no reconocido)
                if (tipo == null)
                    tipo = "DESCONOCIDO";

                System.out.printf("  %-20s %-25s %-8d %-8d%n",
                        tipo,
                        token.getText(),
                        token.getLine(),
                        token.getCharPositionInLine());
            }

            // Si hubo errores léxicos, reportar y detener
            if (!erroresLexicos.isEmpty()) {
                System.out.println("\n ERRORES LEXICOS:");
                for (String error : erroresLexicos) {
                    System.out.println(error);
                }
                System.out.println("\n El analisis no puede continuar con errores léxicos.");
                return;
            }

            System.out.println("\nAnalisis léxico completado sin errores.");
            System.out.println("  📊 Tokens procesados: " + (tokens.getTokens().size() - 1));

            // =========================================================
            // FASE 2: ANÁLISIS SINTÁCTICO (PARSING)
            //
            // El Parser recibe los tokens y verifica que forman
            // estructuras válidas según las REGLAS de la gramática.
            //
            // Si la estructura es válida, construye un ÁRBOL DE PARSEO
            // (Parse Tree) que representa la jerarquía del programa.
            //
            // Ejemplo para "int x = 5 + 3;":
            // programa
            // sentencia
            // declaracion
            // tipo: INT
            // ID: x
            // expresion
            // exprAditiva
            // exprEntero: 5
            // SUM
            // exprEntero: 3
            // =========================================================

            System.out.println("\n===  2. ANÁLISIS SINTÁCTICO ===\n");

            // El parser necesita leer los tokens desde el principio.
            // reset() rebobina el stream al token 0.
            tokens.reset();

            MiLenguajeParser parser = new MiLenguajeParser(tokens);

            // Capturar errores sintácticos de forma personalizada
            List<String> erroresSintacticos = new ArrayList<>();
            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer,
                        Object offendingSymbol,
                        int line, int charPositionInLine,
                        String msg, RecognitionException e) {
                    String tokenErroneo = (offendingSymbol != null)
                            ? "'" + offendingSymbol + "'"
                            : "fin de archivo";
                    erroresSintacticos.add(
                            "  [Linea " + line + ":" + charPositionInLine + "] "
                                    + "cerca de " + tokenErroneo + " → " + msg);
                }
            });

            // Ejecutar el parser desde la REGLA INICIAL 'programa'.
            // Esta llamada construye el árbol de parseo (o reporta errores).
            MiLenguajeParser.ProgramaContext arbolParseo = parser.programa();

            // Verificar si hubo errores
            if (!erroresSintacticos.isEmpty()) {
                System.out.println("ERRORES SINTACTICOS:");
                for (String error : erroresSintacticos) {
                    System.out.println(error);
                }
                System.out.println();
                System.out.println("  Pista: revisa que cada sentencia:");
                System.out.println("    - Termine con punto y coma ';'");
                System.out.println("    - Tenga paréntesis balanceados");
                System.out.println("    - Use tipos válidos (int, float, string, bool, char, double)");
                return;
            }

            System.out.println("Analisis sintactico completado sin errores.");

            System.out.println("\n=== 3. ANÁLISIS SEMÁNTICO ===\n");

            SymbolTable symbolTable = new SymbolTable();
            SemanticAnalyzerVisitor semanticAnalyzer = new SemanticAnalyzerVisitor(symbolTable);
            semanticAnalyzer.visit(arbolParseo);

            symbolTable.imprimirTabla();

            if (!semanticAnalyzer.getWarnings().isEmpty()) {
                System.out.println("WARNINGS SEMANTICOS:");
                for (SemanticWarning warning : semanticAnalyzer.getWarnings()) {
                    System.out.println("  " + warning);
                }
                System.out.println();
            }

            if (semanticAnalyzer.hayErrores()) {
                System.out.println("ERRORES SEMÁNTICOS:");
                for (SemanticError error : semanticAnalyzer.getErrores()) {
                    System.out.println("  " + error);
                }
                System.out.println("\n  El analisis no puede continuar con errores semanticos.");
                return;
            }

            System.out.println("Analisis semantico completado sin errores.");

            System.out.println("\n=== 4. GENERACIÓN DE CÓDIGO INTERMEDIO ===\n");

            GeneradorCodigo generadorCodigo = new GeneradorCodigo();
            CodigoVisitor codigoVisitor = new CodigoVisitor(generadorCodigo);

            codigoVisitor.visit(arbolParseo);

            System.out.println("  📝 Código de tres direcciones generado:\n");

            generadorCodigo.imprimirCodigo();

            String archivoCodigoIntermedio = args[0].replace(".txt", "_codigo_intermedio.txt")
                    .replace(".cpp", "_codigo_intermedio.txt");

            generadorCodigo.guardarCodigo(archivoCodigoIntermedio);

            System.out.println("\n  ✅ Código intermedio guardado en: " + archivoCodigoIntermedio);

            System.out.println("\n=== 5. OPTIMIZACIÓN DE CÓDIGO ===\n");

            List<String> codigoIntermedio = generadorCodigo.getCodigo();

            // Elegir una optimización descomentando solo una línea:
            OptimizadorIntermedio optimizador = new OptimizadorCodigoMuerto(codigoIntermedio);
            // OptimizadorIntermedio optimizador = new OptimizadorSentenciasRedundantes(codigoIntermedio);
            // OptimizadorIntermedio optimizador = new OptimizadorSimplificacionExpresiones(codigoIntermedio);
            // OptimizadorIntermedio optimizador = new OptimizadorPropagacionConstantes(codigoIntermedio);

            List<String> codigoOptimizado = optimizador.optimizar();
            optimizador.imprimirResumen();
            optimizador.imprimirCodigoOptimizado();

            String archivoCodigoOptimizado = args[0].replace(".txt", "_codigo_optimizado.txt")
                    .replace(".cpp", "_codigo_optimizado.txt");

            try (java.io.PrintWriter writer = new java.io.PrintWriter(archivoCodigoOptimizado)) {
                for (String linea : codigoOptimizado) {
                    writer.println(linea);
                }
            }

            System.out.println("\n  ✅ Código optimizado guardado en: " + archivoCodigoOptimizado);

            System.out.println("\n=== RESUMEN DE COMPILACIÓN ===");

            System.out.println("  📁 Archivo procesado: " + args[0]);
            System.out.println("  🔤 Tokens analizados: " + (tokens.getTokens().size() - 1));
            System.out.println("  ✅ Errores léxicos: 0");
            System.out.println("  ✅ Errores sintácticos: 0");
            System.out.println("  ✅ Errores semánticos: 0");
            System.out.println("  📄 Archivo código intermedio: " + archivoCodigoIntermedio);
            System.out.println("  📄 Archivo código optimizado: " + archivoCodigoOptimizado);

            System.out.println("\n🎉 ¡COMPILACIÓN EXITOSA! 🎉");

            // =========================================================
            // VISUALIZADOR GRÁFICO (Swing)
            //
            // TreeViewer es la herramienta de depuración incluida en
            // ANTLR4. Abre una ventana Swing con el árbol de parseo
            // completo, interactivo y con zoom.
            //
            // Se muestra DESPUÉS de la salida en consola para que
            // el alumno pueda leer primero la salida de texto.
            // =========================================================

            System.out.println("\n  Abriendo visualizador grafico del arbol...");
            mostrarArbol(arbolParseo, parser);

        } catch (IOException e) {
            System.err.println("No se pudo leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }

    }

    // =========================================================
    // ÁRBOL VISUAL — métodos auxiliares
    // =========================================================
    private static void mostrarArbol(ParseTree tree, Parser parser) {
        JFrame frame = new JFrame("Arbol Sintáctico");
        JPanel panel = new JPanel();
        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
        viewer.setScale(1.5);
        panel.add(viewer);

        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
