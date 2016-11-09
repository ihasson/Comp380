%{

%}
ws [ \t\n]
h3start "<h3"[^>]*">"
h3end "</h3></a>"
pstart "<p>"
endpara [^<]
%s HEADER
%s PARAGRAPH
%%
[\t\n] ;
{h3start} {
            /*BEGIN HEADER;*/ 
            /*printf("%s", yytext);*/ 
            BEGIN HEADER; 
            /* printf("header symbol\n"); */
            }
<HEADER>{h3end} {BEGIN PARAGRAPH; /*printf("end header\n");*/ }
<HEADER>[^<]* { printf("%s ", yytext); }
<PARAGRAPH>{pstart} ; {printf("\n");}
<PARAGRAPH>"</p>" {printf("\n\n"); BEGIN 0;}
<PARAGRAPH>{endpara} {printf("%s", yytext);}

. ;

%%

main()
{
    yyin = stdin;
    yylex();
}
