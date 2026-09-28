package com.accenture.ltt.utility;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DBUtility {
   
	private static MongoClient mongoClient = null;
    private static MongoDatabase database = null;

    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "myDatabase";  // your MongoDB database name

    public static MongoDatabase getDBConnection() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            System.out.println("MongoDB connection established.");
        }

        if (database == null) {
            database = mongoClient.getDatabase(DATABASE_NAME);
            System.out.println("Connected to database: " + DATABASE_NAME);
        }

        return database;
    }

    public static void getDBDestroyConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
            database = null;
            System.out.println("MongoDB connection closed.");
        }
    }
}
