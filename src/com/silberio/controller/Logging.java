package com.silberio.controller;

public abstract class Logging {

	/**
	 * Abstract method to be implemented in respective classes. Used for creating an
	 * object to be logged later.
	 */
	public abstract void createLoggingObject();

	public abstract void objectToDocument();

	public abstract void documentToObject();
}
