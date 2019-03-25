/**
 * Este ficheiro especif�ca a gram�tica a utilizar na especificac�o 
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
 * Defini��es obrigat�rias de uma sprite.
 * Inclu� o nome que deve ser �nico entre as v�rias sprites (como garantir ?)
 * e o tipo de sprite.
 */
mandatoryDefinitions
  :  nameDefinition ';' typeDefinition ';'
  ;

/**
 * Defini��o da composi��o de um m�dulo da sprite.
 */
fieldDefinition
  :  fieldName '{' (propertyDefinition ';')+ '}'
  ;

/**
 * Defini��o do nome da sprite.
 */
nameDefinition
  :  'name' ':' expr
  ;

/**
 * Defini��o do tipo da sprite.
 */
typeDefinition
  :  'type' ':' spriteType
  ;

/**
 * Defini��o geral de uma propriedade.
 */
propertyDefinition
  :  property ':' expr (',' expr)*
  ;

/**
 * Defini��o de uma express�o.
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
 * Diferentes tipos da composi��o do m�dulo da sprite.
 */
fieldName returns[Field field]
  : 'costume'   { $field = new CostumeField(); }
  | 'physics'   { $field = new PhysicsField(); }
  | 'geometry'  { $field = new GeometryField(); }
  ;


/**
 * Lista das v�rias propriedades poss�veis para os v�rios m�dulos.
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
