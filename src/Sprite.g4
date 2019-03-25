/**
 * Este ficheiro especifíca a gramática a utilizar na especificacão 
 * das sprites (personagens/objetos visuais intervenientes no programa).
 */
grammar Sprite;

/**
 * REGRA PRINCIPAL
 */
program
  :  mandatoryDefinitions fieldDefinition* EOF
  ;

/**
 * Definições obrigatórias de uma sprite.
 * Incluí o nome que deve ser único entre as várias sprites (como garantir ?)
 * e o tipo de sprite.
 */
mandatoryDefinitions
  :  nameDefinition ';' typeDefinition ';'
  ;

/**
 * Definição da composição de um módulo da sprite.
 */
fieldDefinition
  :  fieldName '{' (propertyDefinition ';')+ '}'
  ;

/**
 * Definição do nome da sprite.
 */
nameDefinition
  :  'name' ':' expr
  ;

/**
 * Definição do tipo da sprite.
 */
typeDefinition
  :  'type' ':' spriteType
  ;

/**
 * Definição geral de uma propriedade.
 */
propertyDefinition
  :  property ':' expr (',' expr)*
  ;

/**
 * Definição de uma expressão.
 */
expr returns[Type type]
  : e1=expr op=('*'|'/') e2=expr        #multDivExpr
  | e1=expr op=('+'|'-') e2=expr        #addSubExpr
  | '(' expr ')'                        #parenthesisExpr
  | sign=('+'|'-') e=expr               #signExpr
  | NUMBER                              #numberExpr
  | BOOLEAN                             #booleanExpr
  | STRING                              #stringExpr
  ;

/**
 * As possibilidades para o tipo de sprite.
 */
spriteType returns[Type res]
  :  'Texture'          { $res = new TextureType(); }
  |  'Rectangle'        { $res = new RectangleType(); }
  |  'Circle'           { $res = new CircleType(); }
  |  'Triangle'         { $res = new TriangleType(); }
  |  'Square'           { $res = new SquareType(); }
  |  'RegularPolygon'   { $res = new RegularPolygonType(); }
  ;

/**
 * Diferentes tipos da composição do módulo da sprite.
 */
fieldName returns[Field field]
  : 'costume'   { $field = new CostumeField(); }
  | 'physics'   { $field = new PhysicsField(); }
  | 'geometry'  { $field = new GeometryField(); }
  ;


/**
 * Lista das várias propriedades possíveis para os vários módulos.
 */
property returns[Property prop]
  :  'name'                  { $prop = new NameProperty(); }
  |  'type'                  { $prop = new TypeProperty(); }
  |  'crop'                  { $prop = new CropProperty(); }
  |  'source'                { $prop = new SourceProperty(); }
  |  'height'                { $prop = new HeightProperty(); }
  |  'width'                 { $prop = new WidthProperty(); }
  |  'gravity'               { $prop = new GravityProperty(); }
  |  'collidable'            { $prop = new CollidableProperty(); }
  |  'boundingBoxType'       { $prop = new BoundingBoxTypeProperty(); }
  |  'radius'                { $prop = new RadiusProperty(); }
  |  'xPosition'             { $prop = new XPositionProperty(); }
  |  'yPosition'             { $prop = new YPositionProperty(); }
  |  'nSides'                { $prop = new NSidesProperty(); }
  ;


NUMBER: INTEGER | REAL ;
fragment INTEGER: DIGIT+ ;
fragment REAL: DIGIT+ '.' DIGIT+ | '.' DIGIT+ ;
fragment DIGIT: [0-9] ;
BOOLEAN: 'true' | 'false' ;
STRING:  '"' .*? '"';
WS: [ \t\n\r] -> skip ;
LINE_COMMENT: '/*' .*? '*/' -> skip ;
COMMENT: '//' .*? '\n' -> skip ;
ERROR: . ;
