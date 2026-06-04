// Generated from com\compilador\MiLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiLenguajeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PA=1, PC=2, CA=3, CC=4, LA=5, LC=6, PYC=7, COMA=8, IGUAL=9, EQL=10, DISTINTO=11, 
		MAYOR_IGUAL=12, MENOR_IGUAL=13, MAYOR=14, MENOR=15, SHIFT_L=16, SUM=17, 
		RES=18, MUL=19, DIV=20, MOD=21, OR=22, AND=23, NOT=24, FOR=25, WHILE=26, 
		IF=27, ELSE=28, BREAK=29, CONTINUE=30, RETURN=31, INT=32, FLOAT=33, DOUBLE=34, 
		CHAR=35, STRING_TYPE=36, BOOL=37, VOID=38, VERDADERO=39, FALSO=40, COUT=41, 
		ID=42, INTEGER=43, DECIMAL=44, CHARACTER=45, CADENA=46, COMENTARIO_LINEA=47, 
		COMENTARIO_BLOQUE=48, WS=49, OTRO=50;
	public static final int
		RULE_programa = 0, RULE_sentencia = 1, RULE_declaracion = 2, RULE_tipo = 3, 
		RULE_asignacion = 4, RULE_sentenciaCout = 5, RULE_sentenciaIf = 6, RULE_sentenciaWhile = 7, 
		RULE_sentenciaFor = 8, RULE_inicializacionFor = 9, RULE_actualizacionFor = 10, 
		RULE_sentenciaBreak = 11, RULE_sentenciaContinue = 12, RULE_sentenciaReturn = 13, 
		RULE_bloque = 14, RULE_expresion = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "sentencia", "declaracion", "tipo", "asignacion", "sentenciaCout", 
			"sentenciaIf", "sentenciaWhile", "sentenciaFor", "inicializacionFor", 
			"actualizacionFor", "sentenciaBreak", "sentenciaContinue", "sentenciaReturn", 
			"bloque", "expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", "','", "'='", 
			"'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'<<'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'||'", "'&&'", "'!'", "'for'", "'while'", "'if'", "'else'", 
			"'break'", "'continue'", "'return'", "'int'", "'float'", "'double'", 
			"'char'", "'string'", "'bool'", "'void'", "'true'", "'false'", "'cout'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PA", "PC", "CA", "CC", "LA", "LC", "PYC", "COMA", "IGUAL", "EQL", 
			"DISTINTO", "MAYOR_IGUAL", "MENOR_IGUAL", "MAYOR", "MENOR", "SHIFT_L", 
			"SUM", "RES", "MUL", "DIV", "MOD", "OR", "AND", "NOT", "FOR", "WHILE", 
			"IF", "ELSE", "BREAK", "CONTINUE", "RETURN", "INT", "FLOAT", "DOUBLE", 
			"CHAR", "STRING_TYPE", "BOOL", "VOID", "VERDADERO", "FALSO", "COUT", 
			"ID", "INTEGER", "DECIMAL", "CHARACTER", "CADENA", "COMENTARIO_LINEA", 
			"COMENTARIO_BLOQUE", "WS", "OTRO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiLenguaje.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiLenguajeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiLenguajeParser.EOF, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LA) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << BREAK) | (1L << CONTINUE) | (1L << RETURN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << CHAR) | (1L << STRING_TYPE) | (1L << BOOL) | (1L << VOID) | (1L << COUT) | (1L << ID))) != 0)) {
				{
				{
				setState(32);
				sentencia();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaContext extends ParserRuleContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public SentenciaCoutContext sentenciaCout() {
			return getRuleContext(SentenciaCoutContext.class,0);
		}
		public SentenciaIfContext sentenciaIf() {
			return getRuleContext(SentenciaIfContext.class,0);
		}
		public SentenciaWhileContext sentenciaWhile() {
			return getRuleContext(SentenciaWhileContext.class,0);
		}
		public SentenciaForContext sentenciaFor() {
			return getRuleContext(SentenciaForContext.class,0);
		}
		public SentenciaBreakContext sentenciaBreak() {
			return getRuleContext(SentenciaBreakContext.class,0);
		}
		public SentenciaContinueContext sentenciaContinue() {
			return getRuleContext(SentenciaContinueContext.class,0);
		}
		public SentenciaReturnContext sentenciaReturn() {
			return getRuleContext(SentenciaReturnContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentencia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sentencia);
		try {
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case CHAR:
			case STRING_TYPE:
			case BOOL:
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				declaracion();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				asignacion();
				}
				break;
			case COUT:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				sentenciaCout();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				sentenciaIf();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				sentenciaWhile();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 6);
				{
				setState(45);
				sentenciaFor();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 7);
				{
				setState(46);
				sentenciaBreak();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 8);
				{
				setState(47);
				sentenciaContinue();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 9);
				{
				setState(48);
				sentenciaReturn();
				}
				break;
			case LA:
				enterOuterAlt(_localctx, 10);
				{
				setState(49);
				bloque();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracionContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			tipo();
			setState(53);
			match(ID);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IGUAL) {
				{
				setState(54);
				match(IGUAL);
				setState(55);
				expresion(0);
				}
			}

			setState(58);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiLenguajeParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(MiLenguajeParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(MiLenguajeParser.DOUBLE, 0); }
		public TerminalNode CHAR() { return getToken(MiLenguajeParser.CHAR, 0); }
		public TerminalNode STRING_TYPE() { return getToken(MiLenguajeParser.STRING_TYPE, 0); }
		public TerminalNode BOOL() { return getToken(MiLenguajeParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(MiLenguajeParser.VOID, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << CHAR) | (1L << STRING_TYPE) | (1L << BOOL) | (1L << VOID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsignacionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(ID);
			setState(63);
			match(IGUAL);
			setState(64);
			expresion(0);
			setState(65);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaCoutContext extends ParserRuleContext {
		public TerminalNode COUT() { return getToken(MiLenguajeParser.COUT, 0); }
		public TerminalNode SHIFT_L() { return getToken(MiLenguajeParser.SHIFT_L, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public SentenciaCoutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaCout; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaCout(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaCoutContext sentenciaCout() throws RecognitionException {
		SentenciaCoutContext _localctx = new SentenciaCoutContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sentenciaCout);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(COUT);
			setState(68);
			match(SHIFT_L);
			setState(69);
			expresion(0);
			setState(70);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaIfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiLenguajeParser.IF, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiLenguajeParser.ELSE, 0); }
		public SentenciaIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaIf; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaIfContext sentenciaIf() throws RecognitionException {
		SentenciaIfContext _localctx = new SentenciaIfContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sentenciaIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(IF);
			setState(73);
			match(PA);
			setState(74);
			expresion(0);
			setState(75);
			match(PC);
			setState(76);
			bloque();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(77);
				match(ELSE);
				setState(78);
				bloque();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaWhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiLenguajeParser.WHILE, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public SentenciaWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaWhile; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaWhileContext sentenciaWhile() throws RecognitionException {
		SentenciaWhileContext _localctx = new SentenciaWhileContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sentenciaWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(WHILE);
			setState(82);
			match(PA);
			setState(83);
			expresion(0);
			setState(84);
			match(PC);
			setState(85);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaForContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiLenguajeParser.FOR, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public InicializacionForContext inicializacionFor() {
			return getRuleContext(InicializacionForContext.class,0);
		}
		public List<TerminalNode> PYC() { return getTokens(MiLenguajeParser.PYC); }
		public TerminalNode PYC(int i) {
			return getToken(MiLenguajeParser.PYC, i);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ActualizacionForContext actualizacionFor() {
			return getRuleContext(ActualizacionForContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public SentenciaForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaFor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaForContext sentenciaFor() throws RecognitionException {
		SentenciaForContext _localctx = new SentenciaForContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sentenciaFor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(FOR);
			setState(88);
			match(PA);
			setState(89);
			inicializacionFor();
			setState(90);
			match(PYC);
			setState(91);
			expresion(0);
			setState(92);
			match(PYC);
			setState(93);
			actualizacionFor();
			setState(94);
			match(PC);
			setState(95);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InicializacionForContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public InicializacionForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicializacionFor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitInicializacionFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicializacionForContext inicializacionFor() throws RecognitionException {
		InicializacionForContext _localctx = new InicializacionForContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_inicializacionFor);
		try {
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case CHAR:
			case STRING_TYPE:
			case BOOL:
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				tipo();
				setState(98);
				match(ID);
				setState(99);
				match(IGUAL);
				setState(100);
				expresion(0);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(ID);
				setState(103);
				match(IGUAL);
				setState(104);
				expresion(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActualizacionForContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ActualizacionForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualizacionFor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitActualizacionFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualizacionForContext actualizacionFor() throws RecognitionException {
		ActualizacionForContext _localctx = new ActualizacionForContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_actualizacionFor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(ID);
			setState(108);
			match(IGUAL);
			setState(109);
			expresion(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaBreakContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(MiLenguajeParser.BREAK, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public SentenciaBreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaBreak; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaBreakContext sentenciaBreak() throws RecognitionException {
		SentenciaBreakContext _localctx = new SentenciaBreakContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sentenciaBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(BREAK);
			setState(112);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaContinueContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(MiLenguajeParser.CONTINUE, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public SentenciaContinueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaContinue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaContinue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaContinueContext sentenciaContinue() throws RecognitionException {
		SentenciaContinueContext _localctx = new SentenciaContinueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sentenciaContinue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(CONTINUE);
			setState(115);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiLenguajeParser.RETURN, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public SentenciaReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaReturn; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaReturnContext sentenciaReturn() throws RecognitionException {
		SentenciaReturnContext _localctx = new SentenciaReturnContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sentenciaReturn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(RETURN);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PA) | (1L << RES) | (1L << NOT) | (1L << VERDADERO) | (1L << FALSO) | (1L << ID) | (1L << INTEGER) | (1L << DECIMAL) | (1L << CHARACTER) | (1L << CADENA))) != 0)) {
				{
				setState(118);
				expresion(0);
				}
			}

			setState(121);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode LA() { return getToken(MiLenguajeParser.LA, 0); }
		public TerminalNode LC() { return getToken(MiLenguajeParser.LC, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(LA);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LA) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << BREAK) | (1L << CONTINUE) | (1L << RETURN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << CHAR) | (1L << STRING_TYPE) | (1L << BOOL) | (1L << VOID) | (1L << COUT) | (1L << ID))) != 0)) {
				{
				{
				setState(124);
				sentencia();
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130);
			match(LC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpresionContext extends ParserRuleContext {
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	 
		public ExpresionContext() { }
		public void copyFrom(ExpresionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprIdentificadorContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public ExprIdentificadorContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprIdentificador(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNotContext extends ExpresionContext {
		public TerminalNode NOT() { return getToken(MiLenguajeParser.NOT, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExprNotContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAditivaContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode SUM() { return getToken(MiLenguajeParser.SUM, 0); }
		public TerminalNode RES() { return getToken(MiLenguajeParser.RES, 0); }
		public ExprAditivaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprAditiva(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprRelacionalContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MAYOR() { return getToken(MiLenguajeParser.MAYOR, 0); }
		public TerminalNode MENOR() { return getToken(MiLenguajeParser.MENOR, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(MiLenguajeParser.MAYOR_IGUAL, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(MiLenguajeParser.MENOR_IGUAL, 0); }
		public ExprRelacionalContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprRelacional(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAgrupadaContext extends ExpresionContext {
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public ExprAgrupadaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprAgrupada(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprFalsoContext extends ExpresionContext {
		public TerminalNode FALSO() { return getToken(MiLenguajeParser.FALSO, 0); }
		public ExprFalsoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprFalso(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprOrContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode OR() { return getToken(MiLenguajeParser.OR, 0); }
		public ExprOrContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNegativoContext extends ExpresionContext {
		public TerminalNode RES() { return getToken(MiLenguajeParser.RES, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExprNegativoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprNegativo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprCadenaContext extends ExpresionContext {
		public TerminalNode CADENA() { return getToken(MiLenguajeParser.CADENA, 0); }
		public ExprCadenaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprCadena(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprEnteroContext extends ExpresionContext {
		public TerminalNode INTEGER() { return getToken(MiLenguajeParser.INTEGER, 0); }
		public ExprEnteroContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprEntero(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprVerdaderoContext extends ExpresionContext {
		public TerminalNode VERDADERO() { return getToken(MiLenguajeParser.VERDADERO, 0); }
		public ExprVerdaderoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprVerdadero(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprIgualdadContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode EQL() { return getToken(MiLenguajeParser.EQL, 0); }
		public TerminalNode DISTINTO() { return getToken(MiLenguajeParser.DISTINTO, 0); }
		public ExprIgualdadContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprIgualdad(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAndContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode AND() { return getToken(MiLenguajeParser.AND, 0); }
		public ExprAndContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprCaracterContext extends ExpresionContext {
		public TerminalNode CHARACTER() { return getToken(MiLenguajeParser.CHARACTER, 0); }
		public ExprCaracterContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprCaracter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMultiplicativaContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(MiLenguajeParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MiLenguajeParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MiLenguajeParser.MOD, 0); }
		public ExprMultiplicativaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprMultiplicativa(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprDecimalContext extends ExpresionContext {
		public TerminalNode DECIMAL() { return getToken(MiLenguajeParser.DECIMAL, 0); }
		public ExprDecimalContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprDecimal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new ExprNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(133);
				match(NOT);
				setState(134);
				expresion(10);
				}
				break;
			case RES:
				{
				_localctx = new ExprNegativoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				match(RES);
				setState(136);
				expresion(9);
				}
				break;
			case PA:
				{
				_localctx = new ExprAgrupadaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				match(PA);
				setState(138);
				expresion(0);
				setState(139);
				match(PC);
				}
				break;
			case INTEGER:
				{
				_localctx = new ExprEnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				match(INTEGER);
				}
				break;
			case DECIMAL:
				{
				_localctx = new ExprDecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(DECIMAL);
				}
				break;
			case CHARACTER:
				{
				_localctx = new ExprCaracterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(CHARACTER);
				}
				break;
			case CADENA:
				{
				_localctx = new ExprCadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				match(CADENA);
				}
				break;
			case VERDADERO:
				{
				_localctx = new ExprVerdaderoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(VERDADERO);
				}
				break;
			case FALSO:
				{
				_localctx = new ExprFalsoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(FALSO);
				}
				break;
			case ID:
				{
				_localctx = new ExprIdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(168);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExprOrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(150);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(151);
						match(OR);
						setState(152);
						expresion(17);
						}
						break;
					case 2:
						{
						_localctx = new ExprAndContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(153);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(154);
						match(AND);
						setState(155);
						expresion(16);
						}
						break;
					case 3:
						{
						_localctx = new ExprIgualdadContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(156);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(157);
						_la = _input.LA(1);
						if ( !(_la==EQL || _la==DISTINTO) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(158);
						expresion(15);
						}
						break;
					case 4:
						{
						_localctx = new ExprRelacionalContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(159);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(160);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MAYOR_IGUAL) | (1L << MENOR_IGUAL) | (1L << MAYOR) | (1L << MENOR))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(161);
						expresion(14);
						}
						break;
					case 5:
						{
						_localctx = new ExprAditivaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(162);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(163);
						_la = _input.LA(1);
						if ( !(_la==SUM || _la==RES) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(164);
						expresion(13);
						}
						break;
					case 6:
						{
						_localctx = new ExprMultiplicativaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(165);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(166);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(167);
						expresion(12);
						}
						break;
					}
					} 
				}
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u00b0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2"+
		"$\n\2\f\2\16\2\'\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3\65\n\3\3\4\3\4\3\4\3\4\5\4;\n\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bR\n\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13l\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\17\3\17\5\17z\n\17\3\17\3\17\3\20\3\20\7\20\u0080\n\20\f"+
		"\20\16\20\u0083\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0097\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\7\21\u00ab\n\21\f\21\16\21\u00ae\13\21\3\21\2\3 \22\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \2\7\3\2\"(\3\2\f\r\3\2\16\21\3\2\23\24\3"+
		"\2\25\27\2\u00bd\2%\3\2\2\2\4\64\3\2\2\2\6\66\3\2\2\2\b>\3\2\2\2\n@\3"+
		"\2\2\2\fE\3\2\2\2\16J\3\2\2\2\20S\3\2\2\2\22Y\3\2\2\2\24k\3\2\2\2\26m"+
		"\3\2\2\2\30q\3\2\2\2\32t\3\2\2\2\34w\3\2\2\2\36}\3\2\2\2 \u0096\3\2\2"+
		"\2\"$\5\4\3\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'%\3"+
		"\2\2\2()\7\2\2\3)\3\3\2\2\2*\65\5\6\4\2+\65\5\n\6\2,\65\5\f\7\2-\65\5"+
		"\16\b\2.\65\5\20\t\2/\65\5\22\n\2\60\65\5\30\r\2\61\65\5\32\16\2\62\65"+
		"\5\34\17\2\63\65\5\36\20\2\64*\3\2\2\2\64+\3\2\2\2\64,\3\2\2\2\64-\3\2"+
		"\2\2\64.\3\2\2\2\64/\3\2\2\2\64\60\3\2\2\2\64\61\3\2\2\2\64\62\3\2\2\2"+
		"\64\63\3\2\2\2\65\5\3\2\2\2\66\67\5\b\5\2\67:\7,\2\289\7\13\2\29;\5 \21"+
		"\2:8\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\7\t\2\2=\7\3\2\2\2>?\t\2\2\2?\t\3\2"+
		"\2\2@A\7,\2\2AB\7\13\2\2BC\5 \21\2CD\7\t\2\2D\13\3\2\2\2EF\7+\2\2FG\7"+
		"\22\2\2GH\5 \21\2HI\7\t\2\2I\r\3\2\2\2JK\7\35\2\2KL\7\3\2\2LM\5 \21\2"+
		"MN\7\4\2\2NQ\5\36\20\2OP\7\36\2\2PR\5\36\20\2QO\3\2\2\2QR\3\2\2\2R\17"+
		"\3\2\2\2ST\7\34\2\2TU\7\3\2\2UV\5 \21\2VW\7\4\2\2WX\5\36\20\2X\21\3\2"+
		"\2\2YZ\7\33\2\2Z[\7\3\2\2[\\\5\24\13\2\\]\7\t\2\2]^\5 \21\2^_\7\t\2\2"+
		"_`\5\26\f\2`a\7\4\2\2ab\5\36\20\2b\23\3\2\2\2cd\5\b\5\2de\7,\2\2ef\7\13"+
		"\2\2fg\5 \21\2gl\3\2\2\2hi\7,\2\2ij\7\13\2\2jl\5 \21\2kc\3\2\2\2kh\3\2"+
		"\2\2l\25\3\2\2\2mn\7,\2\2no\7\13\2\2op\5 \21\2p\27\3\2\2\2qr\7\37\2\2"+
		"rs\7\t\2\2s\31\3\2\2\2tu\7 \2\2uv\7\t\2\2v\33\3\2\2\2wy\7!\2\2xz\5 \21"+
		"\2yx\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7\t\2\2|\35\3\2\2\2}\u0081\7\7\2\2"+
		"~\u0080\5\4\3\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\7\b"+
		"\2\2\u0085\37\3\2\2\2\u0086\u0087\b\21\1\2\u0087\u0088\7\32\2\2\u0088"+
		"\u0097\5 \21\f\u0089\u008a\7\24\2\2\u008a\u0097\5 \21\13\u008b\u008c\7"+
		"\3\2\2\u008c\u008d\5 \21\2\u008d\u008e\7\4\2\2\u008e\u0097\3\2\2\2\u008f"+
		"\u0097\7-\2\2\u0090\u0097\7.\2\2\u0091\u0097\7/\2\2\u0092\u0097\7\60\2"+
		"\2\u0093\u0097\7)\2\2\u0094\u0097\7*\2\2\u0095\u0097\7,\2\2\u0096\u0086"+
		"\3\2\2\2\u0096\u0089\3\2\2\2\u0096\u008b\3\2\2\2\u0096\u008f\3\2\2\2\u0096"+
		"\u0090\3\2\2\2\u0096\u0091\3\2\2\2\u0096\u0092\3\2\2\2\u0096\u0093\3\2"+
		"\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0097\u00ac\3\2\2\2\u0098"+
		"\u0099\f\22\2\2\u0099\u009a\7\30\2\2\u009a\u00ab\5 \21\23\u009b\u009c"+
		"\f\21\2\2\u009c\u009d\7\31\2\2\u009d\u00ab\5 \21\22\u009e\u009f\f\20\2"+
		"\2\u009f\u00a0\t\3\2\2\u00a0\u00ab\5 \21\21\u00a1\u00a2\f\17\2\2\u00a2"+
		"\u00a3\t\4\2\2\u00a3\u00ab\5 \21\20\u00a4\u00a5\f\16\2\2\u00a5\u00a6\t"+
		"\5\2\2\u00a6\u00ab\5 \21\17\u00a7\u00a8\f\r\2\2\u00a8\u00a9\t\6\2\2\u00a9"+
		"\u00ab\5 \21\16\u00aa\u0098\3\2\2\2\u00aa\u009b\3\2\2\2\u00aa\u009e\3"+
		"\2\2\2\u00aa\u00a1\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa\u00a7\3\2\2\2\u00ab"+
		"\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad!\3\2\2\2"+
		"\u00ae\u00ac\3\2\2\2\f%\64:Qky\u0081\u0096\u00aa\u00ac";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}