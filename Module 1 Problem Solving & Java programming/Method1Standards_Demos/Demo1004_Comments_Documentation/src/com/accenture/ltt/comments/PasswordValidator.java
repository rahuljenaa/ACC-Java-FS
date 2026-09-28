package com.accenture.ltt.comments;


	/**                      //  JavaDoc Comment
	 * This class provides basic password validation utility.
	 * It checks for minimum length and presence of a special character.
	 */
	public class PasswordValidator {

	    /**
	     * Validates the password based on predefined rules.   // JavaDoc Comment
	     * Rules:
	     * - Minimum 8 characters
	     * - Must contain at least one special character (!, @, #, $, %, etc.)
	     *
	     * @param password the password string to validate
	     * @return true if password is valid, false otherwise
	     */
	    public boolean isValid(String password) {
	        // Check if password is too short           //  Single-line Comment
	        if (password.length() < 8) {
	            return false;
	        }

	        /*                                        //  Multi-line Comment
	         * Check if password contains at least one special character.
	         * This is a basic check using regex pattern.
	         */
	        if (!password.matches(".*[!@#$%^&*()].*")) {
	            return false;
	        }

	        return true;
	    }

	    public static void main(String[] args) {
	        PasswordValidator validator = new PasswordValidator();

	        // Sample test cases                        //  Single-line Comment
	        String pw1 = "welcome123";
	        String pw2 = "welcome@123";

	        System.out.println(pw1 + " => " + validator.isValid(pw1)); // false
	        System.out.println(pw2 + " => " + validator.isValid(pw2)); // true
	    }
	}

