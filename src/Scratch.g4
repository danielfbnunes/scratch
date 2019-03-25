grammar Scratch;

@parser::header {
	import java.util.Map;
	import java.util.HashMap;
}

@parser::members {
    static protected List<HashMap<String, Symbol>> contextSymbolTables   = new ArrayList<>();
    static protected Map<String, Object[]> funcsToBeDef                  = new HashMap<>();
}

main
    :   headerDef* stat* EOF
    ;

headerDef
    :   'function' dataType ID '(' argsListDef? ')' ';'
    ;

stat 
    :   returnStat ';'          #retStat
    |   varDeclaration ';'      #varDeclStat
    |   assignment ';'          #assignStat
    |   functionInvocation ';'  #funcInvStat
    |   classInstanciation ';'  #classInstStat
    |   methodInvocation ';'    #methodInvStat
    |   functionDefinition      #funcDefStat
    |   conditional             #conditionalStat
    |   loop                    #loopDeclStat
    ;

varDeclaration returns[Type type]
    :   dataType idList									            #varDeclOnly
    |   dataType ID '=' expression 						            #varDeclAndAssign
    ;

idList
    :   ID (',' ID)*
    ;

dataType returns[Type type]
    :   'Sprite' {$type = new SpriteType();}
    |   'List'   {$type = new ListType();}
    |   'Window' {$type = new WindowType();}
    |   'num'    {$type = new NumberType();}
    |   'str'    {$type = new StringType();}
    |   'boolean'{$type = new BooleanType();}
    |   'void'   {$type = new VoidType();}
    ;

isKeyPressed returns[Type type]
    :   'is' key 'pressed' '?'
    ;

key returns[String value]
    :    KEYLETTER            {$value = $KEYLETTER.text;}
    |    KEYDIGIT             {$value = $KEYDIGIT.text;}
    |    'key->space'         {$value = "key->space";}
    |    'key->left arrow'    {$value = "key->left arrow";}
    |    'key->right arrow'   {$value = "key->right arrow";}
    |    'key->up arrow'      {$value = "key->up arrow";}
    |    'key->down arrow'    {$value = "key->down arrow";}
    ;

random returns[Type type]
    :    'pickRandom' '(' e1=expression '->' e2=expression ')'
    ;

assignment returns[Type type]
    :   ID '=' expression
    ;

functionInvocation returns[Type type] 
    :   ID '(' argsList? ')'
    ;

classInstanciation returns[Type type] 
    :   'create' dataType '(' argsList? ')'
    ;

argsList
    :   expression (',' expression)*
    ;

argsListDef
    :   dataType ID (',' dataType ID)*
    ;

methodInvocation returns[Type type]
    :   id1=ID '.' id2=ID '(' argsList? ')'        #objMethodInvocation
    |   dataType '.' ID '(' argsList? ')'          #staticMethodInvocation
    ;

functionDefinition returns[Type type]
    :   'function' dataType ID '(' argsListDef? ')' '{' statList? '}'
    ;

returnStat returns[Type type]
    :   'give' expression?
    ;

conditional 
    :   'if' '(' expression ')' '{' trueStats=statList? '}' elseIfStat* ('else' '{' falseStats=statList? '}')?
    ;

elseIfStat
    :   'elsif' '(' expression ')' '{' trueStats=stat* '}'
    ;

loop 
    :   'while' '(' expression ')' '{' statList? '}'                 #whileLoop  
    |   'for' '(' expr1=expression? ';' expr2=expression? ';' expr3=expression? ')' '{' statList? '}' #forLoop
    ;

statList
    :   stat+
    ;

expression returns[Type type, String varName] 
    :   <assoc=right> e1=expression '^' e2=expression               #powExpr       
    |   e1=expression op=('*' | '/') e2=expression                  #multDivExpr
    |   e1=expression op=('+' | '-') e2=expression                  #addSubExpr
    |   e1=expression op=('==' | '!=' | '<' | 
                           '>' | '<=' | '>=') e2=expression         #comparisonExpr
    |   '(' expression ')'                                          #parenExpr
    |   signal=('+'|'-') e=expression                               #signalExpr
    |   e1=expression op=('and' | 'or') e2=expression               #logicCompExpr
    |   'not' expression                                            #logicNotExpr
    |   functionInvocation                                          #funcExpr
    |   methodInvocation								            #methodExpr
    |   classInstanciation								            #classInstExpr
    |   assignment                                                  #assignExpr
    |   varDeclaration                                              #varDeclExpr
    |   isKeyPressed                                                #isKeyPressedExpr
    |   random                                                      #randomExpr
    |   NUM                                                         #numExpr
    |   BOOLEAN                                                     #booleanExpr
    |   STRING                                                      #stringExpr
    |   ID                                                          #varExpr
    ;

STRING: '"' (ESC | .)*? '"' ;
fragment ESC: '\\"' | '\\\\' ;
BOOLEAN: 'true' | 'false' ;
NUM: INT | REAL ;
fragment INT  : DIGIT+ ;
fragment REAL : DIGIT+ '.' DIGIT+ | '.' DIGIT+ ;
KEYDIGIT : 'key->'[0-9] ;
KEYLETTER : 'key->'[a-z] ;
ID: CHAR (CHAR | DIGIT)* ;
fragment CHAR: LOWERLETTER | UPPERLETTER | '_' ;
fragment DIGIT : [0-9] ;
fragment LOWERLETTER: [a-z] ;
fragment UPPERLETTER: [A-Z] ;
WS: [ \t\n\r] -> skip ;
LINE_COMMENT: '//' .*? '\n' -> skip ;
COMMENT: '/**' .*? '*/' -> skip ;
ERROR: . ;
