lexer grammar SlothLexer;

BEGIN: 'begin';
END: 'end';
IF: 'if';
THEN: 'then';
ELSE: 'else';
WHILE: 'while';
DO: 'do';
LENGTH: 'length';
PRINT: 'print';
PRINTLN: 'println';
READINT: 'readInt';
READREAL: 'readReal';
READBOOL: 'readBool';
READSTRING: 'readString';
TRUE: 'true';
FALSE: 'false';
FUNCTION: 'function';
RETURN: 'return';

PLUS: '+';
MINUS: '-';
DIVIDE: '/';
TIMES: '*';
LTHAN: '<';
GTHAN: '>';
LTEQ: '<=';
GTEQ: '>=';
EQUAL: '==';
NOTEQ: '!=';
AND: '&&';
OR: '||';
NOT: '!';
SEMICOL: ';';
WALRUS: ':=';
LPAREN: '(';
RPAREN: ')';
LBRACK: '[';
RBRACK: ']';
COMMA: ',';
ID: [A-Za-z_]+[A-Za-z0-9_]*;
INTVAL: '-'?[0-9]+;
REALVAL: '-'?[0-9]*'.'?[0-9]+;
STRINGVAL: '"'~'"'*'"';
COMMENT: '%'~[\n]* -> skip;
NEWLINE: [\n]+ -> skip;
WS: [ \t]+ -> skip;

