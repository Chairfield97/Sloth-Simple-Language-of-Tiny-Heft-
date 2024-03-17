parser grammar SlothParser;

options {
    tokenVocab = SlothLexer;
}

program: statement*;

statement: ID WALRUS expression SEMICOL                     #assign
         | IF expression THEN statement                     #if
         | IF expression THEN statement ELSE statement      #ifelse
         | WHILE expression DO statement                    #while
         | PRINT LPAREN expression RPAREN SEMICOL           #print
         | PRINTLN LPAREN expression RPAREN SEMICOL         #println
         | BEGIN statement* END                             #begin
         ;

expression: NOT expression                                                          #not
          | expression op=(TIMES | DIVIDE) expression                               #timesdiv
          | expression op=(PLUS | MINUS) expression                                 #plusminus
          | expression op=(LTHAN | LTEQ | GTHAN | GTEQ | EQUAL | NOTEQ) expression  #compare
          | expression AND expression                                               #and
          | expression OR expression                                                #or
          | TRUE                                                                    #true
          | FALSE                                                                   #false
          | term                                                                    #justterm
          ;

term: REALVAL                       #realval
    | INTVAL                        #intval
    | STRINGVAL                     #strval
    | LPAREN expression RPAREN      #parens
    | ID                            #id
    | READINT LPAREN RPAREN         #readint
    | READREAL LPAREN RPAREN        #readreal
    | READBOOL LPAREN RPAREN        #readbool
    | READSTRING LPAREN RPAREN      #readstr
    ;

