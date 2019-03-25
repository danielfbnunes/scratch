// Generated from Scratch.g4 by ANTLR 4.7.1

	import java.util.Map;
	import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScratchParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, STRING=48, BOOLEAN=49, NUM=50, KEYDIGIT=51, KEYLETTER=52, 
		ID=53, WS=54, LINE_COMMENT=55, COMMENT=56, ERROR=57;
	public static final int
		RULE_main = 0, RULE_headerDef = 1, RULE_stat = 2, RULE_varDeclaration = 3, 
		RULE_idList = 4, RULE_dataType = 5, RULE_isKeyPressed = 6, RULE_key = 7, 
		RULE_random = 8, RULE_assignment = 9, RULE_functionInvocation = 10, RULE_classInstanciation = 11, 
		RULE_argsList = 12, RULE_argsListDef = 13, RULE_methodInvocation = 14, 
		RULE_functionDefinition = 15, RULE_returnStat = 16, RULE_conditional = 17, 
		RULE_elseIfStat = 18, RULE_loop = 19, RULE_statList = 20, RULE_expression = 21;
	public static final String[] ruleNames = {
		"main", "headerDef", "stat", "varDeclaration", "idList", "dataType", "isKeyPressed", 
		"key", "random", "assignment", "functionInvocation", "classInstanciation", 
		"argsList", "argsListDef", "methodInvocation", "functionDefinition", "returnStat", 
		"conditional", "elseIfStat", "loop", "statList", "expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'function'", "'('", "')'", "';'", "'='", "','", "'Sprite'", "'List'", 
		"'Window'", "'num'", "'str'", "'boolean'", "'void'", "'is'", "'pressed'", 
		"'?'", "'key->space'", "'key->left arrow'", "'key->right arrow'", "'key->up arrow'", 
		"'key->down arrow'", "'pickRandom'", "'->'", "'create'", "'.'", "'{'", 
		"'}'", "'give'", "'if'", "'else'", "'elsif'", "'while'", "'for'", "'^'", 
		"'*'", "'/'", "'+'", "'-'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", 
		"'and'", "'or'", "'not'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"STRING", "BOOLEAN", "NUM", "KEYDIGIT", "KEYLETTER", "ID", "WS", "LINE_COMMENT", 
		"COMMENT", "ERROR"
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
	public String getGrammarFileName() { return "Scratch.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    static protected List<HashMap<String, Symbol>> contextSymbolTables   = new ArrayList<>();
	    static protected Map<String, Object[]> funcsToBeDef                  = new HashMap<>();

	public ScratchParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MainContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ScratchParser.EOF, 0); }
		public List<HeaderDefContext> headerDef() {
			return getRuleContexts(HeaderDefContext.class);
		}
		public HeaderDefContext headerDef(int i) {
			return getRuleContext(HeaderDefContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(44);
					headerDef();
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__31) | (1L << T__32) | (1L << ID))) != 0)) {
				{
				{
				setState(50);
				stat();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
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

	public static class HeaderDefContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ScratchParser.ID, 0); }
		public ArgsListDefContext argsListDef() {
			return getRuleContext(ArgsListDefContext.class,0);
		}
		public HeaderDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitHeaderDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderDefContext headerDef() throws RecognitionException {
		HeaderDefContext _localctx = new HeaderDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_headerDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(T__0);
			setState(59);
			dataType();
			setState(60);
			match(ID);
			setState(61);
			match(T__1);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) {
				{
				setState(62);
				argsListDef();
				}
			}

			setState(65);
			match(T__2);
			setState(66);
			match(T__3);
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LoopDeclStatContext extends StatContext {
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public LoopDeclStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitLoopDeclStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionalStatContext extends StatContext {
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public ConditionalStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitConditionalStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDeclStatContext extends StatContext {
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public VarDeclStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitVarDeclStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncDefStatContext extends StatContext {
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public FuncDefStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitFuncDefStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassInstStatContext extends StatContext {
		public ClassInstanciationContext classInstanciation() {
			return getRuleContext(ClassInstanciationContext.class,0);
		}
		public ClassInstStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitClassInstStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RetStatContext extends StatContext {
		public ReturnStatContext returnStat() {
			return getRuleContext(ReturnStatContext.class,0);
		}
		public RetStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitRetStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignStatContext extends StatContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitAssignStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MethodInvStatContext extends StatContext {
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public MethodInvStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitMethodInvStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncInvStatContext extends StatContext {
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public FuncInvStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitFuncInvStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new RetStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				returnStat();
				setState(69);
				match(T__3);
				}
				break;
			case 2:
				_localctx = new VarDeclStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				varDeclaration();
				setState(72);
				match(T__3);
				}
				break;
			case 3:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				assignment();
				setState(75);
				match(T__3);
				}
				break;
			case 4:
				_localctx = new FuncInvStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				functionInvocation();
				setState(78);
				match(T__3);
				}
				break;
			case 5:
				_localctx = new ClassInstStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				classInstanciation();
				setState(81);
				match(T__3);
				}
				break;
			case 6:
				_localctx = new MethodInvStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				methodInvocation();
				setState(84);
				match(T__3);
				}
				break;
			case 7:
				_localctx = new FuncDefStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(86);
				functionDefinition();
				}
				break;
			case 8:
				_localctx = new ConditionalStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(87);
				conditional();
				}
				break;
			case 9:
				_localctx = new LoopDeclStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(88);
				loop();
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

	public static class VarDeclarationContext extends ParserRuleContext {
		public Type type;
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
	 
		public VarDeclarationContext() { }
		public void copyFrom(VarDeclarationContext ctx) {
			super.copyFrom(ctx);
			this.type = ctx.type;
		}
	}
	public static class VarDeclOnlyContext extends VarDeclarationContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public VarDeclOnlyContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitVarDeclOnly(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDeclAndAssignContext extends VarDeclarationContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ScratchParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDeclAndAssignContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitVarDeclAndAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDeclaration);
		try {
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new VarDeclOnlyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				dataType();
				setState(92);
				idList();
				}
				break;
			case 2:
				_localctx = new VarDeclAndAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				dataType();
				setState(95);
				match(ID);
				setState(96);
				match(T__4);
				setState(97);
				expression(0);
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

	public static class IdListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ScratchParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ScratchParser.ID, i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitIdList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_idList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(ID);
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(102);
					match(T__5);
					setState(103);
					match(ID);
					}
					} 
				}
				setState(108);
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
			exitRule();
		}
		return _localctx;
	}

	public static class DataTypeContext extends ParserRuleContext {
		public Type type;
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dataType);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(T__6);
				((DataTypeContext)_localctx).type =  new SpriteType();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(T__7);
				((DataTypeContext)_localctx).type =  new ListType();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				match(T__8);
				((DataTypeContext)_localctx).type =  new WindowType();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(115);
				match(T__9);
				((DataTypeContext)_localctx).type =  new NumberType();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(117);
				match(T__10);
				((DataTypeContext)_localctx).type =  new StringType();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 6);
				{
				setState(119);
				match(T__11);
				((DataTypeContext)_localctx).type =  new BooleanType();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 7);
				{
				setState(121);
				match(T__12);
				((DataTypeContext)_localctx).type =  new VoidType();
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

	public static class IsKeyPressedContext extends ParserRuleContext {
		public Type type;
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public IsKeyPressedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isKeyPressed; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitIsKeyPressed(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsKeyPressedContext isKeyPressed() throws RecognitionException {
		IsKeyPressedContext _localctx = new IsKeyPressedContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_isKeyPressed);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__13);
			setState(126);
			key();
			setState(127);
			match(T__14);
			setState(128);
			match(T__15);
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

	public static class KeyContext extends ParserRuleContext {
		public String value;
		public Token KEYLETTER;
		public Token KEYDIGIT;
		public TerminalNode KEYLETTER() { return getToken(ScratchParser.KEYLETTER, 0); }
		public TerminalNode KEYDIGIT() { return getToken(ScratchParser.KEYDIGIT, 0); }
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_key);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEYLETTER:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				((KeyContext)_localctx).KEYLETTER = match(KEYLETTER);
				((KeyContext)_localctx).value =  (((KeyContext)_localctx).KEYLETTER!=null?((KeyContext)_localctx).KEYLETTER.getText():null);
				}
				break;
			case KEYDIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				((KeyContext)_localctx).KEYDIGIT = match(KEYDIGIT);
				((KeyContext)_localctx).value =  (((KeyContext)_localctx).KEYDIGIT!=null?((KeyContext)_localctx).KEYDIGIT.getText():null);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(134);
				match(T__16);
				((KeyContext)_localctx).value =  "key->space";
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(136);
				match(T__17);
				((KeyContext)_localctx).value =  "key->left arrow";
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 5);
				{
				setState(138);
				match(T__18);
				((KeyContext)_localctx).value =  "key->right arrow";
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 6);
				{
				setState(140);
				match(T__19);
				((KeyContext)_localctx).value =  "key->up arrow";
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 7);
				{
				setState(142);
				match(T__20);
				((KeyContext)_localctx).value =  "key->down arrow";
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

	public static class RandomContext extends ParserRuleContext {
		public Type type;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public RandomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_random; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitRandom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RandomContext random() throws RecognitionException {
		RandomContext _localctx = new RandomContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_random);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__21);
			setState(147);
			match(T__1);
			setState(148);
			((RandomContext)_localctx).e1 = expression(0);
			setState(149);
			match(T__22);
			setState(150);
			((RandomContext)_localctx).e2 = expression(0);
			setState(151);
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

	public static class AssignmentContext extends ParserRuleContext {
		public Type type;
		public TerminalNode ID() { return getToken(ScratchParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(ID);
			setState(154);
			match(T__4);
			setState(155);
			expression(0);
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

	public static class FunctionInvocationContext extends ParserRuleContext {
		public Type type;
		public TerminalNode ID() { return getToken(ScratchParser.ID, 0); }
		public ArgsListContext argsList() {
			return getRuleContext(ArgsListContext.class,0);
		}
		public FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInvocation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitFunctionInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionInvocationContext functionInvocation() throws RecognitionException {
		FunctionInvocationContext _localctx = new FunctionInvocationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(ID);
			setState(158);
			match(T__1);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__21) | (1L << T__23) | (1L << T__36) | (1L << T__37) | (1L << T__46) | (1L << STRING) | (1L << BOOLEAN) | (1L << NUM) | (1L << ID))) != 0)) {
				{
				setState(159);
				argsList();
				}
			}

			setState(162);
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

	public static class ClassInstanciationContext extends ParserRuleContext {
		public Type type;
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public ArgsListContext argsList() {
			return getRuleContext(ArgsListContext.class,0);
		}
		public ClassInstanciationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInstanciation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitClassInstanciation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassInstanciationContext classInstanciation() throws RecognitionException {
		ClassInstanciationContext _localctx = new ClassInstanciationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_classInstanciation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(T__23);
			setState(165);
			dataType();
			setState(166);
			match(T__1);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__21) | (1L << T__23) | (1L << T__36) | (1L << T__37) | (1L << T__46) | (1L << STRING) | (1L << BOOLEAN) | (1L << NUM) | (1L << ID))) != 0)) {
				{
				setState(167);
				argsList();
				}
			}

			setState(170);
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

	public static class ArgsListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argsList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitArgsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsListContext argsList() throws RecognitionException {
		ArgsListContext _localctx = new ArgsListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_argsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			expression(0);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(173);
				match(T__5);
				setState(174);
				expression(0);
				}
				}
				setState(179);
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

	public static class ArgsListDefContext extends ParserRuleContext {
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(ScratchParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ScratchParser.ID, i);
		}
		public ArgsListDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argsListDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitArgsListDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsListDefContext argsListDef() throws RecognitionException {
		ArgsListDefContext _localctx = new ArgsListDefContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_argsListDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			dataType();
			setState(181);
			match(ID);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(182);
				match(T__5);
				setState(183);
				dataType();
				setState(184);
				match(ID);
				}
				}
				setState(190);
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

	public static class MethodInvocationContext extends ParserRuleContext {
		public Type type;
		public MethodInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation; }
	 
		public MethodInvocationContext() { }
		public void copyFrom(MethodInvocationContext ctx) {
			super.copyFrom(ctx);
			this.type = ctx.type;
		}
	}
	public static class ObjMethodInvocationContext extends MethodInvocationContext {
		public Token id1;
		public Token id2;
		public List<TerminalNode> ID() { return getTokens(ScratchParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ScratchParser.ID, i);
		}
		public ArgsListContext argsList() {
			return getRuleContext(ArgsListContext.class,0);
		}
		public ObjMethodInvocationContext(MethodInvocationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitObjMethodInvocation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StaticMethodInvocationContext extends MethodInvocationContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ScratchParser.ID, 0); }
		public ArgsListContext argsList() {
			return getRuleContext(ArgsListContext.class,0);
		}
		public StaticMethodInvocationContext(MethodInvocationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitStaticMethodInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodInvocationContext methodInvocation() throws RecognitionException {
		MethodInvocationContext _localctx = new MethodInvocationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_methodInvocation);
		int _la;
		try {
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new ObjMethodInvocationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				((ObjMethodInvocationContext)_localctx).id1 = match(ID);
				setState(192);
				match(T__24);
				setState(193);
				((ObjMethodInvocationContext)_localctx).id2 = match(ID);
				setState(194);
				match(T__1);
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__21) | (1L << T__23) | (1L << T__36) | (1L << T__37) | (1L << T__46) | (1L << STRING) | (1L << BOOLEAN) | (1L << NUM) | (1L << ID))) != 0)) {
					{
					setState(195);
					argsList();
					}
				}

				setState(198);
				match(T__2);
				}
				break;
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
				_localctx = new StaticMethodInvocationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				dataType();
				setState(200);
				match(T__24);
				setState(201);
				match(ID);
				setState(202);
				match(T__1);
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__21) | (1L << T__23) | (1L << T__36) | (1L << T__37) | (1L << T__46) | (1L << STRING) | (1L << BOOLEAN) | (1L << NUM) | (1L << ID))) != 0)) {
					{
					setState(203);
					argsList();
					}
				}

				setState(206);
				match(T__2);
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

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public Type type;
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ScratchParser.ID, 0); }
		public ArgsListDefContext argsListDef() {
			return getRuleContext(ArgsListDefContext.class,0);
		}
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__0);
			setState(211);
			dataType();
			setState(212);
			match(ID);
			setState(213);
			match(T__1);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) {
				{
				setState(214);
				argsListDef();
				}
			}

			setState(217);
			match(T__2);
			setState(218);
			match(T__25);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__31) | (1L << T__32) | (1L << ID))) != 0)) {
				{
				setState(219);
				statList();
				}
			}

			setState(222);
			match(T__26);
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

	public static class ReturnStatContext extends ParserRuleContext {
		public Type type;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__27);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__21) | (1L << T__23) | (1L << T__36) | (1L << T__37) | (1L << T__46) | (1L << STRING) | (1L << BOOLEAN) | (1L << NUM) | (1L << ID))) != 0)) {
				{
				setState(225);
				expression(0);
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

	public static class ConditionalContext extends ParserRuleContext {
		public StatListContext trueStats;
		public StatListContext falseStats;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ElseIfStatContext> elseIfStat() {
			return getRuleContexts(ElseIfStatContext.class);
		}
		public ElseIfStatContext elseIfStat(int i) {
			return getRuleContext(ElseIfStatContext.class,i);
		}
		public List<StatListContext> statList() {
			return getRuleContexts(StatListContext.class);
		}
		public StatListContext statList(int i) {
			return getRuleContext(StatListContext.class,i);
		}
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitConditional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_conditional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__28);
			setState(229);
			match(T__1);
			setState(230);
			expression(0);
			setState(231);
			match(T__2);
			setState(232);
			match(T__25);
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__31) | (1L << T__32) | (1L << ID))) != 0)) {
				{
				setState(233);
				((ConditionalContext)_localctx).trueStats = statList();
				}
			}

			setState(236);
			match(T__26);
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__30) {
				{
				{
				setState(237);
				elseIfStat();
				}
				}
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(243);
				match(T__29);
				setState(244);
				match(T__25);
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__31) | (1L << T__32) | (1L << ID))) != 0)) {
					{
					setState(245);
					((ConditionalContext)_localctx).falseStats = statList();
					}
				}

				setState(248);
				match(T__26);
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

	public static class ElseIfStatContext extends ParserRuleContext {
		public StatContext trueStats;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ElseIfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitElseIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfStatContext elseIfStat() throws RecognitionException {
		ElseIfStatContext _localctx = new ElseIfStatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_elseIfStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(T__30);
			setState(252);
			match(T__1);
			setState(253);
			expression(0);
			setState(254);
			match(T__2);
			setState(255);
			match(T__25);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__31) | (1L << T__32) | (1L << ID))) != 0)) {
				{
				{
				setState(256);
				((ElseIfStatContext)_localctx).trueStats = stat();
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(262);
			match(T__26);
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

	public static class LoopContext extends ParserRuleContext {
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
	 
		public LoopContext() { }
		public void copyFrom(LoopContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileLoopContext extends LoopContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public WhileLoopContext(LoopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForLoopContext extends LoopContext {
		public ExpressionContext expr1;
		public ExpressionContext expr2;
		public ExpressionContext expr3;
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForLoopContext(LoopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_loop);
		int _la;
		try {
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(T__31);
				setState(265);
				match(T__1);
				setState(266);
				expression(0);
				setState(267);
				match(T__2);
				setState(268);
				match(T__25);
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__31) | (1L << T__32) | (1L << ID))) != 0)) {
					{
					setState(269);
					statList();
					}
				}

				setState(272);
				match(T__26);
				}
				break;
			case T__32:
				_localctx = new ForLoopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				match(T__32);
				setState(275);
				match(T__1);
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__21) | (1L << T__23) | (1L << T__36) | (1L << T__37) | (1L << T__46) | (1L << STRING) | (1L << BOOLEAN) | (1L << NUM) | (1L << ID))) != 0)) {
					{
					setState(276);
					((ForLoopContext)_localctx).expr1 = expression(0);
					}
				}

				setState(279);
				match(T__3);
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__21) | (1L << T__23) | (1L << T__36) | (1L << T__37) | (1L << T__46) | (1L << STRING) | (1L << BOOLEAN) | (1L << NUM) | (1L << ID))) != 0)) {
					{
					setState(280);
					((ForLoopContext)_localctx).expr2 = expression(0);
					}
				}

				setState(283);
				match(T__3);
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__21) | (1L << T__23) | (1L << T__36) | (1L << T__37) | (1L << T__46) | (1L << STRING) | (1L << BOOLEAN) | (1L << NUM) | (1L << ID))) != 0)) {
					{
					setState(284);
					((ForLoopContext)_localctx).expr3 = expression(0);
					}
				}

				setState(287);
				match(T__2);
				setState(288);
				match(T__25);
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__31) | (1L << T__32) | (1L << ID))) != 0)) {
					{
					setState(289);
					statList();
					}
				}

				setState(292);
				match(T__26);
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

	public static class StatListContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public StatListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitStatList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatListContext statList() throws RecognitionException {
		StatListContext _localctx = new StatListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_statList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(295);
				stat();
				}
				}
				setState(298); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__31) | (1L << T__32) | (1L << ID))) != 0) );
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

	public static class ExpressionContext extends ParserRuleContext {
		public Type type;
		public String varName;
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
			this.type = ctx.type;
			this.varName = ctx.varName;
		}
	}
	public static class IsKeyPressedExprContext extends ExpressionContext {
		public IsKeyPressedContext isKeyPressed() {
			return getRuleContext(IsKeyPressedContext.class,0);
		}
		public IsKeyPressedExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitIsKeyPressedExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncExprContext extends ExpressionContext {
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public FuncExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubExprContext extends ExpressionContext {
		public ExpressionContext e1;
		public Token op;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddSubExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitAddSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RandomExprContext extends ExpressionContext {
		public RandomContext random() {
			return getRuleContext(RandomContext.class,0);
		}
		public RandomExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitRandomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanExprContext extends ExpressionContext {
		public TerminalNode BOOLEAN() { return getToken(ScratchParser.BOOLEAN, 0); }
		public BooleanExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitBooleanExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExprContext extends ExpressionContext {
		public ExpressionContext e1;
		public Token op;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComparisonExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitComparisonExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicNotExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LogicNotExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitLogicNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumExprContext extends ExpressionContext {
		public TerminalNode NUM() { return getToken(ScratchParser.NUM, 0); }
		public NumExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitNumExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringExprContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(ScratchParser.STRING, 0); }
		public StringExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitStringExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(ScratchParser.ID, 0); }
		public VarExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SignalExprContext extends ExpressionContext {
		public Token signal;
		public ExpressionContext e;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SignalExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitSignalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassInstExprContext extends ExpressionContext {
		public ClassInstanciationContext classInstanciation() {
			return getRuleContext(ClassInstanciationContext.class,0);
		}
		public ClassInstExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitClassInstExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MethodExprContext extends ExpressionContext {
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public MethodExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitMethodExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicCompExprContext extends ExpressionContext {
		public ExpressionContext e1;
		public Token op;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LogicCompExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitLogicCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDeclExprContext extends ExpressionContext {
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public VarDeclExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitVarDeclExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultDivExprContext extends ExpressionContext {
		public ExpressionContext e1;
		public Token op;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultDivExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitMultDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowExprContext extends ExpressionContext {
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PowExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitPowExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExprContext extends ExpressionContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScratchVisitor ) return ((ScratchVisitor<? extends T>)visitor).visitAssignExpr(this);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(301);
				match(T__1);
				setState(302);
				expression(0);
				setState(303);
				match(T__2);
				}
				break;
			case 2:
				{
				_localctx = new SignalExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(305);
				((SignalExprContext)_localctx).signal = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__36 || _la==T__37) ) {
					((SignalExprContext)_localctx).signal = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(306);
				((SignalExprContext)_localctx).e = expression(14);
				}
				break;
			case 3:
				{
				_localctx = new LogicNotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(307);
				match(T__46);
				setState(308);
				expression(12);
				}
				break;
			case 4:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(309);
				functionInvocation();
				}
				break;
			case 5:
				{
				_localctx = new MethodExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(310);
				methodInvocation();
				}
				break;
			case 6:
				{
				_localctx = new ClassInstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(311);
				classInstanciation();
				}
				break;
			case 7:
				{
				_localctx = new AssignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(312);
				assignment();
				}
				break;
			case 8:
				{
				_localctx = new VarDeclExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(313);
				varDeclaration();
				}
				break;
			case 9:
				{
				_localctx = new IsKeyPressedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(314);
				isKeyPressed();
				}
				break;
			case 10:
				{
				_localctx = new RandomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(315);
				random();
				}
				break;
			case 11:
				{
				_localctx = new NumExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(316);
				match(NUM);
				}
				break;
			case 12:
				{
				_localctx = new BooleanExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(317);
				match(BOOLEAN);
				}
				break;
			case 13:
				{
				_localctx = new StringExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(318);
				match(STRING);
				}
				break;
			case 14:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(319);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(339);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(337);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExpressionContext(_parentctx, _parentState));
						((PowExprContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(322);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(323);
						match(T__33);
						setState(324);
						((PowExprContext)_localctx).e2 = expression(19);
						}
						break;
					case 2:
						{
						_localctx = new MultDivExprContext(new ExpressionContext(_parentctx, _parentState));
						((MultDivExprContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(325);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(326);
						((MultDivExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__34 || _la==T__35) ) {
							((MultDivExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(327);
						((MultDivExprContext)_localctx).e2 = expression(19);
						}
						break;
					case 3:
						{
						_localctx = new AddSubExprContext(new ExpressionContext(_parentctx, _parentState));
						((AddSubExprContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(328);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(329);
						((AddSubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__36 || _la==T__37) ) {
							((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(330);
						((AddSubExprContext)_localctx).e2 = expression(18);
						}
						break;
					case 4:
						{
						_localctx = new ComparisonExprContext(new ExpressionContext(_parentctx, _parentState));
						((ComparisonExprContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(331);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(332);
						((ComparisonExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43))) != 0)) ) {
							((ComparisonExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(333);
						((ComparisonExprContext)_localctx).e2 = expression(17);
						}
						break;
					case 5:
						{
						_localctx = new LogicCompExprContext(new ExpressionContext(_parentctx, _parentState));
						((LogicCompExprContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(334);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(335);
						((LogicCompExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__44 || _la==T__45) ) {
							((LogicCompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(336);
						((LogicCompExprContext)_localctx).e2 = expression(14);
						}
						break;
					}
					} 
				}
				setState(341);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
		case 21:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 17);
		case 3:
			return precpred(_ctx, 16);
		case 4:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u0159\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\7\2\60\n\2\f\2"+
		"\16\2\63\13\2\3\2\7\2\66\n\2\f\2\16\29\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\5\3B\n\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\\\n\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\5f\n\5\3\6\3\6\3\6\7\6k\n\6\f\6\16\6n\13\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7~\n\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0093\n"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\5\f\u00a3"+
		"\n\f\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u00ab\n\r\3\r\3\r\3\16\3\16\3\16\7\16"+
		"\u00b2\n\16\f\16\16\16\u00b5\13\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17"+
		"\u00bd\n\17\f\17\16\17\u00c0\13\17\3\20\3\20\3\20\3\20\3\20\5\20\u00c7"+
		"\n\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00cf\n\20\3\20\3\20\5\20\u00d3"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\5\21\u00da\n\21\3\21\3\21\3\21\5\21\u00df"+
		"\n\21\3\21\3\21\3\22\3\22\5\22\u00e5\n\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u00ed\n\23\3\23\3\23\7\23\u00f1\n\23\f\23\16\23\u00f4\13\23\3\23"+
		"\3\23\3\23\5\23\u00f9\n\23\3\23\5\23\u00fc\n\23\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\7\24\u0104\n\24\f\24\16\24\u0107\13\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\5\25\u0111\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u0118"+
		"\n\25\3\25\3\25\5\25\u011c\n\25\3\25\3\25\5\25\u0120\n\25\3\25\3\25\3"+
		"\25\5\25\u0125\n\25\3\25\5\25\u0128\n\25\3\26\6\26\u012b\n\26\r\26\16"+
		"\26\u012c\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0143\n\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0154"+
		"\n\27\f\27\16\27\u0157\13\27\3\27\2\3,\30\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,\2\6\3\2\'(\3\2%&\3\2).\3\2/\60\2\u0183\2\61\3\2\2\2"+
		"\4<\3\2\2\2\6[\3\2\2\2\be\3\2\2\2\ng\3\2\2\2\f}\3\2\2\2\16\177\3\2\2\2"+
		"\20\u0092\3\2\2\2\22\u0094\3\2\2\2\24\u009b\3\2\2\2\26\u009f\3\2\2\2\30"+
		"\u00a6\3\2\2\2\32\u00ae\3\2\2\2\34\u00b6\3\2\2\2\36\u00d2\3\2\2\2 \u00d4"+
		"\3\2\2\2\"\u00e2\3\2\2\2$\u00e6\3\2\2\2&\u00fd\3\2\2\2(\u0127\3\2\2\2"+
		"*\u012a\3\2\2\2,\u0142\3\2\2\2.\60\5\4\3\2/.\3\2\2\2\60\63\3\2\2\2\61"+
		"/\3\2\2\2\61\62\3\2\2\2\62\67\3\2\2\2\63\61\3\2\2\2\64\66\5\6\4\2\65\64"+
		"\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\67\3\2\2\2:"+
		";\7\2\2\3;\3\3\2\2\2<=\7\3\2\2=>\5\f\7\2>?\7\67\2\2?A\7\4\2\2@B\5\34\17"+
		"\2A@\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\7\5\2\2DE\7\6\2\2E\5\3\2\2\2FG\5\""+
		"\22\2GH\7\6\2\2H\\\3\2\2\2IJ\5\b\5\2JK\7\6\2\2K\\\3\2\2\2LM\5\24\13\2"+
		"MN\7\6\2\2N\\\3\2\2\2OP\5\26\f\2PQ\7\6\2\2Q\\\3\2\2\2RS\5\30\r\2ST\7\6"+
		"\2\2T\\\3\2\2\2UV\5\36\20\2VW\7\6\2\2W\\\3\2\2\2X\\\5 \21\2Y\\\5$\23\2"+
		"Z\\\5(\25\2[F\3\2\2\2[I\3\2\2\2[L\3\2\2\2[O\3\2\2\2[R\3\2\2\2[U\3\2\2"+
		"\2[X\3\2\2\2[Y\3\2\2\2[Z\3\2\2\2\\\7\3\2\2\2]^\5\f\7\2^_\5\n\6\2_f\3\2"+
		"\2\2`a\5\f\7\2ab\7\67\2\2bc\7\7\2\2cd\5,\27\2df\3\2\2\2e]\3\2\2\2e`\3"+
		"\2\2\2f\t\3\2\2\2gl\7\67\2\2hi\7\b\2\2ik\7\67\2\2jh\3\2\2\2kn\3\2\2\2"+
		"lj\3\2\2\2lm\3\2\2\2m\13\3\2\2\2nl\3\2\2\2op\7\t\2\2p~\b\7\1\2qr\7\n\2"+
		"\2r~\b\7\1\2st\7\13\2\2t~\b\7\1\2uv\7\f\2\2v~\b\7\1\2wx\7\r\2\2x~\b\7"+
		"\1\2yz\7\16\2\2z~\b\7\1\2{|\7\17\2\2|~\b\7\1\2}o\3\2\2\2}q\3\2\2\2}s\3"+
		"\2\2\2}u\3\2\2\2}w\3\2\2\2}y\3\2\2\2}{\3\2\2\2~\r\3\2\2\2\177\u0080\7"+
		"\20\2\2\u0080\u0081\5\20\t\2\u0081\u0082\7\21\2\2\u0082\u0083\7\22\2\2"+
		"\u0083\17\3\2\2\2\u0084\u0085\7\66\2\2\u0085\u0093\b\t\1\2\u0086\u0087"+
		"\7\65\2\2\u0087\u0093\b\t\1\2\u0088\u0089\7\23\2\2\u0089\u0093\b\t\1\2"+
		"\u008a\u008b\7\24\2\2\u008b\u0093\b\t\1\2\u008c\u008d\7\25\2\2\u008d\u0093"+
		"\b\t\1\2\u008e\u008f\7\26\2\2\u008f\u0093\b\t\1\2\u0090\u0091\7\27\2\2"+
		"\u0091\u0093\b\t\1\2\u0092\u0084\3\2\2\2\u0092\u0086\3\2\2\2\u0092\u0088"+
		"\3\2\2\2\u0092\u008a\3\2\2\2\u0092\u008c\3\2\2\2\u0092\u008e\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0093\21\3\2\2\2\u0094\u0095\7\30\2\2\u0095\u0096\7\4\2"+
		"\2\u0096\u0097\5,\27\2\u0097\u0098\7\31\2\2\u0098\u0099\5,\27\2\u0099"+
		"\u009a\7\5\2\2\u009a\23\3\2\2\2\u009b\u009c\7\67\2\2\u009c\u009d\7\7\2"+
		"\2\u009d\u009e\5,\27\2\u009e\25\3\2\2\2\u009f\u00a0\7\67\2\2\u00a0\u00a2"+
		"\7\4\2\2\u00a1\u00a3\5\32\16\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2"+
		"\u00a3\u00a4\3\2\2\2\u00a4\u00a5\7\5\2\2\u00a5\27\3\2\2\2\u00a6\u00a7"+
		"\7\32\2\2\u00a7\u00a8\5\f\7\2\u00a8\u00aa\7\4\2\2\u00a9\u00ab\5\32\16"+
		"\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad"+
		"\7\5\2\2\u00ad\31\3\2\2\2\u00ae\u00b3\5,\27\2\u00af\u00b0\7\b\2\2\u00b0"+
		"\u00b2\5,\27\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b3\u00b4\3\2\2\2\u00b4\33\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7"+
		"\5\f\7\2\u00b7\u00be\7\67\2\2\u00b8\u00b9\7\b\2\2\u00b9\u00ba\5\f\7\2"+
		"\u00ba\u00bb\7\67\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bd\u00c0"+
		"\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\35\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c1\u00c2\7\67\2\2\u00c2\u00c3\7\33\2\2\u00c3\u00c4\7"+
		"\67\2\2\u00c4\u00c6\7\4\2\2\u00c5\u00c7\5\32\16\2\u00c6\u00c5\3\2\2\2"+
		"\u00c6\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00d3\7\5\2\2\u00c9\u00ca"+
		"\5\f\7\2\u00ca\u00cb\7\33\2\2\u00cb\u00cc\7\67\2\2\u00cc\u00ce\7\4\2\2"+
		"\u00cd\u00cf\5\32\16\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0"+
		"\3\2\2\2\u00d0\u00d1\7\5\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00c1\3\2\2\2\u00d2"+
		"\u00c9\3\2\2\2\u00d3\37\3\2\2\2\u00d4\u00d5\7\3\2\2\u00d5\u00d6\5\f\7"+
		"\2\u00d6\u00d7\7\67\2\2\u00d7\u00d9\7\4\2\2\u00d8\u00da\5\34\17\2\u00d9"+
		"\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\7\5"+
		"\2\2\u00dc\u00de\7\34\2\2\u00dd\u00df\5*\26\2\u00de\u00dd\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\7\35\2\2\u00e1!\3\2\2\2"+
		"\u00e2\u00e4\7\36\2\2\u00e3\u00e5\5,\27\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5#\3\2\2\2\u00e6\u00e7\7\37\2\2\u00e7\u00e8\7\4\2\2\u00e8"+
		"\u00e9\5,\27\2\u00e9\u00ea\7\5\2\2\u00ea\u00ec\7\34\2\2\u00eb\u00ed\5"+
		"*\26\2\u00ec\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\u00f2\7\35\2\2\u00ef\u00f1\5&\24\2\u00f0\u00ef\3\2\2\2\u00f1\u00f4\3"+
		"\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00fb\3\2\2\2\u00f4"+
		"\u00f2\3\2\2\2\u00f5\u00f6\7 \2\2\u00f6\u00f8\7\34\2\2\u00f7\u00f9\5*"+
		"\26\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fc\7\35\2\2\u00fb\u00f5\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc%\3\2\2\2"+
		"\u00fd\u00fe\7!\2\2\u00fe\u00ff\7\4\2\2\u00ff\u0100\5,\27\2\u0100\u0101"+
		"\7\5\2\2\u0101\u0105\7\34\2\2\u0102\u0104\5\6\4\2\u0103\u0102\3\2\2\2"+
		"\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108"+
		"\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\7\35\2\2\u0109\'\3\2\2\2\u010a"+
		"\u010b\7\"\2\2\u010b\u010c\7\4\2\2\u010c\u010d\5,\27\2\u010d\u010e\7\5"+
		"\2\2\u010e\u0110\7\34\2\2\u010f\u0111\5*\26\2\u0110\u010f\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\7\35\2\2\u0113\u0128\3"+
		"\2\2\2\u0114\u0115\7#\2\2\u0115\u0117\7\4\2\2\u0116\u0118\5,\27\2\u0117"+
		"\u0116\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011b\7\6"+
		"\2\2\u011a\u011c\5,\27\2\u011b\u011a\3\2\2\2\u011b\u011c\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d\u011f\7\6\2\2\u011e\u0120\5,\27\2\u011f\u011e\3\2"+
		"\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\7\5\2\2\u0122"+
		"\u0124\7\34\2\2\u0123\u0125\5*\26\2\u0124\u0123\3\2\2\2\u0124\u0125\3"+
		"\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128\7\35\2\2\u0127\u010a\3\2\2\2\u0127"+
		"\u0114\3\2\2\2\u0128)\3\2\2\2\u0129\u012b\5\6\4\2\u012a\u0129\3\2\2\2"+
		"\u012b\u012c\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d+\3"+
		"\2\2\2\u012e\u012f\b\27\1\2\u012f\u0130\7\4\2\2\u0130\u0131\5,\27\2\u0131"+
		"\u0132\7\5\2\2\u0132\u0143\3\2\2\2\u0133\u0134\t\2\2\2\u0134\u0143\5,"+
		"\27\20\u0135\u0136\7\61\2\2\u0136\u0143\5,\27\16\u0137\u0143\5\26\f\2"+
		"\u0138\u0143\5\36\20\2\u0139\u0143\5\30\r\2\u013a\u0143\5\24\13\2\u013b"+
		"\u0143\5\b\5\2\u013c\u0143\5\16\b\2\u013d\u0143\5\22\n\2\u013e\u0143\7"+
		"\64\2\2\u013f\u0143\7\63\2\2\u0140\u0143\7\62\2\2\u0141\u0143\7\67\2\2"+
		"\u0142\u012e\3\2\2\2\u0142\u0133\3\2\2\2\u0142\u0135\3\2\2\2\u0142\u0137"+
		"\3\2\2\2\u0142\u0138\3\2\2\2\u0142\u0139\3\2\2\2\u0142\u013a\3\2\2\2\u0142"+
		"\u013b\3\2\2\2\u0142\u013c\3\2\2\2\u0142\u013d\3\2\2\2\u0142\u013e\3\2"+
		"\2\2\u0142\u013f\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0141\3\2\2\2\u0143"+
		"\u0155\3\2\2\2\u0144\u0145\f\25\2\2\u0145\u0146\7$\2\2\u0146\u0154\5,"+
		"\27\25\u0147\u0148\f\24\2\2\u0148\u0149\t\3\2\2\u0149\u0154\5,\27\25\u014a"+
		"\u014b\f\23\2\2\u014b\u014c\t\2\2\2\u014c\u0154\5,\27\24\u014d\u014e\f"+
		"\22\2\2\u014e\u014f\t\4\2\2\u014f\u0154\5,\27\23\u0150\u0151\f\17\2\2"+
		"\u0151\u0152\t\5\2\2\u0152\u0154\5,\27\20\u0153\u0144\3\2\2\2\u0153\u0147"+
		"\3\2\2\2\u0153\u014a\3\2\2\2\u0153\u014d\3\2\2\2\u0153\u0150\3\2\2\2\u0154"+
		"\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156-\3\2\2\2"+
		"\u0157\u0155\3\2\2\2#\61\67A[el}\u0092\u00a2\u00aa\u00b3\u00be\u00c6\u00ce"+
		"\u00d2\u00d9\u00de\u00e4\u00ec\u00f2\u00f8\u00fb\u0105\u0110\u0117\u011b"+
		"\u011f\u0124\u0127\u012c\u0142\u0153\u0155";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}