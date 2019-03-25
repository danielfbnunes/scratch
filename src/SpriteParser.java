// Generated from Sprite.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SpriteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, NUMBER=34, BOOLEAN=35, STRING=36, WS=37, LINE_COMMENT=38, 
		COMMENT=39, ERROR=40;
	public static final int
		RULE_program = 0, RULE_mandatoryDefinitions = 1, RULE_fieldDefinition = 2, 
		RULE_nameDefinition = 3, RULE_typeDefinition = 4, RULE_propertyDefinition = 5, 
		RULE_expr = 6, RULE_spriteType = 7, RULE_fieldName = 8, RULE_property = 9;
	public static final String[] ruleNames = {
		"program", "mandatoryDefinitions", "fieldDefinition", "nameDefinition", 
		"typeDefinition", "propertyDefinition", "expr", "spriteType", "fieldName", 
		"property"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'{'", "'}'", "'name'", "':'", "'type'", "','", "'*'", "'/'", 
		"'+'", "'-'", "'('", "')'", "'Texture'", "'Rectangle'", "'Circle'", "'Triangle'", 
		"'Square'", "'RegularPolygon'", "'costume'", "'physics'", "'geometry'", 
		"'crop'", "'source'", "'height'", "'width'", "'gravity'", "'collidable'", 
		"'boundingBoxType'", "'radius'", "'xPosition'", "'yPosition'", "'nSides'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "NUMBER", 
		"BOOLEAN", "STRING", "WS", "LINE_COMMENT", "COMMENT", "ERROR"
	};
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
	public String getGrammarFileName() { return "Sprite.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SpriteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public MandatoryDefinitionsContext mandatoryDefinitions() {
			return getRuleContext(MandatoryDefinitionsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SpriteParser.EOF, 0); }
		public List<FieldDefinitionContext> fieldDefinition() {
			return getRuleContexts(FieldDefinitionContext.class);
		}
		public FieldDefinitionContext fieldDefinition(int i) {
			return getRuleContext(FieldDefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(20);
			mandatoryDefinitions();
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) {
				{
				{
				setState(21);
				fieldDefinition();
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(27);
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

	public static class MandatoryDefinitionsContext extends ParserRuleContext {
		public NameDefinitionContext nameDefinition() {
			return getRuleContext(NameDefinitionContext.class,0);
		}
		public TypeDefinitionContext typeDefinition() {
			return getRuleContext(TypeDefinitionContext.class,0);
		}
		public MandatoryDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mandatoryDefinitions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitMandatoryDefinitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MandatoryDefinitionsContext mandatoryDefinitions() throws RecognitionException {
		MandatoryDefinitionsContext _localctx = new MandatoryDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mandatoryDefinitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			nameDefinition();
			setState(30);
			match(T__0);
			setState(31);
			typeDefinition();
			setState(32);
			match(T__0);
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

	public static class FieldDefinitionContext extends ParserRuleContext {
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public List<PropertyDefinitionContext> propertyDefinition() {
			return getRuleContexts(PropertyDefinitionContext.class);
		}
		public PropertyDefinitionContext propertyDefinition(int i) {
			return getRuleContext(PropertyDefinitionContext.class,i);
		}
		public FieldDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitFieldDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDefinitionContext fieldDefinition() throws RecognitionException {
		FieldDefinitionContext _localctx = new FieldDefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fieldDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			fieldName();
			setState(35);
			match(T__1);
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				propertyDefinition();
				setState(37);
				match(T__0);
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0) );
			setState(43);
			match(T__2);
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

	public static class NameDefinitionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NameDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitNameDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameDefinitionContext nameDefinition() throws RecognitionException {
		NameDefinitionContext _localctx = new NameDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nameDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(T__3);
			setState(46);
			match(T__4);
			setState(47);
			expr(0);
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

	public static class TypeDefinitionContext extends ParserRuleContext {
		public SpriteTypeContext spriteType() {
			return getRuleContext(SpriteTypeContext.class,0);
		}
		public TypeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitTypeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDefinitionContext typeDefinition() throws RecognitionException {
		TypeDefinitionContext _localctx = new TypeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typeDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__5);
			setState(50);
			match(T__4);
			setState(51);
			spriteType();
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

	public static class PropertyDefinitionContext extends ParserRuleContext {
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PropertyDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitPropertyDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyDefinitionContext propertyDefinition() throws RecognitionException {
		PropertyDefinitionContext _localctx = new PropertyDefinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_propertyDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			property();
			setState(54);
			match(T__4);
			setState(55);
			expr(0);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(56);
				match(T__6);
				setState(57);
				expr(0);
				}
				}
				setState(62);
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

	public static class ExprContext extends ParserRuleContext {
		public Type type;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.type = ctx.type;
		}
	}
	public static class StringExprContext extends ExprContext {
		public TerminalNode STRING() { return getToken(SpriteParser.STRING, 0); }
		public StringExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitStringExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubExprContext extends ExprContext {
		public ExprContext e1;
		public Token op;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitAddSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SignExprContext extends ExprContext {
		public Token sign;
		public ExprContext e;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SignExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitSignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberExprContext extends ExprContext {
		public TerminalNode NUMBER() { return getToken(SpriteParser.NUMBER, 0); }
		public NumberExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitNumberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanExprContext extends ExprContext {
		public TerminalNode BOOLEAN() { return getToken(SpriteParser.BOOLEAN, 0); }
		public BooleanExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitBooleanExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultDivExprContext extends ExprContext {
		public ExprContext e1;
		public Token op;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MultDivExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitMultDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesisExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitParenthesisExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				_localctx = new ParenthesisExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(64);
				match(T__11);
				setState(65);
				expr(0);
				setState(66);
				match(T__12);
				}
				break;
			case T__9:
			case T__10:
				{
				_localctx = new SignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				((SignExprContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__9 || _la==T__10) ) {
					((SignExprContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(69);
				((SignExprContext)_localctx).e = expr(4);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumberExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				match(NUMBER);
				}
				break;
			case BOOLEAN:
				{
				_localctx = new BooleanExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				match(BOOLEAN);
				}
				break;
			case STRING:
				{
				_localctx = new StringExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				match(STRING);
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
						_localctx = new MultDivExprContext(new ExprContext(_parentctx, _parentState));
						((MultDivExprContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(75);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(76);
						((MultDivExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__7 || _la==T__8) ) {
							((MultDivExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(77);
						((MultDivExprContext)_localctx).e2 = expr(8);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExprContext(new ExprContext(_parentctx, _parentState));
						((AddSubExprContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(78);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(79);
						((AddSubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==T__10) ) {
							((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(80);
						((AddSubExprContext)_localctx).e2 = expr(7);
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

	public static class SpriteTypeContext extends ParserRuleContext {
		public Type res;
		public SpriteTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spriteType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitSpriteType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpriteTypeContext spriteType() throws RecognitionException {
		SpriteTypeContext _localctx = new SpriteTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_spriteType);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(T__13);
				 ((SpriteTypeContext)_localctx).res =  new TextureType(); 
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(T__14);
				 ((SpriteTypeContext)_localctx).res =  new RectangleType(); 
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				match(T__15);
				 ((SpriteTypeContext)_localctx).res =  new CircleType(); 
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				match(T__16);
				 ((SpriteTypeContext)_localctx).res =  new TriangleType(); 
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 5);
				{
				setState(94);
				match(T__17);
				 ((SpriteTypeContext)_localctx).res =  new SquareType(); 
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 6);
				{
				setState(96);
				match(T__18);
				 ((SpriteTypeContext)_localctx).res =  new RegularPolygonType(); 
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

	public static class FieldNameContext extends ParserRuleContext {
		public Field field;
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitFieldName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fieldName);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(T__19);
				 ((FieldNameContext)_localctx).field =  new CostumeField(); 
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(T__20);
				 ((FieldNameContext)_localctx).field =  new PhysicsField(); 
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				match(T__21);
				 ((FieldNameContext)_localctx).field =  new GeometryField(); 
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

	public static class PropertyContext extends ParserRuleContext {
		public Property prop;
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpriteVisitor ) return ((SpriteVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_property);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(T__3);
				 ((PropertyContext)_localctx).prop =  new NameProperty(); 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(T__5);
				 ((PropertyContext)_localctx).prop =  new TypeProperty(); 
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				match(T__22);
				 ((PropertyContext)_localctx).prop =  new CropProperty(); 
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				match(T__23);
				 ((PropertyContext)_localctx).prop =  new SourceProperty(); 
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 5);
				{
				setState(116);
				match(T__24);
				 ((PropertyContext)_localctx).prop =  new HeightProperty(); 
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 6);
				{
				setState(118);
				match(T__25);
				 ((PropertyContext)_localctx).prop =  new WidthProperty(); 
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 7);
				{
				setState(120);
				match(T__26);
				 ((PropertyContext)_localctx).prop =  new GravityProperty(); 
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 8);
				{
				setState(122);
				match(T__27);
				 ((PropertyContext)_localctx).prop =  new CollidableProperty(); 
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 9);
				{
				setState(124);
				match(T__28);
				 ((PropertyContext)_localctx).prop =  new BoundingBoxTypeProperty(); 
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 10);
				{
				setState(126);
				match(T__29);
				 ((PropertyContext)_localctx).prop =  new RadiusProperty(); 
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 11);
				{
				setState(128);
				match(T__30);
				 ((PropertyContext)_localctx).prop =  new XPositionProperty(); 
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 12);
				{
				setState(130);
				match(T__31);
				 ((PropertyContext)_localctx).prop =  new YPositionProperty(); 
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 13);
				{
				setState(132);
				match(T__32);
				 ((PropertyContext)_localctx).prop =  new NSidesProperty(); 
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
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u008b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\6\4*\n\4\r\4\16\4+\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7=\n\7\f\7\16\7@\13\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\bL\n\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bT\n\b\f\b\16"+
		"\bW\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\te\n\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\5\nm\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u0089\n\13\3\13\2\3\16\f\2\4\6\b\n\f\16\20\22"+
		"\24\2\4\3\2\f\r\3\2\n\13\2\u009c\2\26\3\2\2\2\4\37\3\2\2\2\6$\3\2\2\2"+
		"\b/\3\2\2\2\n\63\3\2\2\2\f\67\3\2\2\2\16K\3\2\2\2\20d\3\2\2\2\22l\3\2"+
		"\2\2\24\u0088\3\2\2\2\26\32\5\4\3\2\27\31\5\6\4\2\30\27\3\2\2\2\31\34"+
		"\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\35\3\2\2\2\34\32\3\2\2\2\35\36"+
		"\7\2\2\3\36\3\3\2\2\2\37 \5\b\5\2 !\7\3\2\2!\"\5\n\6\2\"#\7\3\2\2#\5\3"+
		"\2\2\2$%\5\22\n\2%)\7\4\2\2&\'\5\f\7\2\'(\7\3\2\2(*\3\2\2\2)&\3\2\2\2"+
		"*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\7\5\2\2.\7\3\2\2\2/\60\7\6"+
		"\2\2\60\61\7\7\2\2\61\62\5\16\b\2\62\t\3\2\2\2\63\64\7\b\2\2\64\65\7\7"+
		"\2\2\65\66\5\20\t\2\66\13\3\2\2\2\678\5\24\13\289\7\7\2\29>\5\16\b\2:"+
		";\7\t\2\2;=\5\16\b\2<:\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?\r\3\2\2"+
		"\2@>\3\2\2\2AB\b\b\1\2BC\7\16\2\2CD\5\16\b\2DE\7\17\2\2EL\3\2\2\2FG\t"+
		"\2\2\2GL\5\16\b\6HL\7$\2\2IL\7%\2\2JL\7&\2\2KA\3\2\2\2KF\3\2\2\2KH\3\2"+
		"\2\2KI\3\2\2\2KJ\3\2\2\2LU\3\2\2\2MN\f\t\2\2NO\t\3\2\2OT\5\16\b\nPQ\f"+
		"\b\2\2QR\t\2\2\2RT\5\16\b\tSM\3\2\2\2SP\3\2\2\2TW\3\2\2\2US\3\2\2\2UV"+
		"\3\2\2\2V\17\3\2\2\2WU\3\2\2\2XY\7\20\2\2Ye\b\t\1\2Z[\7\21\2\2[e\b\t\1"+
		"\2\\]\7\22\2\2]e\b\t\1\2^_\7\23\2\2_e\b\t\1\2`a\7\24\2\2ae\b\t\1\2bc\7"+
		"\25\2\2ce\b\t\1\2dX\3\2\2\2dZ\3\2\2\2d\\\3\2\2\2d^\3\2\2\2d`\3\2\2\2d"+
		"b\3\2\2\2e\21\3\2\2\2fg\7\26\2\2gm\b\n\1\2hi\7\27\2\2im\b\n\1\2jk\7\30"+
		"\2\2km\b\n\1\2lf\3\2\2\2lh\3\2\2\2lj\3\2\2\2m\23\3\2\2\2no\7\6\2\2o\u0089"+
		"\b\13\1\2pq\7\b\2\2q\u0089\b\13\1\2rs\7\31\2\2s\u0089\b\13\1\2tu\7\32"+
		"\2\2u\u0089\b\13\1\2vw\7\33\2\2w\u0089\b\13\1\2xy\7\34\2\2y\u0089\b\13"+
		"\1\2z{\7\35\2\2{\u0089\b\13\1\2|}\7\36\2\2}\u0089\b\13\1\2~\177\7\37\2"+
		"\2\177\u0089\b\13\1\2\u0080\u0081\7 \2\2\u0081\u0089\b\13\1\2\u0082\u0083"+
		"\7!\2\2\u0083\u0089\b\13\1\2\u0084\u0085\7\"\2\2\u0085\u0089\b\13\1\2"+
		"\u0086\u0087\7#\2\2\u0087\u0089\b\13\1\2\u0088n\3\2\2\2\u0088p\3\2\2\2"+
		"\u0088r\3\2\2\2\u0088t\3\2\2\2\u0088v\3\2\2\2\u0088x\3\2\2\2\u0088z\3"+
		"\2\2\2\u0088|\3\2\2\2\u0088~\3\2\2\2\u0088\u0080\3\2\2\2\u0088\u0082\3"+
		"\2\2\2\u0088\u0084\3\2\2\2\u0088\u0086\3\2\2\2\u0089\25\3\2\2\2\13\32"+
		"+>KSUdl\u0088";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}