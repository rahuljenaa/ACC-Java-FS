package com.accenture.ltt;

/**
 * @author r.roopavathi.n
 *
 */
public class Greeting {

    public static void main(String[] args) {
        String name = "Alice";

        // Proper whitespace and braces usage
        if (name != null && !name.isEmpty()) {
            System.out.println("Hello, " + name + "!");
        } else {
            System.out.println("Hello, guest!");
        }
    }
}
//Bad Practice (Poor Braces & Whitespace Usage)
/*public class Greeting1{
public static void main(String[]args){
String name="Alice";
if(name!=null&&!name.isEmpty()){
System.out.println("Hello,"+name+"!");
}else{
System.out.println("Hello, guest!");
}
}} */

