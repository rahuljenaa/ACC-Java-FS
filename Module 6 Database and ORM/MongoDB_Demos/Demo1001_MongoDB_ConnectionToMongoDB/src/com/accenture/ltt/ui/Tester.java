package com.accenture.ltt.ui;

import com.accenture.ltt.utility.DBUtility;
import com.mongodb.client.MongoDatabase;

public class Tester {

    public static MongoDatabase database = null;

    public static void main(String[] args) {

        try {
            // Establish MongoDB connection
            database = DBUtility.getDBConnection();

            // Test: Print database name
            System.out.println("Connected to MongoDB Database: " + database.getName());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close MongoDB connection
            if (database != null) {
                DBUtility.getDBDestroyConnection();
            }
        }
    }
}
