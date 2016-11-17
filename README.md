# Comp380
Source control wil be done using git.
I strongly recommend to everyone to make an account on github.com
We will discuss the details of a master repository on Monday.

note to team: The best tutorial for using git can be found from reading the 
man page of git.

The standards for coding are in the Sun/Oracle java coding conventions.

Names should be placed in the sourse files by the following convention:
(a.) Certain files will be edited by all of us, in which case we will all put 
our names at the top of the file in no particular order and fitting as many 
names on one line as is reasonable.
(b.) Files with only one author will have only that contributer's name.
(c.) Files with a main author plus other contributers will have one name per 
line ordered by contribution.

The build system will be gnumake as in the java coding conventions for two 
reasons:
(i) Make is simple, easy to learn, flexible, and human readable.
(ii) Ant, the default in eclipse, is more complicated to use and does less than
make.

Documentation of code should be done by taking advantage of javadoc whenever 
possible.
For questions about javadoc try "man javadoc" in your favorite terminal 
emulator or search engine.

Other tools to be aware of are jdb, jshell, JFLEX, and uncrustify.

Also for for adding course information I recommend downloading the webpage with 
the course info you want to use and using the the lexer in the catolog directory 
to pull out the information before making whichever edits you need. 

I will push some parsed text from the lexer program in the file 
catalog-CITandCS.txt for you guys to use incase you can't figure out how to 
build lexer scripts. Tell me if there are any difficulties with pasring from 
that file. 

Other Notes: Feel free to add to this file.

I added a Main class since I am guessing that would be the best place to put 
or initialize the objects used through out the program.


