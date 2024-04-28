parser grammar SlothParser;

options {
    tokenVocab = SlothLexer;
}

program: statement*;

statement: ID (LBRACK expression RBRACK)? WALRUS expression SEMICOL             #assign
         | IF expression THEN statement                                         #if
         | IF expression THEN statement ELSE statement                          #ifelse
         | WHILE expression DO statement                                        #while
         | PRINT LPAREN expression RPAREN SEMICOL                               #print
         | PRINTLN LPAREN expression RPAREN SEMICOL                             #println
         | BEGIN statement* END                                                 #begin
         | FUNCTION ID LPAREN (ID(COMMA ID)*)? RPAREN BEGIN statement* END      #functionDef
         | RETURN expression? SEMICOL                                           #return
         | ID LPAREN (expression(COMMA expression)*)? RPAREN SEMICOL            #funcCallStmt
         ;

expression: NOT expression                                                          #not
          | expression op=(TIMES | DIVIDE) expression                               #timesdiv
          | expression op=(PLUS | MINUS) expression                                 #plusminus
          | expression op=(LTHAN | LTEQ | GTHAN | GTEQ | EQUAL | NOTEQ) expression  #compare
          | expression AND expression                                               #and
          | expression OR expression                                                #or
          | LENGTH LPAREN ID RPAREN                                                 #length
          | ID LBRACK expression RBRACK                                             #arraysub
          | ID LPAREN (expression(COMMA expression)*)? RPAREN                       #funcCallExpr
          | TRUE                                                                    #true
          | FALSE                                                                   #false
          | term                                                                    #justterm
          ;

term: REALVAL                                            #realval
    | INTVAL                                             #intval
    | STRINGVAL                                          #strval
    | LPAREN expression RPAREN                           #parens
    | ID                                                 #id
    | READINT LPAREN RPAREN                              #readint
    | READREAL LPAREN RPAREN                             #readreal
    | READBOOL LPAREN RPAREN                             #readbool
    | READSTRING LPAREN RPAREN                           #readstr
    | LBRACK (expression(COMMA expression)*)? RBRACK     #litarray
    ;

