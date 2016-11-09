default: extract


lex.yy.c: extract.l
	lex extract.l

extract: lex.yy.c
	cc -o extract lex.yy.c -ll

parse.sh: extract

test: parse.sh
	./parse.sh

clean:
	$(RM) out.txt lex.yy.c
