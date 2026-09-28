package com.accenture.ltt.zeleven;

import java.util.Optional;

public class Tester1001_Not_Predicate {
	public static void main(String[] args) {
		var opt =
				Optional.ofNullable(null);
				System.out.println(opt.isEmpty() == true); // isEmpty added
	}

}
