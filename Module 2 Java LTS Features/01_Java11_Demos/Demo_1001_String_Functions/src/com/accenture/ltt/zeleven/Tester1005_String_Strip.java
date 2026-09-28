package com.accenture.ltt.zeleven;

public class Tester1005_String_Strip {
	public static void main(String[] args) {
		
		String name = " Mohpreet "; 
        System.out.print("Start");
        System.out.print(name.strip());
        System.out.println("End");
        
        System.out.print("Start");
        System.out.print(name.stripLeading());
        System.out.println("End");
        
        System.out.print("Start");
        System.out.print(name.stripTrailing());
        System.out.println("End");
		
	}

}


/**
 *strip(), stripLeading(), stripTrailing()

strip() � Removes the white space from both, beginning and the end of string.

But we already have trim(). Then what�s the need of strip()?
strip() is �Unicode-aware� evolution of trim(). 
When trim() was introduced, Unicode wasn�t evolved. Now, the new strip() removes all kinds of whitespaces leading 
and trailing(check the method Character.isWhitespace(c) to know if a unicode is whitespace or not)
 * */
