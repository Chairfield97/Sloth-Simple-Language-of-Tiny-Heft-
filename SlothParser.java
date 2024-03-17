// Generated from SlothParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SlothParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BEGIN=1, END=2, IF=3, THEN=4, ELSE=5, WHILE=6, DO=7, PRINT=8, PRINTLN=9, 
		READINT=10, READREAL=11, READBOOL=12, READSTRING=13, TRUE=14, FALSE=15, 
		PLUS=16, MINUS=17, DIVIDE=18, TIMES=19, LTHAN=20, GTHAN=21, LTEQ=22, GTEQ=23, 
		EQUAL=24, NOTEQ=25, AND=26, OR=27, NOT=28, SEMICOL=29, WALRUS=30, LPAREN=31, 
		RPAREN=32, ID=33, INTVAL=34, REALVAL=35, STRINGVAL=36, COMMENT=37, NEWLINE=38, 
		WS=39;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_expression = 2, RULE_term = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "expression", "term"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'begin'", "'end'", "'if'", "'then'", "'else'", "'while'", "'do'", 
			"'print'", "'println'", "'readInt'", "'readReal'", "'readBool'", "'readString'", 
			"'true'", "'false'", "'+'", "'-'", "'/'", "'*'", "'<'", "'>'", "'<='", 
			"'>='", "'=='", "'!='", "'&&'", "'||'", "'!'", "';'", "':='", "'('", 
			"')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BEGIN", "END", "IF", "THEN", "ELSE", "WHILE", "DO", "PRINT", "PRINTLN", 
			"READINT", "READREAL", "READBOOL", "READSTRING", "TRUE", "FALSE", "PLUS", 
			"MINUS", "DIVIDE", "TIMES", "LTHAN", "GTHAN", "LTEQ", "GTEQ", "EQUAL", 
			"NOTEQ", "AND", "OR", "NOT", "SEMICOL", "WALRUS", "LPAREN", "RPAREN", 
			"ID", "INTVAL", "REALVAL", "STRINGVAL", "COMMENT", "NEWLINE", "WS"
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
	public String getGrammarFileName() { return "SlothParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SlothParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589935434L) != 0)) {
				{
				{
				setState(8);
				statement();
				}
				}
				setState(13);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends StatementContext {
		public TerminalNode PRINT() { return getToken(SlothParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(SlothParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SlothParser.RPAREN, 0); }
		public TerminalNode SEMICOL() { return getToken(SlothParser.SEMICOL, 0); }
		public PrintContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintlnContext extends StatementContext {
		public TerminalNode PRINTLN() { return getToken(SlothParser.PRINTLN, 0); }
		public TerminalNode LPAREN() { return getToken(SlothParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SlothParser.RPAREN, 0); }
		public TerminalNode SEMICOL() { return getToken(SlothParser.SEMICOL, 0); }
		public PrintlnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitPrintln(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(SlothParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DO() { return getToken(SlothParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends StatementContext {
		public TerminalNode IF() { return getToken(SlothParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(SlothParser.THEN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BeginContext extends StatementContext {
		public TerminalNode BEGIN() { return getToken(SlothParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(SlothParser.END, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BeginContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitBegin(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends StatementContext {
		public TerminalNode ID() { return getToken(SlothParser.ID, 0); }
		public TerminalNode WALRUS() { return getToken(SlothParser.WALRUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOL() { return getToken(SlothParser.SEMICOL, 0); }
		public AssignContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfelseContext extends StatementContext {
		public TerminalNode IF() { return getToken(SlothParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(SlothParser.THEN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SlothParser.ELSE, 0); }
		public IfelseContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitIfelse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				match(ID);
				setState(15);
				match(WALRUS);
				setState(16);
				expression(0);
				setState(17);
				match(SEMICOL);
				}
				break;
			case 2:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				match(IF);
				setState(20);
				expression(0);
				setState(21);
				match(THEN);
				setState(22);
				statement();
				}
				break;
			case 3:
				_localctx = new IfelseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(24);
				match(IF);
				setState(25);
				expression(0);
				setState(26);
				match(THEN);
				setState(27);
				statement();
				setState(28);
				match(ELSE);
				setState(29);
				statement();
				}
				break;
			case 4:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(31);
				match(WHILE);
				setState(32);
				expression(0);
				setState(33);
				match(DO);
				setState(34);
				statement();
				}
				break;
			case 5:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(36);
				match(PRINT);
				setState(37);
				match(LPAREN);
				setState(38);
				expression(0);
				setState(39);
				match(RPAREN);
				setState(40);
				match(SEMICOL);
				}
				break;
			case 6:
				_localctx = new PrintlnContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(42);
				match(PRINTLN);
				setState(43);
				match(LPAREN);
				setState(44);
				expression(0);
				setState(45);
				match(RPAREN);
				setState(46);
				match(SEMICOL);
				}
				break;
			case 7:
				_localctx = new BeginContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(48);
				match(BEGIN);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589935434L) != 0)) {
					{
					{
					setState(49);
					statement();
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(55);
				match(END);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimesdivContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode TIMES() { return getToken(SlothParser.TIMES, 0); }
		public TerminalNode DIVIDE() { return getToken(SlothParser.DIVIDE, 0); }
		public TimesdivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitTimesdiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusminusContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(SlothParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SlothParser.MINUS, 0); }
		public PlusminusContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitPlusminus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(SlothParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompareContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LTHAN() { return getToken(SlothParser.LTHAN, 0); }
		public TerminalNode LTEQ() { return getToken(SlothParser.LTEQ, 0); }
		public TerminalNode GTHAN() { return getToken(SlothParser.GTHAN, 0); }
		public TerminalNode GTEQ() { return getToken(SlothParser.GTEQ, 0); }
		public TerminalNode EQUAL() { return getToken(SlothParser.EQUAL, 0); }
		public TerminalNode NOTEQ() { return getToken(SlothParser.NOTEQ, 0); }
		public CompareContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JusttermContext extends ExpressionContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public JusttermContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitJustterm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(SlothParser.OR, 0); }
		public OrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(SlothParser.AND, 0); }
		public AndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueContext extends ExpressionContext {
		public TerminalNode TRUE() { return getToken(SlothParser.TRUE, 0); }
		public TrueContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseContext extends ExpressionContext {
		public TerminalNode FALSE() { return getToken(SlothParser.FALSE, 0); }
		public FalseContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(59);
				match(NOT);
				setState(60);
				expression(9);
				}
				break;
			case TRUE:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61);
				match(TRUE);
				}
				break;
			case FALSE:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				match(FALSE);
				}
				break;
			case READINT:
			case READREAL:
			case READBOOL:
			case READSTRING:
			case LPAREN:
			case ID:
			case INTVAL:
			case REALVAL:
			case STRINGVAL:
				{
				_localctx = new JusttermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				term();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(83);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(81);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new TimesdivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(66);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(67);
						((TimesdivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==DIVIDE || _la==TIMES) ) {
							((TimesdivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(68);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new PlusminusContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(69);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(70);
						((PlusminusContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((PlusminusContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(71);
						expression(8);
						}
						break;
					case 3:
						{
						_localctx = new CompareContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(72);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(73);
						((CompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 66060288L) != 0)) ) {
							((CompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(74);
						expression(7);
						}
						break;
					case 4:
						{
						_localctx = new AndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(75);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(76);
						match(AND);
						setState(77);
						expression(6);
						}
						break;
					case 5:
						{
						_localctx = new OrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(78);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(79);
						match(OR);
						setState(80);
						expression(5);
						}
						break;
					}
					} 
				}
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadboolContext extends TermContext {
		public TerminalNode READBOOL() { return getToken(SlothParser.READBOOL, 0); }
		public TerminalNode LPAREN() { return getToken(SlothParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SlothParser.RPAREN, 0); }
		public ReadboolContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitReadbool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends TermContext {
		public TerminalNode LPAREN() { return getToken(SlothParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SlothParser.RPAREN, 0); }
		public ParensContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntvalContext extends TermContext {
		public TerminalNode INTVAL() { return getToken(SlothParser.INTVAL, 0); }
		public IntvalContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitIntval(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadrealContext extends TermContext {
		public TerminalNode READREAL() { return getToken(SlothParser.READREAL, 0); }
		public TerminalNode LPAREN() { return getToken(SlothParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SlothParser.RPAREN, 0); }
		public ReadrealContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitReadreal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StrvalContext extends TermContext {
		public TerminalNode STRINGVAL() { return getToken(SlothParser.STRINGVAL, 0); }
		public StrvalContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitStrval(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RealvalContext extends TermContext {
		public TerminalNode REALVAL() { return getToken(SlothParser.REALVAL, 0); }
		public RealvalContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitRealval(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends TermContext {
		public TerminalNode ID() { return getToken(SlothParser.ID, 0); }
		public IdContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadintContext extends TermContext {
		public TerminalNode READINT() { return getToken(SlothParser.READINT, 0); }
		public TerminalNode LPAREN() { return getToken(SlothParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SlothParser.RPAREN, 0); }
		public ReadintContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitReadint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadstrContext extends TermContext {
		public TerminalNode READSTRING() { return getToken(SlothParser.READSTRING, 0); }
		public TerminalNode LPAREN() { return getToken(SlothParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SlothParser.RPAREN, 0); }
		public ReadstrContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SlothParserVisitor ) return ((SlothParserVisitor<? extends T>)visitor).visitReadstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_term);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REALVAL:
				_localctx = new RealvalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(REALVAL);
				}
				break;
			case INTVAL:
				_localctx = new IntvalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				match(INTVAL);
				}
				break;
			case STRINGVAL:
				_localctx = new StrvalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				match(STRINGVAL);
				}
				break;
			case LPAREN:
				_localctx = new ParensContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				match(LPAREN);
				setState(90);
				expression(0);
				setState(91);
				match(RPAREN);
				}
				break;
			case ID:
				_localctx = new IdContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(93);
				match(ID);
				}
				break;
			case READINT:
				_localctx = new ReadintContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(94);
				match(READINT);
				setState(95);
				match(LPAREN);
				setState(96);
				match(RPAREN);
				}
				break;
			case READREAL:
				_localctx = new ReadrealContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(97);
				match(READREAL);
				setState(98);
				match(LPAREN);
				setState(99);
				match(RPAREN);
				}
				break;
			case READBOOL:
				_localctx = new ReadboolContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(100);
				match(READBOOL);
				setState(101);
				match(LPAREN);
				setState(102);
				match(RPAREN);
				}
				break;
			case READSTRING:
				_localctx = new ReadstrContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(103);
				match(READSTRING);
				setState(104);
				match(LPAREN);
				setState(105);
				match(RPAREN);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\'m\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0005\u0000\n\b"+
		"\u0000\n\u0000\f\u0000\r\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u00013\b\u0001\n\u0001\f\u00016\t"+
		"\u0001\u0001\u0001\u0003\u00019\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002A\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002R\b\u0002\n\u0002\f\u0002U\t"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003k\b\u0003\u0001\u0003\u0000"+
		"\u0001\u0004\u0004\u0000\u0002\u0004\u0006\u0000\u0003\u0001\u0000\u0012"+
		"\u0013\u0001\u0000\u0010\u0011\u0001\u0000\u0014\u0019\u0080\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u00028\u0001\u0000\u0000\u0000\u0004@\u0001\u0000"+
		"\u0000\u0000\u0006j\u0001\u0000\u0000\u0000\b\n\u0003\u0002\u0001\u0000"+
		"\t\b\u0001\u0000\u0000\u0000\n\r\u0001\u0000\u0000\u0000\u000b\t\u0001"+
		"\u0000\u0000\u0000\u000b\f\u0001\u0000\u0000\u0000\f\u0001\u0001\u0000"+
		"\u0000\u0000\r\u000b\u0001\u0000\u0000\u0000\u000e\u000f\u0005!\u0000"+
		"\u0000\u000f\u0010\u0005\u001e\u0000\u0000\u0010\u0011\u0003\u0004\u0002"+
		"\u0000\u0011\u0012\u0005\u001d\u0000\u0000\u00129\u0001\u0000\u0000\u0000"+
		"\u0013\u0014\u0005\u0003\u0000\u0000\u0014\u0015\u0003\u0004\u0002\u0000"+
		"\u0015\u0016\u0005\u0004\u0000\u0000\u0016\u0017\u0003\u0002\u0001\u0000"+
		"\u00179\u0001\u0000\u0000\u0000\u0018\u0019\u0005\u0003\u0000\u0000\u0019"+
		"\u001a\u0003\u0004\u0002\u0000\u001a\u001b\u0005\u0004\u0000\u0000\u001b"+
		"\u001c\u0003\u0002\u0001\u0000\u001c\u001d\u0005\u0005\u0000\u0000\u001d"+
		"\u001e\u0003\u0002\u0001\u0000\u001e9\u0001\u0000\u0000\u0000\u001f \u0005"+
		"\u0006\u0000\u0000 !\u0003\u0004\u0002\u0000!\"\u0005\u0007\u0000\u0000"+
		"\"#\u0003\u0002\u0001\u0000#9\u0001\u0000\u0000\u0000$%\u0005\b\u0000"+
		"\u0000%&\u0005\u001f\u0000\u0000&\'\u0003\u0004\u0002\u0000\'(\u0005 "+
		"\u0000\u0000()\u0005\u001d\u0000\u0000)9\u0001\u0000\u0000\u0000*+\u0005"+
		"\t\u0000\u0000+,\u0005\u001f\u0000\u0000,-\u0003\u0004\u0002\u0000-.\u0005"+
		" \u0000\u0000./\u0005\u001d\u0000\u0000/9\u0001\u0000\u0000\u000004\u0005"+
		"\u0001\u0000\u000013\u0003\u0002\u0001\u000021\u0001\u0000\u0000\u0000"+
		"36\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000079\u0005\u0002"+
		"\u0000\u00008\u000e\u0001\u0000\u0000\u00008\u0013\u0001\u0000\u0000\u0000"+
		"8\u0018\u0001\u0000\u0000\u00008\u001f\u0001\u0000\u0000\u00008$\u0001"+
		"\u0000\u0000\u00008*\u0001\u0000\u0000\u000080\u0001\u0000\u0000\u0000"+
		"9\u0003\u0001\u0000\u0000\u0000:;\u0006\u0002\uffff\uffff\u0000;<\u0005"+
		"\u001c\u0000\u0000<A\u0003\u0004\u0002\t=A\u0005\u000e\u0000\u0000>A\u0005"+
		"\u000f\u0000\u0000?A\u0003\u0006\u0003\u0000@:\u0001\u0000\u0000\u0000"+
		"@=\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@?\u0001\u0000\u0000"+
		"\u0000AS\u0001\u0000\u0000\u0000BC\n\b\u0000\u0000CD\u0007\u0000\u0000"+
		"\u0000DR\u0003\u0004\u0002\tEF\n\u0007\u0000\u0000FG\u0007\u0001\u0000"+
		"\u0000GR\u0003\u0004\u0002\bHI\n\u0006\u0000\u0000IJ\u0007\u0002\u0000"+
		"\u0000JR\u0003\u0004\u0002\u0007KL\n\u0005\u0000\u0000LM\u0005\u001a\u0000"+
		"\u0000MR\u0003\u0004\u0002\u0006NO\n\u0004\u0000\u0000OP\u0005\u001b\u0000"+
		"\u0000PR\u0003\u0004\u0002\u0005QB\u0001\u0000\u0000\u0000QE\u0001\u0000"+
		"\u0000\u0000QH\u0001\u0000\u0000\u0000QK\u0001\u0000\u0000\u0000QN\u0001"+
		"\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000"+
		"ST\u0001\u0000\u0000\u0000T\u0005\u0001\u0000\u0000\u0000US\u0001\u0000"+
		"\u0000\u0000Vk\u0005#\u0000\u0000Wk\u0005\"\u0000\u0000Xk\u0005$\u0000"+
		"\u0000YZ\u0005\u001f\u0000\u0000Z[\u0003\u0004\u0002\u0000[\\\u0005 \u0000"+
		"\u0000\\k\u0001\u0000\u0000\u0000]k\u0005!\u0000\u0000^_\u0005\n\u0000"+
		"\u0000_`\u0005\u001f\u0000\u0000`k\u0005 \u0000\u0000ab\u0005\u000b\u0000"+
		"\u0000bc\u0005\u001f\u0000\u0000ck\u0005 \u0000\u0000de\u0005\f\u0000"+
		"\u0000ef\u0005\u001f\u0000\u0000fk\u0005 \u0000\u0000gh\u0005\r\u0000"+
		"\u0000hi\u0005\u001f\u0000\u0000ik\u0005 \u0000\u0000jV\u0001\u0000\u0000"+
		"\u0000jW\u0001\u0000\u0000\u0000jX\u0001\u0000\u0000\u0000jY\u0001\u0000"+
		"\u0000\u0000j]\u0001\u0000\u0000\u0000j^\u0001\u0000\u0000\u0000ja\u0001"+
		"\u0000\u0000\u0000jd\u0001\u0000\u0000\u0000jg\u0001\u0000\u0000\u0000"+
		"k\u0007\u0001\u0000\u0000\u0000\u0007\u000b48@QSj";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}