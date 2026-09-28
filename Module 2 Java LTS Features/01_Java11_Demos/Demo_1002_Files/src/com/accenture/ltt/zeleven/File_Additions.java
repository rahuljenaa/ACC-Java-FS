package com.accenture.ltt.zeleven;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class File_Additions {
	public static void main(String[] args) throws Exception {
		Path path = Files.writeString(new File("text").toPath(), "Writing to the file");
		System.out.println(path);
		String s = Files.readString(path);
		System.out.println(s);
	}

}
/**
 * 
 * 
 * String readString(Path path)
 * String readString(Path path, Charset cs)
 * Path writeString(Path path, CharSequence cs,OpenOption options)
 * Path writeString(Path path, CharSequence cs,Charset cs, OpenOption options
 * */