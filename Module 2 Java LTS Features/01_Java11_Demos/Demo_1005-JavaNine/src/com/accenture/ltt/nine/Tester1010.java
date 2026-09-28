package com.accenture.ltt.nine;

import java.io.FileInputStream;
import java.io.IOException;

public class Tester1010 {
	public static void main(String[] args) {

	}

	// 1 try with resources
	public void doWithFileJava3() throws IOException {
		try (FileInputStream fis = new FileInputStream("~/tmp/test")) {
			fis.read();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 2 try with resources, new variable required here line 24
	public void doWithFileJava8(FileInputStream fis) throws IOException {
		try (FileInputStream fis2 = fis) {
			fis2.read();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 3 try with resource, java 9
	public void doWithFileJava9(FileInputStream fis) throws IOException {
		try (fis) {
			fis.read();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
