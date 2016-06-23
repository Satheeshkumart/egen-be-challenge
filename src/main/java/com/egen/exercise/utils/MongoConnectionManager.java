package com.egen.exercise.utils;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.egen.exercise.domain.Metric;
import com.mongodb.MongoClient;

public final class MongoConnectionManager {
	private static final MongoConnectionManager INSTANCE = new MongoConnectionManager();

	private final Datastore db;
	public static final String DB_NAME = "PersonalWeightTracker";

	private MongoConnectionManager() {
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			db = new Morphia().map(Metric.class).createDatastore(mongoClient, DB_NAME);
			db.ensureIndexes();
		} catch (Exception e) {
			throw new RuntimeException("Error initializing mongo db", e);
		}
	}

	public static MongoConnectionManager instance() {
		return INSTANCE;
	}

	public Datastore getDb() {
		return db;
	}
	
}