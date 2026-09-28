package com.accenture.ltt;
//Create new objects by cloning an existing object
//Best when object creation is costly or time-consuming
class Document implements Cloneable {
    String content;

    Document(String content) {
        this.content = content;
    }
 // clone() returns a copy of current object
    public Document clone() throws CloneNotSupportedException {
        return (Document) super.clone();
    }
}

public class PrototypePatternDemo {
    public static void main(String[] args) throws Exception {
        Document doc1 = new Document("Original Content");
        
     // Create duplicate instead of re-creating from scratch
        Document doc2 = doc1.clone();

        System.out.println(doc2.content); // Same content cloned
    }
}
