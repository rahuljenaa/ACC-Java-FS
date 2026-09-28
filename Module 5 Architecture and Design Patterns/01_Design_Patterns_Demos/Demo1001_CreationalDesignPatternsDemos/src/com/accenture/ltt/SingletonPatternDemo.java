package com.accenture.ltt;
//Ensures only ONE instance of this class exists in entire application
// Provides a global point of access to that instance
class DatabaseConnection {
	
	// static instance - shared globally
    private static DatabaseConnection instance;

    // private constructor - Restricts creation from outside the class
    private DatabaseConnection() {}

    // Public method to return the same instance every time
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection(); // Create only once
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to DB...");
    }
}
public class SingletonPatternDemo {

	public static void main(String[] args) {
	
		    // Both variables refer to EXACT same object
		    DatabaseConnection db1 = DatabaseConnection.getInstance();
	        DatabaseConnection db2 = DatabaseConnection.getInstance();

	        System.out.println(db1 == db2); // true (same object)
	        db1.connect();
	}

}
